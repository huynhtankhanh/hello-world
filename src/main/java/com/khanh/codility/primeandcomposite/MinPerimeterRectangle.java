package com.khanh.codility.primeandcomposite;

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/
 * 
 * @author htkhanh
 *
 */
public class MinPerimeterRectangle {

	// 100%
	public int solution(int N) {
		double squareRoot = Math.sqrt(N);
		List<Integer> factors = new ArrayList<>();
		for (int i = 1; i <= squareRoot; i++) {
			if (N % i == 0) {
				if (i < squareRoot) {
					factors.add(i);
					factors.add(N / i);
				} else {
					factors.add((int) squareRoot);
				}
			}
		}

		int minPerimeterOf = Integer.MAX_VALUE, minPerimeter = Integer.MAX_VALUE;
		List<Integer> usedFactors = new ArrayList<>();
		for (int i = 0; i < factors.size(); i++) {
			if (!usedFactors.contains(factors.get(i))) {
				int factor = factors.get(i);
				int oppFactor = N / factor;
				usedFactors.add(factor);
				usedFactors.add(oppFactor);
				int perimeterAt = 2 * (factor + oppFactor);
				minPerimeterOf = Math.min(minPerimeterOf, perimeterAt);
				minPerimeter = Math.min(minPerimeter, minPerimeterOf);
			}
		}
		return minPerimeter;
	}

	public static void main(String[] args) {
		MinPerimeterRectangle m = new MinPerimeterRectangle();
		System.out.println(m.solution(30));
	}
}
