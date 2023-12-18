public class TestMain {

    public static double Test(String Expression) {
        StackCalc Calculator = new StackCalc();
        return Calculator.Calculate(Expression);
    }

    public static void main(String[] args) {
        double test_0 = Test("2+2-2-2");
        System.out.println(test_0);

        double test_1 = Test("4+(221/17+15)/(3*4+(1+5)/2-1)");
        System.out.println(test_1);

        double test_2 = Test("-(-(-(-5+1)))");
        System.out.println(test_2);

        double test_3 = Test("((2+2)-(-2-2))");
        System.out.println(test_3);
        
        double test_7 = Test("((2+3))");
        System.out.println(test_7);

        //check error types
        double test_4 = Test("(2+3))*7");
        System.out.println(test_4);

        double test_5 = Test("(2+3*7");
        System.out.println(test_5);

        double test_6 = Test("2+*7");
        System.out.println(test_6);
        
        double test_8 = Test("2++7");
        System.out.println(test_8);

    }
}