import java.util.Scanner;

public class AikidoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnePersonJournal journal = new OnePersonJournal();

        while (true) {
            System.out.printf(
                    "%n===================================%n" +
                            "===== Aikido Practice Tracker =====%n" +
                            "=======  Choose an option:  =======%n" +
                            "===================================%n%n" +
                            "1. Add Practice Session%n" +
                            "2. View Total Practice Time%n" +
                            "3. Check Graduation Eligibility%n" +
                            "4. Exit%n%n" +
                            "Enter your choice: "
            );

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter session duration in minutes: ");
                    int duration = scanner.nextInt();
                    journal.AddSession(new Session(duration));
                    System.out.printf("Session added successfully!%n");
                    break;

                case 2:
                    System.out.printf("Total practice time: %.2f hours.%n", journal.ReturnTotalPracticeTime());
                    break;

                case 3:
                    System.out.printf("%s%n",
                            journal.KyuGraduated() ?
                                    "Congratulations! You are eligible for Kyu graduation." :
                                    "Keep practicing! You need more sessions or time."
                    );
                    break;

                case 4:
                    System.out.printf("Exiting Aikido Practice Tracker. See you next time!%n");
                    scanner.close();
                    return;

                default:
                    System.out.printf("Invalid choice. Please enter a number between 1 and 4.%n");
            }

            System.out.printf("%nPress Enter to continue...");
            scanner.nextLine();
        }
    }
}
