package com.khanh.codility.test;

public class CinemaSeatAllocation {
	private static final String seatSigns = "ABCDEFGHJK";

	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		String reservedSeatStr = "";
		for (int i = 0; i < reservedSeats.length; i++) {
			int[] colArr = reservedSeats[i];
			String seatNum = "" + colArr[0] + seatSigns.charAt(colArr[1] - 1);
			reservedSeatStr = reservedSeatStr + seatNum + " ";
		}

		System.out.println("Lala " + reservedSeatStr);
		return SeatReservation.solution(n, reservedSeatStr);
	}

	public static void main(String[] args) {
		int[][] reservedSeats = new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies(2, reservedSeats));

		int[][] reservedSeats1 = new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies(4, reservedSeats1));
	}

}
