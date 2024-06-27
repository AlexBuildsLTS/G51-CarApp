package fullstackOS.org;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creates two cars
        Car car1 = new Car("123ABC", "Volvo", "XC90", 2021);
        Car car2 = new Car("456CDB", "Toyota", "Corolla", 2019);

        // New person created
        Person person1 = new Person("12345", "Alex", "alex@lexicon.com", "123-456-7890");

        // Set owner of car1
        car1.setOwner(person1);

        // Display information for both cars
        System.out.println("Car 1 Info:");
        System.out.println(car1.getCarInfo());

        System.out.println("Car 2 Info:");
        System.out.println(car2.getCarInfo());

        // Option to add a new owner to car1 or car2
        System.out.println("Would you like to add a new owner to a car? (yes/no)");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter the car number (1 or 2):");
            int carNumber = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            System.out.println("Enter new owner's personal number:");
            String personalNumber = scanner.nextLine();
            System.out.println("Enter new owner's name:");
            String name = scanner.nextLine();
            System.out.println("Enter new owner's email (optional):");
            String email = scanner.nextLine();
            System.out.println("Enter new owner's phone number:");
            String phoneNumber = scanner.nextLine();

            Person newOwner = new Person(personalNumber, name, email, phoneNumber);

            if (carNumber == 1) {
                car1.addOwner(newOwner);
                System.out.println("Updated Car 1 Info:");
                System.out.println(car1.getCarInfo());
            } else if (carNumber == 2) {
                car2.addOwner(newOwner);
                System.out.println("Updated Car 2 Info:");
                System.out.println(car2.getCarInfo());
            } else {
                System.out.println("Invalid car number.");
            }
        } else {
            System.out.println("No new owner added.");
        }

        scanner.close();
    }
}
