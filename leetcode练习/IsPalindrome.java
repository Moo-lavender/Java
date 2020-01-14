//判断一个整数是否是回文数。
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        int i = 0;
        int j = ch.length - 1;
        for( ; i < j; i++,j--){
            if(ch[i] != ch[j]){
                return false;
            }
        }
        return true;
    }
	//进阶：不将整数转为字符串来解决这个问题
	//为负数直接返回false，否则将原数逆置后判断与前后是否相等
	public boolean ispalindrome2(int x){
		if(x < 0)
            return false;
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
	}
}