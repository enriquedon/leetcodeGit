import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int min = 0;
		List<Integer> preMin = new ArrayList<Integer>();
		for (List<Integer> level : triangle) {
			preMin = helper(level, preMin);
		}
		return Collections.min(preMin);

	}

	private List<Integer> helper(List<Integer> level, List<Integer> preMin) {
		List<Integer> curMin = new ArrayList<Integer>();
		int minRoot = 0;
		int b;
		int a;
		for (int i = 0; i < level.size(); i++) {
			a = assignA(preMin, i);
			b = assignB(preMin, i);
//			System.out.println("a:" + a + " b:" + b);
			minRoot = Math.min(a, b);
			curMin.add(minRoot + level.get(i));
			 System.out.println(curMin);
		}
		return curMin;
	}

	private int assignB(List<Integer> preMin, int i) {
		if (preMin.size() == 0) {
			return 0;
		} else if (i == preMin.size()) {
			return Integer.MAX_VALUE;
		}
			
		return preMin.get(i);
	}

	private int assignA(List<Integer> preMin, int i) {
		if (preMin.size() == 0) {
			return 0;
		}else if (i == 0) {
			return Integer.MAX_VALUE;
		}

		return preMin.get(i - 1);
	}

	public int minimumTotal2(List<List<Integer>> triangle) {  
	    if(triangle.size() == 0)  
	        return 0;  
	    int[] res = new int[triangle.size()];  
	    for(int i=0;i<triangle.size();i++)  
	    {  
	        res[i] = triangle.get(triangle.size()-1).get(i);  
	    }  
	    for(int i=triangle.size()-2;i>=0;i--)  
	    {  
	        for(int j=0;j<=i;j++)  
	        {  
	            res[j] = Math.min(res[j],res[j+1])+triangle.get(i).get(j);   
	        }  
	    }  
	    return res[0];  
	}
	
	public static void main(String args[]) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(3);
		triangle.add(a);
		triangle.add(b);
		Triangle triangle2 = new Triangle();
		triangle2.minimumTotal(triangle);
	}
}
