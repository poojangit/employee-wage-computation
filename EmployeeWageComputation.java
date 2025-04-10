import java.util.Random;
import java.util.Scanner;

public class EmployeeWageComputation {
    // class variables
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8;
    // part-time attributes half of a full day
    static final int PART_TIME_HOURS = 4;
    // total working days per month.
    static final int MAX_WORKING_DAYS = 20;
    // maximum working hours
    static final int MAX_WORKING_HOURS = 100;
    // initializing the total wage per month
    static int wagePerMonth = 0;
    static int totalHours = 0;
    static int totalDays = 0;

    public static void computeEmployeeWage() {
        // Displaying a welcome message
        System.out.println("Welcome to employee wage computation Problem!!");
        // creating a new Scanner Object
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a employee Name : ");
        String name = sc.nextLine();
        // creating random object
        Random random = new Random();

        while (totalHours < MAX_WORKING_HOURS && totalDays < MAX_WORKING_DAYS) {
            totalDays++;
            // 0 - absent , 1-present for full time , 2- present for part-time
            int attendance = random.nextInt(3);
            // solving in switch case instead of if-else to find the attendance status
            int dailyHours = 0;
            switch (attendance) {
                case 1:
                    System.out.println("Day " + totalDays + " Employee " + name + " is Present for full-time");
                    // setting daily hours for full time
                    dailyHours = FULL_DAY_HOURS;
                    break;
                case 2:
                    System.out.println("Day " + totalDays + " Employee " + name + " is Presnt for part-time");
                    // setting a daily hours for part time
                    dailyHours = PART_TIME_HOURS;
                    break;
                case 0:
                    System.out.println("Day " + totalDays + " Employee " + name + " is Absent!!");
                    dailyHours = 0;
                    break;
                default:
                    System.out.println("Invalid Attendance!");
            }
            // If total hours exceed max limit after adding, restrict to maxWorkingHours
            if (totalHours + dailyHours > MAX_WORKING_HOURS) {
                dailyHours = MAX_WORKING_HOURS - totalHours;
            }
            totalHours += dailyHours;
            // calculate the daily wage
            int dailyWage = dailyHours * WAGE_PER_HOUR;
            // total wage based on month
            wagePerMonth += dailyWage;
            System.out.println("Daily wage for Day " + totalDays + ": " + dailyWage);
            System.out.println("Total Hours Worked so far: " + totalHours);
            System.out.println("--------------------------------------------");
        }
        System.out.println("***** Final Details ******");
        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage for a month : " + wagePerMonth);
        sc.close();
    }

    public static void main(String[] args) {
        computeEmployeeWage();
    }
}
