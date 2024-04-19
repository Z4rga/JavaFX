package tn.esprit.application.services;

import tn.esprit.application.models.Service;
import tn.esprit.application.utils.myDatabase;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class ServiceService implements ServiceInterface<Service> {
    private Connection connection;

    public ServiceService() {
        try {
            this.connection = myDatabase.getInstance().getConnection();
            if (this.connection == null) {
                throw new SQLException("Failed to establish a database connection");
            }
        } catch (SQLException e) {
            System.err.println("Error establishing database connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void ajouter(Service service) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not established.");
        }
        String req = "INSERT INTO service (name, description, duration, availability, creation_date, user_id, category_id, price, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, service.getName());
        ps.setString(2, service.getDescription());
        ps.setInt(3, service.getDuration());
        ps.setBoolean(4, service.isAvailability());
        ps.setDate(5, new java.sql.Date(service.getCreationDate().getTime()));
        ps.setInt(6, service.getUserId());
        ps.setInt(7, service.getCategoryId());
        ps.setDouble(8, service.getPrice());
        ps.setString(9, service.getState());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            service.setId(rs.getInt(1));
        }
    }

    @Override
    public void modifier(Service service) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not established.");
        }
        String req = "UPDATE service SET name=?, description=?, duration=?, availability=?, creation_date=?, user_id=?, category_id=?, price=?, state=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setString(1, service.getName());
        ps.setString(2, service.getDescription());
        ps.setInt(3, service.getDuration());
        ps.setBoolean(4, service.isAvailability());
        ps.setDate(5, new java.sql.Date(service.getCreationDate().getTime()));
        ps.setInt(6, service.getUserId());
        ps.setInt(7, service.getCategoryId());
        ps.setDouble(8, service.getPrice());
        ps.setString(9, service.getState());
        ps.setInt(10, service.getId());
        ps.executeUpdate();
    }

    @Override
    public void supprimer(int id) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not established.");
        }
        String req = "DELETE FROM service WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Service recuperer(int id) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not established.");
        }
        String req = "SELECT * FROM service WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(req);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Service(rs);
        }
        return null;  // Return null if no service is found
    }

    @Override
    public List<Service> recupererall() throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not established.");
        }
        List<Service> services = new ArrayList<>();
        String req = "SELECT * FROM service";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(req);
        while (rs.next()) {
            services.add(new Service(rs));
        }
        return services;
    }
}
