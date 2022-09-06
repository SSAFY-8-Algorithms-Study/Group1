import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static class Ice implements Comparable<Ice> {
		int amount, idx;

		public Ice(int amount, int idx) {
			super();
			this.amount = amount;
			this.idx = idx;
		}

		@Override
		public int compareTo(Ice o) {
			return this.idx - o.idx;
		}
	}

	static int K;
	static long ans;
	static Ice[] ices;
	static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inArr = br.readLine().split(" ");
		int N = Integer.parseInt(inArr[0]);
		K = Integer.parseInt(inArr[1]);
		ices = new Ice[N];

		for (int i = 0; i < N; i++) {
			inArr = br.readLine().split(" ");
			ices[i] = new Ice(Integer.parseInt(inArr[0]), Integer.parseInt(inArr[1]));
		}
		Arrays.sort(ices);

		long[] sum = new long[ices[N - 1].idx + 1];
		for (int i = 0, idx = 0; i < ices[N - 1].idx + 1; i++) {
			if (i != 0) {
				sum[i] += sum[i - 1];
			}
			if (i == ices[idx].idx) {
				sum[i] += ices[idx].amount;
				idx++;
			}
		}

		int start = 0;
		int end = Math.min(K * 2, ices[N - 1].idx);
		long max_sum = 0;
		while (end < ices[N - 1].idx + 1) {
			if (start - 1 < 0) {
				max_sum = Math.max(max_sum, sum[end]);
			} else {
				max_sum = Math.max(max_sum, sum[end] - sum[start - 1]);
			}
			start++;
			end++;
		}
		System.out.println(max_sum);
	}
}
