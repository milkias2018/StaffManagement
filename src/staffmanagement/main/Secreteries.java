package staffmanagement.main;

import java.util.Date;

public class Secreteries extends Employee {
int count=0;
    public Secreteries( String firstName, String lastName, String gender, String birthDate, double salary, String department) {
        super( firstName, lastName, gender, birthDate, salary, department);
count++;
    }

    public void averageWage() {

        double averageSecretaryWage = 0;
        int countSecretary = 0;

        for (int i = 0; i < EmployeeManagement.employee.size(); i++) {
            if (EmployeeManagement.employee.get(i).getDepartment().equals("Secretary")) {
                averageSecretaryWage = averageSecretaryWage + EmployeeManagement.employee.get(i).getSalary();
                countSecretary++;
            }

        }
        System.out.println("Secretarys' average wage is :" + (averageSecretaryWage / countSecretary));
    }

    @Override
    public double totalBonus(int bonusPoint ) {
        
        
          
        if (bonusPoint< 10){
            
            return bonusPoint*500 ;
        }
        else if  (bonusPoint>= 10 && bonusPoint<= 30){
            
            return bonusPoint*500 ;
        }
        if (bonusPoint > 30){
            
            return bonusPoint*1000 ;
        }
        
        return bonusPoint  ;
    } 
        
 
}
