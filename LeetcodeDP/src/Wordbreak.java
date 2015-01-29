import java.util.HashSet;
import java.util.Set;

public class Wordbreak {
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null)
			return true;
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for (int i = 0; i < s.length(); i++) {
			System.out.println();
			for (int j = 0; j <= i; j++) {
				StringBuilder substingBuilder = new StringBuilder(s.substring(
						j, i + 1));
				
				System.out.print(substingBuilder.toString()+",");
				if (res[j] && dict.contains(substingBuilder.toString())) {
					res[i + 1] = true;
					break;
				}
				
				// substingBuilder.deleteCharAt(0);
			}
		}
		return res[s.length()];
	}
	
	 public static boolean wordBreak2(String s, Set<String> dict) {  
		    if(s==null || s.length()==0)  
		        return true;  
		    boolean[] res = new boolean[s.length()+1];  
		    res[0] = true;  
		    System.out.println(s.length());
		    for(int i=0;i<s.length();i++)  
		    {  
		    	System.out.println();
		        StringBuilder str = new StringBuilder(s.substring(0,i+1));  
		        for(int j=0;j<=i;j++)  
		        {  
		        	System.out.print(str.toString()+",");
		            if(res[j] && dict.contains(str.toString()))  
		            {  
		                res[i+1] = true;  
		                break;  
		            }  
		            str.deleteCharAt(0);  
		        }  
		    }  
		    return res[s.length()];  
		}  

	public static void main(String args[]) {
		String TextFile = "baaaaaac";
		Set<String> tokenMap = new HashSet();
		tokenMap.add("ba");
		tokenMap.add("aaaaaaaaaaaaaa");
		tokenMap.add("aaaa");
		tokenMap.add("aaaaaaaaaaaaaaaaaaaaaaaa");
		if(wordBreak2(TextFile,tokenMap)){
			System.out.println("true");
		}
	}

}
