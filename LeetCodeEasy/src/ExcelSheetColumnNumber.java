public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		int num = 0;
		for(int i=s.length()-1;i>=0;i--){
			num+=(s.charAt(i)-64)*Math.pow(26, s.length()-i-1);
			System.out.println(s.charAt(i));
		}
		
		
		return num;

	}
	
	public static void main(String srgs[]){
		String s="BAA";
		System.out.println(titleToNumber(s));
	}
}
