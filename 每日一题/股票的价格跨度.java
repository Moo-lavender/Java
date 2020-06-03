/*
901. 股票价格跨度
编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。

今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。

例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。

 

示例：

输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
输出：[null,1,1,1,2,1,4,6]
解释：
首先，初始化 S = StockSpanner()，然后：
S.next(100) 被调用并返回 1，
S.next(80) 被调用并返回 1，
S.next(60) 被调用并返回 1，
S.next(70) 被调用并返回 2，
S.next(60) 被调用并返回 1，
S.next(75) 被调用并返回 4，
S.next(85) 被调用并返回 6。

注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
(包括今天的价格 75) 小于或等于今天的价格。
*/
class StockSpanner {
    /*
    需要使用单调栈，需要两个单调栈来做辅助，一个单调栈来存放每一个price，另一个栈用来存放对应的结果  
    */
    Stack<Integer> prices;
    Stack<Integer> weights;

    public StockSpanner() {
        prices = new Stack();
        weights = new Stack();
    }
    
    public int next(int price) {
        int res = 1;
        while (! prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            res += weights.pop();
        }
        weights.push(res);
        prices.push(price);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */