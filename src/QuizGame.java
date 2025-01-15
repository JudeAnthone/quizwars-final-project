 import java.util.*;

public class QuizGame {

    public static void main(String[] args) {
      
         
        // Create a Scanner for user input
        Scanner userInput = new Scanner(System.in);
        boolean playAgain = true;

        // Display a welcome message with a stylized title
        System.out.println(
                " __        __   _                            _           ___        _    __        __             _ \r\n" +
                " \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___    / _ \\ _   _(_)___\\ \\      / /_ _ _ __ ___| |\r\n" +
                "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | | | | | | |_  /\\ \\ /\\ / / _` | '__/ __| |\r\n" +
                "   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |_| | |_| | |/ /  \\ V  V / (_| | |  \\__ \\_|\r\n" +
                "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   \\__\\_\\\\__,_|_/___|  \\_/\\_/ \\__,_|_|  |___(_)\r\n"
        );

        while (playAgain) {
            int score = 0;

            // Prompt the user to select a difficulty
            System.out.println("\nTest your knowledge with multiple-choice questions. \n");

            System.out.println("Please select a difficulty: Easy, Medium, or Hard:");
            String difficulty = userInput.nextLine().trim().toLowerCase();

            // Load questions based on difficulty
            List<Question> questions = QuestionLoader.loadQuestion(difficulty);

            // Ensure there are questions to play with
            if (questions != null && !questions.isEmpty()) {
                System.out.println("\nStarting the Game!!!!!\n");

                int questionNumber = 1;

                // Loop through and display each question
                for (Question q : questions) {

                    // Display the question and its options
                    System.out.println("========================================");
                    System.out.println("                Question " + questionNumber);
                    System.out.println("========================================");
                    System.out.println(q.getQuestionText());
                    System.out.println("A: " + q.getOptionA());
                    System.out.println("B: " + q.getOptionB());
                    System.out.println("C: " + q.getOptionC());
                    System.out.println("D: " + q.getOptionD());
                    System.out.println("========================================");

                    // Prompt the user for their answer - NEW VERSION! 
                    String answer;
                    while (true) {
                        System.out.print("Your Answer (A - B - C - D): ");
                        answer = userInput.nextLine().trim().toUpperCase();
                        if (answer.matches("[ABCD]"))
                            break;
                        System.out.println("ERROR: INVALID INPUT. Please enter A, B, C, D. ");
                    }

                    // validation
                    if (answer.equals(q.getCorrectAnswer())) {
                        System.out.println("CORRECT!!\n");
                        score++;
                        System.err.println("Your Score " + score);
                    } else {
                        System.out.println("TRY AGAIN! The correct answer is: " + q.getCorrectAnswer() + "\n");
                    }
                    questionNumber++;
                }

                //FINAL SCORE
                System.out.println("Game Over! Thanks for playing!\n");
                System.out.println("Total Score is: " + score + "\n");
            } else {
                // If no questions are available for the selected difficulty
                System.out.println("\nNo questions available for the selected difficulty. Please try again.");
            }

            System.out.println("\nWould you like to Play Again? (YES OR NO): ");
            String userResponse = userInput.nextLine().trim().toLowerCase();
            

            if (!userResponse.equalsIgnoreCase("yes") && !userResponse.equalsIgnoreCase("y")) {
                playAgain = false;
                System.out.println("\nTHANK YOU FOR PLAYING!!!!\n");
            }

        }
        
        userInput.close();
    }
}
