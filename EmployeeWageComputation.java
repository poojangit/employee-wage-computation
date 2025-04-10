import java.util.Random;
import java.util.Scanner;

public class EmployeeWageComputation {
    // Main method
    public static void main(String[] args) {
        // Displaying a welcome message
        System.out.println("Welcome to employee wage computation Problem!!");
        // creating a new Scanner Object
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a employee Name : ");
        String name = sc.nextLine();
        // creating random object
        Random random = new Random();
        int wagePerHour = 20;
        int fullDayHours = 8;
        // part-time attributes half of a full day
        int partTimeHours = 4;
        // total working days per month.
        int totalWorkingDays = 20;
        // initializing the total wage per month
        int wagePerMonth = 0;
        for (int day = 1; day <= totalWorkingDays; day++) {
            // 0 - absent , 1-present for full time , 2- present for part-time
            int attendance = random.nextInt(3);
            // solving in switch case instead of if-else to find the attendance status
            int dailyHours = 0;
            switch (attendance) {
                case 1:
                    System.out.println("Day " + day + " Employee " + name + " is Present for full-time");
                    // setting daily hours for full time
                    dailyHours = fullDayHours;
                    break;
                case 2:
                    System.out.println("Day " + day + " Employee " + name + " is Presnt for part-time");
                    // setting a daily hours for part time
                    dailyHours = partTimeHours;
                    break;
                case 0:
                    System.out.println("Day " + day + "Employee " + name + " is Absent!!");
                    dailyHours = 0;
                    break;
                default:
                    System.out.println("Invalid Attendance!");
            }
            // calculate the daily wage
            int dailyWage = dailyHours * wagePerHour;
            // total wage based on month
            wagePerMonth += dailyWage;
            System.out.println("Daily wage for Day " + day + ": " + dailyWage);
        }
        // Output of the daily wage
        System.out.println("Total Wage for a month : " + wagePerMonth);
        sc.close();
    }

}
