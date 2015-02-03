import java.util.Stack;

public class Minstack {
	int min = Integer.MAX_VALUE;
	Stack<Integer> a;
	Stack<Integer> minStack = new Stack<Integer>();

	Minstack() {
		a = new Stack<Integer>();
	}

	public void push(int x) {
		if (x < min) {
			min = x;
			minStack.push(x);
		}
		a.push(x);
	}

	public void pop() {
		if (a.peek() == min) {
			minStack.pop();
			min = minStack.peek();
		}
		a.pop();
		if (a.empty()) {
			min = Integer.MAX_VALUE;
		}

	}

	public int top() {
		return a.peek();
	}

	public int getMin() {
		return min;
	}

	public static void main(String args[]) {
		Minstack ms=new Minstack();
		ms.push(1);
		ms.push(2);
		ms.push(0);
		ms.pop();
		System.out.println(ms.min);
	}
}
