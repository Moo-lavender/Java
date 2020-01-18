/*你的朋友正在使用键盘输入他的名字 name。
* 偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
* 你将会检查键盘输入的字符 typed。
* 如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
*/
public class  IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()){
            return false;
        }
        int n = 0;
        int t = 0;
        while(n < name.length() && t < typed.length()){
            if(typed.charAt(t) == name.charAt(n)){
                n++;
                t++;
            }else if(n > 0 && typed.charAt(t) == name.charAt(n-1)){
                t++;
            }else{
                return false;
            }
        }
        return n == name.length();
    }
}