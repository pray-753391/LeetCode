package LC;

import java.util.Vector;

/*两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。
示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
 

说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
 */
class Solution {
    public static boolean IsExist(int x,int[] nums) {
    	boolean ans = false;
    	for(int i:nums) {
    		if(i==x) {
    			ans = true;
    			break;
    		}
    	}
    	return ans;
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
    	//用ans向量接收答案
    	Vector ans = new Vector();

    	for(int i:nums1) {
    		if(IsExist(i,nums2)==true) {
    			if(!ans.contains(i)) {
    				ans.add(i);
    			}
    		}
    	}
    	//把ans的数据传入数组并返回
    	int[] ans1 = new int[ans.size()];
    	for(int i=0;i<ans.size();i++) {
    		ans1[i]=(int) ans.elementAt(i);
    	}
    	
    	return ans1;
    }
    

    
    public static void main(String[] args) {
    	int[] num1 = {2,4,4,6,7};
    	int[] num2 = {4,5,6,7,8};
    	int[] num3 = intersection(num1,num2);
    	for(int i:num3) {
    		System.out.println(i);
    	}
    	
    }
}
