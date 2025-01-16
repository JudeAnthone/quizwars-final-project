import java.util.*;

public class QuizGame {
    // Console width (adjust if needed)
    private static final int CONSOLE_WIDTH = 60;

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean playAgain = true;

        // Keep the ASCII art title as is since it's pre-formatted
        System.out.println(
												" __        __   _                            _           ___        _    __        __             _ \r\n" +
                " \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___    / _ \\ _   _(_)___\\ \\      / /_ _ _ __ ___| |\r\n" +
                "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | | | | | | |_  /\\ \\ /\\ / / _` | '__/ __| |\r\n" +
                "   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |_| | |_| | |/ /  \\ V  V / (_| | |  \\__ \\_|\r\n" +
                "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   \\__\\_\\\\__,_|_/___|  \\_/\\_/ \\__,_|_|  |___(_)\r\n");

        printCentered("=======================================");
        printCentered("WELCOME TO QUIZ WARS");
        printCentered("Test Your Knowledge!");
        printCentered("=======================================");

        while (playAgain) {
            int score = 0;
            int totalQuestions = 0;

            printCentered("\n            ------ Select Difficulty Level ------");
            printCentered("| 1. Easy                          |");
            printCentered("| 2. Medium                        |");
            printCentered("| 3. Hard                          |");
            printCentered("----------------------------------");

            String difficulty;
            while (true) {
                printCentered("Please Enter your Choice (1, 2, or 3): ");
                String choice = userInput.nextLine().trim().toLowerCase();
                switch (choice) {
                    case "1": difficulty = "easy"; break;
                    case "2": difficulty = "medium"; break;
                    case "3": difficulty = "hard"; break;
                    default:
                        printCentered("ERROR: Invalid choice of Difficulty. Please select 1, 2, 3 only!");
                        continue;
                }
                break;
            }

            List<Question> questions = QuestionLoader.loadQuestion(difficulty);
            if (questions == null || questions.isEmpty()) {
                printCentered("\nERROR: No question Available! \n");
                continue;
            }

            printCentered("\n                            READY KA NA BA?                         ");
            for (int i = 3; i > 0; i--) {
                printCentered(i + "......");
                sleep(500);
            }
            printCentered("GO! \n");
            sleep(500);

            totalQuestions = questions.size();

            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);

                printCentered("\nQuestion " + (i + 1) + " of " + totalQuestions);
                String progressBar = "Progress: [" + getProgressBar(i + 1, totalQuestions) + "]";
                printCentered(progressBar);

                printCentered("========================================");
                printCentered(q.getQuestionText());
                printCentered("========================================");
                printCentered("A: " + q.getOptionA());
                printCentered("B: " + q.getOptionB());
                printCentered("C: " + q.getOptionC());
                printCentered("D: " + q.getOptionD());
                printCentered("========================================");

                String answer;
                while (true) {
                    printCentered("Your Answer (A - B - C - D):");
                    answer = userInput.nextLine().trim().toUpperCase();
                    if (answer.matches("[ABCD]")) break;
                    printCentered("ERROR: INVALID INPUT. Please enter A, B, C, D.");
                }

                if (answer.equals(q.getCorrectAnswer())) {
                    printCentered("CORRECT!!\n");
                    score++;
                } else {
                    printCentered("TRY AGAIN! The correct answer is: " + q.getCorrectAnswer() + "\n");
                }

                printCentered("---------------------------------------");
                printCentered("Current Score: " + score + " out of " + (i + 1));
                printCentered("---------------------------------------");

                sleep(1000);
            }

            double percentage = (score * 100.0) / totalQuestions;
            printCentered("\n=======================================");
            printCentered("            FINAL RESULTS             ");
            printCentered("=======================================");
            printCentered(String.format("Final Score: %d/%d", score, totalQuestions));
            printCentered(String.format("Percentage: %.1f%%", percentage));
            printCentered("---------------------------------------");

            if (percentage >= 90) {
                printCentered("ANG GALING!");
            } else if (percentage >= 70) {
                printCentered("GOOD JOB!");
            } else if (percentage >= 50) {
                printCentered("GALINGAN MO PA!");
            } else {
                printCentered("BONAK!");
            }

            printCentered("=======================================");

            printCentered("\nWould you like to Play Again? (Y/N): ");
            String userResponse = userInput.nextLine().trim().toLowerCase();
            playAgain = userResponse.startsWith("y");

            if (!playAgain) {
                printCentered("\n=======================================");
                printCentered("          Thanks for playing!         ");
                printCentered("            See you soon!            ");
                printCentered("=======================================");
            }
        }
        userInput.close();
    }

    // Helper method to center text
    private static void printCentered(String text) {
        int padding = (CONSOLE_WIDTH - text.length()) / 2;
        if (padding > 0) {
            System.out.println(" ".repeat(padding) + text);
        } else {
            System.out.println(text);
        }
    }

    private static String getProgressBar(int current, int total) {
        int barLength = 20;
        int progress = (int) ((double) current / total * barLength);
        StringBuilder bars = new StringBuilder();
        for (int i = 0; i < barLength; i++) {
            if (i < progress) {
                bars.append("=");
            } else {
                bars.append("-");
            }
        }
        return bars.toString();
    }

    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}