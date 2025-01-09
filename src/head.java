  import java.io.*;
import java.util.*;

public class head {

  public static void main (String[] args) {
    Scanner userInput = new Scanner(System.in);

    //MESSAGE DISPLAY
    System.out.println(" \r\n" + //
        " __        __   _                            _           ___        _    __        __             _ \r\n" + //
        " \\ \\      / /__| | ___ ___  _ __ ___   ___  | |_ ___    / _ \\ _   _(_)___\\ \\      / /_ _ _ __ ___| |\r\n"
        + //
        "  \\ \\ /\\ / / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | | | | | | |_  /\\ \\ /\\ / / _` | '__/ __| |\r\n"
        + //
        "   \\ V  V /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |_| | |_| | |/ /  \\ V  V / (_| | |  \\__ \\_|\r\n" + //
        "    \\_/\\_/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   \\__\\_\\\\__,_|_/___|  \\_/\\_/ \\__,_|_|  |___(_)\r\n"
        + //
        "                                                                                                    \r\n" + //
        "");

    System.out.println("Please Select Difficulty: Easy, Medium, Hard: ");
    String difficulty = userInput.nextLine().toLowerCase();

    // load question based on difficulty
    List<Question> questions = QuestionLoader.loadQuestion(difficulty);

    // ensuring that there are question to play with - If question is not null && not empty
    if (questions != null && !questions.isEmpty()) {
      System.out.println("Starting the Game!!!!!");

      //displaying questions via looping
      for (Question q : questions) {
        System.out.println(q.getQuestionText());
        System.out.println("A " + q.getOptionA());
        System.out.println("B " + q.getOptionB());
        System.out.println("C " + q.getOptionC());
        System.out.println("D " + q.getOptionD());
        System.out.println('\n');
        System.out.println("Your Answer: ");
        String answer = userInput.nextLine().toUpperCase();

        if (answer.equals(q.getCorrectAnswer())) {
          System.out.println("Correct!\n");
        } else {
          System.out.println("TRY AGAIN! The Correct answer is " + q.getCorrectAnswer() + "\n");
        }
      }
      userInput.close();
    }

  }
  
}