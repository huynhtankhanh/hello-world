package ch.klara.hello_world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
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
	
	public static void main(String[] args) {
		Solution solution = new Solution();

		// 1108
		String a = "1.1.1.1";
		System.out.println("1108. Defanging an IP Address_1: " + a.replace(".", "[.]"));

		String[] b = a.split("\\.");
		System.out.println("1108. Defanging an IP Address_2: " + String.join("[.]", b));

		// 1. Two Sum
		int[] nums = { 1, 2, 3, 4, 5 };
		int[] result = solution.twoSum(nums, 8);
		System.out.println("1. Two sum: " + result.toString());

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
		
		//1480
		System.out.println("1480. Running Sum of 1d Array");
		System.out.println(solution.runningSum(new int[] { 1, 2, 3, 4}));
	}

}
