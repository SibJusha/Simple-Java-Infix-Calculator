public class TestMain {

    public static double Test(String Expression) {
        StackCalc Calculator = new StackCalc();
        return Calculator.Calculate(Expression);
    }

    public static void main(String[] args) {
        double test_0 = Test("2+2");
        System.out.println(test_0);

        double test_1 = Test("4+(221/17+15)/(3*4+(1+5)/2-1)");
        System.out.println(test_1);

        double test_2 = Test("-(-(-(-5+1)))");
        System.out.println(test_2);
    }
}