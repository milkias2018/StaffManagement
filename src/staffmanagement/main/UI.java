/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.main;

/**
 *
 * @author User
 */
public class UI {

    public static void mainMenue() {
        System.out.println("*********");
        System.out.println("MAIN MENU");
        System.out.println("*********");

        System.out.println("Press 1 for Employee Management(Add,update,delete): ");
        System.out.println("Press 2 for Employee Statstics");
        System.out.println("Press 0 to Exit Program");

    }

    public static void taskEmployee() {
        System.out.println("*********************************");
        System.out.println("Employee Task Management Sub Menu");
        System.out.println("*********************************");
        System.out.println("Press 1 Register an employee");
        System.out.println("Press 2 Remove an Employee");
        System.out.println("Press 3 Update Employee Information");
        System.out.println("Press 4 Search Employee Information");
        System.out.println("Press 5 Display Employee Information");
        System.out.println("Press 0 Back to Menu");

    }

    public static void statEmployee() {
        System.out.println("***************************");
        System.out.println("Employee Statstics Sub Menu");
        System.out.println("***************************");
        System.out.println("Press 1 Minimum Salary in the Company ");
        System.out.println("Press 2 Maximum Salary in the Company");
        System.out.println("Press 3 Average Wage among the Company");
        System.out.println("Press 4 Overall Percentage for Gender MALE");
        System.out.println("Press 5 Overall Percentage for Gender FEMALE");
        System.out.println("Press 6 for bonus calculation ");
        System.out.println("Press 0 Back to Menu");
      
    }

    public static void fillDataBase() {

        Programmers p1 = new Programmers("abc", "lastName", "m", "15-10-2000", 121234, "Programmer");
        Secreteries sec = new Secreteries("Bita", "Bond", "f", "23-01-1973", 29000, "Secretary");
        Programmers p2 = new Programmers("Lolo", "Cool", "f", "940120", 29000, "Programmer");
        Programmers p3 = new Programmers("Maliheh", "SaadatFard", "f", "800123", 29000, "Programmer");
        Secreteries sec2 = new Secreteries("Tom", "Cruise", "m", "730123", 2900000, "technician");
        Technicians tec = new Technicians("ABC", "Bond", "m", "730113", 5344000, "technician");
        Technicians tec2 = new Technicians("Linda", "May", "f", "900123", 34000, "technician");
        Programmers p4 = new Programmers("George", "Nilsen", "m", "850123", 29000, "Programmer");

        EmployeeManagement.employee.add(p1);

        EmployeeManagement.employee.add(p3);
        EmployeeManagement.employee.add(sec);
        EmployeeManagement.employee.add(p2);
        EmployeeManagement.employee.add(sec2);
        EmployeeManagement.employee.add(tec);
        EmployeeManagement.employee.add(tec2);
        EmployeeManagement.employee.add(p4);
    }


}
