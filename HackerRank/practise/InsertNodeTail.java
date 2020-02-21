package com.capgemini.practise;

import java.util.Scanner;

public class InsertNodeTail {

	// class to create a new node
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
	}

	// start of the linkedlist
	static class SinglyLinkedList {
		public SinglyLinkedListNode head;

		public SinglyLinkedList() {
			this.head = null;
		}

	}

	// method to print the elements in the linkedlist
	public static void printSinglyLinkedList(SinglyLinkedListNode node) {
		while (node != null) {
			System.out.println(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				System.out.println();
			}
		}
	}

	// method to insert nodes to head and return the head node.
	static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
	

		if (head == null) {
			return node;
		} else {
			SinglyLinkedListNode currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = node;
			return head;
		}
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// creation of the head object
		SinglyLinkedList llist = new SinglyLinkedList();
		System.out.println("Enter the list size: ");
		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		System.out.println("Enter the list elements: ");
		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, llistItem);

			llist.head = llist_head;
		}

		printSinglyLinkedList(llist.head);

		scanner.close();
	}

}
