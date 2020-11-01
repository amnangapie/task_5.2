package ua.nure.sorokina;

import ua.nure.sorokina.utils.TimeUtils;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private final long id;
    private final String firstName;
    private final String lastName;
    private Address address;
    List<Integer> weekend = new LinkedList<>();

    /* monthly salary with 100-percent hours worked */
    private int rate;
    /* actual hours of work per month */
    private int actualHoursOfWork;

    public Employee(long id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        weekend.add(Calendar.SATURDAY);
        weekend.add(Calendar.SUNDAY);
    }

    public Employee(long id, String firstName, String lastName, int rate, int actualHoursOfWork) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rate = rate;
        this.actualHoursOfWork = actualHoursOfWork;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) throws IllegalArgumentException {
        if (rate < 0) {
            throw new IllegalArgumentException("Invalid value: salary must be positive!");
        }
        this.rate = rate;
    }

    public int getActualHoursOfWork() {
        return actualHoursOfWork;
    }

    public void setActualHoursOfWork(int actualHoursOfWork)
            throws IllegalArgumentException {
        if (actualHoursOfWork < 0) {
            throw new IllegalArgumentException("Invalid value: hours of work must be positive!");
        }
        this.actualHoursOfWork = actualHoursOfWork;
    }

    public double getActualWorkTimePercentage(int month, int year) {
        int workHours = TimeUtils.getWorkHoursPerMonth(month, year);
        double percentage = (double) actualHoursOfWork / workHours;

        return Math.round(percentage * 100.) / 100.;
    }

    public double getSalary(int month, int year) {return 0;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
