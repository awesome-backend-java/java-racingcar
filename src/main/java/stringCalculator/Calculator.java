package stringCalculator;

public class Calculator {
    
    public double compute(double x, String op, double y){
        if(op.equals("+")){
            return sum(x,y);
        }
        if(op.equals("-")){
            return sub(x,y);
        }
        if(op.equals("*")){
            return mul(x,y);
        }
        return div(x,y);
    }

    public double sum(double x,double y){
        return x+y;
    }
    public double sub(double x,double y){
        return x-y;
    }
    public double mul(double x,double y){
        return x*y;
    }
    public double div(double x,double y){
        return x/y;
    }
    
}
