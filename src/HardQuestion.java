 // HardQuestion class inherits from Question and represents questions of hard difficulty
public class HardQuestion extends Question {
    
    // Constructor to initialize a hard difficulty question with its options
    public HardQuestion(String questionText, String optionA, String optionB, String optionC, String optionD) {
        super(questionText, optionA, optionB, optionC, optionD); // Call the superclass constructor
        this.correctAnswer = "C"; // For hard questions, we assume option C is correct (adjust as necessary)
    }

    // Implement the abstract method to return the correct answer for a hard question
    @Override
    public String getCorrectAnswer() {
        return correctAnswer; // Return the correct answer (in this case, option C)
    }
}
