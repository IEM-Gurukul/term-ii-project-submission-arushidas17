public class TrueFalseQuestion extends Question {
    private boolean correctAnswer; 

    public TrueFalseQuestion(String questionText, boolean correctAnswer, int marks) {
        super(questionText, marks);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void display() {
        System.out.println("  " + getQuestionText());
        System.out.println("    A) True");
        System.out.println("    B) False");
        System.out.print("  Your answer (True/False or T/F): ");
    }

    
    @Override
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) return false;
        String a = userAnswer.trim().toLowerCase();
        boolean userBool;
        switch (a) {
            case "true":  case "t": case "yes": case "y": case "a": userBool = true;  break;
            case "false": case "f": case "no":  case "n": case "b": userBool = false; break;
            default: return false;
        }
        return userBool == correctAnswer;
    }

    @Override
    public String getCorrectAnswer() {
        return correctAnswer ? "True" : "False";
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }
}
