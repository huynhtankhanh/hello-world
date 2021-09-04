package ch.klara.hello_world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		result.add(root.val);
		result.addAll(preorderTraversal(root.left));
		result.addAll(preorderTraversal(root.right));

		return result;
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer diff = (Integer) (target - nums[i]);
			if (map.containsKey(diff)) {
				int[] toReturn = { map.get(diff), i };
				return toReturn;
			}
			map.put(nums[i], i);
		}
		return null;
	}

	public int numberOfSteps(int num) {
		int step = 0;
		while (num > 0) {
			num = (num % 2 == 0) ? (num / 2) : (num - 1);
			step++;

		}
		return step;
	}

	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] copy = nums.clone();
		Arrays.sort(copy);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < copy.length; i++) {
			if (!map.containsKey(copy[i])) {
				map.put(copy[i], i);
			}
		}
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = map.get(nums[i]);
		}
		return result;
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0;
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] > max) {
				max = candies[i];
			}
		}

		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < candies.length; i++) {
			if ((candies[i] + extraCandies) >= max) {
				result.add(true);
			} else {
				result.add(false);
			}
		}

		return result;
	}

	public int[] shuffle(int[] nums, int n) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(nums[i]);
			list.add(nums[i + n]);
		}

		int[] result = new int[nums.length];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public int[] runningSum(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				result[i] = nums[i];
			} else {
				result[i] = result[i - 1] + nums[i];
			}
		}

		return result;
	}

	public int maximumWealth(int[][] accounts) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < accounts.length; i++) {
			map.put(i, sum1762(accounts[i]));
		}

		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > result) {
				result = entry.getValue();
			}
		}

		return result;
	}

	public int sum1762(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result += nums[i];
		}
		return result;
	}

	// index 1 type, 2 color, 3 name
	public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
		return items.stream().filter(item -> {
			if ("type".equals(ruleKey)) {
				return item.get(0).equals(ruleValue);
			} else if ("color".equals(ruleKey)) {
				return item.get(1).equals(ruleValue);
			}
			return item.get(2).equals(ruleValue);
		}).collect(Collectors.toList()).size();
	}

	public boolean checkIfPangram(String sentence) {
		Set<String> pangramSet = new HashSet<>();
		for (int i = 0; i < sentence.length(); i++) {
			String str = String.valueOf(sentence.charAt(i));
			pangramSet.add(str);
		}

		return pangramSet.size() == 26 ? true : false;
	}

	public int reverse(int x) {
		if (x < Integer.MIN_VALUE || x > Integer.MAX_VALUE) {
			return 0;
		}
		int result = 0;
		while (x != 0) {
			int digit = x % 10;
			if (result < (Integer.MIN_VALUE / 10) || result > (Integer.MAX_VALUE / 10)) {
				result = 0;
			} else {
				result = result * 10 + digit;
			}
			x /= 10;
		}
		return result;
	}

	public boolean isOutOfIntegerBoundary(int x) {
		return x < Integer.MIN_VALUE || x > Integer.MAX_VALUE;
	}

	public boolean isPalindrome(int x) {
		if (x < 0 || x > Integer.MAX_VALUE) {
			return false;
		}
		int reversedX = 0;
		int copy = x;
		while (copy != 0) {
			int digit = copy % 10;
			if (reversedX < (Integer.MIN_VALUE / 10) || reversedX > (Integer.MAX_VALUE / 10)) {
				reversedX = 0;
			} else {
				reversedX = reversedX * 10 + digit;
			}
			copy /= 10;
		}
		return reversedX == x;
	}

	public int romanToInt(String s) {
		int prev = lookRomanInt(s.charAt(s.length() - 1));
		int sum = 0;
		sum += prev;
		for (int i = s.length() - 2; i >= 0; i--) {
			int curr = 0;
			char val = s.charAt(i);
			curr = lookRomanInt(val);
			if (curr >= prev) {
				sum += curr;
			} else {
				sum -= curr;
			}
			prev = curr;
		}
		return sum;
	}

	public int lookRomanInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String shortestStr = strs[0];
		int skip = 0;
		for (int i = 1; i < strs.length; i++) {
			if ("".equals(strs[i].trim())) {
				return "";
			}
			if (strs[i].length() < shortestStr.length()) {
				shortestStr = strs[i];
				skip = i;
			}
		}

		String result = "";
		for (int i = 0; i < shortestStr.length(); i++) {
			String prefix = shortestStr.substring(0, i + 1); // substring get from 0 to endIndex - 1
			result = prefix;
			for (int j = 0; j < strs.length; j++) {
				if (j == skip) {
					continue;
				}
				String str = strs[j];
				if (!str.startsWith(prefix)) {
					result = shortestStr.substring(0, i);
					return result;
				}
			}
		}
		return result;
	}

	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			String str = strs[i];
			while (str.indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}

	boolean valid(char b, char e) {
		return b == '(' && e == ')' || b == '{' && e == '}' || b == '[' && e == ']';
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else if (valid(stack.peek(), c)) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}

	public boolean containsDuplicate(int[] nums) {
		boolean isContainsDuplicate = false;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				isContainsDuplicate = true;
				break;
			}
		}
		return isContainsDuplicate;
	}

