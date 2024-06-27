package fullstackOS.org;

import java.util.UUID;

public class Car {

    //fields this is private for encapsulation
    private String registrationNumber;
    private String brand;
    private String model;
    private int year;

    private Person owner;

    //constructors
    public Car(String registrationNumber, String brand, String model, int year, Person owner) {
        this.registrationNumber = generateCarNumber();
        this.brand = null;
        this.model = null;
        this.year = 0;
        this.owner = null;
    }
    // Parameterized constructor with specified registration numbers
    public Car(String registrationNumber, String brand, String model, int year) {
        this.registrationNumber = validateStringParams(registrationNumber, "Registration Number");
        this.brand = validateStringParams(brand, "Brand");
        this.model = validateStringParams(model, "Model");
        this.year = validateYear(year);
        this.owner = null; // Owner is initinaly null
    }
    // Method to validate string parameters
    private String validateStringParams(String param, String paramName) {
        if (param == null || param.trim().isEmpty()) {
            throw new IllegalArgumentException(paramName + " cannot be null or empty");
        }
        return param;
    }

    private String generateCarNumber() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private int validateYear(int year) {
        if (year < 1886 || year > 2023) { // Cars were invented around 1886
            throw new IllegalArgumentException("Invalid year: " + year);
        }
        return year;
    }

    // Getter and setter methods
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = validateStringParams(registrationNumber, "Registration Number");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = validateStringParams(brand, "Brand");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = validateStringParams(model, "Model");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = validateYear(year);
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    // Method to add an owner
    public void addOwner(Person owner) {
        if (this.owner != null) {
            throw new IllegalStateException("This car already has an owner.");
        }
        this.owner = owner;
    }

    // Method to remove the owner
    public void removeOwner() {
        if (this.owner == null) {
            throw new IllegalStateException("This car does not have an owner.");
        }
        this.owner = null;
    }

    // Method to get car information
    public String getCarInfo() {
        String ownerInfo = (owner != null) ? ", Owner: " + owner.getName() : ", Owner: None";
        return "Registration Number: " + registrationNumber + ", Brand: " + brand + ", Model: " + model + ", Year: " + year + ownerInfo;
    }
}

