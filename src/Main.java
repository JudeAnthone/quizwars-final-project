import java.io.*; // For file handling
import java.util.*; // For using Scanner and List classes

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize scanner to take user input

        // Display welcome message and ask for difficulty
        System.out.println("Welcome to Trivia Game!");
        System.out.print("Please select difficulty (easy, medium, hard): ");
        String difficulty = scanner.nextLine().toLowerCase(); // Convert input to lowercase for consistency

        // Load questions based on the selected difficulty
        List<Question> questions = loadQuestions(difficulty);

        if (questions != null && !questions.isEmpty()) { // Ensure there are questions to play with
            System.out.println("Starting the game...");

            // Loop through each question in the list
            for (Question q : questions) {
                // Display the question and its options
                System.out.println(q.getQuestion());
                System.out.println("A) " + q.getOptionA());
                System.out.println("B) " + q.getOptionB());
                System.out.println("C) " + q.getOptionC());
                System.out.println("D) " + q.getOptionD());
                System.out.print("Your answer: ");
                String answer = scanner.nextLine().toUpperCase(); // Convert user's input to uppercase for comparison

                // Check if the user's answer is correct
                if (answer.equals(q.getCorrectAnswer())) {
                    System.out.println("Correct!\n"); // Provide feedback for a correct answer
                } else {
                    System.out.println("Wrong! The correct answer was " + q.getCorrectAnswer() + "\n"); // Show the correct answer
                }
            }
        } else {
            System.out.println("No questions available for this difficulty."); // Handle cases where no questions are loaded
        }
        scanner.close(); // Close the scanner to prevent resource leaks
    }

    // Method to load questions from the corresponding file
    public static List<Question> loadQuestions(String difficulty) {
        List<Question> questions = new ArrayList<>(); // Create a list to store questions
        String filePath = "resources/" + difficulty + ".txt"; // Path to the file containing questions

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Open the file for reading
            String line;
            while ((line = reader.readLine()) != null) { // Read each line until EOF
                String[] parts = line.split(","); // Split the line into parts using a comma
                if (parts.length == 5) { // Ensure the line contains 5 parts (question + 4 options)
                    String questionText = parts[0]; // Extract the question text
                    String optionA = parts[1]; // Extract option A
                    String optionB = parts[2]; // Extract option B
                    String optionC = parts[3]; // Extract option C
                    String optionD = parts[4]; // Extract option D

                    // Create a question object based on the difficulty
                    Question question = createQuestion(difficulty, questionText, optionA, optionB, optionC, optionD);
                    if (question != null) {
                        questions.add(question); // Add the question to the list
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print an error message if file reading fails
        }
        return questions; // Return the list of questions
    }

    // Factory method to create a question object based on the difficulty
    public static Question createQuestion(String difficulty, String questionText, String optionA, String optionB, String optionC, String optionD) {
        switch (difficulty) {
            case "easy":
                return new EasyQuestion(questionText, optionA, optionB, optionC, optionD);
            case "medium":
                return new MediumQuestion(questionText, optionA, optionB, optionC, optionD);
            case "hard":
                return new HardQuestion(questionText, optionA, optionB, optionC, optionD);
            default:
                return null; // Return null if an invalid difficulty is provided
        }
    }
}
