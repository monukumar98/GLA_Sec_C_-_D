package Lec9;

import java.util.*;

public class Binary_Tree_Right_Side_View {
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
		int maxdept = 0;

		public List<Integer> rightSideView(TreeNode root) {
			List<Integer> ll = new ArrayList<>();
			rightView(root, 1, ll);
			return ll;
		}

		public void rightView(TreeNode root, int curr,List<Integer> ll) {
			if (root == null) {
				return;
			}
			if (curr > maxdept) {
				// data Store
				ll.add(root.val);
				maxdept = curr;

			}
			rightView(root.right, curr + 1,ll);
			rightView(root.left, curr + 1,ll);
		}
	}
}
