

import java.util.ArrayList;
import java.util.Scanner;


public class QuizEngine {

    private ArrayList<Question> questions; 
    private String quizTitle;
    private int score;
    private int totalMarks;

    public QuizEngine(String quizTitle) {
        this.quizTitle = quizTitle;
        this.questions = new ArrayList<>();
        this.score = 0;
        this.totalMarks = 0;
    }

    
    public void addQuestion(Question q) {
        if (q == null) throw new InvalidQuestionException("Cannot add a null question.");
        questions.add(q);
        totalMarks += q.getMarks();
    }

    
    public int getQuestionCount() {
        return questions.size();
    }

    
    public void startQuiz() {
        if (questions.isEmpty()) {
            System.out.println("[ERROR] No questions available. Cannot start quiz.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        score = 0;

        printBanner("  " + quizTitle + "  ");
        System.out.println("  Total Questions : " + questions.size());
        System.out.println("  Total Marks     : " + totalMarks);
        System.out.println("  Type your answer and press Enter.");
        printDivider();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("\nQ" + (i + 1) + ". [" + q.getMarks() + " mark"
                               + (q.getMarks() > 1 ? "s" : "") + "]");

            q.display(); 

            String userAnswer = "";
            boolean validInput = false;

            
            while (!validInput) {
                try {
                    userAnswer = sc.nextLine().trim();
                    validateAnswer(userAnswer, q);
                    validInput = true;
                } catch (InvalidAnswerException e) {
                    System.out.println("  [!] " + e.getMessage() + " Please try again: ");
                }
            }

            if (q.checkAnswer(userAnswer)) { 
                System.out.println("  ✔  Correct! +" + q.getMarks());
                score += q.getMarks();
            } else {
                System.out.println("  ✘  Wrong. Correct answer: " + q.getCorrectAnswer());
            }
        }

        displayResult();
        sc.close();
    }

   
    private void validateAnswer(String answer, Question q) throws InvalidAnswerException {
        if (answer == null || answer.isEmpty()) {
            throw new InvalidAnswerException("Answer cannot be empty.");
        }
        if (q instanceof MCQQuestion) {
            char c = answer.toUpperCase().charAt(0);
            int numOptions = ((MCQQuestion) q).getOptions().size();
            char maxLabel = (char) ('A' + numOptions - 1);
            if (c < 'A' || c > maxLabel) {
                throw new InvalidAnswerException(
                    "Please enter a letter between A and " + maxLabel + ".");
            }
        } else if (q instanceof TrueFalseQuestion) {
            String a = answer.toLowerCase();
            if (!a.equals("true") && !a.equals("false")
                    && !a.equals("t") && !a.equals("f")
                    && !a.equals("a") && !a.equals("b")) {
                throw new InvalidAnswerException(
                    "Please enter True/False (or T/F or A/B).");
            }
        }
    }

    
    private void displayResult() {
        printDivider();
        System.out.println("\n  *** QUIZ COMPLETE ***");
        System.out.println("  Score   : " + score + " / " + totalMarks);
        double percent = (totalMarks > 0) ? (score * 100.0 / totalMarks) : 0;
        System.out.printf("  Percent : %.1f%%\n", percent);
        System.out.println("  Grade   : " + getGrade(percent));
        printDivider();
    }

    private String getGrade(double percent) {
        if (percent >= 90) return "A+ (Outstanding)";
        if (percent >= 75) return "A  (Excellent)";
        if (percent >= 60) return "B  (Good)";
        if (percent >= 45) return "C  (Average)";
        if (percent >= 33) return "D  (Pass)";
        return "F  (Fail)";
    }

    private void printBanner(String text) {
        String line = "=".repeat(text.length() + 4);
        System.out.println("\n" + line);
        System.out.println("  " + text);
        System.out.println(line);
    }

    private void printDivider() {
        System.out.println("--------------------------------------------------");
    }

    public int getScore()      { return score; }
    public int getTotalMarks() { return totalMarks; }
    public ArrayList<Question> getQuestions() { return questions; }
}
