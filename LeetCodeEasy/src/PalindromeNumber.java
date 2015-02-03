
public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x==Integer.MAX_VALUE||x==Integer.MIN_VALUE) return false;
        if(x<0) return false;
        int length=countLength(x);
        System.out.println("len:"+length);
        while(length>1){
            int lownum=x%10;
            if(lownum==0&&x>0) return false;
            x-=(lownum+lownum*Math.pow(10,length-1));
            x/=10;
            System.out.println("x:"+x+"low:"+lownum+"high:"+lownum*Math.pow(10,length-1));
            if(!(x>=0&&x<Math.pow(10,length-1))) return false;
            length-=2;
            
        }
        return true;
    }
    private static int countLength(int x){
        int length=0;
        while(x>0){
            x/=10;
            length++;
        }
        return length;
    }
    public static void main(String args[]){
		
		int b=1000110001;
		System.out.println(isPalindrome(b));;
	}
}
