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
        int attendance = random.nextInt(2);
        System.out.println(attendance);
        // check if the employee is absent
        if (attendance == 0) {
            System.out.println("Employee " + name + " is absent!!");
        } else
            System.out.println("Employee " + name + " is presnt ");
        sc.close();
        // calculating daily wage
        int dailyWage = wagePerHour * fullDayHours;
        // Output of the daily wage
        System.out.println("Daily Employee Wage is : " + dailyWage);
    }

}
