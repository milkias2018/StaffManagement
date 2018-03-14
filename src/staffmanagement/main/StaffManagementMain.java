package staffmanagement.main;

import java.util.Scanner;

public class StaffManagementMain {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        EmployeeManagement stats = new EmployeeManagement();
       

        fillDataBase();

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

                                        Secreteries emy = new Secreteries("", "", "", "", "", 0, "Secretary");
                                        System.out.println("Insert employee information: ");

                                        EmployeeManagement.addEmployeesInfo(emy);

                                        break;
                                    case "p":
                                        Programmers prog = new Programmers("", "", "", "", "", 0, "Programmers");
                                        System.out.println("Insert employee information: ");

                                        EmployeeManagement.addEmployeesInfo(prog);

                                        break;

                                    case "t":
                                        Technicians tec = new Technicians("", "", "", "", "", 0, "Technicians");
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

                            searchEmployeeMenu();

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
                            System.out.println("The Minimum Salary in the Company is:");
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

    private static void fillDataBase() {

        Programmers p1 = new Programmers("1", "abc", "lastName", "m", "22", 121234, "Programmer");
        Secreteries sec = new Secreteries("2", "Bita", "Bond", "f", "730123", 29000, "Secretary");
        Programmers p2 = new Programmers("3", "Lolo", "Cool", "f", "940120", 29000, "Programmer");
        Programmers p3 = new Programmers("4", "Maliheh", "SaadatFard", "f", "800123", 29000, "Programmer");
        Secreteries sec2 = new Secreteries("5", "Tom", "Cruise", "m", "730123", 2900000, "technician");
        Technicians tec = new Technicians("6", "ABC", "Bond", "m", "730113", 5344000, "technician");
        Technicians tec2 = new Technicians("7", "Linda", "May", "f", "900123", 34000, "technician");
        Programmers p4 = new Programmers("8", "George", "Nilsen", "m", "850123", 29000, "Programmer");
        EmployeeManagement.employee.add(p1);

        EmployeeManagement.employee.add(p1);
        EmployeeManagement.employee.add(sec);
        EmployeeManagement.employee.add(p2);
        EmployeeManagement.employee.add(sec2);
        EmployeeManagement.employee.add(tec);
        EmployeeManagement.employee.add(tec2);
        EmployeeManagement.employee.add(p4);
    }

    private static void searchEmployeeMenu() {

        boolean c = true;
        while (c) {
            try {
                System.out.println("");
                System.out.println("Choose the way do you want to search about the Employee !!");
                System.out.println("");
                System.out.println("1. Search by Employee Id");

                System.out.println("2. Search by First name");

                System.out.println("3. Search by Last name");

                int choice = scan.nextInt();
                scan.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println(EmployeeManagement.searchEmployeebyId());
                        break;

                    case 2:

                        EmployeeManagement.searchEmployeebyFirstName();
                        break;

                    case 3:
                        EmployeeManagement.searchEmployeebyLastName();
                        break;

                    default:
                        System.out.println("Wrong input");

                }

                System.out.println("Do you want to continue search about employee? Y/N");

                String response = scan.nextLine();
                System.out.println("         ---------------------        ");
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
}
