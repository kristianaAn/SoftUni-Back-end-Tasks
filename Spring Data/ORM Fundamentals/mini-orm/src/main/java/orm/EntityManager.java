package orm;

import annotations.Column;
import annotations.Entity;
import annotations.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        Field idColumn = getIdColumn(entity.getClass());
        idColumn.setAccessible(true);
        Object value = idColumn.get(entity);

        if (value == null || (long) value <= 0) {
            return doInsert(entity, idColumn);
        } else {
            return doUpdate(entity, idColumn);
        }
    }

    private boolean doUpdate(E entity, Field idColumn) throws SQLException {
        String tableName = getTableName(entity.getClass());
        String columnToUpdate = getColumnForUpdate(entity.getClass());

        String updateQuery = String.format("UPDATE %s SET %s WHERE `id` = %d", tableName, columnToUpdate, idColumn.getClass());
        return connection.prepareStatement(updateQuery).execute();
    }

    private String getColumnForUpdate(Class<?> aClass) {
        List<Field> fieldList = Arrays.stream(aClass.getDeclaredFields())
                .filter(annotation -> !annotation.isAnnotationPresent(Id.class))
                .filter(annotation -> annotation.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());

        //....
        //TODO: Finish the method
        return "false";
    }

    private boolean doInsert(E entity, Field idColumn) throws IllegalAccessException, SQLException {
        String tableName = getTableName(entity.getClass());
        String columnsWithoutID = getColumnsWithoutID(entity.getClass());
        String columnValues = getColumnsValues(entity);
        String insertQuery = String.format("INSERT INTO %s(%s) VALUES(%s)", tableName, columnsWithoutID, columnValues);

        return connection.prepareStatement(insertQuery).execute();
    }

    private String getColumnsValues(E entity) throws IllegalAccessException {
        Class<?> aClass = entity.getClass();
        List<Field> annotatedColumns = Arrays.stream(aClass.getDeclaredFields())
                .filter(field -> !field.isAnnotationPresent(Id.class))
                .filter(field -> field.isAnnotationPresent(Column.class))
                .collect(Collectors.toList());

        List<String> annotationsList = new ArrayList<>();
        for (Field annotatedColumn : annotatedColumns) {
            annotatedColumn.setAccessible(true);
            Object columnClassObj = annotatedColumn.get(entity);

            if (columnClassObj instanceof String || columnClassObj instanceof LocalDate) {
                annotationsList.add("'" + columnClassObj.toString() + "'");
            } else {
                annotationsList.add(columnClassObj.toString());
            }
        }

        return String.join(", ", annotationsList);
    }

    private String getColumnsWithoutID(Class<?> aClass) {
        return Arrays.stream(aClass.getDeclaredFields())
                .filter(annotation -> !annotation.isAnnotationPresent(Id.class))
                .filter(annotation -> annotation.isAnnotationPresent(Column.class))
                .map(field -> field.getAnnotationsByType(Column.class))
                .map(f -> f[0].name()).collect(Collectors.joining(", "));
    }


    private String getTableName(Class<?> aClass) {
        Entity[] annotationsByType = aClass.getAnnotationsByType(Entity.class);

        if (annotationsByType.length == 0) {
            throw new UnsupportedOperationException("Class is not Entity");
        }

        return annotationsByType[0].name();
    }


    @Override
    public Iterable<E> find(Class<E> table) {
        return null;
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> table) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(table, null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String selectQuery = String.join("SELECT * FROM %s %s LIMIT 1;"
                , getTableName(table), where == null ? "" : where);

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return fillEntity(table, resultSet);
        }
        return null;
    }

    private E fillEntity(Class<E> table, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        E entity = table.getDeclaredConstructor().newInstance();

        Arrays.stream(table.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillData(entity, f, resultSet);
                    } catch (SQLException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        return entity;
    }

    private void fillData(E entity, Field field, ResultSet resultSet) throws SQLException, IllegalAccessException {
        field.setAccessible(true);
        String fieldName = field.getAnnotation(Column.class).name();
        Class<?> fieldType = field.getType();

        Object value;
        if (fieldType == int.class) {
            value = resultSet.getInt(fieldName);
        } else if (fieldType == LocalDate.class) {
            String stringDate = resultSet.getString(fieldName);
            value = LocalDate.parse(stringDate);
        } else {
            value = resultSet.getString(fieldName);
        }

        field.set(entity, value);
    }


    private Field getIdColumn(Class<?> entity) {
        return Arrays.stream(entity.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst()
                .orElseThrow(() -> new UnsupportedOperationException("Entity does not have primary key"));
    }
}
