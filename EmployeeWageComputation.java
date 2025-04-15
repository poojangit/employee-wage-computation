import java.util.Random;
import java.util.Scanner;

public class EmployeeWageComputation {

    public static void computeEmployeeWage(String companyName, int wagePerHour, int maxWorkingDays,
            int maxWorkingHours) {
        int totalWage = 0;
        int totalHours = 0;
        int totalDays = 0;

        Random random = new Random();

        System.out.println("\n--- Wage Computation for Company: " + companyName + " ---");

        while (totalHours < maxWorkingHours && totalDays < maxWorkingDays) {
            totalDays++;
            int attendance = random.nextInt(3); // 0 - Absent, 1 - Full-time, 2 - Part-time
            int dailyHours = 0;

            switch (attendance) {
                case 1:
                    System.out.println("Day " + totalDays + ": Employee is Present for full-time");
                    dailyHours = 8;
                    break;
                case 2:
                    System.out.println("Day " + totalDays + ": Employee is Present for part-time");
                    dailyHours = 4;
                    break;
                case 0:
                    System.out.println("Day " + totalDays + ": Employee is Absent");
                    dailyHours = 0;
                    break;
            }

            if (totalHours + dailyHours > maxWorkingHours) {
                dailyHours = maxWorkingHours - totalHours;
            }

            int dailyWage = dailyHours * wagePerHour;
            totalWage += dailyWage;
            totalHours += dailyHours;

            System.out.println("Worked Hours: " + dailyHours + ", Daily Wage: " + dailyWage);
            System.out.println("Total Hours So Far: " + totalHours);
            System.out.println("--------------------------------------------");
        }

        System.out.println("***** Final Details for " + companyName + " *****");
        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage for the Month: " + totalWage);
        System.out.println("=============================================\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Employee Wage Computation Program!");
        System.out.print("Enter number of companies to compute wages for: ");
        int numCompanies = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        for (int i = 1; i <= numCompanies; i++) {
            System.out.println("\nEnter details for Company " + i + ":");

            System.out.print("Company Name: ");
            String companyName = sc.nextLine();

            System.out.print("Wage per Hour: ");
            int wagePerHour = sc.nextInt();

            System.out.print("Maximum Working Days: ");
            int maxWorkingDays = sc.nextInt();

            System.out.print("Maximum Working Hours per Month: ");
            int maxWorkingHours = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            computeEmployeeWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        }

        sc.close();
    }
}
