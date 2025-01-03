 import java.io.*;
import java.util.*;

public class QuestionLoader {
    
    // Method to load questions from a specified difficulty file
    public static List<Question> loadQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>(); // List to hold all questions for the selected difficulty
        String filePath = "resources/" + difficulty + ".txt"; // Determine the file path based on the difficulty

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Try opening the file for reading
            String line;
            while ((line = reader.readLine()) != null) { // Read each line from the file
                String[] parts = line.split(","); // Split the line by commas to extract parts of the question
                if (parts.length == 5) { // Ensure there are exactly 5 parts (question + 4 options)
                    String questionText = parts[0]; // The first part is the question
                    String optionA = parts[1]; // The second part is option A
                    String optionB = parts[2]; // The third part is option B
                    String optionC = parts[3]; // The fourth part is option C
                    String optionD = parts[4]; // The fifth part is option D

                    // Create a question object based on the difficulty level
                    Question question = createQuestion(difficulty, questionText, optionA, optionB, optionC, optionD);
                    if (question != null) {
                        questions.add(question); // Add the question to the list
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print error if file reading fails
        }
        return questions; // Return the list of questions
    }

    // Factory method to create different types of questions based on difficulty
    private static Question createQuestion(String difficulty, String questionText, String optionA, String optionB, String optionC, String optionD) {
        switch (difficulty) {
            case "easy":
                return new EasyQuestion(questionText, optionA, optionB, optionC, optionD); // Return an EasyQuestion
            case "medium":
                return new MediumQuestion(questionText, optionA, optionB, optionC, optionD); // Return a MediumQuestion
            case "hard":
                return new HardQuestion(questionText, optionA, optionB, optionC, optionD); // Return a HardQuestion
            default:
                return null; // If the difficulty is invalid, return null
        }
    }
}
