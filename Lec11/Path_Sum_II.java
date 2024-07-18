package Lec11;

import java.util.*;

public class Path_Sum_II {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {
		public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
			List<List<Integer>> ans = new ArrayList<>();
			List<Integer> ll = new ArrayList<>();
			 pathSum_1(root, targetSum, ans, ll);
			 return ans;
		}

		public void pathSum_1(TreeNode root, int targetSum, List<List<Integer>> ans, 
				List<Integer> ll) {
			if (root == null) {
				return;
			}
			if (root.left == null && root.right == null) {

				if (root.val - targetSum == 0) {
					ll.add(root.val);
					ans.add(new ArrayList<>(ll));
					ll.remove(ll.size() - 1);
				}
				return;
			}
			ll.add(root.val);
			pathSum_1(root.left, targetSum - root.val, ans, ll);
			pathSum_1(root.right, targetSum - root.val, ans, ll);
			ll.remove(ll.size() - 1);
		}
	}
}
