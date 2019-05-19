public class longfactorial{
	public static int factorial1(int n){
		if (n==0||n==1){
			return 1;
		}
		return factorial1(n-1)*n;
	}
	public static int factorial2(int n){
		int fact = 1;
		for (int i = 1;i <=n; i++){
			fact = fact * i;
		}
		return fact;
	}
	public static double calcE(double precision){
		double e = 1;
		int n = 1;
		while(true){
			double item = 1.0/factorial2(n++);
			e += item;
			if(item < precision){
				break;
			}
		}
		return e;
	}
	public static void main (String[] args){
		int n =12;
		int fact1 =factorial1(n);
		System.out.printf("%d%n",fact1);
		int fact2 =factorial2(n);
		System.out.printf("%d%n",fact2);
		double e = calcE(0.0000000001);
		System.out.printf("%f",e);
		
		
	}
}
//求一个数的阶乘并求e的值
