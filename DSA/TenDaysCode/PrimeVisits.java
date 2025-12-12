package TenDaysCode;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeVisits {

	static boolean isPrime(int no) {

		if (no <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(no); i++) {
			if (no % i == 0)
				return false;
		}
		return true;
	}

	static int countPrimes(int a, int b) {
		int count = 0;

		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	static int countPrimeNos(int n) {

		if (n <= 1)
			return 0;

		int[] isprimeArr = new int[n + 1];
		int count = 0;
		Arrays.fill(isprimeArr, 1);
		isprimeArr[0] = 0;
		isprimeArr[1] = 0;

		for (int i = 2; i <= Math.sqrt(n); i++) {

			if (isprimeArr[i] == 1) {
				for (int j = 2; i * j <= n; j++) {
					isprimeArr[i * j] = 0;
				}
			}
		}

		for (int k = 2; k <= n; k++) {
			if (isprimeArr[k] == 1)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int notest = sc.nextInt();
		for (int i = 0; i < notest; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// System.out.println(countPrimes(a,b));
			// System.out.println(countPrimeNos(a));
			// System.out.println(countPrimeNos(b));
			if (countPrimeNos(a) == countPrimeNos(a - 1))
				System.out.println(countPrimeNos(b) - countPrimeNos(a));
			else
				System.out.println(countPrimeNos(b) - countPrimeNos(a) + 1);

		}

	}

}
