import java.util.Arrays;
public final class MyString implements Comparable<MyString>{
    private final char[] value ;
    public MyString(char value[]){
        //需要拷贝复制数组，保证数组的引用不会被泄露
        //泄露会导致通过泄露的引用，
        this.value = Arrays.copyOf(value,value.length);
    }

    public MyString(char value[], int offset, int count){
        this.value = Arrays.copyOfRange(value,offset,offset+count);
    }

    public MyString(MyString s){
        //这里引用泄露没问题，因为新的对象中也不会去修改
        //value 数组中的值
        //相比于copyOf，可以省去复制的时间，提升效率
        this.value = s.value;
    }

    public MyString(boolean intern, char[] value){
        this.value = value;
    }

    public char charAt(int index){
        return value[index];
    }

    public char[] toCharArray(){
        //不能直接返回引用
        return Arrays.copyOf(value,value.length);
    }

    @Override
    public boolean equals(Object s){
        //1.引用是否指向同一个对象
        //2.引用是否为空
        //3.是否是一个类型
        //4.是否相等
        if(this == s){
            return true;
        }
        if(s == null){
            return  false;
        }
        //s.getClass() == getClass()
        if(!(s instanceof MyString)){
            return false;
        }
        return Arrays.equals(value,((MyString)s).value);
    }

    public MyString toUpper(){
        // 1. 构造一个新的对象
        // 2. 遍历新对象的 value
        // 3. 把小写字母变成大写字母
        // 4. 返回新的对象
        MyString s = new MyString(value);
        for(int i = 0; i < s.value.length;i ++){
            if(s.value[i] >= 'a'&& s.value[i]<='z'){
                value[i] = (char)(s.value[i] - 'a' + 'A');
            }
        }
        return s;
    }

    public MyString toLower() {
        MyString s = new MyString(value);
        for(int i = 0; i < s.value.length; i ++){
            if(s.value[i] >= 'A' && s.value[i] <= 'Z'){
                value[i] = (char)(s.value[i] - 'A'+ 'a');
            }
        }
        return s;
    }

    public MyString substring(int begin, int end) {
        return new MyString(value,begin,end - begin);
    }

    public int hashcode(){
        int hash = 0;
        for(char c: value){
            hash = (hash ^ c);
        }
        return hash;
    }

    @Override
    public int compareTo(MyString o) {
        if (o == null) {
            return 1;
        }
        int length = Math.min(value.length, o.value.length);
        for (int i = 0; i < length; i++) {
            if (value[i] > o.value[i]) {
                return 1;
            } else if (value[i] < o.value[i]) {
                return -1;
            }
        }
        if (value.length > o.value.length) {
            return 1;
        } else if (value.length < o.value.length) {
            return -1;
        } else return 0;
    }

    @Override
    public String toString(){
        return new String(value);
    }

    public static void main(String[] args) {
        char[] a = {'A', 'b', 'c'};
        MyString s = new MyString(a);
        MyString t = new MyString(s);
        System.out.println(s);
        System.out.println(t);
        System.out.println(s.equals(t));

        MyString u = s.toUpper();
        System.out.println(u);
        MyString l = s.toLower();
        System.out.println(l);

        MyString b = new MyString(a);
        System.out.println(b.substring(1, 2));
        System.out.println(s.equals(t));
    }
}


