/*
青蛙跳台阶，一次可以跳一阶、二阶... n阶
跳到target阶有几种不同的方法
f(n)=f(n-1)+f(n-2)+...+f(1)
f(n-1)=f(n-2)+...f(1)
得:f(n)=2*f(n-1)
*/
public class JumpFloorII {
    public int jumpFloorII(int target) {
        return 1<<(target-1);
    }
}