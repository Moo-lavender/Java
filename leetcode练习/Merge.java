//合并两个有序数组
//给定两个有序整数数组 nums1 和 nums2，
//将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
public class Merge {
	//从前往后对比
	//时间O（m+n） 空间 O（m）
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int [] nums1_copy = new int[m];
    System.arraycopy(nums1, 0, nums1_copy, 0, m);
    int p1 = 0;
    int p2 = 0;
    int p = 0;
    while ((p1 < m) && (p2 < n)){
        nums1[p++] = (nums1_copy[p1] < nums2[p2])? nums1_copy[p1++] : nums2[p2++];
    }
    if (p1 < m)
      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    if (p2 < n)
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
  }
	//从后往前
	//时间O（m+n）空间O（1）
	public void merge2(int[] nums1, int m, int[] nums2,int n){
		int p1 = m - 1;
		int p2 = n - 1;
		int p = m + n - 1;
		while((p1 >= 0) && (p2 >= 0)){
			nums1[p--] = nums1[p1] > nums2[p2]? nums1[p1--] : nums2[p2--];
		}
		System.arraycopy(nums2,0,nums1,0,p2 + 1);
	}
}
