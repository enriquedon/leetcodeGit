

import java.util.HashMap;
import java.util.Map;

public class twosum {
	public static int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        int[] result=new int[2];
        for(int i=0;i<numbers.length;i++){
        	 if(!map.containsKey(numbers[i])){
        		  map.put(target-numbers[i],i);
        	 }else{
        		 result[0]=map.get(numbers[i]);
        		 result[1]=i;
        	 }
        }
        return result;
    }
	
	public static void main(String args[]) {
		 int[] result=new int[2];
		 int[]a={0,4,3,0};
		 result = twoSum(a,0);
		 for(int c:result){
			 System.out.println(c);
		 }
	}
}
