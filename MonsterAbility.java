import java.util.Scanner;
/*
* 小易经常沉迷于网络游戏.有一次,他在玩一个打怪升级的游戏,他的角色的初始能力值为 a.
* 在接下来的一段时间内,他将会依次遇见n个怪物,每个怪物的防御力为b1,b2,b3...bn.
* 如果遇到的怪物防御力bi小于等于小易的当前能力值c,那么他就能轻松打败怪物,并且使得自己的能力值增加bi;
* 如果bi大于c,那他也能打败怪物,但他的能力值只能增加bi 与c的最大公约数.
* 那么问题来了,在一系列的锻炼后,小易的最终能力值为多少?
* */
public class MonsterAbility {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int monsterCount = sc.nextInt();
            int ability = sc.nextInt();
            int curAbility = ability;
            for(int i = 0; i < monsterCount; i++){
                int curMonster = sc.nextInt();
                if(curMonster <= curAbility){
                    curAbility += curMonster;
                }else{
                    int tmp = common(curAbility,curMonster);
                    curAbility += tmp;
                }
            }
            System.out.println(curAbility);
        }
    }
    public static int common(int p,int q){
        int a = p > q ? p:q;
        int b = p < q ? p:q;
        int c = a % b;
        while( c!= 0){
            a = b;
            b = c;
            c = a % b;
        }
        return b;
    }
}
