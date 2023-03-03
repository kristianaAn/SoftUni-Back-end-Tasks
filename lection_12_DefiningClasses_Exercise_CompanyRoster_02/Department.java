package lection_12_DefiningClasses_Exercise_CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {
       private String name;
       private List<Employee> listEmployees;

       public Department(String name) {
              this.name = name;
              this.listEmployees = new ArrayList<>();
       }

       public double calculateAverageSalary () {
              return listEmployees.stream().mapToDouble(employee -> employee.getSalary()).average().orElse(0);
       }

       public String getName() {
              return name;
       }

       public List<Employee> getListEmployees() {
              return listEmployees;
       }

       public void setName(String name) {
              this.name = name;
       }

}
