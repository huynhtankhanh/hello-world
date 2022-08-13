package com.khanh.codility.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class CinemaSeatAllocation {
	private static final String seatSigns = "ABCDEFGHJK";

	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		String reservedSeatStr = "";
		for (int i = 0; i < reservedSeats.length; i++) {
			int[] colArr = reservedSeats[i];
			String seatNum = "" + colArr[0] + seatSigns.charAt(colArr[1] - 1);
			reservedSeatStr = reservedSeatStr + seatNum + " ";
		}

		System.out.println("Reserved str: " + reservedSeatStr);
		return SeatReservation.solution(n, reservedSeatStr);
	}

	public static int maxNumberOfFamilies1(int n, int[][] reservedSeats) {
		Map<Integer, int[]> seats = new LinkedHashMap<>();

		for (int[] seat : reservedSeats) {
			int row = seat[0];
			int col = seat[1];
			int[] groups = seats.getOrDefault(row, new int[3]);

			if (col >= 2 && col <= 5) { // left group
				groups[0] = 1;
			}
			if (col >= 4 && col <= 7) { // middle group
				groups[1] = 1;
			}
			if (col >= 6 && col <= 9) { // right group
				groups[2] = 1;
			}

			seats.put(seat[0], groups);
		}

		int result = 0;
		for (int[] groups : seats.values()) {
			int taken = groups[0] + groups[2];
			if (taken == 2 && groups[1] == 0) {
				result++;
			} else if (taken == 1) {
				result++;
			} else {
				result += 2;
			}

		}

		return result;
	}

	public static void main(String[] args) {
//		int[][] reservedSeats = new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } };
//		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies(2, reservedSeats));
//
//		int[][] reservedSeats1 = new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
//		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies(4, reservedSeats1));
//
//		System.out.println("=====================");

		int[][] reservedSeats3 = new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies1(2, reservedSeats3));

		int[][] reservedSeats4 = new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies1(4, reservedSeats4));
	}

}
