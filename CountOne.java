/*求出任意非负整数区间中1出现的次数*/
public class CountOne{
	public int countOne(int n) {
		int count = 0;
		for(int i = 1; i <= n; i *= 10){
			int a = n / i, b = n % i;
			//之所以补8，是因为当百位为0，则a/10==(a+8)/10，
			//当百位>=2，补8会产生进位位，效果等同于(a/10+1)
			count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
		}
		return count;
	}
}