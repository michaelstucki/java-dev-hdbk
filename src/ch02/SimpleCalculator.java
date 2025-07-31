package ch02;

public class SimpleCalculator {
    public static void main(String[] args) {
        if (args.length == 3) {
            String operation = args[0];
            int operand1 = Integer.parseInt(args[1]);
            int operand2 = Integer.parseInt(args[2]);
            int result = 0;
            boolean valid = false;
            switch (operation) {
                case "+":
                    result = operand1 + operand2;
                    valid = true;
                    break;
                case "-":
                    result = operand1 - operand2;
                    valid = true;
                    break;
                case "*":
                    result = operand1 * operand1;
                    valid = true;
                    break;
                case "/":
                    if (operand2 != 0) {
                        result = operand1 / operand2;
                        valid = true;
                    }
                    break;
                default:
                    System.out.println(operation + " is not supported.");
            }
            if (valid) System.out.println(operand1 + " " + operation + " " + operand2 + " = " + result);
        }
    }
}
