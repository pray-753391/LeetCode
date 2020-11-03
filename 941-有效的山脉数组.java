package LC;
class Solution {
	 public static boolean validMountainArray(int[] A) {
		 if(A.length<3) return false;
		 //使用index记录可能作为山顶的标识
		 int index=0;
		 for(int i=0;i<A.length-1;i++) {
			 if(A[i]>A[i+1]) {
				 index = i;
				 break;
			 }
		 }
		 //没有考虑{987654321}这种情况，即index可能为0
		 if(index==0) return false;
		 //从山顶的左边排查
		 for(int i=0;i<index;i++) {
			 if(A[i]>=A[i+1]) return false;
		 }
		 //从山顶右边排查
		 for(int i=index;i<A.length-1;i++) {
			 if(A[i]<=A[i+1]) return false;
		 }
		 return true;
	    }
    public static void main(String[] args) {
    	int[] arr = {9,8,7,6,5,4,3,2,1};
    	boolean ans = validMountainArray(arr);
    	System.out.println(ans);
    	
    }
}
