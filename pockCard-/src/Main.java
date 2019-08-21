import java.util.ArrayList;
import java.util.Random;

public class Main {
    //交换
    public static void swap(ArrayList<pockCard> cards,int i,int j){
        pockCard tmpi = cards.get(i);
        pockCard tmpj = cards.get(j);
        cards.set(i,tmpj);
        cards.set(j,tmpi);
    }
    public static void main(String[] args){
        ArrayList<pockCard> cards = new ArrayList<>(52);
        String[] colors = {"♥","♦","♣","♠"};
        for(int i = 0; i < 4;i++){
            for (int j =1;j <= 13;j++){
                pockCard card = new pockCard(j,colors[i]);
                cards.add(card);
            }
        }
        //洗牌
        Random random = new Random(20190820);
        for(int i = 51; i > 0; i--){
            int j = random.nextInt(i);
            swap(cards,i,j);
        }
        System.out.println(cards);

        //ABC抓15张牌
        ArrayList<pockCard> A = new ArrayList<>();
        ArrayList<pockCard> B = new ArrayList<>();
        ArrayList<pockCard> C = new ArrayList<>();
        System.out.println(cards.subList(52 - 15 , 52));

        for (int i = 0; i < 15; i++){
            pockCard card = cards.remove(cards.size()-1);
            switch (i % 3){
                case 0:
                    A.add(card);break;
                case 1:
                    B.add(card);break;
                case 2:
                    C.add(card);break;
            }
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

        //A抓到的牌有没有♥12 如果有删除
        pockCard heart12 = new pockCard(12,"♥");
        for(int i = 0;i < A.size(); i++){
            pockCard o = A.get(i);
            if(o.equals((heart12))){
                A.remove(o);
            }
        }
        System.out.println(A);

    }


}



















