import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class OnlineExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Login
        System.out.println("Welcome to the Online Examination!");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        // Validate login credentials
        if (!isValidLogin(username, password)) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }
        
        // Start the examination
        System.out.println("\nWelcome, " + username + "!");
        System.out.println("You have 2 minutes to complete the examination.");
        System.out.println("The timer starts now!");
        
        // Set the timer for 2 minutes
        long startTime = System.currentTimeMillis();
        long endTime = startTime + TimeUnit.MINUTES.toMillis(2);
        
        // MCQs
        String[] questions = {
            "Which is the most famous programming language?",
            "Who is the author of 'Pride and Prejudice'?",
            "Which Indian film won Oscar recently?",
            "Which is the largest planet in our solar system?",
            "What is 5 + 20?"
        };
        
        String[][] options = {
            {"A. Php", "B. Python", "C. Go", "D. Ruby"},
            {"A. Jane Austen", "B. Charlotte Bronte", "C. William Shakespeare", "D. Charles Dickens"},
            {"A. Bahubali", "B. 3 idiots", "C. Pushpa", "D. RRR"},
            {"A. Mars", "B. Venus", "C. Jupiter", "D. Saturn"},
            {"A. 50", "B. 24", "C. 15", "D. 25"}
        };
        
        int[] correctAnswers = {1, 0, 3, 2, 3}; // Index of the correct option for each question
        
        // Variables for tracking score and answered questions
        int score = 0;
        int answeredQuestions = 0;
        
        // Loop through the MCQs until the timer expires
        for (int i = 0; i < questions.length && System.currentTimeMillis() < endTime; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            System.out.println(questions[i]);
            
            // Display options
            for (String option : options[i]) {
                System.out.println(option);
            }
            
            System.out.print("Your answer (enter option letter): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            
            // Check if the answer is correct
            if (userAnswer.equals(String.valueOf((char) ('A' + correctAnswers[i])))) {
                System.out.println("Correct answer!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }
            
            answeredQuestions++;
        }
        
        // Calculate the remaining time
        long remainingTime = TimeUnit.MILLISECONDS.toSeconds(endTime - System.currentTimeMillis());
        
        // Auto-submit if all questions are answered or the timer expires
        if (answeredQuestions == questions.length || remainingTime <= 0) {
            System.out.println("\nTime's up! Your answers are being submitted...");
            // Simulate submission process
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        // Display final score
        System.out.println("\nYour score: " + score + "/" + questions.length);
        
        // Log out
        System.out.println("\nThank you for taking the Online Examination, " + username + "!");
        System.out.println("You are now logged out.");
        
        // Close the scanner
        scanner.close();
    }
    
    // Method to validate login credentials (dummy implementation)
    private static boolean isValidLogin(String username, String password) {
        // You can implement your own validation logic here
        // For simplicity, we assume any username and password combination is valid
        return true;
    }
}
