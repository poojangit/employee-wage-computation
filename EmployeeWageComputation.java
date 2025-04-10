import java.util.Random;
import java.util.Scanner;

public class EmployeeWageComputation {
    // Main method
    public static void main(String[] args) {
        // Displaying a welcome message
        System.out.println("Welcome to employee wage computation Problem!!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a employee Name : ");
        String name = sc.nextLine();
        Random random = new Random();
        int attendance = random.nextInt(2);
        System.out.println(attendance);
        if (attendance == 0) {
            System.out.println("Employee " + name + " is absent!!");
        } else
            System.out.println("Employee " + name + " is presnt ");
        sc.close();
    }

}
