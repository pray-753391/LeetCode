
//时间复杂度为O(log n) 又是升序数组 可以考虑使用折半查找
import java.util.Vector;

public class test1 {
    public static int[] searchRange(int[] nums, int target) {
        //定义最小 最大的索引
        int start=0;
        int end=nums.length-1;
        //返回最后答案的数组
        int[] ans = {-1,-1};
        //如果长度为1 那么start会等于end 这时候直接判断就行
        if(start==end){
            if(nums[0]!=target) return ans;
            else {
                ans[0]=0;
                ans[1]=0;
                return ans;
            }
        }
        //判断条件就用start和end比较
        while (start<=end){
            int par = (start+end)/2;
            if(nums[par]>target) end=par-1;
            else if(nums[par]<target) start=par+1;
            else{
                ans[0]=par;
                ans[1]=par;
                break;
            }
        }
        if(ans[0]==-1) return ans;
        //向左向右找
        for(int i=ans[0];i>=0;i--){
            if(nums[i]!=target){
                ans[0]=++i;
                break;
            }
        }
        if(nums[0]==target) ans[0]=0;
        for(int i=ans[0];i<=nums.length-1;i++){
            if(nums[i]!=target){
                ans[1]=--i;
                break;
            }
        }
        if(nums[nums.length-1]==target) ans[1]=nums.length-1;
        return ans;
    }

    public static void main(String[] args) {

        int arr[]={1,4};
        int target=4;
        int ans[]=searchRange(arr,target);
        for(int a:ans){
            System.out.println(a);
        }
    }
}
