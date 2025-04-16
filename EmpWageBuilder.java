// Class to represent and compute employee wages for a specific company
public class EmpWageBuilder {

    // Instance variables for company wage computation
    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalWage;

    // Constructor to initialize company details and limits
    public EmpWageBuilder(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
        this.totalWage = 0; // Initialize total wage to zero
    }

    // Method to compute total employee wage based on working days/hours
    public void computeWage() {
        int totalHours = 0; // Track total hours worked
        int totalDays = 0; // Track total days worked

        System.out.println("\n --- Wage Computation for Company: " + companyName + " ---");

        // Loop runs until either max working days or hours is reached
        while (totalHours < maxWorkingHours && totalDays < maxWorkingDays) {
            totalDays++;

            // Random attendance: 0 = Absent, 1 = Full-time, 2 = Part-time
            int attendance = (int) (Math.random() * 3);
            int dailyHours = 0;

            // Determine daily working hours based on attendance
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

            // Ensure total hours do not exceed the monthly limit
            if (totalHours + dailyHours > maxWorkingHours) {
                dailyHours = maxWorkingHours - totalHours;
            }

            // Calculate daily wage and update totals
            int dailyWage = dailyHours * wagePerHour;
            totalWage += dailyWage;
            totalHours += dailyHours;

            // Display daily summary
            System.out.println("Worked Hours: " + dailyHours + ", Daily Wage: " + dailyWage);
            System.out.println("--------------------------------------------");
        }

        // Display final summary for the company
        System.out.println("Total Days Worked: " + totalDays);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Wage for " + companyName + " : Rs." + totalWage);
        System.out.println("=============================================\n");
    }

    // Getter method to retrieve total wage for a company
    public int getTotalWage() {
        return totalWage;
    }

    // Getter method to retrieve company name
    public String getCompanyName() {
        return companyName;
    }
}
