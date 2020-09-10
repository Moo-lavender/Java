/*
1104. 二叉树寻路
在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。



给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。

 

示例 1：

输入：label = 14
输出：[1,3,4,14]
示例 2：

输入：label = 26
输出：[1,2,6,10,26]
*/

class Solution {
public List<Integer> pathInZigZagTree(int label) {
        boolean ji = true;
        int count = 1; //每行个数
        int num = 0; //上一层结束数字
        int index = 0; //label数字的坐标
        boolean flag = false;
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            if (ji) {
                num ++;
                for (int i = 0; i < count; i ++) {
                    if (num == label) {
                        index = list.size();
                        flag = true;
                    }
                    list.add(num ++);
                }
                num --;
                ji = false;
            }else {

                num += count;
                int t = num;
                for (int i = 0; i < count; i ++) {
                    if (t == label) {
                        index = list.size();
                        flag = true;
                    }
                    list.add(t --);
                }
                ji = true;
            }
            count *= 2;
            if (flag) break;
        }

        List<Integer> res = new ArrayList<>();

        while (index > 0) {
            res.add(list.get(index));
            index = (index -1) / 2;
        }
        res.add(list.get(0));
        Collections.reverse(res);
        return res;

    }
}