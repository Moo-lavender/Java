/*
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 
数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
*/
public class Duplicate {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
	
	//时间O（n）空间O（n）
    public boolean duplicate1(int numbers[],int length,int [] duplication) {
        int[] counts = new int[length];
        for (int i = 0; i < length; i ++) {
            counts[numbers[i]] ++;
        }
        for (int i = 0; i < length; i ++) {
            if(counts[numbers[i]] > 1) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false; 
    }
//时间O（n）空间O（1）
public boolean duplicate2(int numbers[], int length, int[] duplication) {
      if (length <= 0 || numbers == null) {
          return false;
      }
 
      int index = 0;
      while (index < length) {
          if (numbers[index] == index) { // 当前下标index的值刚好为index
              index++;
          } else {
              int tmp = numbers[index];
              if (tmp == numbers[tmp]) { // 要交换位置的两个数相同
                  duplication[0] = tmp;
                  return true;
              } else { // 交换位置
                  numbers[index] = numbers[tmp];
                  numbers[tmp] = tmp;
              }
          }
      }
      return false;
  }
	
}