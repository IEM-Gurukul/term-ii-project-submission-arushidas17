

import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        QuizEngine engine = new QuizEngine("Java OOP Knowledge Quiz");

    
        engine.addQuestion(QuestionFactory.createMCQ(
            "Which keyword is used to create a subclass in Java?",
            Arrays.asList("implements", "extends", "inherits", "super"),
            1, 
            2
        ));

        engine.addQuestion(QuestionFactory.createMCQ(
            "Which OOP concept hides internal implementation details?",
            Arrays.asList("Inheritance", "Polymorphism", "Encapsulation", "Abstraction"),
            2, 
            2
        ));

        engine.addQuestion(QuestionFactory.createMCQ(
            "What does the 'final' keyword do to a method?",
            Arrays.asList("Makes it static", "Prevents overriding",
                          "Makes it abstract", "Speeds up execution"),
            1, 
            2
        ));

        engine.addQuestion(QuestionFactory.createMCQ(
            "Which collection allows duplicate elements in Java?",
            Arrays.asList("HashSet", "TreeSet", "ArrayList", "LinkedHashSet"),
            2, 
            1
        ));

        engine.addQuestion(QuestionFactory.createMCQ(
            "What design pattern is used to delegate object creation?",
            Arrays.asList("Singleton", "Observer", "Factory", "Decorator"),
            2, 
            2
        ));

        
        engine.addQuestion(QuestionFactory.createTrueFalse(
            "An abstract class can have constructors in Java.",
            true,
            1
        ));

        engine.addQuestion(QuestionFactory.createTrueFalse(
            "A Java interface can contain concrete (non-abstract) methods before Java 8.",
            false,
            1
        ));

        engine.addQuestion(QuestionFactory.createTrueFalse(
            "Method overloading is an example of compile-time polymorphism.",
            true,
            1
        ));

        engine.addQuestion(QuestionFactory.createTrueFalse(
            "The 'super' keyword can be used to call a parent class constructor.",
            true,
            1
        ));

        engine.addQuestion(QuestionFactory.createTrueFalse(
            "ArrayList is synchronized (thread-safe) by default in Java.",
            false,
            1
        ));

        
        engine.startQuiz();
    }
}