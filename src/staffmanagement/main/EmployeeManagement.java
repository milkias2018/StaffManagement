/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.main;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import static staffmanagement.main.Employee.scan;

/**
 *
 * @author User
 */
public class EmployeeManagement implements EmployeeStatstics {

    
    public static ArrayList<Employee> employee = new ArrayList<Employee>();
    public static DecimalFormat decimalFormat = new DecimalFormat();
    
    public int countFemaleGender = 0;
    public int countMaleGender = 0;


    public static void print() {
        for (Employee employee1 : employee) {
            System.out.println(employee1);
        }

    }

    public static void addEmployeesInfo(Employee emy) {

        boolean d = true;
        while (d) {
            try {

                System.out.println("Enter the first name:");
                emy.setFirstName(scan.nextLine());

                boolean boolLastName = true;
                while (boolLastName) {
                    System.out.println("Enter the last name:");

                    String lastName = scan.nextLine();
                    if (lastName.matches("[A-Za-z]+")) {

                        emy.setGender(lastName);
                        boolLastName = false;

                    } else {
                        boolLastName = true;
                    }
                }

                boolean bool = true;
                while (bool) {
                    System.out.println("Enter Gender: m/f ");//first check gender and set gender.

                    String c = scan.nextLine();
                    if (c.equalsIgnoreCase("m") || c.equalsIgnoreCase("f")) {
                        emy.setGender(c);
                        bool = false;
                    } else {
                        System.out.println("Wrong gender (m/f),please try again");
                        bool = true;
                    }
                }
                boolean check = true;
                while (check) {
                    try {
                        System.out.println("Enter the birth day: [dd/mm/yyyy]");
                        String birth = scan.nextLine();
                                      
                        if (birth.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                            emy.setBirthDate(birth);
                            check=false;
                        } else {
                            System.out.println("** Incorrect date format **");
                            check = true;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Enter the salary:");
                emy.setSalary(scan.nextDouble());

                System.out.println("New employee inserted." + "\n");
                scan.nextLine();

                registerEmployee(emy);

                d = false;
            } catch (Exception e) {

                System.out.println("**********invalid input**********");
            }
        }

    }

    public int countMale() {

        int countMale = 0;
        for (Employee emp : employee) {

            if (emp.getGender().equalsIgnoreCase("m")) {
                countMale++;
            }
        }
        return countMale;
    }

    public int countFemale() {

        int countFemale = 0;
        for (Employee emp : employee) {

            if (emp.getGender().equalsIgnoreCase("f")) {
                countFemale++;
            }
        }

        return countFemale;
    }

    public static void registerEmployee(Employee emp) {

        employee.add(emp);

    }

    public static void removeEmployee() {

        try {

            System.out.println("Please enter employee id");
            int employeeId = scan.nextInt();

            for (int i = (employee.size() - 1); i >= 0; i--) {

                if (employeeId == employee.get(i).id) {

                    System.out.println(employee.get(i));
                    employee.remove(i);

                }

            }
            System.out.println("Employee Removed");

        } catch (Exception e) {
            System.out.println("***********invalid input************");
        }

    }

    public static void updateEmployee() {
        try {

            System.out.println("Please enter employee id");
            int employeeId = scan.nextInt();

            for (int i = 0; i < employee.size(); i++) {

                if (employeeId == employee.get(i).id) {
                    System.out.println(employee.get(i));
                    System.out.println("Which information about the employee do you want to update ? 1.First name 2.Last name 3.Birth date 4.Salary 5.Department");
                    int updateUser = scan.nextInt();
                    scan.nextLine();

                    switch (updateUser) {
                        case 1:
                            System.out.println("Enter the new First name");
                            String newFirstName = scan.nextLine();
                            employee.get(i).setFirstName(newFirstName);
                            System.out.println("First name updated.");
                            break;
                        case 2:
                            System.out.println("Enter the new Last name");
                            String newLastName = scan.nextLine();
                            employee.get(i).setLastName(newLastName);
                            System.out.println("Last name updated.");
                            break;
                        case 3:
                            System.out.println("Enter the new Birth date");
                            String newBirthdate = scan.nextLine();
                            employee.get(i).setBirthDate(newBirthdate);
                            System.out.println("Birth day updated.");
                            break;
                        case 4:
                            System.out.println("Enter the new Salary");
                            double newSalary = scan.nextDouble();
                            employee.get(i).setSalary(newSalary);
                            System.out.println("Salary updated.");
                            break;
                        case 5:
                            System.out.println("Enter the new Department");
                            String newDepartment = scan.nextLine();
                            employee.get(i).setDepartment(newDepartment);
                            System.out.println("Department updated.");
                            break;
                        default:
                            System.out.println("Invalid input: (1,2,3,4,5)");
                            break;

                    }

                }

            }

        } catch (Exception e) {
            System.out.println("*********invalid input***********");
        }

    }

    public static void searchEmployeeMenu() {

        boolean c = true;
        while (c) {
            try {
                System.out.println("");
                System.out.println("Choose the way you want to search the Employee !!");
                System.out.println("");
                System.out.println("1. Search by Employee Id");

                System.out.println("2. Search by First name");

                System.out.println("3. Search by Last name");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        searchEmployeebyId();
                        break;

                    case 2:

                        searchEmployeebyFirstName();
                        break;

                    case 3:
                        EmployeeManagement.searchEmployeebyLastName();
                        break;

                    default:
                        System.out.println("Wrong input");

                }

                System.out.println("Do you want to continue search about employee? Y/N");

                String response = scan.nextLine();

                if (response.equalsIgnoreCase("N")) {

                    c = false;

                } else {
                    c = true;
                }
            } catch (Exception e) {

                System.out.println("**********invalid input please try again************");
            }
        }
    }

    public static void searchEmployeebyId() {

        System.out.print("What is the id of the employee: ");
        int id = scan.nextInt();

        for (Employee employee1 : employee) {
            if (employee1.getId() == id) {
                System.out.println(employee1);
            }
        }
//        System.out.println("\n---------------------------------");
//        System.out.println("Employee with that id is not found");
//        System.out.println("----------------------------------");
    }

    public static void searchEmployeebyFirstName() {
        System.out.print("Enter the First name of the employee: ");
        String name = scan.nextLine();

        ArrayList<Employee> results = new ArrayList();

        for (Employee employee1 : employee) {
            if (employee1.getFirstName().equalsIgnoreCase(name)) {
                results.add(employee1);

            }
        }
        for (Employee employee1 : results) {
            System.out.println(employee1);

        }
        //        for (Employee employee1 : employee) {
//            if(employee1.getFirstName().equalsIgnoreCase(name)){
//        
//        System.out.println("\n----------------------------------------------");
//        System.out.println("Employee with that First name can not be found");
//        System.out.println("----------------------------------------------");
//        break;
//        
//        }}

    }

    public static void searchEmployeebyLastName() {
        System.out.print("Enter the last name of the employee: ");
        String name = scan.nextLine();

        ArrayList<Employee> results = new ArrayList();

        for (Employee employee1 : employee) {
            if (employee1.getLastName().equalsIgnoreCase(name)) {
                results.add(employee1);

            }
        }
        for (Employee employee1 : results) {
            System.out.println(employee1);

        }
//        System.out.println("\n---------------------------------------------");
//        System.out.println("Employee with that Last name can not be found");
//        System.out.println("---------------------------------------------");
    }

    public static void displayEmployee(Employee emp) {

        emp.toString();

    }

    @Override
    public String averageWage() {
        double averageWage = 0;
        decimalFormat.setMaximumFractionDigits(2);

        for (int i = 0; i < employee.size(); i++) {

            averageWage = averageWage + employee.get(i).getSalary();

        }
        return String.format("%.02f", (averageWage / employee.size()));
    }

    @Override
    public double maximumSalary() {

        double maximumSalary = employee.get(0).getSalary();

        for (int i = 1; i < employee.size(); i++) {
            if (employee.get(i).getSalary() > maximumSalary) {
                maximumSalary = employee.get(i).getSalary();
            }
        }
        return maximumSalary;
    }

    @Override
    public double minimumSalary() {

        double minimumSalary = employee.get(0).getSalary();

        for (int i = 1; i < employee.size(); i++) {
            if (employee.get(i).getSalary() < minimumSalary) {
                minimumSalary = employee.get(i).getSalary();
            }
        }
        return minimumSalary;
    }

    @Override
    public void womenPercentage() {
        double result = (countFemale() / (double) employee.size()) * 100;
        System.out.print(String.format("%.02f", result));
        System.out.println(" Percent");
    }

    @Override
    public void menPercentage() {
        decimalFormat.setMaximumFractionDigits(2);
        double result = (countMale() / (double) employee.size()) * 100;
        System.out.print(String.format("%.02f", result));
        System.out.println(" Percent");

    }

    @Override
    public void sumOfBonus() {

        double techBonus = 0;
        double progBonus = 0;
        double secBonus = 0;

        for (Employee currentEmployee : employee) {
            if (currentEmployee instanceof Technicians) {
                techBonus += ((Technicians) currentEmployee).totalBonus(15);
            } else if (currentEmployee instanceof Programmers) {
                progBonus += ((Programmers) currentEmployee).totalBonus(15);
            } else if (currentEmployee instanceof Secreteries) {
                secBonus += ((Secreteries) currentEmployee).totalBonus(15);
            }

        }
        System.out.println("The overall bonus for the company is: " + (techBonus + progBonus + secBonus));
        System.out.println("The total bonus for profession programmers is: " + progBonus);
        System.out.println("The total bonus for profession technicians is: " + techBonus);
        System.out.println("The total bonus for profession secretaries is: " + secBonus);

    }
}
