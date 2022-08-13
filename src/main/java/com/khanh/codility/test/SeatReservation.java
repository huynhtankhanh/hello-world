package com.khanh.codility.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatReservation {
	private static final String seatChar = "ABCDEFGHJK";
	private static final List<Integer> isleSeats = Arrays.asList(2, 3, 6, 7);

	private static Map<String, Boolean> mapSeat() {
		Map<String, Boolean> map = new HashMap<>();
		for (int i = 0; i < seatChar.length(); i++) {
			if (Arrays.asList(2, 3, 6, 7).contains(i)) {
				map.put("" + seatChar.charAt(i), true);
			} else {
				map.put("" + seatChar.charAt(i), false);
			}
		}
		return map;
	}

	public static int solution(int N, String S) {
		System.out.println(mapSeat());
		if (N == 1 && "".equals(S.trim())) {
			return 2;
		}

		Map<Integer, Map<String, Boolean>> mapRowSeats = new HashMap<>();
		Map<String, Boolean> mapIsleSeats = new HashMap<>();
		for (int i = 0; i < N; i++) {
			Map<String, Boolean> seatAndReserved = new HashMap<>();
			for (int j = 0; j < seatChar.length(); j++) {
				String seatNum = "" + (i + 1) + seatChar.charAt(j);
				seatAndReserved.put(seatNum, false);
				if (isleSeats.contains(j)) {
					mapIsleSeats.put(seatNum, true);
				}
			}
			mapRowSeats.put(i, seatAndReserved);
		}
		System.out.println("Map before reservation : " + mapRowSeats);
		System.out.println("Map isle seat : " + mapIsleSeats);

		String[] reservedSeats = S.split(" ");
		for (Map.Entry<Integer, Map<String, Boolean>> entry : mapRowSeats.entrySet()) {
			Map<String, Boolean> rowSeatAndReservation = entry.getValue();
			for (int i = 0; i < reservedSeats.length; i++) {
				if (rowSeatAndReservation.containsKey(reservedSeats[i])) {
					rowSeatAndReservation.put(reservedSeats[i], true);
				}
			}
		}
		System.out.println("Map after reservation: " + mapRowSeats);

		int result = 0;
		for (Map.Entry<Integer, Map<String, Boolean>> entry : mapRowSeats.entrySet()) {
			Map<String, Boolean> rowSeatAndReservation = entry.getValue();
//			System.out.println("rowSeatAndReservation  at row: " + entry.getKey() + ", value: " + rowSeatAndReservation);
			int countConsecutiveSeat = 0;
			for (boolean entryRowAndReservation : rowSeatAndReservation.values()) {
				if (entryRowAndReservation) {
					countConsecutiveSeat = 0;
				} else {
					countConsecutiveSeat++;
				}
			}
			System.out.println("countConsecutiveSeat: " + countConsecutiveSeat);
			if (countConsecutiveSeat >= 4) {
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(SeatReservation.solution(2, "1A 2F 1C"));
//		System.out.println(SeatReservation.solution(40, "1A 3C 2B 40G 5A"));
	}
}
