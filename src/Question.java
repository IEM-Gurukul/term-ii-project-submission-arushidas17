


public abstract class Question {
    private String questionText;
    private int marks;

    public Question(String questionText, int marks) {
        if (questionText == null || questionText.trim().isEmpty()) {
            throw new InvalidQuestionException("Question text cannot be empty.");
        }
        if (marks <= 0) {
            throw new InvalidQuestionException("Marks must be a positive integer.");
        }
        this.questionText = questionText.trim();
        this.marks = marks;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getMarks() {
        return marks;
    }

    
    public abstract void display();

    
    public abstract boolean checkAnswer(String userAnswer);

    
    public abstract String getCorrectAnswer();
}