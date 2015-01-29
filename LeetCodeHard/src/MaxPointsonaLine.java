import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxPointsonaLine {

	public static int maxPoints(Point[] points) {

		//HashMap<Integer, Integer> deduplicate = new HashMap<Integer, Integer>();
		HashMap<Double, Integer> slope = new HashMap<Double, Integer>();
		// Double[] parament = new Double[2];
		Double tmp = null;
		Double K = null;
		Double D = null;
		int count = 0;
		int max = 2;

		if (points.length == 0) {
			return 0;
		}
		if (points.length == 1) {
			return 1;
		}
		for (int i = 0; i < points.length; i++) {
			int same = 0;

			for (int j = i + 1; j < points.length; j++) {
				if (j == i) {
					break;
				}
				if ((points[i].x == points[j].x)
						&& (points[i].y == points[j].y)) {
					same++;
					continue;
				} else if ((points[i].x == points[j].x)) {
					K = Double.POSITIVE_INFINITY;
					D = (double) points[i].x;
				} else {
					K = (double) ((double) (double) (points[i].y - points[j].y) / (points[i].x - points[j].x));
					D = points[i].y - (points[i].x * K);
				}
				tmp = K / 31 + D / 17;
				// parament[0] = K;
				// parament[1] = D;
				//if (deduplicate.get(tmp) != null) {
				//	break;
				//}
				if (slope.get(tmp) != null) {
					count = slope.get(tmp) + 1 + same;
				} else {
					count = 2 + same;
				}
				if (count > max) {
					max = count;
				}
				System.out.println(" i:" + i + " count:" + count + " same:"
						+ same + " K:" + K + " D:" + D);
				slope.put(tmp, count);
			}

		}

		return max;
	}

	// public static int maxPoints(Point[] points) {
	// int res = 0;
	// for (int i = 0; i < points.length; i++) { // all line will pass through
	// // ith element
	// int ni = 1;
	// int max_count = 0; // ni is the number of repeating point for ith
	// HashMap<Double, Integer> count = new HashMap<Double, Integer>();
	// for (int j = i + 1; j < points.length; j++) {
	// if (points[i].x == points[j].x) {
	// if (points[i].y == points[j].y) { // same point
	// ni++;
	// } else {
	// int temp;
	// if (count.get(Double.POSITIVE_INFINITY) != null) {
	// temp = count.get(Double.POSITIVE_INFINITY);
	// temp++;
	// } else {
	// temp = 2;
	// }
	// }
	// } else {
	// int temp;
	// if (count
	// .get((double) ((points[i].y - points[j].y) / (points[i].x -
	// points[j].x))) != null) {
	// temp = count
	// .get((double) ((points[i].y - points[j].y) / (points[i].x -
	// points[j].x)));
	// temp++;
	// } else {
	// temp = 2;
	// }
	//
	// count.put(
	// (double) ((points[i].y - points[j].y) / (points[i].x - points[j].x)),
	// temp);
	// }
	// }
	// for (Map.Entry<Double, Integer> entry : count.entrySet()) {
	// max_count = (max_count < entry.getValue()) ? entry.getValue()
	// : max_count;
	// }
	//
	// max_count += ni;
	// res = (res < max_count) ? max_count : res;
	// }
	//
	// return res;
	// }

	public static void main(String args[]) {
		// Point[] points = new Point[10];
		// for (int i = 0; i < points.length; i++) {
		// Point tmp=new Point(i + 1, i + 2);
		// points[i]=tmp;
		// }
		Point[] points = new Point[7];
		Point tmp1 = new Point(0, 0);
		Point tmp2 = new Point(0, 0);
		Point tmp3 = new Point(1, 1);
		Point tmp4 = new Point(1, -1);
		Point tmp5 = new Point(0, 0);
		Point tmp6 = new Point(1, 1);
		Point tmp7 = new Point(2, 2);
		points[0] = tmp1;
		points[1] = tmp2;
		points[2] = tmp3;
		points[3] = tmp4;
		points[4] = tmp5;
		points[5] = tmp6;
		points[6] = tmp7;
		System.out.println(maxPoints(points));
	}
}
