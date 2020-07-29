/*
在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。

请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。

 

示例 1：

输入：[1,1,1,2,2,2]
输出：[2,1,2,1,2,1]
示例 2：

输入：[1,1,1,1,2,2,3,3]
输出：[1,3,1,3,2,1,2,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/distant-barcodes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int [] vis=new int[10000+1];
        int [] ans=new int [barcodes.length];
        for (int i=0;i<barcodes.length;i++){
            vis[barcodes[i]]++;
        }
        PriorityQueue<Pair<Integer,Integer> > q=new PriorityQueue(new Comparator<Pair<Integer,Integer> >() {
            @Override
            public int compare(Pair<Integer,Integer>  o1, Pair<Integer,Integer>  o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for (int i=0;i<vis.length;i++){
            if(vis[i]>0){
                q.add(new Pair<Integer,Integer>(i,vis[i]));
            }
        }
        int num=0;
        while (q.size()!=0){
            Pair<Integer,Integer> s=q.poll();
            if(q.size()==0){
                ans[num++]=s.getKey();
                if (s.getValue()!=1){
                    q.add(new Pair<>(s.getKey(),s.getValue()-1));
                }
            }else{
                Pair<Integer,Integer> t=q.poll();
                ans[num++]=s.getKey();
                ans[num++]=t.getKey();
                if (s.getValue()!=1){
                    q.add(new Pair<>(s.getKey(),s.getValue()-1));
                }
                if (t.getValue()!=1){
                    q.add(new Pair<>(t.getKey(),t.getValue()-1));
                }
            }
        }
        return ans;
    }
}