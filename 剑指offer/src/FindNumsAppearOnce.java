/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。
请写程序找出这两个只出现一次的数字。
思路：
两个相同的数字异或后为0，所以将所有的数组元素异或得到的就是两个只出现一次的元素的异或
那么这两个不同数异或后，总是不为0的。
此时我们以异或结果为1的位将整个数组分为两部分，对每一个部分在进行异或，
两部分剩下的数就是结果。
*/
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int xor1 = 0;
        for (int i = 0; i < array.length; i++) {
            xor1 = xor1 ^ array[i];
        }
        int index = 1;
        while ((index & xor1) == 0) {
            index <<= 1;
        }
        int result1 = 0;
        int result2 = 0;
        for (int i = 0; i < array.length; i++){
            //index位上是0
            if((index & array[i]) == 0)
                result1 = result1^array[i];
            else
                result2 = result2^array[i];
        }
        num1[0] = result1;
        num2[0] = result2;
    }
}