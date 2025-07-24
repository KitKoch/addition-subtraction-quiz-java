import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntBinaryOperator;

public class AdditionSubtractionQuiz {

    private AdditionSubtractionQuiz(){}

    private static final int DIGIT_BOUND = 100;

    private static int generateRandom() {
        return ThreadLocalRandom.current().nextInt(DIGIT_BOUND);
    }

    private static void askAndCheck(Scanner input, int num1, int num2, String sign, IntBinaryOperator calc) {
        int expectedVal = calc.applyAsInt(num1, num2);
        int answerVal = promptInt(input, "What is " + num1 + " " + sign + " " + num2 + " ? ");
        System.out.println(answerVal == expectedVal ? "You are correct!" :
                "Your answer is wrong. " + num1 + " " + sign + " " + num2 + " = " + expectedVal);
    }

    private static int promptInt(Scanner input, String msg) {
        while(true) {
            System.out.print(msg);
            if(input.hasNextInt()) {
                return input.nextInt();
            } else {
                System.out.println("Please enter a whole number");
                input.next();
            }
        }
    }

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int num1 = generateRandom(), num2 = generateRandom();
            askAndCheck(input, num1, num2, "-", (x, y) -> x - y);
            askAndCheck(input, num1, num2, "+", (x, y) -> x + y);
        }

    }
}
