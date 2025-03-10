 // utility class
import java.io.*;
import java.util.*;

public class QuestionLoader {

  // Array List method for loading question
  public static List<Question> loadQuestion(String difficulty) {
    
    // array list to store Question objects/questions - BOOK REFFERENCE
      List<Question> questions = new ArrayList<>();
        // change file path based on device folder. 
        String filePath = "C:\\Users\\kript\\Downloads\\QUIZWARS-FINAL\\resources/" + difficulty + ".txt";
        System.out.println("\nLooking for file at:" + filePath);

            // reader method to read the txt files from filePath
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
       
      String line;
      // loop stops when the reader is null
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        if (parts.length == 6) {
          String questionText = parts[0];
            String optionA = parts[1];
              String optionB = parts[2];
                String optionC = parts[3];
                  String optionD = parts[4];
                  String correctAnswer = parts[5];
            
                  // created an object of Question.java (Abstract class)
                  Question question = createQuestion(difficulty, questionText, optionA, optionB, optionC, optionD,
                      correctAnswer);

          
          if (question != null) {
            questions.add(question);
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: File not found at " + filePath);
    } catch (IOException e){
      e.printStackTrace();
    }

    return questions;

  }
    // we now utilize the createQuestion method that we made Question.java (Abstract class)
  private static Question createQuestion(String difficulty, String questionText, String optionA, String optionB, String optionC, String optionD, String correctAnswer){
    switch (difficulty) {

      case "easy":
        return new EasyQuestion(questionText, optionA, optionB, optionC, optionD, correctAnswer);
      
        case "medium":
          return new MediumQuestion(questionText, optionA, optionB, optionC, optionD, correctAnswer);

            case "hard":
            return new HardQuestion(questionText, optionA, optionB, optionC, optionD, correctAnswer); 
        
      default:
        return null;
    }
  }
}  