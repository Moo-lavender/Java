/*
LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,
“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字
,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),
“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 
如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0
思路：
1.保证除0外其它数字无重复
2.保证最大数最小数差<5
*/
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length != 5) return false;
        int min = numbers[0];
        int max = numbers[0];
        int[] num = new int[14];
        for (int i = 0; i < numbers.length; i ++) {
            if(numbers[i] != 0) {
                if(num[numbers[i]] != 0) return false;
                if(max == 0) max = numbers[i];
                if(min == 0) min = numbers[i];
                max = nuAmbers[i] > max ? numbers[i] : max;
                min = numbers[i] < min ? numbers[i] : min;
                num[numbers[i]] ++;
            }
        }
        boolean ans = (max - min < 5) ? true : false;
        return ans;
    }
}