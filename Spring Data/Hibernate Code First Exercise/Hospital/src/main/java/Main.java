import entities.Diagnose;
import entities.Patient;
import entities.PrescribedMedicament;
import entities.Visitation;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        EntityManager em = Persistence
                .createEntityManagerFactory("hospital")
                .createEntityManager();

        em.getTransaction().begin();

        System.out.println("Please add Patient data:");

        System.out.print("Please enter name: ");
        String fullName = scanner.nextLine();
        String firstName = fullName.split(" ")[0];
        String lastName = fullName.split(" ")[1];

        System.out.print("Please enter address: ");
        String address = scanner.nextLine();

        System.out.print("Please enter email: ");
        String email = scanner.nextLine();

        System.out.print("Please enter date of birth: ");
        scanner.useDelimiter("/");
        String dateString = scanner.nextLine();

        Date date = dateFormatter(dateString);

        System.out.print("Please upload picture: ");
        BufferedImage bf = null;
        File f = null;

        try {
           f = new File("PICTURE_URL");
           bf = new BufferedImage(100, 200, BufferedImage.TYPE_BYTE_GRAY);
           bf = ImageIO.read(f);
            System.out.print("Success");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        System.out.print("Patient has medical insurance (true/false): ");
        String insurance = scanner.nextLine();
        boolean hasInsurance = checkInsurance(insurance);
        Patient currentPatient = new Patient(firstName, lastName, address, email, date, hasInsurance);

        em.persist(currentPatient);

        System.out.println("Please enter visitation info:");

        System.out.print("Enter date: ");
        scanner.useDelimiter("/");
        String visDate = scanner.nextLine();
        Date visitationDate = dateFormatter(visDate);

        System.out.print("Enter your comments: ");
        String visitationComments = scanner.nextLine();
        Visitation currentVisitation = new Visitation(visitationDate, visitationComments);

        currentPatient.setVisitations(currentVisitation);
        em.persist(currentVisitation);

        System.out.println("Enter diagnose data:");

        System.out.print("Enter diagnose: ");
        String diagnose = scanner.nextLine();

        System.out.print("Enter your comments: ");
        String diagnoseComments = scanner.nextLine();
        Diagnose diagnose1 = new Diagnose(diagnose, diagnoseComments);
        currentPatient.setDiagnoses(diagnose1);

        em.persist(diagnose1);

        System.out.println("Enter Treatment:");

        System.out.print("Enter prescribed medication: ");
        String medicineName = scanner.nextLine();
        PrescribedMedicament prescribedMedicament = new PrescribedMedicament(medicineName);
        currentPatient.setPrescribedMedicaments(prescribedMedicament);

        em.persist(prescribedMedicament);

        em.getTransaction().commit();
        System.out.println("Successfully added patient data!");
        em.close();
        scanner.close();
    }

    private static boolean checkInsurance(String insurance) {
        boolean hasInsurance = false;
        if (insurance.equals("true")) {
            hasInsurance = true;
        }
        return hasInsurance;
    }

    private static Date dateFormatter(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(dateString);
    }
}
