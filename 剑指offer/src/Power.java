/*
数值的整数次方
*/
public class Power {
    public double power(double base, int exponent) {
        double result = 1;
        int exponentAbs = exponent < 0 ? (exponent*(-1)):exponent;
        for(int i = 0; i < exponentAbs; i++){
            result *= base;
        }
        if(exponent < 0){
            result = 1.0 / result;
        }
        return result;
  }
}