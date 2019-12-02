import java.util.ArrayList;
import java.util.Scanner;
/*
小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。
于是小红要你帮忙判断一下，某串珠子里是否包含了全部自己想要的珠子？
如果是，那么告诉她有多少多余的珠子；
如果不是，那么告诉她缺了多少珠子。*/
public class StringContains {
    public static void main(String[] srgs){
        Scanner sc = new Scanner(System.in);
        String shop = sc.nextLine();
        String custom = sc.nextLine();
        int count = 0;
        ArrayList<Character> listShop = new ArrayList<>();
       for(int i = 0; i < shop.length() - 1; i++){
           listShop.add(shop.charAt(i));
       }
       for(int i = 0; i < custom.length(); i++){
           char ch = custom.charAt(i);
            for(int j = 0; j < listShop.size(); j++){
                if(ch == listShop.get(j)){
                    count ++;
                    listShop.remove(j);
                    break;
                }
            }
        }
        if(count == custom.length()){
            System.out.println("Yes"+ " "+ (shop.length() - count));
        }else{
            System.out.println("No"+ " "+ (custom.length() - count));
        }
    }
}
