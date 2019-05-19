public class pi{
	public static double calcPi1(int n){
	double Pi = 0;
	for(int i = 3;i < n; i+=4){
	 Pi = Pi - ((double)1/i);
	}
	for(int i = 1;i < n; i+=4){
	 Pi = Pi + ((double)1/i);
	}
	Pi = 4*Pi;
	return Pi;
	}
	public static double calcPi2(int n){
		double Pi = 0;
		for (int i = 0; i < n; i ++){
			if(i%2 !=0){    //奇数
				Pi -= 1.0/(2*i + 1);
				}
			else{
				Pi += 1.0/(2*i + 1);
			}
			}
			return Pi*4;
		}
	
	public static void main(String[] args){
		double Pi1 = calcPi1(5000000);
		System.out.printf("%f%n",Pi1);
		double Pi2 = calcPi2(5000000);
		System.out.printf("%f%n",Pi2);
	}
	
}

//求pi  1/4 pi = 1 - 1 / 3 + 1 / 5 - 1 / 7 + 1 / 9-...