/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.main;

import java.util.ArrayList;
import java.text.DecimalFormat;

import static staffmanagement.main.Employee.scan;

/**
 *
 * @author User
 */
public class EmployeeManagement implements EmployeeStatstics {
    
    public  int countFemaleGender = 0;
    public  int countMaleGender = 0;
    
    public static ArrayList<Employee> employee = new ArrayList();
    public static DecimalFormat decimalFormat = new DecimalFormat();

    public static void print() {
        for (Employee employee1 : employee) {
            System.out.println(employee1);
        }

    }

    public static void addEmployeesInfo(Employee emy) {

        
          boolean d = true ;
       while (d) 
        try {
            
       
        System.out.println("Enter the first name:");
        emy.setFirstName(scan.nextLine());
         
        boolean boolLastName=true;
         while(boolLastName){
        System.out.println("Enter the last name:");
        
        String lastName=scan.nextLine();
        if(lastName.matches("[A-Za-z]+")){
          
           emy.setGender(lastName);
           boolLastName=false;
                     
        }
         else
           
           boolLastName=true;
         }   
        
        boolean bool = true ;
        while (bool){
        System.out.println("Enter Gender: m/f ");//first check gender and set gender.
        
        String c= scan.nextLine();
        if (c.equalsIgnoreCase("m") || c.equalsIgnoreCase("f")){
        emy.setGender(c);
        bool = false ;
        }
        else  {
            System.out.println("Wrong gender (m/f),please try again");
            bool=true;
        }
           }
        System.out.println("Enter the birth day:");
        emy.setBirthDate(scan.nextLine());

        System.out.println("Enter the salary:");
        emy.setSalary(scan.nextDouble());

        System.out.println("New employee inserted." + "\n");
        scan.nextLine();

        registerEmployee(emy);
        
        d = false ;
        } catch (Exception e) {
     
            System.out.println("**********invalid input**********");
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
       
        for ( int i = (employee.size() - 1); i >= 0; i--) {

            if (employeeId==employee.get(i).id) {
               
                System.out.println(employee.get(i));
                employee.remove(i);
                                             
                
            }
            
           
        }
       
        System.out.println("Employee removed");
          } catch (Exception e) {
              System.out.println("***********invalid input************");
        }
    }

    public static void updateEmployee() {
        try {
            
       
        System.out.println("Please enter employee id");
        int employeeId = scan.nextInt();

        for (int i = 0; i < employee.size(); i++) {

            if (employeeId == employee.get(i).id ) {
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

        } } catch (Exception e) {
            System.out.println("*********invalid input***********");
        }

    }

    public static Employee searchEmployeebyId() {
        
        System.out.print("What is the id of the employee: ");
        int id = scan.nextInt();

        for (Employee employee1 : employee) {
            if (employee1.getId()==id) {
                return employee1;
            }
        }
        return null;
    }
    public static void searchEmployeebyFirstName() {
        System.out.print("Enter the first name of the employee: ");
        String name = scan.nextLine();
        
        ArrayList<Employee> results=new ArrayList();
        
        for (Employee employee1 : employee) {
            if (employee1.getFirstName().equalsIgnoreCase(name)) {
                 results.add(employee1);

            }
        }
        for (Employee employee1 : results) {
            System.out.println(employee1);

            }
        }
        
       
    
    
   public static void searchEmployeebyLastName() {
        System.out.print("Enter the last name of the employee: ");
        String name = scan.nextLine();
        
        ArrayList<Employee> results=new ArrayList();
        
        for (Employee employee1 : employee) {
            if (employee1.getLastName().equalsIgnoreCase(name)) {
                 results.add(employee1);

            }
        }
        for (Employee employee1 : results) {
            System.out.println(employee1);

            }
        }

    public static void displayEmployee(Employee emp) {

        emp.toString();

    }

    @Override
    public double averageWage() {
        double averageWage = 0;

        for (int i = 0; i < employee.size(); i++) {

            averageWage = averageWage + employee.get(i).getSalary();

        }
        return (averageWage / employee.size());
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
       public  void sumOfBonus(){
           
           double techBonus=0;
           double progBonus=0;
           double secBonus=0;
           
                      
           for (Employee currentEmployee : employee) {
               if(currentEmployee instanceof Technicians){
                   techBonus+=((Technicians) currentEmployee).totalBonus(15);
           }
               else if(currentEmployee instanceof Programmers){
                   progBonus+=((Programmers) currentEmployee).totalBonus(15);
           }
              else if(currentEmployee instanceof Secreteries){
                   secBonus+=((Secreteries) currentEmployee).totalBonus(15);
           }
           

      } 
           System.out.println("The overall bonus for the company is: "+(techBonus+progBonus+secBonus));
           System.out.println("The total bonus for profession programmers is: "+progBonus);
           System.out.println("The total bonus for profession technicians is: "+techBonus);
           System.out.println("The total bonus for profession secretaries is: "+secBonus);
        
   }
}
       
 
