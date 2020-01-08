import java.util.ArrayList;
//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
//打印能拼接出的所有数字中最小的一个。
public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                int tmp1 = Integer.valueOf(numbers[i] +""+ numbers[j]);
                int tmp2 = Integer.valueOf(numbers[j] +""+ numbers[i]);
                if(tmp1 > tmp2){
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        String s = new String();
        for(int i = 0; i < numbers.length; i ++){
            s = s + numbers[i];
        }
        return s;
    }
}