//	public boolean containsNearbyDuplicate(int[] nums, int k) {
//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < nums.length; i++) {
//			list.add(nums[i]);
//			int firstOccurance = list.indexOf(nums[i]);
//			int lastOccurance = list.lastIndexOf(nums[i]);
//			if (firstOccurance != lastOccurance && (lastOccurance - firstOccurance) <= k) {
//				return true;
//			}
//			if (lastOccurance - firstOccurance > k) {
//				// remove first occur
//				list.remove((Integer) nums[i]);
//			}
//		}
//		return false;
//	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			Integer num = nums[i];
			if (map.containsKey(num) && Math.abs(i - map.get(num)) <= k) {
				return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.floor(nums[i]) != null && set.floor(nums[i]) >= (long) nums[i] - t) {
				return true;
			}
			if (set.ceiling(nums[i]) != null && set.ceiling(nums[i]) <= nums[i] + t) {
				return true;
			}
			set.add(nums[i]);
			if (i >= k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

	public int missingPositiveNumberInArray(int[] A) {
		Arrays.sort(A);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				set.add(A[i]);
			}
		}

		int N = A[A.length - 1];
		// loop up to N + 1, the missing could be NEXT number in arr. Ex [1,2,3,4], the
		// missing should be 5
		for (int i = 1; i <= N + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return 1;
	}

	public void bubbleSort(int arr[]) {
		System.out.println("before==============");
		printArray(arr);
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("after=================");
		printArray(arr);
	}

	public void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
    
	public int removeDuplicates(int[] nums) {
		int count = 1;
		int i = 0, j = 1;
		while (j < nums.length) {
			System.out.println("i: " + i);
			System.out.println("j: " + j);
			System.out.println("nums[i]: " + nums[i]);
			System.out.println("nums[j]: " + nums[j]);
			System.out.println("=============");
			
			if (nums[i] != nums[j]) {
				System.out.println("count: " + count);
				nums[count] = nums[j];
				count++;
				i = j;
				j++;
			} else {
				j++;
			}
		}
		return count;
	}

	/**
	 * FASTEST SOLUTION
	 * 
	 * @param arr
	 * @param k
	 * @return
	 */
	public int findKthPositive(int[] arr, int k) {
		Arrays.sort(arr);
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] - mid - 1 < k) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start + k;
	}

