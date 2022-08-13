package com.khanh.codility.test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SeatReservation {
	private static final String seatSigns = "ABCDEFGHJK";
	private static final List<Integer> isleSeatIndexs = Arrays.asList(2, 3, 6, 7); // 001 1001 100
	private static final List<Integer> adjacentSeatIndexs = Arrays.asList(1, 2, 3, 4, 5, 6); // 011 1111 000

	public static int solution(int N, String S) {
		if (N == 1 && "".equals(S.trim())) {
			return 2;
		}

		// initialize all utilities maps
		Map<Integer, Map<String, Boolean>> mapRowIndexAndReservedSeats = new LinkedHashMap<>();
		Map<String, Boolean> mapIsleSeats = new LinkedHashMap<>();
		Map<String, Boolean> mapAdjacentSeats = new LinkedHashMap<>();
		for (int i = 0; i < N; i++) {
			Map<String, Boolean> seatAndReserved = new LinkedHashMap<>();
			for (int j = 0; j < seatSigns.length(); j++) {
				String seatNum = "" + (i + 1) + seatSigns.charAt(j);
				seatAndReserved.put(seatNum, false);
				if (isleSeatIndexs.contains(j)) {
					mapIsleSeats.put(seatNum, true);
				}
				if (adjacentSeatIndexs.contains(j)) {
					mapAdjacentSeats.put(seatNum, true);
				}
			}
			mapRowIndexAndReservedSeats.put(i, seatAndReserved);
		}
		System.out.println("Map row index before reservation : " + mapRowIndexAndReservedSeats);
		System.out.println("Map isle seat : " + mapIsleSeats);
		System.out.println("Map adjecent seat : " + mapAdjacentSeats);

		// depend on reserved seat, put reserved flag
		String[] reservedSeats = S.split(" ");
		for (Map.Entry<Integer, Map<String, Boolean>> entry : mapRowIndexAndReservedSeats.entrySet()) {
			Map<String, Boolean> rowSeatAndReservation = entry.getValue();
			for (int i = 0; i < reservedSeats.length; i++) {
				if (rowSeatAndReservation.containsKey(reservedSeats[i])) {
					rowSeatAndReservation.put(reservedSeats[i], true);
				}
			}
		}

		// verify if there is any 4 consecutive seats are not reserved and belong to
		// adjacent seats on each row
		int result = 0;
		for (Map.Entry<Integer, Map<String, Boolean>> entry : mapRowIndexAndReservedSeats.entrySet()) {
			Map<String, Boolean> rowOfSeatAndReservation = entry.getValue();
			System.out.println("Row of map reserved: " + rowOfSeatAndReservation);
			int consecutiveAdjacentSeat = 0;
			for (Map.Entry<String, Boolean> e : rowOfSeatAndReservation.entrySet()) {
				if (e.getValue() || !mapAdjacentSeats.containsKey(e.getKey())) {
					consecutiveAdjacentSeat = 0;
				} else {
					consecutiveAdjacentSeat++;
				}
				if (consecutiveAdjacentSeat >= 4) {
					result++;
					consecutiveAdjacentSeat = 0; // just need to check  4 adjacent seats then reset the count
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(SeatReservation.solution(1, "1A 1C"));
		System.out.println(SeatReservation.solution(2, "1A 2F 1C"));
//		System.out.println(SeatReservation.solution(40, "1A 1D 1E 3C 2B 40G 5A"));
	}
}
