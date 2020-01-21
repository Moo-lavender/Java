/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

*/
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        int t = 0;
		//先判断最后一位是否有进位
        if(digits[p] < 9 ){
                digits[p] += 1;
        }else{
                digits[p] = 0;
                p--;
                t=1;
        }
		//判断每一位是否可以累加
        while(p >= 0 && t == 1){
            if(digits[p] < 9 ){
                digits[p] += 1;
                t=0;
                break;
            }else{
                digits[p] = 0;
                p--;
                t=1;
            }
        }
		//如果全是9，开辟新数组
        if(t == 1){
            int[] arr = new int[digits.length + 1];
            System.arraycopy(digits,0,arr,1,digits.length);
            arr[0] = 1;
            return arr;
            
        }else{
            return digits;
        }
    }

	public int[] plusOne2(int[] digits) {
		//从最后一位开始往前推，如果不是9，加1
		for(int i = digits.length - 1; i > 0; i--){
			if(digits[i] != 9){
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		//跳出循环说明都是9
		int tmp = new int[digits.length + 1];
		tmp[0] = 1;
		return tmp;
	}
}