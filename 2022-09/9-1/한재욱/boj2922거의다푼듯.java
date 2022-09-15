import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String mo = "AEIOU";
	static char[] inputs = { 'A', 'B', 'L' };
	static char[] results;
	static int n, ncases;
	static char[] txt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		txt = br.readLine().toCharArray();
		n = txt.length;
		int cnt = 0;
		ncases = 0;
		for (int i = 0; i < txt.length; i++) {
			if (txt[i] == '_') {
				cnt++;
			}
		}
		results = new char[cnt];
		perm(0);
		System.out.println(ncases);
	}

	private static void perm(int idx) {
		if (idx == results.length) {
			int loc = 0;
			char[] copy = txt.clone();
			boolean isL = false;
			for (int i = 0; i < n; i++) {
				if (txt[i] == '_') {
					copy[i] = results[loc++];
				}
				if (copy[i] == 'L') {
					isL = true;
				}
			}

			if (isL) {
				int mocnt = 0;
				int jacnt = 0;
				for (int i = 0; i < n; i++) {
					if (mo.contains(Character.toString(copy[i]))) {
						mocnt++;
						jacnt = 0;
					} else {
						mocnt = 0;
						jacnt++;
					}
					if(mocnt==3||jacnt==3) return;
				}
				int sum = 1;
				for(int i=0;i<results.length;i++) {
					if(results[i]=='A') {
						sum *=5;
					}else if(results[i]=='B'){
						sum *=20;
					}
				}
				ncases += sum;
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			results[idx] = inputs[i];
			perm(idx + 1);
		}
	}
}