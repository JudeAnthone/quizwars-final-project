 public abstract class Question {
    protected String questionText; // The text of the question
    protected String optionA; // Option A for the question
    protected String optionB; // Option B for the question
    protected String optionC; // Option C for the question
    protected String optionD; // Option D for the question
    protected String correctAnswer; // The correct answer for the question

    // Constructor to initialize a question
    public Question(String questionText, String optionA, String optionB, String optionC, String optionD) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
    }

    // Abstract method to get the correct answer (implemented in subclasses)
    public abstract String getCorrectAnswer();

    public String getQuestion() {
        return questionText; // Return the question text
    }

    public String getOptionA() {
        return optionA; // Return option A
    }

    public String getOptionB() {
        return optionB; // Return option B
    }

    public String getOptionC() {
        return optionC; // Return option C
    }

    public String getOptionD() {
        return optionD; // Return option D
    }
}
