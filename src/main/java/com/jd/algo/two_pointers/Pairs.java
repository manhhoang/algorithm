package com.jd.algo.two_pointers;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Pairs {

	public static int[] solution(int[] a, int[] b, int X) {
		int[] ans = new int[2];
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0;
		int j = b.length - 1;
		while (i < a.length) {
			while (a[i] + b[j] > X && j > 0) {
				j--;
			}
			if (a[i] + b[j] == X) {
				ans[0] = i;
				ans[1] = j;
				break;
			}
			i++;
		}
		return ans;
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new int[] { 0, 0 }, solution(new int[] { 1, 2, 5 }, new int[] { 2, 4, 7 }, 3));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new int[] { 0, 1 }, solution(new int[] { 1, 4, 6 }, new int[] { 2, 4, 7 }, 5));
	}
}
