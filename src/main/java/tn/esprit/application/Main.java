package tn.esprit.application;

import tn.esprit.application.models.Service;
import tn.esprit.application.services.ServiceService;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            ServiceService serviceService = new ServiceService();
            Service newService = new Service(0, "Web Development", "Full stack web development", 120, true, new Date(), 1, 101, 500.00, "Active");
            serviceService.ajouter(newService);
            System.out.println("Service added successfully");

            newService.setDescription("Updated full stack web development");
            newService.setPrice(550.00);
            serviceService.modifier(newService);
            System.out.println("Service modified successfully");

            serviceService.supprimer(newService.getId());
            System.out.println("Service deleted successfully");

            Service retrievedService = serviceService.recuperer(newService.getId());
            if (retrievedService != null) {
                System.out.println("Retrieved Service: " + retrievedService);
            } else {
                System.out.println("No service found with the specified ID.");
            }

            List<Service> services = serviceService.recupererall();
            System.out.println("List of all services:");
            for (Service service : services) {
                System.out.println(service);
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("General Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
