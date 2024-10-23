package utils;

import models.Question;
import models.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {
    private HashMap<String, User> users = new HashMap<>();
    private List<Question> mcqQuestions = new ArrayList<>();
    private List<Question> descriptiveQuestions = new ArrayList<>();

    public Database() {
        // Add some users
        users.put("admin", new User("admin", "password123", "Admin User"));
        users.put("student", new User("student", "pass123", "Student User"));
        users.put("mani", new User("mani", "newpass", "Mani Srinivas"));

        // Add some MCQs
        mcqQuestions.add(new Question("What is 2 + 2?", new String[]{"1", "2", "3", "4"}));
        mcqQuestions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Lisbon"}));

        // Add some descriptive questions
        descriptiveQuestions.add(new Question("Explain polymorphism in OOP."));
        descriptiveQuestions.add(new Question("Describe the concept of machine learning."));
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public List<Question> getMCQQuestions() {
        return mcqQuestions;
    }

    public List<Question> getDescriptiveQuestions() {
        return descriptiveQuestions;
    }
}
