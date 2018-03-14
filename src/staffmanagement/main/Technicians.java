package staffmanagement.main;

public class Technicians extends Employee {
int count=0;
    public Technicians(String id, String firstName, String lastName, String gender, String birthDate, double salary, String department) {
        super(firstName, lastName, gender, birthDate, salary, department);
    count++;
    }

    public void averageWage() {

        double averageTechnicianWage = 0;
        int countTechnician = 0;

        for (int i = 0; i < EmployeeManagement.employee.size(); i++) {
            if (EmployeeManagement.employee.get(i).getDepartment().equals("Technician")) {
                averageTechnicianWage = averageTechnicianWage + EmployeeManagement.employee.get(i).getSalary();
                countTechnician++;
            }

        }
        System.out.println("Secretarys' average wage is :" + (averageTechnicianWage / countTechnician));
    }

    public void calculateBonus() {

    }

    @Override
    public double totalBonus(int  bonusPoint) {
        
        
        if (bonusPoint < 20){
            
            return bonusPoint*1000 ;
        }
        else if ( bonusPoint >= 20 && bonusPoint <= 30 ){
            
            return bonusPoint*1000 ;
        }
        if (bonusPoint> 30 ){
            
            return bonusPoint*1000;
        }

        return bonusPoint ;
    }

}
