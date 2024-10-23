import services.AuthenticationService;
import services.ExaminationService;
import utils.Database;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AuthenticationService authService = new AuthenticationService();
        Database db = new Database();
        ExaminationService examService = new ExaminationService(db.getMCQQuestions(), db.getDescriptiveQuestions());

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Online Examination System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (authService.login(username, password) != null) {
                    boolean loggedIn = true;
                    while (loggedIn) {
                        System.out.println("1. Update Profile");
                        System.out.println("2. Change Password");
                        System.out.println("3. Start MCQ Exam");
                        System.out.println("4. Start Descriptive Exam");
                        System.out.println("5. Logout");
                        int userChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (userChoice) {
                            case 1:
                                System.out.print("Enter new Full Name: ");
                                String newFullName = scanner.nextLine();
                                authService.updateProfile(newFullName);
                                break;
                            case 2:
                                System.out.print("Enter new Password: ");
                                String newPassword = scanner.nextLine();
                                authService.changePassword(newPassword);
                                break;
                            case 3:
                                examService.startMCQExam();
                                break;
                            case 4:
                                examService.startDescriptiveExam();
                                break;
                            case 5:
                                authService.logout();
                                loggedIn = false;
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                }
            } else {
                running = false;
                System.out.println("Exiting...");
            }
        }
        scanner.close();
    }
}
