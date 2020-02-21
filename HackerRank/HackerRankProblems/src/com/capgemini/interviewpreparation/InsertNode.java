package com.capgemini.interviewpreparation;

import java.io.IOException;
import java.util.Scanner;

public class InsertNode {
	// Node object that takes in int data through constructor parameters.
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
		}
		
	
		
	}

	//
	static class SinglyLinkedList {
		public SinglyLinkedListNode head; // first node
		public SinglyLinkedListNode tail; // last node

		public SinglyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
			// if first node is null, place it as head.
			if (this.head == null) {
				this.head = node;
			} else { // if last node is null, place it as tail
				this.tail.next = node;
			}

			this.tail = node;
		}
	}

	public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
		while (node != null) {
			System.out.println(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				System.out.println(sep);
			}
		}
	}

	// Complete the insertNodeAtPosition function below.

	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode { int data; SinglyLinkedListNode next; }
	 *
	 */
	static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
		SinglyLinkedListNode node = new SinglyLinkedListNode(data);
		SinglyLinkedListNode prev = null;
		SinglyLinkedListNode current = head;
		
		int i = 0; 
		while(current != null && i < position) {
			prev = current;
			current = current.next;
			i++;
		}
		
		node.next = prev.next;
		prev.next = node;
		
		return head;
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the number of elements"); // insert print line comments here

		SinglyLinkedList llist = new SinglyLinkedList();
		
		int llistCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("enter the elements");
		// this section inserts data into the list 
		for (int i = 0; i < llistCount; i++) {
			int llistItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			llist.insertNode(llistItem);
		}
		System.out.println("Enter the data");
		// data to be inserted at said position
		int data = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		System.out.println("enter the position");
		// position in which data is to be inserted
		int position = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);

		printSinglyLinkedList(llist_head, " ");
		scanner.close();
	}

}
