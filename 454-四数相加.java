//用哈希表解决
//把AB的两两之和求出来，在哈希表中建立两数之和和其出现次数的映射
//再遍历C和D中的两数之和，看哈希表内存不存在就行了
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Test {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int ans=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                //getOrDefault函数意思就是当Map集合中有这个key时，就使用这个key对应的value值
               map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                ans+=map.getOrDefault(-C[i]-D[j],0);
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] a={0,1,-1};
        int[] b={-1,1,0};
        int[] c={0,0,1};
        int[] d={-1,1,1};

        System.out.println(fourSumCount(a,b,c,d));
    }
}
