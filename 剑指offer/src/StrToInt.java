//不使用库函数把字符串转为整数
public class StrToInt {
    public int strToInt(String str) {
        char[] ch = str.toCharArray();
        int p = 1;
        int sum = 0;
        int i;
        for(i = ch.length - 1; i > 0; i--){
            if(ch[i] < '0' || ch[i] > '9'){
                break;
            }
            int c = (int)ch[i] * p;
            sum += c;
            p *= 10;
        }
        if(i == 0 && ch[0] > '0' && ch[0] < '9'){
            return sum + (int)ch[i] * p;
        }else if(i == 0 && ch[0] == '+'){
            return sum;
        }else if(i == 0 && ch[0] == '-'){
            return 0-sum;
        }else{
            return 0;
        }
    }

}
