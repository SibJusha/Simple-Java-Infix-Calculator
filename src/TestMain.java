public class TestMain {

    public static double Test(String Expression, int precision) {
        StackCalc Calculator = new StackCalc();
        return Calculator.calculate(Expression, precision);
    }
    
    public static double Test(String Expression) {
        StackCalc Calculator = new StackCalc();
        return Calculator.calculate(Expression);
    }

    public static void main(String[] args) {
        try {
            double test_0 = Test("2.1+2-2-2");
            System.out.println(test_0);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_1 = Test("4+(221.221/17+15)/(3*4+(1+5)/2-1)", 5);
            System.out.println(test_1);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_2 = Test("-(-(-(-5.5+1.3)))");
            System.out.println(test_2);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_3 = Test("((2+2)-(-2-2))");
            System.out.println(test_3);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_7 = Test("((2+3))");
            System.out.println(test_7);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_4 = Test("(2+3))*7");
            System.out.println(test_4);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_5 = Test("(2+3*7");
            System.out.println(test_5);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_6 = Test("2+*7");
            System.out.println(test_6);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_8 = Test("2++7");
            System.out.println(test_8);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }

        try {
            double test_9 = Test("90909#");
            System.out.println(test_9);
        } catch (Exception e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}