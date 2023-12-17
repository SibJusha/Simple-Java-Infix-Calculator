import java.util.ArrayDeque;

public class StackCalc {
    private ArrayDeque<Double> StackOfNumbers;
    private ArrayDeque<Character> StackOfOperators;

    private class Pair {
        double first;
        int second;

        public Pair(double a, int b) {
            first = a;
            second = b;
        }
    }

    public StackCalc() {
        StackOfNumbers = new ArrayDeque<>();
        StackOfOperators = new ArrayDeque<>();
    }

    private boolean SmallerOrSamePriority(char right, char left) {
        return (left == right) || 
            (right == '+' && left == '-') || 
            (right == '-' && left == '+') || 
            (right == '*' && left == '/') ||
            (right == '/' && left == '*') ||
            (right == '+' || right == '-') && (left == '*' || left == '/');
    }

    private boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    private double Operation(char ch, double right, double left) {
        switch (ch) {
            case '*':
                return left * right;
            case '/':
                return left / right;
            case '+':
                return left + right;
            case '-':
                return left - right;
            default:
                throw new IllegalArgumentException(
                                        "Неправильный символ оператора");
        }
    }

    private Pair ReadNumber(String Expression, int i) {
        if (i >= Expression.length()) {
            throw new IndexOutOfBoundsException("Нераспознаваемый символ на позиции " + i); 
        }
        char ch = Expression.charAt(i);
        double number = 0;

        while (Character.isDigit(ch)) {
            number = number * 10 + (ch - '0');
            i++;
            if (i < Expression.length()) {
                ch = Expression.charAt(i);
            } 
            else {
                break;
            }
        }
        if (ch == '.') {
            if (++i < Expression.length()) {
                ch = Expression.charAt(i);
            }
            for (int j = 1; Character.isDigit(ch); j++) 
            {
                number += (ch - '0') / Math.pow(10, j);
                i++;
                if (i < Expression.length()) {
                    ch = Expression.charAt(i);
                } else {
                    break;
                }
            }
        }
        
        return new Pair(number, --i);
    }

    public double Calculate(String Expression) {
        double result = 0;

        for (int i = 0; i < Expression.length(); i++) {
            char ch = Expression.charAt(i);
            if (Character.isDigit(ch)) {
                Pair pair = ReadNumber(Expression, i);
                i = pair.second;
                StackOfNumbers.push(pair.first);
                continue;
            }
            else if (isOperator(ch)) {
                if (ch == '-' && (StackOfOperators.isEmpty() || 
                                                StackOfOperators.peek() == '(')) 
                {
                    StackOfNumbers.push(0.0);
                    StackOfOperators.push('-');
                    continue;
                }
                if (StackOfOperators.isEmpty()) {
                    StackOfOperators.push(ch);
                    continue;
                }
                while (!StackOfOperators.isEmpty() && 
                                        SmallerOrSamePriority(ch, StackOfOperators.peek())) 
                {
                    try {
                        StackOfNumbers.push(Operation(StackOfOperators.pop(), 
                                            StackOfNumbers.pop(), StackOfNumbers.pop()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                
                StackOfOperators.push(ch);
            }
            else if (ch == '(') {
                StackOfOperators.push(ch);
            }
            else if (ch == ')') {
                double right = StackOfNumbers.pop();
                char operator = StackOfOperators.pop();
                
                while (operator != '(') {
                    try {
                        right = Operation(operator, right, StackOfNumbers.pop());
                        operator = StackOfOperators.pop();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                StackOfNumbers.push(right);
            }
            else {
                System.out.println("Нераспознаваемый символ на позиции " + i);
            }
        }
        
        while (!StackOfOperators.isEmpty()) {
            try {
                StackOfNumbers.push(Operation(StackOfOperators.pop(), 
                                        StackOfNumbers.pop(), StackOfNumbers.pop()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        result = StackOfNumbers.pop();
        StackOfNumbers.clear();
        StackOfOperators.clear();
        return result;
    }

    public static void main(String[] args) {
        StackCalc Calculator = new StackCalc();
        if (args.length < 1) {
            throw new IllegalArgumentException("Нет входного выражения (как аргумента)");
        }
        System.out.println(Calculator.Calculate(args[0]));
    }

}