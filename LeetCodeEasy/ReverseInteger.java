public class ReverseInteger {
	public static int reverse(int x) {
		int ZF;
		if (x < 0) {
			ZF = -1;
		} else if (x > 0) {
			ZF = 1;
		} else {
			return 0;
		}
		int digit = 0;
		int temp = x * ZF;
		while (temp > 0) {
			// temp = (int) (temp -Math.pow(10, digit+1));
			temp = temp / 10;
			digit++;
			// System.out.println(temp);
		}

		int sum = 0;
		temp = x * ZF;
		while (digit > 0) {

			// if(temp % 10!=0){
			sum = (int) (sum + (temp % 10) * Math.pow(10, digit - 1));

			temp = (temp - temp % 10) / 10;
			digit--;
		}
		return sum * ZF;
	}

	static int reverse2(int x) {
		long y = 0;
		int m = x;
		x = Math.abs(x);
		while (x != 0) {
			y = y * 10 + x % 10;
			x = x / 10;
		}
		if (m < 0)
			return (int) -y;
		else
			return (int) y;
	}

	public static void main(String args[]) {
		System.out.println(reverse2(-102300));
	}
}
