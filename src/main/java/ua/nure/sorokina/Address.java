package ua.nure.sorokina;

public class Address {
    private String street;
    private int streetNumber;
    private int[] flats;

    public Address() {
        this.street = "street";
        this.streetNumber = 12;
        this.flats = new int[3];
        flats[0] = 1;
        flats[1] = 2;
        flats[2] = 3;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int[] getFlats() {
        return flats;
    }
}
