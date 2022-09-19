package boj11387;

import java.math.BigDecimal;
import java.util.Scanner;
// 부동 소수점 떄문에 BigDecimal을 사용해야한다.
// 이때 비율인 것을 입력받을 때부터 100으로 나누면 안된다.
public class Main {
	// attack, power, hit, harm, speed
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] currKree = { sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble() };
		double[] currPabu = { sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble() };
		double[] kreeWeapon = { sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble() };
		double[] pabuWeapon = { sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble(), sc.nextDouble() };

		double[] Kree = new double[5];
		double[] Pabu = new double[5];
		for (int i = 0; i < 5; i++) {
			Kree[i] = currKree[i] - kreeWeapon[i];
			Pabu[i] = currPabu[i] - pabuWeapon[i];
		}
		double[] kreeWP = new double[5];
		double[] pabuWK = new double[5];
		for (int i = 0; i < 5; i++) {
			kreeWP[i] = Kree[i] + pabuWeapon[i];
			pabuWK[i] = Pabu[i] + kreeWeapon[i];
		}
		BigDecimal KreeStat = stat(currKree);
		BigDecimal PabuStat = stat(currPabu);
		BigDecimal KreeWPStat = stat(kreeWP);
		BigDecimal PabuWKStat = stat(pabuWK);


		char ansK = '0';
		char ansP = '0';
		if (KreeStat.compareTo(KreeWPStat) > 0) {
			ansK = '-';
		} else if (KreeStat.compareTo(KreeWPStat) < 0) {
			ansK = '+';
		}
		if (PabuStat.compareTo(PabuWKStat) > 0) {
			ansP = '-';
		} else if (PabuStat.compareTo(PabuWKStat) < 0) {
			ansP = '+';
		}

		System.out.println(ansK);
		System.out.println(ansP);

	}

	// 전투력 = arr[0] * (100 + arr[1]) * (a + b) * (100 + arr[4]
	// a = 100 - min(arr[2], 100)
	// b = min(arr[2],100) * arr[3]
	public static BigDecimal stat(double[] arr) {
		BigDecimal attack = BigDecimal.valueOf(arr[0]);
		BigDecimal power = BigDecimal.valueOf(arr[1]).divide(BigDecimal.valueOf(100.0));
		BigDecimal hit = BigDecimal.valueOf(arr[2]).divide(BigDecimal.valueOf(100.0));
		BigDecimal harm = BigDecimal.valueOf(arr[3]).divide(BigDecimal.valueOf(100.0));
		BigDecimal speed = BigDecimal.valueOf(arr[4]).divide(BigDecimal.valueOf(100.0));

		BigDecimal one = BigDecimal.valueOf(1.0);
		BigDecimal min1 = one.min(hit);
		BigDecimal temp = one.subtract(min1);
		temp = temp.add(min1.multiply(harm));
		power = power.add(one);
		speed = speed.add(one);
		return attack.multiply(power).multiply(temp).multiply(speed);

	}

}