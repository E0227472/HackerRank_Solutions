package com.datastructures;

import java.util.Scanner;

public class LastElementK {

    // node as part of the singly linked list
    static class Node {
        private int element;
        private Node next;

        Node(int element) {
            this.element = element;
        }
    }

    // starting node
    static Node head;

    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of elements to enter in the singly linked list: ");

        int n = scanner.nextInt();

        //enter the number of element inputs into the node
        for (int i = 0; i < n; i++) {
            append(scanner.nextInt());
        }

        System.out.println("Enter the element to be removed: ");

        int k = scanner.nextInt();

        removeNode(k);

        while (head != null) {
            System.out.println(head.element);
            head = head.next;
        }

    }

    // Appends a new node at the end
    public static void append(int new_data) {
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        Node new_node = new Node(new_data);

    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (head == null) {
            head = new Node(new_data);
            return;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }

    public static void removeNode(int k) {
        Node current = head;
        Node follow = head;
        Node prev = null;
        int countCurrent = 0;
        int countFollow = 0;

        while (current != null) {
            // if current is equal to k, move follow pointer to k.
            if (current.element == k) {
                while (countFollow < countCurrent) {

                    prev = follow;
                    // at end of loop, this will be node containing k
                    follow = follow.next;

                    System.out.println(prev.element + " prev");
                    System.out.println(follow.element + " follow");
                    countFollow++;
                } // end inner while loop
            } // end if loop

            countCurrent++;
            current = current.next;
        } // end outer while loop


        // when current pointer has completed loop, follow points to last k
        System.out.println(prev.element + " outside loop prev");
        System.out.println(follow.element + " outside loop follow");
        prev.next = follow.next;
    }
}
