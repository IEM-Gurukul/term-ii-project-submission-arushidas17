

import java.util.List;


public class MCQQuestion extends Question {
    private List<String> options;   
    private int correctOptionIndex; 

    public MCQQuestion(String questionText, List<String> options, int correctOptionIndex, int marks) {
        super(questionText, marks);
        if (options == null || options.size() < 2) {
            throw new InvalidQuestionException("MCQ must have at least 2 options.");
        }
        if (correctOptionIndex < 0 || correctOptionIndex >= options.size()) {
            throw new InvalidQuestionException("Correct option index is out of range.");
        }
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    @Override
    public void display() {
        System.out.println("  " + getQuestionText());
        char label = 'A';
        for (String opt : options) {
            System.out.println("    " + label + ") " + opt);
            label++;
        }
        System.out.print("  Your answer (A/B/C/D...): ");
    }

    
    @Override
    public boolean checkAnswer(String userAnswer) {
        if (userAnswer == null || userAnswer.trim().isEmpty()) return false;
        char ch = userAnswer.trim().toUpperCase().charAt(0);
        int idx = ch - 'A';
        return idx == correctOptionIndex;
    }

    @Override
    public String getCorrectAnswer() {
        char label = (char) ('A' + correctOptionIndex);
        return label + ") " + options.get(correctOptionIndex);
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}