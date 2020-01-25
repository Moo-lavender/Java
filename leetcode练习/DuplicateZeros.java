//给你一个长度固定的整数数组 arr，
//请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
public class DuplicateZero {
    public void duplicateZeros1(int[] arr) {
        for(int i = 0; i< arr.length; i++){
         if(arr[i] == 0){
           for(int j = arr.length - 1; j > i; j--){
               arr[j] = arr[j-1];
         }
             i++;
          }
        }
    }
	public void duplicateZeros2(int[] arr) {
       ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			arrList.add(arr[i]);
			if(arr[i]==0){
				arrList.add(0);
			}
			arr[i]=arrList.get(i);
		}
    }
}