package com.tavisca;

public class CalculateHelper {
    private static final char ADD_SYMBOL = '+';
    private static final char SUBTRACT_SYMBOL = '+';
    private static final char DIVIDE_SYMBOL = '+';
    private static final char MULTIPLY_SYMBOL = '*';
    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process(String statement){
        //add 1.0 2.0
        String[] parts = statement.split(" ");
        String commandString=parts[0];
        leftValue = Double.parseDouble(parts[1]);
        rightValue= Double.parseDouble(parts[2]);

        setCommandFromString(commandString);

        CalculateBase calculator = null;
        switch (command) {
            case Add:
                calculator=new Adder(leftValue,rightValue);
                break;
            case Subtract:
                calculator=new Subtracter(leftValue,rightValue);
                break;
            case Divide:
                calculator=new Divider(leftValue,rightValue);
                break;
            case Multiply:
                calculator=new Multiplier(leftValue,rightValue);
                break;
            default:
                System.out.println("Error");
                result = 0.0d;
                break;
        }

        calculator.calculate();
        result=calculator.getResult();
    }

    private void setCommandFromString(String commandString){
        if(commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command=MathCommand.Add;
        else if(commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command=MathCommand.Subtract;
        else if(commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command=MathCommand.Multiply;
        else if(commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command=MathCommand.Divide;
    }

    @Override
    public String toString(){
        //1.0 + 2.0 - 3.0
        char symbol = ' ';
        switch (command){
            case Add:
                symbol=ADD_SYMBOL;
                break;
            case Subtract:
                symbol=SUBTRACT_SYMBOL;
                break;
            case Divide:
                symbol=DIVIDE_SYMBOL;
                break;
            case Multiply:
                symbol=MULTIPLY_SYMBOL;
                break;
        }

        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(leftValue);
        stringBuilder.append(' ');
        stringBuilder.append(symbol);
        stringBuilder.append(' ');
        stringBuilder.append(rightValue);
        stringBuilder.append(" = ");
        stringBuilder.append(result);

        return stringBuilder.toString();
    }
}
