/*
��ȡ���
ʱ�����ƣ� 3000MS
�ڴ����ƣ� 589824KB
��Ŀ������
С�����һ��Ӣ�Ķ�������ȡǱ�ڵ������Ϣ����ƥ�����ݵķ�ΧΪ1000����3999�꣬����1000��3999��

����һ��Ӣ�Ķ��ģ������ִ����������ȡ�������п��ܵ�����ַ�����



��������
�������룬����һ��Ӣ�Ķ��ģ����ܰ�����ĸ��Сд�������ż��ո񡣣�������2000���ַ���

�������
�������ȡ�������п��ܵ�����ַ���������֮����һ���ո������


��������
And millionaires will hold 46% of total wealth by 2019, the report says. This ratio is likely to increase in 2020.
�������
2019 2020
*/
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0;i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '1' && c <= '3') {
                int j;
                for (j = i+1; j < i+4 && j < str.length(); j++) {
                    char ch = str.charAt(j);
                    if (!Character.isDigit(ch)) {
                        break;
                    }
                }
                if (j == i+4) {
                    String s = str.substring(i,i+4);
                    res.add(s);
                 //   i += 3;
                }
            }
        }
        for (int i = 0; i < res.size(); i ++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
