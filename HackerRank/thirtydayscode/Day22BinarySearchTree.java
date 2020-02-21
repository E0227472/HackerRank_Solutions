package com.capgemini.thirtydayscode;

import java.util.Scanner;

class Node {
	Node left, right;
	int data;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class Day22BinarySearchTree {
	public static int getHeight(Node root) {
		// Write your code here
		int countLeft = 0;
		int countRight = 0;
		Node tempLeft = root;
		Node tempRight = root;
		// if root is object 3.
		while (tempLeft != null) {
			tempLeft = tempLeft.left;
			if (tempLeft == null)
				break;
			else
				countLeft++;
		}
		while (tempRight != null) {
			tempRight = tempRight.right;
			if (tempRight == null)
				break;
			else
				countRight++;
		}

		int maxlength = Math.max(countLeft, countRight);

		return maxlength;
	}

	// 1st insert loop, has root = null.
	// 2nd insert loop, root has previous data.
	// comparison done between previous root and and current root
	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = insert(root, data);
		}
		int height = getHeight(root);
		System.out.println(height);
	}

}
