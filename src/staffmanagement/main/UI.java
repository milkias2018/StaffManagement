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
        System.out.println("Main Menu");
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
      
//sout bonus  

    }
}
