package Tasks;

import connection.EMCall;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheLatest10Projects {
    public static void main(String[] args) {
        EntityManager em = EMCall.callEM();

        em.getTransaction().begin();

        List<Project> lastTenProjectsList = em.createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream()
                .sorted((a,b) -> a.getName().compareTo(b.getName()))
                .collect(Collectors.toList());

        lastTenProjectsList.forEach(Project::printProjectInfo);

        em.getTransaction().commit();
        em.close();
    }
}
