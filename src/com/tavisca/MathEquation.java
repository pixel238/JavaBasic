package com.tavisca;

public class MathEquation {
    private char opCode = 'a';
    private double leftVal;
    private double rightVal;
    private double result;

    public char getOpCode() {
        return opCode;
    }
    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }

    public MathEquation(){}

    public MathEquation(char opCode)
    {
        this.opCode=opCode;
    }

    public MathEquation(char opCode,double leftVal, double rightVal)
    {
        this.rightVal=rightVal;
        this.leftVal=leftVal;
        this.opCode=opCode;
    }

    public void execute(double leftVal,double rightVal){
        this.leftVal=leftVal;
        this.rightVal=rightVal;
        execute();
    }

    public void execute(int leftVal,int rightVal){
        this.leftVal=leftVal;
        this.rightVal=rightVal;
        execute();
        result=(int)result;
    }

    public void execute(){
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error");
                result = 0.0d;
                break;
        }
    }
}
