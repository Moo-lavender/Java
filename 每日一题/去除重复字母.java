/*
给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

 

示例 1:

输入: "bcabc"
输出: "abc"
示例 2:

输入: "cbacdcbc"
输出: "acdb"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicate-letters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

class Solution {
    public String removeDuplicateLetters(String s) {
        /*因为要保证返回的字典需最小，且去除重复的字母。所以维护一个单调递增的栈，遍历s
            1. 如果栈空，入栈
            2. 遍历到的元素大于栈顶元素，入栈
            3. 遍历到的元素小于栈顶元素，判断栈顶元素是否会在以后出现
                以后会出现，那么当前遍历到的这个较小的元素就应该放在栈顶这个元素的前面，所以出栈栈顶
                以后不会出现，说明不可以去重，该栈顶元素一定要保存
            4. 遍历发现元素已经在栈中出现，就直接舍弃
            5. 遍历结束后，出栈

        要判断以后会否再出现，可以保存最后出现的下标，使用一个数组表示
        要判断是否在栈中出现过，也可以使用一个数组表示    
        
        */
        if (s.length() < 2) {
            return s;
        }
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean[] isExist = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < ch.length; i ++) {
            int index = (int)(ch[i] - 'a');
            lastIndex[index] = i;
        }
  
        for (int i = 0; i < ch.length; i ++) { 
            if (isExist[ch[i]-'a']) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > ch[i] ) {
                if (lastIndex[stack.peek()-'a'] >= i){ // 后面还有
                    isExist[stack.peek()-'a'] = false;
                    stack.pop();
                }else{
                    break;
                }
                    
            } 
            isExist[ch[i]-'a'] = true;
            stack.push(ch[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            stringBuilder.insert(0, stack.pop());
        }
        return stringBuilder.toString();
    }
}