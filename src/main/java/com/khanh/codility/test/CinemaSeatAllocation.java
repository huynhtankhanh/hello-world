package com.khanh.codility.test;

import java.util.HashMap;
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
        Map<Integer, int[]> seats = new HashMap<>();
        int availableGroups = 2 * n; // max available groups since each empty row could fit at max 2 groups
        
        for (int[] seat: reservedSeats) {
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
        
        for (int[] groups: seats.values()) {
            int taken = groups[0] + groups[2];
            
            if (taken == 2) { // both slots at either ends are taken
                if (groups[1] == 0) { // check if middle slot not taken
                    availableGroups--; // reduce available slots by 1 since middle slot is available
                } else {
                    availableGroups -= 2; // entire row not available - reduce by 2
                }
            } else if (taken == 1) { // one of the slots at either ends are taken
                availableGroups--; // reduce by 1 since either side of the slots not available
            }
        }
        
        return availableGroups;
    }

	public static void main(String[] args) {
		int[][] reservedSeats = new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies(2, reservedSeats));

		int[][] reservedSeats1 = new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies(4, reservedSeats1));
		
		System.out.println("=====================");
		
		int[][] reservedSeats3 = new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies1(2, reservedSeats3));

		int[][] reservedSeats4 = new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } };
		System.out.println(CinemaSeatAllocation.maxNumberOfFamilies1(4, reservedSeats4));
	}

}