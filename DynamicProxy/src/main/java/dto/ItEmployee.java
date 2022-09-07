package dto;

public class ItEmployee implements IEmployee{
    private double salary=3000;
    private int id;
    private String name;



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void giveHike(double amount) {
        salary=salary+amount;
    }

    @Override
    public void payCut(double amount) {
    salary=salary-amount;
    }
}