//	public int findKthPositive(int[] arr, int k) {
//		Arrays.sort(arr);
//		Set<Integer> set = new HashSet<>();
//		for (int i = 0; i < arr.length; i++) {
//			set.add(arr[i]);
//		}
//
//		int max = arr[arr.length - 1] + k;
//		List<Integer> missingNumber = new ArrayList<>();
//		for (int i = 1; i <= max; i++) {
//			if (!set.contains(i)) {
//				missingNumber.add(i);
//			}
//		}
//		return missingNumber.get(k - 1);
//	}	
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		// 1108
		String ip = "1.1.1.1";
		System.out.println("1108. Defanging an IP Address_1: " + ip.replace(".", "[.]"));

		String[] b = ip.split("\\.");
		System.out.println("1108. Defanging an IP Address_2: " + String.join("[.]", b));

		// 1. Two Sum
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println("1. Two sum");
		System.out.println(solution.twoSum(nums, 8).toString());

		// 1342
		System.out.println("1342. Number of Steps to Reduce a Number to Zero: " + solution.numberOfSteps(14));

		// 1365
		System.out.println("1365. How Many Numbers Are Smaller Than the Current Number");
		solution.smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 5 });

		// 1431
		System.out.println("1431. Kids With the Greatest Number of Candies");
		System.out.println(solution.kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 2));

		// 1470
		System.out.println("1470. Shuffle the Array");
		System.out.println(solution.shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3));

		// 1480
		System.out.println("1480. Running Sum of 1d Array");
		System.out.println(solution.runningSum(new int[] { 1, 2, 3, 4 }));

		// 1603
		System.out.println("1603. Design Parking System");
		// ==> refer to ParkingSystem.java

		// 1672
		System.out.println("1672. Richest Customer Wealth");
		int[][] accounts = new int[][] { { 1, 2, 3 }, { 3, 2, 1 } };
		System.out.println(solution.maximumWealth(accounts));

		// 1773
		System.out.println("1773. Count Items Matching a Rule");
		List<String> item1 = new ArrayList<>(Arrays.asList("phone", "blue", "pixel"));
		List<String> item2 = new ArrayList<>(Arrays.asList("computer", "silver", "lenovo"));
		List<String> item3 = new ArrayList<>(Arrays.asList("phone", "gold", "iphone"));
		System.out.println(solution.countMatches(Arrays.asList(item1, item2, item3), "type", "phone"));

		// 1832
		System.out.println("1832. Check if the Sentence Is Pangram");
		System.out.println("leetcode ? " + solution.checkIfPangram("leetcode"));
		System.out.println("thequickbrownfoxjumpsoverthelazydog ? "
				+ solution.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));

		// 7
		System.out.println("7. Reverse Integer");
		System.out.println(solution.reverse(134236469));

		// 9
		System.out.println("9. Palindrome Number");
		System.out.println(solution.isPalindrome(131));

		// 13
		System.out.println("13. Roman to Integer");
		System.out.println(solution.romanToInt("LVIII"));
		System.out.println(solution.romanToInt("LIV"));

		// 14
		System.out.println("14. Longest Common Prefix");
		System.out.println("c1_a: " + solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
		System.out.println("c1_b: " + solution.longestCommonPrefix(new String[] { "a" }));
		System.out.println("c2_1: " + solution.longestCommonPrefix2(new String[] { "flower", "flow", "flight" }));
		System.out.println("c2_b: " + solution.longestCommonPrefix2(new String[] { "a" }));

		// 20
		System.out.println("20. Valid Parentheses");
		System.out.println(solution.isValid("([])"));
//		System.out.println(solution.isValid("(]"));

		// 217
		System.out.println("217. Contains Duplicate");
		System.out.println(solution.containsDuplicate(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(solution.containsDuplicate(new int[] { 2, 3, 5, 1, 3 }));

		// 219
		System.out.println("219. Contains Duplicate II");
		System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3));
		System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2));
		System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1));

		// 220
		System.out.println("220. Contains Duplicate III");
		System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
		System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));
		System.out.println(solution.containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));

		System.out.println("MissingPositive number ");
//		System.out.println(solution.missingPositiveNumber(new int[] { 1, 3, 6, 4, 1, 2 }));
//		System.out.println(solution.missingPositiveNumberInArray(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(solution.missingPositiveNumberInArray(new int[] { 1, 7, 8, 9 }));

		// 1539
		System.out.println("1539. Kth Missing Positive Number");
		System.out.println(solution.findKthPositive(new int[] { 1, 4, 3, 2 }, 2));
		System.out.println(solution.findKthPositive(new int[] { 1, 6, 3, 2 }, 2));
		System.out.println(solution.findKthPositive(new int[] { 1, 2, 3, 5, }, 2));
		System.out.println(solution.findKthPositive(new int[] { 1, 3, 5, 7, 9 }, 3));

		// 25
		System.out.println("26. Remove Duplicates from Sorted Array");
		System.out.println(solution.removeDuplicates(new int[] { 1, 1, 2, 2, 3, 3, 4 }));

		//bubble sort
		System.out.println("bubble sort");
		solution.bubbleSort(new int[] {5,1,3,2,4});
		
		//oddOccurrencesInArray
		System.out.println("oddOccurrencesInArray");
		System.out.println(solution.oddOccurrencesInArray(new int[] { 7, 1, 2, 2, 4, 4, 7 }));
		
