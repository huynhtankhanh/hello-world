package ch.klara.hello_world;

public class BitwiseOperator {

	public static void main(String[] args) {
		// Bitwise AND (&): It returns 1 if and only if both bits are 1, else returns 0.
		/**
		 * x	y	x&y
		 * 0	0	0
		 * 1	0	0
		 * 0	1	0
		 * 1	1	1
		 */
		System.out.println("8&1: "+ (8&1)); // 1000 & 0001 -> 0000 = 0
		System.out.println("9&8: " + (9&8)); // 1001 & 1000 -> 1000 = 8
		
		// Bitwise exclusive OR (^):  It returns 0 if both bits are the same, else returns 1.
		/**
		 * x	y	x^y
		 * 0	0	0
		 * 1	0	1
		 * 0	1	1
		 * 1	1	0
		 */
		System.out.println("5^6: "+ (5^6)); // 101 ^ 110 => 011 
		System.out.println("9^6: " + (9^6)); // 1001 ^ 0110 => 1111= 8 + 4 + 2 + 1
		
		//Bitwise inclusive OR (|) - pipe : It returns 1 if either of the bit is 1, else returns 0.
		/**
		 * x	y	x|y
		 * 0	0	0
		 * 1	0	1
		 * 0	1	1
		 * 1	1	1
		 */
		System.out.println("5|6: "+ (5|6)); // 101 | 110 => 111 
		System.out.println("9|6: " + (9|6)); // 1001 | 0110 => 1111= 8 + 4 + 2 + 1
		
		/**
		 * x	~x
		 * 0	1
		 * 1	0
		 */
		//Bitwise Complement (~) - tilde: It returns the inverse or complement of the bit. It makes every 0 a 1 and every 1 a 0.
		System.out.println("~2 = " + (~2)); // 2 = 0010 -> - (0010 + 1) = -0011 = -3
		System.out.println("~10 = " + (~10)); // 10 = 1010 -> -(1010 + 1) = -1011 = -11 
		System.out.println("~9 = " + (~9)); // 9 = 1001 -> - (1001 + 1) = -(1010) = -10
	}
}
