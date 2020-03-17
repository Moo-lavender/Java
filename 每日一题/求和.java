/*
链接：https://www.nowcoder.com/questionTerminal/11cc498832db489786f8a03c3b67d02c
来源：牛客网

输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来

输入描述:
每个测试输入包含2个整数,n和m


输出描述:
按每个组合的字典序排列输出,每行输出一种组合
示例1
输入
5 5
输出
1 4
2 3
5
*/
import java.util.Scanner;
import java.util.ArrayList;
public class Main{
	private static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	private static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			dfs(1,m,n);
		
			for(ArrayList<Integer> l : ans){
				for(int i = 0; i < l.size() - 1; i ++){
					System.out.print(l.get(i) + " ");
				}
				System.out.println(l.get(l.size()-1));
			}
		}
	}
	private static void dfs (int index, int count, int n){
		if(count == 0){
			ans.add(new ArrayList(list));
		}else{
			for(int i = index; i <= count && i <= n; i ++){
				list.add(i);
				dfs(i + 1,count - i, n);
				list.remove(list.size() - 1);
			}
		}
	}
}