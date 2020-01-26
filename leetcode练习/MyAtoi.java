/*
请你来实现一个 atoi 函数，使其能将字符串转换成整数。
首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        //1.跳过空格
        if(str == null || str.length() == 0){
            return 0;
        }
        int start = 0;
        while(start < str.length() && str.charAt(start) == ' '){
            start ++;
        }
        if(start == str.length()){
            return 0;
        }
        //2.判断正负
        int flag = 1;
        if(str.charAt(start) == '-'){
            flag = -1;
            start++;
        }else if(str.charAt(start) == '+'){
            flag = 1;
            start++;
        }
        //3.得到数字
        int res = 0;
        for(int i = start; i < str.length(); i++){
            int tmp = res * 10 + str.charAt(i) - '0';
            if(! Character.isDigit(str.charAt(i))){
                return res * flag;
            }else if(flag == 1 && res > Integer.MAX_VALUE/10 || flag ==1 && tmp < res){
                return Integer.MAX_VALUE;
            }else if(flag == -1 &&res > Integer.MAX_VALUE/10 || flag ==-1 && tmp < res){
                return Integer.MIN_VALUE;
            }else{
                res = res * 10 + str.charAt(i) - '0';
            }
        }
        return res * flag;
    }

    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoi(s));
    }
}
