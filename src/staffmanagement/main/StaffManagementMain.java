package staffmanagement.main;

import java.util.Scanner;

public class StaffManagementMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        EmployeeManagement stats = new EmployeeManagement();
       

        UI.fillDataBase();

        boolean runagain = true;

        do {
            try {

                UI.mainMenue();

                System.out.println("  ");
                int userInput = scan.nextInt();
                scan.nextLine();

                switch (userInput) {
                    case 1:

                        UI.taskEmployee();
                        System.out.println();
                        int input = scan.nextInt();
                        scan.nextLine();
                        boolean b = false;
                        if (input == 1) {

                            do {
                                System.out.println("Choose the department where you want to register the employee [ t : technician ] , [s: secretary] ,[ p: programmers] ");

                                String depp = scan.nextLine();

                                switch (depp) {
                                    case "s":

                                        Secreteries emy = new Secreteries("", "", "", null, 0, "Secretary");
                                        System.out.println("Insert employee information: ");

                                        EmployeeManagement.addEmployeesInfo(emy);

                                        break;
                                    case "p":
                                        Programmers prog = new Programmers( "", "", "",null, 0, "Programmers");
                                        System.out.println("Insert employee information: ");

                                        EmployeeManagement.addEmployeesInfo(prog);

                                        break;

                                    case "t":
                                        Technicians tec = new Technicians( "", "", "", null, 0, "Technicians");
                                        System.out.println("Insert employee information: ");

                                        EmployeeManagement.addEmployeesInfo(tec);

                                        break;
                                    default:
                                        System.out.println("Not a valid character");
                                        break;

                                }
                                System.out.println("Do you want to continue adding employee? Y/N");
                                String response = scan.nextLine();

                                if (response.equalsIgnoreCase("N")) {

                                    b = false;

                                } else {
                                    b = true;
                                }
                            } while (b);

                        } else if (input == 2) {
                            EmployeeManagement.removeEmployee();
                        } else if (input == 3) {
                            EmployeeManagement.updateEmployee();
                        } else if (input == 4) {

                            EmployeeManagement.searchEmployeeMenu();

                        } else if (input == 5) {
                            EmployeeManagement.print();
                        } else if (input == 0) {
                            runagain = true;
                        }

                        break;
                    case 2:
                        UI.statEmployee();
                        System.out.println();

                        int statOperationChoose = scan.nextInt();
                        scan.nextLine();

                        if (statOperationChoose == 1) {

                            System.out.println("The Minimum Salary in the Company is:");
                            System.out.println(stats.minimumSalary());

                        } else if (statOperationChoose == 2) {
                            System.out.println("The Maximum Salary in the Company is:");
                            System.out.println(stats.maximumSalary());
                        } else if (statOperationChoose == 3) {
                            System.out.println("The Average Wage in the Company is:");
                            System.out.println(stats.averageWage());
                        } else if (statOperationChoose == 4) {
                            System.out.println("The Overall Percentage for Gender MALE is:");
                            stats.menPercentage();
                        } else if (statOperationChoose == 5) {
                            System.out.println("The Overall Percentage for Gender FEMALE is:");
                            stats.womenPercentage();

                        } else if (statOperationChoose == 6) {
                            System.out.println("Bonus Summary:");
                            System.out.println("------------- ");
                            stats.sumOfBonus();                          

                        } else if (statOperationChoose == 0) {
                            runagain = true;
                        }

                        break;

                    case 0:
                        runagain = false;

                        break;
                    default:
                        System.out.println("Wrong input (1,2,0)");
                        break;
                }
            } catch (Exception e) {
                System.out.println("*******invalid input ***********");
            }
        } while (runagain);
    }   
        }

   

