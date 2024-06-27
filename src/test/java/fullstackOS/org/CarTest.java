package fullstackOS.org;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void testCarCreation() {
        Car car = new Car("123ABC", "Volvo", "XC90", 2021);
        assertEquals("123ABC", car.getRegistrationNumber());
        assertEquals("Volvo", car.getBrand());
        assertEquals("XC90", car.getModel());
        assertEquals(2021, car.getYear());
        assertNull(car.getOwner());
    }

    @Test
    void testSetOwner() {
        Car car = new Car("123ABC", "Volvo", "XC90", 2021);
        Person person = new Person("12345", "Alex", "alex@lexicon.com", "123-456-7890");
        car.setOwner(person);
        assertEquals(person, car.getOwner());
    }

    @Test
    void testAddOwner() {
        Car car = new Car("123ABC", "Volvo", "XC90", 2021);
        Person person = new Person("12345", "Alex", "alex@lexicon.com", "123-456-7890");
        car.addOwner(person);
        assertEquals(person, car.getOwner());
    }

    @Test
    void testRemoveOwner() {
        Car car = new Car("123ABC", "Volvo", "XC90", 2021);
        Person person = new Person("12345", "Alex", "alex@lexicon.com", "123-456-7890");
        car.addOwner(person);
        car.removeOwner();
        assertNull(car.getOwner());
    }
}
