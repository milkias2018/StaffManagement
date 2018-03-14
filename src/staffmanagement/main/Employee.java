package staffmanagement.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import static staffmanagement.main.EmployeeManagement.employee;

/**
 *
 * @author User
 */
public  abstract class Employee {

    public int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private double salary;
    private String department;

    public static int Count = 0;
   

    static Scanner scan = new Scanner(System.in);

    public Employee(String firstName, String lastName, String gender, String birthDate, double salary, String department) {

        this.id = ++Count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.department = department;
        this.salary = salary;
        this.gender = gender;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("-------------------------------------------------------------------------------------------------------------------------------");
        sb.append("\n");
        sb.append("Record [  ID = ").append(getId()).append(", First Name = ").append(firstName).append(", Last Name = ").append(lastName).append(", Birth Date = ").append(birthDate).append(", Salary = ").append(salary).append(", Department = ").append(department).append(']');
        sb.append("\n");
        sb.append("-------------------------------------------------------------------------------------------------------------------------------");
        return sb.toString();
    }

    public abstract double totalBonus(int num) ;

    public static int getCount() {
        return Count;
    }

  

}
