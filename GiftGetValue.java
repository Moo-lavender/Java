import java.util.Arrays;
/*
* 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
* 若没有金额超过总数的一半，返回0。*/
public class GiftGetValue {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int x = n / 2 + 1;
        int count = 0;
        for(int i = 0; i < gifts.length; i++){
            if(gifts[i] == gifts[x]){
                count ++;
            }
            if (count > n / 2){
                break;
            }
        }
        return count < n / 2 ? 0 : gifts[x];
    }
}
