/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
/*
在二叉搜索数中，左子树的值<根节点的值<右子树的值
而最后一个节点就是根节点，根节点左边都比根节点小，右边都大
因此只需遍历数组，找到一个比根节点大的元素，那么在这个元素之后的节点应该都比该元素大

*/
public class VerifySquenceOfBST {
	 public boolean verifySquenceOfBST1(int [] sequence) {
		 if(sequence == null || sequence.length == 0){
			 return false;
		 }
		 return  helpVerify(sequence, 0, sequence.length-1);
	 }
	 public boolean helpVerify(int[] sequence,int start,int root){
		 if(start >= root){
			 return true;
		 }
		 int i = start;
		 //找到第一个比根节点大的值
		 for(; i < root; i ++){
			 if(start > root){
				 break;
			 }
		 }
		 //判断右子树中是否有比根节点小的节点
		 for(int j = i; j < root; j++){
			 if(sequence[j] < sequence[root]){
				 return false;
			 }
		 }
		 return helpVerify(sequence,start,i-1)&&helpVerify(sequence,i,root - 1);
	 }
    public boolean verifySquenceOfBST2(int [] sequence) {
        if(sequence == null || sequence.length == 0){
            return false;
        }
        //后序遍历最后一个数字就是根
        int root = sequence.length - 1;
		//动态判断位置
        int i = 0;
        while(root != 0){
			//找到第一个比根节点大的值
            while(sequence[i] < sequence[root]){
                i++;
            }
			//找到比根节点大的值中有无比根节点小的值
            while(sequence[i] > sequence[root]){
                i++;
            }
            if(i != root){
                return false;
            }
			//重新循环
            i = 0;
            root --;
        }
        return true;
    }

}