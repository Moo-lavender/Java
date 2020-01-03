/*请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        char[] ch = s.toCharArray();
        int nullNum = 0;
        for(char a : ch){
            if(a == ' '){
                nullNum ++;
            }
        }
        int newLength = ch.length + nullNum * 2;
        char[] c = new char[newLength];
        int i = ch.length - 1;
        int j = newLength - 1;
        while(i >= 0){
            if(ch[i] != ' '){
                c[j] = ch[i];
                j--;
                i--;
            }else{
                c[j--] = '0';
                c[j--] = '2';
                c[j--] = '%';
                i--;
            }
        }
        String result = new String(c);

        return result;

    }

    public static void main(String[] args) {
        StringBuffer s = new StringBuffer("We Are Happy");
        System.out.println(new ReplaceSpace().replaceSpace(s));

    }
}
