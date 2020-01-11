//将字符串中大写转小写
class ToLowerCase {
    public String toLowerCase(String str) {
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length; i++){
            if(ch[i] >= 'A' && ch[i] <= 'Z'){
                ch[i] = (char)(ch[i] - 'A' + 'a');
            }
        }
        String s = new String(ch);
        return s;
    }
}