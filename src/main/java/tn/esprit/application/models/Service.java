package tn.esprit.application.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Service {
    private int id;
    private String name;
    private String description;
    private int duration;
    private boolean availability;
    private Date creationDate;
    private int userId;
    private int categoryId;
    private double price;
    private String state;

    // Default constructor
    public Service() {
    }

    // Full constructor
    public Service(int id, String name, String description, int duration, boolean availability,
                   Date creationDate, int userId, int categoryId, double price, String state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.availability = availability;
        this.creationDate = creationDate;
        this.userId = userId;
        this.categoryId = categoryId;
        this.price = price;
        this.state = state;
    }

    // Constructor to build from a ResultSet
    public Service(ResultSet rs) throws SQLException {
        this.id = rs.getInt("id");
        this.name = rs.getString("name");
        this.description = rs.getString("description");
        this.duration = rs.getInt("duration");
        this.availability = rs.getBoolean("availability");
        this.creationDate = new Date(rs.getDate("creation_date").getTime());
        this.userId = rs.getInt("user_id");
        this.categoryId = rs.getInt("category_id");
        this.price = rs.getDouble("price");
        this.state = rs.getString("state");
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isAvailability() {
        return availability;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public double getPrice() {
        return price;
    }

    public String getState() {
        return state;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setState(String state) {
        this.state = state;
    }
}
