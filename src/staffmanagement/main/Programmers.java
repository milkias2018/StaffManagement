/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.main;

import java.util.Date;

/**
 *
 * @author User
 */
public class Programmers extends Employee {
int count = 0 ;
    public Programmers( String firstName, String lastName, String gender, String birthDate, double salary, String department) {
        super(firstName, lastName, gender, birthDate, salary, department);
        count++ ;
    }

    public void averageWage() {

        double averageProgrammerWage = 0;
        int countProgrammer = 0;

        for (int i = 0; i < EmployeeManagement.employee.size(); i++) {
            if (EmployeeManagement.employee.get(i).getDepartment().equals("Programmer")) {
                averageProgrammerWage = averageProgrammerWage +EmployeeManagement.employee.get(i).getSalary();
                countProgrammer++;
            }

        }
        System.out.println("Secretarys' average wage is :" + (averageProgrammerWage / countProgrammer));
    }

    public static void calculateSalary() {

    }

    @Override
    public double totalBonus(int bonusPoint ) {
        
         
        
        if (bonusPoint < 10){
            
            return bonusPoint*1000 ;
        }
        else if  (bonusPoint >= 10 && bonusPoint<= 30){
            
            return bonusPoint*1000;
        }
        if (bonusPoint >30){
            
            return bonusPoint*1000 ;
        }
        
        return 0  ;
    } 
   
}
