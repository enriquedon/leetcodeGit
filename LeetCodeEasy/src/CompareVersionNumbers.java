public class CompareVersionNumbers {
	 public static int compareVersion(String version1, String version2) {
	        version1=trimzero(version1);
	        version2=trimzero(version2);
			String bring1[] = version1.split("\\.");
			String bring2[] = version2.split("\\.");
	        for(int i=0;i<(bring1.length<bring2.length?bring1.length:bring2.length);i++){
	            if(Integer.parseInt(bring1[i])>Integer.parseInt(bring2[i])) return 1;
	            if(Integer.parseInt(bring1[i])<Integer.parseInt(bring2[i])) return -1;
	        }
	        if(bring1.length==bring2.length) return 0;
	        return bring1.length<bring2.length?-1:1;
		}
		
		private static String trimzero(String v){
		    int idx=v.lastIndexOf('.');
		    while(idx>0){
		        if(Integer.parseInt(v.substring(idx+1,v.length()))!=0) return v;
		        v=v.substring(0,idx);
		        idx=v.lastIndexOf('.');
		    }
		    return v;
		}

	public static void main(String args[]) {
		String aString = "01";
		String bString = "1";
		
		String bring[] = bString.split("\\.");
		// System.out.println(bring.length);
//		for (String a : bring) {
//			System.out.println(a);
//		}
		// int interger1=Integer.parseInt(aString);
		// System.out.println(interger1);
//		System.out.println(compareVersion(aString, bString));
		 int idx = bString.lastIndexOf(".");
		 System.out.println(idx);
	}
}
