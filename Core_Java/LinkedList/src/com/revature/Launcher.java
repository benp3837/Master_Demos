package com.revature;

public class Launcher {

    public static void main(String[] args) {

        Node nodeA = new Node();
        nodeA.data = 4;

        Node nodeB = new Node();
        nodeB.data = 3;

        Node nodeC = new Node();
        nodeC.data = 7;

        Node nodeD = new Node();
        nodeD.data = 8;

        /**
         * Here we have instantiated the nodes but we haven't linked them...
         * we need to define each Node's "next" field, thus making each node point to its successor.
         */

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        // ======= Demo space for SinglyLinkedList.java =======
        LinkedList mylist = new LinkedList();
        mylist.insertNode(100);
        mylist.insertNode(50);
        mylist.insertNode(99);
        mylist.insertNode(88);
        mylist.insertLast(9999999);

        mylist.displayList();

    }

}
