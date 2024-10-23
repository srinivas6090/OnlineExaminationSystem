package models;

public class Question {
    private String questionText;
    private String[] options; // For MCQs
    private String answer;

    // Constructor for MCQs
    public Question(String questionText, String[] options) {
        this.questionText = questionText;
        this.options = options;
    }

    // Constructor for descriptive questions
    public Question(String questionText) {
        this.questionText = questionText;
    }

    // Getter and Setter
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
