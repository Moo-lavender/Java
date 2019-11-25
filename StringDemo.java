public class StringDemo {
    public static void main(String[] args) {
       /* String s1 = new String("hello");
        String s2 = "hello";
        s1.intern();
        System.out.println(s1 == s2);//false
*/
       /* String s3 = new String("hello") + new String("world");
        String s4 = "hello world";
        String t = s3.intern();
        System.out.println(s3 == s4);//false
        System.out.println(s4 == t); //false
        System.out.println(s3 == s3.intern());//true*/
        String t3 = new String("2") + new String("2");
        t3.intern();
        String t4 = "22";
        System.out.println(t3 == t4);//true

        String t5 = new String("1") + new String("1");
        String t6 = "11";
        t5.intern();
        System.out.println(t5 == t6);//false
        System.out.println(t5.intern() == t6);//true


        String t7 = new String("5") + new String("5");
        System.out.println(t7.intern() == t7);//true

     /*   String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String("abc");
        String s4 = "a" + "bc";
        String s5 = new String("a")+new String("bc");
        String s6 = new String("a");
        String s7 = new String("bc");
        String s8 = s6 + s7;
        String s9 = s2.intern();

        System.out.println(s1 == s2); // false
        System.out.println(s2 == s3); // false
        System.out.println(s1 == s4); // ture
        System.out.println(s2 == s4); // false
        System.out.println(s1 == s5); //false
        System.out.println(s2 == s5); //false
        System.out.println(s1 == s8); //false
        System.out.println(s2 == s8); //false
        System.out.println(s4 == s8); //false
        System.out.println(s1 == s9); //true
        System.out.println(s2 == s9); //false
*/

    }
}
