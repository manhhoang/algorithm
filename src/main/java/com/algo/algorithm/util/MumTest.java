package com.algo.algorithm.util;

import java.util.HashMap;
import java.util.Map;

public class MumTest {
	public static void main(String[] args) {
		isStepped(new int[] { 1, 1, 1, 5, 5, 5, 5, 8, 8, 8 });
		isStepped(new int[] { 1, 1, 5, 5, 5, 5, 8, 8, 8 });
		isStepped(new int[] { 5, 5, 5, 15 });
		isStepped(new int[] { 3, 3, 3, 2, 2, 2, 5, 5, 5 });
		isStepped(new int[] { 3, 3, 3, 2, 2, 2, 1, 1, 1 });
		isStepped(new int[] { 1, 1, 1 });
		isStepped(new int[] { 1, 1, 1, 1, 1, 1, 1 });

		System.out.println("---------");

		closestFibonacci(12);
		closestFibonacci(33);
		closestFibonacci(34);

		System.out.println("---------");

		isSelfReferential(new int[] { 0 });
		isSelfReferential(new int[] { 1 });
		isSelfReferential(new int[] { 2, 0, 0 });
		isSelfReferential(new int[] { 1, 2, 1, 0 });
		isSelfReferential(new int[] { 2, 0, 2, 0 });
		isSelfReferential(new int[] { 2, 1, 2, 0, 0 });
		isSelfReferential(new int[] { 3, 2, 1, 1, 0, 0, 0 });
		isSelfReferential(new int[] { 4, 2, 1, 0, 1, 0, 0, 0 });
		isSelfReferential(new int[] { 5, 2, 1, 0, 0, 1, 0, 0, 0 });
		isSelfReferential(new int[] { 6, 2, 1, 0, 0, 0, 1, 0, 0, 0 });
	}

	static int isStepped(int[] a) {
		int ans = 1;
		for (int i = 0; i < a.length;) {
			int j = i;
			int count = 0;
			while (j < a.length) {
				if (a[i] == a[j]) {
					j++;
					count++;
				} else if (a[i] > a[j]) {
					ans = 0;
					System.out.println(ans);
					return ans;
				} else {
					break;
				}
			}
			if (j == i) {
				j++;
			}
			if (count < 3) {
				ans = 0;
				break;
			}
			i = j;
		}
		System.out.println(ans);
		return ans;
	}

	static int closestFibonacci(int n) {
		int ans = 0;
		int[] fib = new int[n];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
			if (fib[i] > n) {
				break;
			}
			ans = fib[i];
		}
		System.out.println(ans);
		return ans;
	}

	static int isSelfReferential(int[] a) {
		int ans = 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			Integer count = map.get(a[i]);
			if (count == null) {
				count = 0;
				map.put(a[i], count);
			}
			map.put(a[i], ++count);
		}

		for (int i = 0; i < a.length; i++) {
			Integer count = map.get(i);
			if (count == null) {
				count = 0;
			}
			if (count != a[i]) {
				ans = 0;
				break;
			}

		}
		System.out.println(ans);
		return ans;
	}
}