//		System.out.println(String.format("id=%08.2f", 423.147));
//		int j = 0;
//		for (int i = 0; i < 100; i++) {
//			while (j < 100) {
//				j++;
//				System.out.println("j==" + j);
//				if (j == 10) {
//					return;
//				}
//			}
//		}
//		final Set<String> set = new HashSet<>(Arrays.asList("first", "second"));
//		set.add("third");
//		System.out.println(set);
		
		// 1375
		System.out.println("1375. Bulb Switcher III");
		System.out.println(solution.numTimesAllBlue(new int[] { 2, 3, 4, 1, 5 }));
		System.out.println(solution.numTimesAllBlue(new int[] { 1, 3, 4, 2, 5 }));
		System.out.println(solution.numTimesAllBlue(new int[] { 2, 5, 4, 1, 3 }));
		System.out.println(solution.numTimesAllBlue(new int[] { 1, 2, 5, 3, 4 }));
		
		List<String> strs = new ArrayList<>();
		strs.add("c");
		strs.add("a");
		strs.add("a");
		strs.add("b");
		strs.add("b");
		
		Map<String, String> map = strs.stream().collect(Collectors.toMap(i -> i, i -> i, (a1, a2) -> a2));
		System.out.println(map);
		Map<String, List<String>> mapStr = strs.stream().collect(Collectors.groupingBy(i -> i));
		System.out.println(mapStr);
		String singleEntry = mapStr.entrySet().stream().filter(item -> item.getValue().size() == 1)
				.findFirst().get().getKey();
		System.out.println(singleEntry);
		
		// 868. Binary Gap
		System.out.println("868. Binary Gap");
//		System.out.println(solution.binaryGap(8)); // 1000 -> 0
//		System.out.println(solution.binaryGap(9)); // 1001 -> 3
		
		System.out.println("5^6: "+ (5^6)); // 101 ^ 110 => 011 
		System.out.println("9^6: " + (9^6)); // 1001 ^ 0110 => 1111= 8 + 4 + 2 + 1
		System.out.println("8&1: "+ (8&1)); // 1000 & 0001 -> 0000 = 0
	}
	
//    public int binaryGap(int n) {
//    	String bStr = Integer.toBinaryString(n);
//    	for (int i = 0; i < bStr.length(); i++) {
//			String s = bStr.substring(i, i + 1);
//			System.out.println("Substring: " + s);
//		}
//    	
//        return 0;
//    }
    
	public int binaryGap(int n) {
		int pos = 1;
		int lastPos = -1;
		int distance = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				if (lastPos != -1) {
					distance = Math.max(distance, pos - lastPos);
				}
				lastPos = pos;
			}
			n = n >>> 1;
			pos++;
		}
		return distance;
	}
	
	public static List<String> mergeObject(String a, String b) {
		List<String> result = new ArrayList<>();
		result.add(a);
		result.add(b);
		return result;
	}
	
	public int numTimesAllBlue(int[] A) {
		// write your code in Java SE 8
		int first = 0, next = 0, result = 0;
		for (int i = 0; i < A.length; i++) {
			first += A[i];
			next += i + 1;
			System.out.println("first: " + first);
			System.out.println("next: " + next);
			if (first == next) {
				result++;
			}
		}
		return result;
	}
	
	public int oddOccurrencesInArray(int[] nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			System.out.println("OLD result: " + result);
			System.out.println("nums[i]: " + nums[i]);
			result = result ^ nums[i];
			System.out.println("NEW result: " + result);
			System.out.println("===================");
		}
		return result;
	}
	
}
