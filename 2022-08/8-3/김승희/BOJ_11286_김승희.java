import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		PriorityQueue<Tuple> pq = new PriorityQueue<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			if (value == 0) {
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll().value + "\n");
				}
			} else {
				pq.add(new Tuple(value));
			}
		}
		System.out.println(sb.toString());
	}

	static class Tuple implements Comparable<Tuple> {
		int abs_value, value;

		public Tuple(int v) {
			this.abs_value = Math.abs(v);
			this.value = v;
		}

		@Override
		public int compareTo(Tuple o) {
			return this.abs_value == o.abs_value ? Math.min(this.value, o.abs_value) : this.abs_value - o.abs_value;
		}
	}

}