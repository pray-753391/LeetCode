import java.util.Vector;
public class Test {
    static int canCompleteCircuit(int[] gas, int[] cost) {
        Vector<Integer> gas1=new Vector<Integer>();
        for(int i:gas){
            gas1.add(i);
        }

        Vector<Integer> cost1=new Vector<Integer>();
        for(int i:cost){
            cost1.add(i);
        }

        //总的油箱
        int GasBox=0;
        //记录当前的始发站
        int ans=0;
        //判断是否成功
        boolean IsSuccess=true;
        //当前坐标 会根据遍历ed地方变化的
        int index = 0;
        //当前坐标 相对在一次循环里不会变化的
        int index1=0;
        for(int i:gas) {
            GasBox=0;
            IsSuccess=true;
            //当前坐标
            index = index1;
            index1++;

            while(index<gas.length){
                GasBox+=gas1.get(index);
                GasBox-=cost1.get(index);
                if(GasBox<0){
                    IsSuccess=false;
                    break;
                }
                index++;
            }
            if(IsSuccess==false) continue;
            index=0;
            while(index<(index1-1)){
                GasBox+=gas1.get(index);
                GasBox-=cost1.get(index);
                if(GasBox<0){
                    IsSuccess=false;
                    break;
                }
                index++;
            }
            if (IsSuccess==true) return index1-1;
            else continue;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,3,2,4,1,5,3,2,4};
        int[] cost = {1,1,1,3,2,4,3,6,7,4,3,1};
        System.out.println(canCompleteCircuit(gas,cost));
    }
}
