 // MediumQuestion class inherits from Question and represents questions of medium difficulty
public class MediumQuestion extends Question {
    
    // Constructor to initialize a medium difficulty question with its options
    public MediumQuestion(String questionText, String optionA, String optionB, String optionC, String optionD) {
        super(questionText, optionA, optionB, optionC, optionD); // Call the superclass constructor
        this.correctAnswer = "B"; // For medium questions, we assume option B is correct (adjust as necessary)
    }

    // Implement the abstract method to return the correct answer for a medium question
    @Override
    public String getCorrectAnswer() {
        return correctAnswer; // Return the correct answer (in this case, option B)
    }
}
