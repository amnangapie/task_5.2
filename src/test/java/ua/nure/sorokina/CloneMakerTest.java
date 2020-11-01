package ua.nure.sorokina;

import org.junit.jupiter.api.Test;

class CloneMakerTest {

    @Test
    void printProperties() throws IllegalAccessException {
        CloneMaker.printProperties(new Employee(1, "Bob", "Marley",
                new Address()));
        CloneMaker.printProperties(null);
    }
}