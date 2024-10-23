package services;

import models.User;
import utils.Database;

public class AuthenticationService {
    private Database database = new Database();
    private User loggedInUser;

    // Method for logging in
    public User login(String username, String password) {
        User user = database.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Login Successful! Welcome " + user.getFullName());
            return user;
        } else {
            System.out.println("Invalid credentials");
            return null;
        }
    }

    // Method for logging out
    public void logout() {
        if (loggedInUser != null) {
            System.out.println("Logout Successful!");
            loggedInUser = null;
        }
    }

    // Method for updating profile
    public void updateProfile(String fullName) {
        if (loggedInUser != null) {
            loggedInUser.setFullName(fullName);
            System.out.println("Profile updated successfully!");
        }
    }

    // Method for changing password
    public void changePassword(String newPassword) {
        if (loggedInUser != null) {
            loggedInUser.setPassword(newPassword);
            System.out.println("Password updated successfully!");
        }
    }
}
