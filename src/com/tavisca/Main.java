package com.tavisca;

public class Main {

    public static void main(String[] args) {
//        useMathEquation();
//        useCalculatorsBase();

        String[] statements={
                "divide 100.0 50.0 ",
                "add 25.0 92.0",
                "subtract 255.0 17.0",
                "multiply 11.0 3.0"
        };
        
        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            helper.process(statement);
            System.out.println(helper);
        }
    }

    private static void useCalculatorsBase() {
        System.out.println("Inheritance");

        CalculateBase[] calculators = {
                new Divider(100.0d,50.0d),
                new Adder(25.0d,92.0d),
                new Subtracter(225.0d,17.0d),
                new Multiplier(11.0d,3.0d)
        };

        for (CalculateBase calculator:calculators) {
            calculator.calculate();
            System.out.println("Results "+calculator.getResult());
        }
    }

    private static void useMathEquation() {
        MathEquation[] equations=new MathEquation[4];
        equations[0] = new MathEquation('d',100.0d,0.0d);
        equations[1] = new MathEquation('a', 25.0d,92.0d);
        equations[2] = new MathEquation('s',225.0d,17.0d);
        equations[3] = new MathEquation('m',11.0d,3.0d);

        for (MathEquation equation:
                equations) {
            equation.execute();
            System.out.println("results =");
            System.out.println(equation.getResult());
        }

        System.out.println("Overloading");

        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(9.0d,4.0d);
        System.out.println("results =");
        System.out.println(equationOverload.getResult());

        equationOverload.execute(9,4);
        System.out.println("results =");
        System.out.println(equationOverload.getResult());

        equationOverload.execute((double)9,4);
        System.out.println("results =");
        System.out.println(equationOverload.getResult());
    }
}
