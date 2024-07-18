package Lec11;

public class Maximum_Sum_BST_in_Binary_Tree {
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
		public int maxSumBST(TreeNode root) {
			return SumBST(root).ans;
		}

		public BstPair SumBST(TreeNode root) {
			if (root == null) {
				return new BstPair();

			}

			BstPair lbp = SumBST(root.left);// isbst min max
			BstPair rbp = SumBST(root.right);// isbst min max
			BstPair sbp = new BstPair();
			sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.val));
			sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.val));
			sbp.sum = lbp.sum + rbp.sum + root.val;
			sbp.isbst = lbp.isbst && rbp.isbst && lbp.max < root.val && rbp.min > root.val;
			if (sbp.isbst) {
				sbp.ans = Math.max(lbp.ans, Math.max(rbp.ans, sbp.sum));
			} else {
				sbp.ans = Math.max(lbp.ans, rbp.ans);
			}
			return sbp;
		}

		class BstPair {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			boolean isbst = true;
			int sum = 0;
			int ans = 0;// only bst wala ka maximum sum ka track
		}
	}
}
