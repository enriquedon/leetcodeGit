public class MajorityElement {
	//static int count = 0;

	public static int majorityElement(int[] num) {
		
		if (num.length == 1 ||num.length == 2) {
			return num[0];
		}
		// int result = 0;
		int count = 0;
		int[] temp = new int[num.length / 2 + 1];
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i] + " " + num.length);
			if (i == num.length - 1) {
				temp[count] = num[num.length - 1];
				System.out
						.println(num[num.length - 1]);
				count++;
				break;
			}
			if (num[i] == num[i + 1]) {
				temp[count] = num[i];
				System.out.println(temp[count]);
				count++;
			}
			i++;

		}
		int[] temp2 = new int[count];
		for (int i = 0; i < count; i++) {
			temp2[i] = temp[i];
		}
		System.out.println("cout :"+count);
		return majorityElement(temp2);

	}

	public static void main(String args[]) {
		int length = 10;
		int[] Number = new int[length];
		for (int i = 0; i < length; i++) {

			if (i % 2 == 0) {
				Number[i] = 2;

			} else {
				Number[i] = i;
			}
		}
		Number[9] = 2;
		for (int c : Number) {
			System.out.print(c + ",");
		}
		int[] num = new int[3];
		num[0] = 6;
		num[1] = 6;
		num[2] = 5;
		System.out.println(majorityElement(num));
	}
}
