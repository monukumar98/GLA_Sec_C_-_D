package Lec10;

public class Binary_Tree_Cameras {
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
		int count = 0;
		public int minCameraCover(TreeNode root) {
			int x = minCamera(root);
			if (x == -1) {
				count++;
			}
			return count;
		}
		public int minCamera(TreeNode root) {
			if (root == null) {
				return 0;
			}
			int left = minCamera(root.left);
			int right = minCamera(root.right);
			if (left == -1 || right == -1) {// mera lift ya right koi bhi ek chlid ke pass camera ki reaquremnet hai
				count++;
				return 1;// has Camera mtlb hmmne Camera install kra hai
			} else if (left == 1 || right == 1) {// mera lift ya right koi bhi ek chlid ke pass camera install hai
				return 0;// Node ke child pe Camera install hai
			} else
				return -1;// Camera chahiye bhai
		}
	}

}
