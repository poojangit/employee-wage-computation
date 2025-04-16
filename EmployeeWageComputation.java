import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main class to handle employee wage computation for multiple companies
public class EmployeeWageComputation {

    // List to store EmpWageBuilder objects for each company
    private List<EmpWageBuilder> companyList = new ArrayList<>();

    // Method to add company and its wage-related parameters to the list
    public void addCompany(String companyName, int wagePerHour, int maxDays, int maxHours) {
        companyList.add(new EmpWageBuilder(companyName, wagePerHour, maxDays, maxHours));
    }

    // Method to compute wages for all companies in the list
    public void computeWages() {
        for (EmpWageBuilder company : companyList) {
            company.computeWage(); // Call compute method of each company
        }
    }

    // Method to display total wage of all companies
    public void showAllCompanyWages() {
        System.out.println("\n****** Company Wages *********");
        for (EmpWageBuilder company : companyList) {
            System.out.println(company.getCompanyName() + " => Total Wage : Rs." + company.getTotalWage());
        }
        System.out.println("*****************************************************\n");
    }

    // Main method to interact with the user and manage wage computation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        EmployeeWageComputation system = new EmployeeWageComputation();

        System.out.println("Welcome to Employee Wage Computation Program!");
        System.out.print("Enter number of companies to compute wages for: ");
        int numCompanies = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Loop to take input for each company
        for (int i = 1; i <= numCompanies; i++) {
            System.out.println("\nEnter details for Company " + i + ":");

            // Input: Company Name
            System.out.print("Company Name: ");
            String companyName = sc.nextLine();

            // Input: Wage per Hour
            System.out.print("Wage per Hour: ");
            int wagePerHour = sc.nextInt();

            // Input: Maximum Working Days per month
            System.out.print("Maximum Working Days: ");
            int maxWorkingDays = sc.nextInt();

            // Input: Maximum Working Hours per month
            System.out.print("Maximum Working Hours per Month: ");
            int maxWorkingHours = sc.nextInt();
            sc.nextLine(); // Consume leftover newline

            // Add company to system
            system.addCompany(companyName, wagePerHour, maxWorkingDays, maxWorkingHours);
        }

        // Note: Compute and display methods can be called here if needed:
        system.computeWages();
        system.showAllCompanyWages();

        sc.close(); // Close the scanner to avoid memory leak
    }
}
