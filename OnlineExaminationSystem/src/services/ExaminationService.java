package services;

import models.Question;
import java.util.List;
import java.util.Scanner;

public class ExaminationService {
    private List<Question> mcqQuestions;
    private List<Question> descriptiveQuestions;
    private Scanner scanner = new Scanner(System.in);

    public ExaminationService(List<Question> mcqQuestions, List<Question> descriptiveQuestions) {
        this.mcqQuestions = mcqQuestions;
        this.descriptiveQuestions = descriptiveQuestions;
    }

    // MCQ exam
    public void startMCQExam() {
        System.out.println("Starting MCQ exam...");

        for (Question question : mcqQuestions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            question.setAnswer(options[choice - 1]);
        }

        System.out.println("MCQ Exam completed!");
    }

    // Descriptive exam
    public void startDescriptiveExam() {
        System.out.println("Starting Descriptive exam...");

        for (Question question : descriptiveQuestions) {
            System.out.println(question.getQuestionText());
            System.out.print("Enter your answer: ");
            String answer = scanner.nextLine();
            question.setAnswer(answer);
        }

        System.out.println("Descriptive Exam completed!");
    }
}
