package fullstackOS.org;

public class Person {

    // Fields: kept private for encapsulation
    private String name;
    private final String personalNumber; // Final because it's immutable once set
    private String email;
    private String phoneNumber;

    // Constructor with all fields
    public Person(String personalNumber, String name, String email, String phoneNumber) {
        this.personalNumber = validateStringParams(personalNumber, "Personal Number");
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    // Constructor without email
    public Person(String personalNumber, String name, String phoneNumber) {
        this(personalNumber, name, null, phoneNumber); // Calls the main constructor
    }

    // Method to validate string parameters
    private String validateStringParams(String param, String paramName) {
        if (param == null || param.trim().isEmpty()) {
            throw new IllegalArgumentException(paramName + " cannot be null or empty");
        }
        return param;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateStringParams(name, "Name");
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = validateStringParams(phoneNumber, "Phone Number");
    }
}
