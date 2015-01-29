
public class CountandSay {
	public String countAndSay(int n) {
        if(n==0) return null;
        StringBuilder sbuilder=new StringBuilder("1");
        //sbuilder.append(1);
        System.out.println(sbuilder.toString());
        for(int i=1;i<n;i++){
            char cur=sbuilder.charAt(0);
            int count=1;
            StringBuilder nextString=new StringBuilder();
            sbuilder.append('\0');
            for(int j=1;j<sbuilder.length();j++){
                if(sbuilder.charAt(j)==cur){
                    count++;
                }else{
                    nextString.append(count);
                    nextString.append(cur);
                    count=1;
                    cur=sbuilder.charAt(j+count-1);
                }
            }
            sbuilder=nextString;
        }
        return sbuilder.toString();
    }
	
	
}
