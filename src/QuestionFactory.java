
import java.util.List;


public class QuestionFactory {

    public enum QuestionType {
        MCQ,
        TRUE_FALSE
    }             
    public static Question createMCQ(String text, List<String> options,
                                     int correctOptionIndex, int marks) {
        return new MCQQuestion(text, options, correctOptionIndex, marks);
    }
    public static Question createTrueFalse(String text, boolean correctAnswer, int marks) {
        return new TrueFalseQuestion(text, correctAnswer, marks);
    }
}
