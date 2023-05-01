package task4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public BigDecimal getBasePayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        if (getExperience()!=employee.getExperience())return false;
    if (getBasePayment()!=employee.getBasePayment())return false;
    return getName().equals(employee.getName());}

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31*result+getName().hashCode();
        result =31*result+getExperience();
        result = 31*result + getBasePayment().hashCode();
        return result;
    }

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }
}

class Manager extends Employee {
    private double coefficient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager )) return false;
        if (!super.equals(o))return false;
        Manager manager = (Manager) o;
        return getCoefficient()==manager.coefficient;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = (int) (31*result+getCoefficient());
        return result;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return BigDecimal.valueOf(coefficient).multiply(super.getPayment());
    }
}

public class MyUtils {

    public static List<Employee> largestEmployees(List<Employee> employees) {

        int maxExperience = employees.stream().mapToInt(Employee::getExperience).max().orElse(0);
        BigDecimal maxPayment = employees.stream().map(Employee::getPayment)
                .max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO);


        List<Employee> maxExperienceEmployees = employees.stream()
                .filter(e -> e.getExperience() == maxExperience && e.getPayment().equals(maxPayment))
                .distinct().collect(Collectors.toList());


        List<Employee> maxExperienceManagers = employees.stream()
                .filter(e -> e instanceof Manager)
                .map(e -> (Manager) e)
                .filter(m -> m.getExperience() == maxExperience && m.getPayment().equals(maxPayment))
                .distinct().collect(Collectors.toList());


        List<Employee> maxEmployees = new ArrayList<>();
        maxEmployees.addAll(maxExperienceEmployees);
        maxEmployees.addAll(maxExperienceManagers);
        maxEmployees = maxEmployees.stream().distinct().collect(Collectors.toList());

        return maxEmployees;
    }
}

