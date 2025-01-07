// base class of the questions 
// abstract class
public abstract class Question {
  protected String questionText;
  protected String optionA;
  protected String optionB;
  protected String optionC;
  protected String optionD;
  protected String correctAnswer; 

   
  // constructors
  public Question(String questionText, String optionA, String optionB, String optionC, String optionD) {
    this.questionText = questionText;
    this.optionA = optionA;
    this.optionB = optionB;
    this.optionC = optionC;
    this.optionD = optionD;
  }

  // abstract method to get the correct ans. Implemented in subclasses (easy, medium, hard) - Override this
  public abstract String getCorrectAnswer();

  // getters
  public String getQuestionText() {
    return questionText;
  }

  public String getOptionA() {
    return optionA;
  }

  public String getOptionB() {
    return optionB;
  }

  public String getOptionC() {
    return optionC;
  }

  public String getOptionD() {
    return optionD;
  }


 }

