 // EasyQuestion class inherits from Question and represents questions of easy difficulty
public class EasyQuestion extends Question {
    
    // Constructor to initialize an easy question with its options
    public EasyQuestion(String questionText, String optionA, String optionB, String optionC, String optionD) {
        super(questionText, optionA, optionB, optionC, optionD); // Call the superclass constructor
        this.correctAnswer = "A"; // For the easy question, we assume option A is correct (you can adjust this)
    }

    // Implement the abstract method to return the correct answer for an easy question
    @Override
    public String getCorrectAnswer() {
        return correctAnswer; // Return the correct answer (in this case, option A)
    }
}
