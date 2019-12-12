package DynamicProgramming;
/*
动态规划题目四：
买股票的最佳时间
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
* 如果你最多只允许完成一笔交易（即买入和卖出一支股票）
* 设计一个算法来计算你所能获取的最大利润

第i天的最大收益等于max(i-1天的最大收益，i价格-前i-1天最小价格)
所以需要两个变量存放最大收益和最小价格
所以动态规划不一定都要建立数组
* */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int maxPro = 0;
        int minPri = prices[0];
        for(int i = 1; i < prices.length; i++){
            maxPro = Math.max(maxPro,prices[i] - minPri);
            minPri = Math.min(minPri,prices[i]);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int[] prices ={7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit(prices));
    }
}
