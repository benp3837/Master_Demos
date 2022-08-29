package com.revature;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("===============================(LinkedList)");

        //instantiate three nodes to add to our LinkedList.
        Node nodeA = new Node();
        nodeA.data = 4;

        Node nodeB = new Node();
        nodeB.data = 3;

        Node nodeC = new Node();
        nodeC.data = 7;

        //Here we have instantiated the nodes but we haven't linked them...
        //we need to define each Node's "next" field, thus making each node point to its successor.
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        //nodeC.next will remain null, since it's the last node as HAS no next node.

        //Create a LinkedList, add some values, display those values
        LinkedList mylist = new LinkedList();
        mylist.insertNode(100);
        mylist.insertNode(50);
        mylist.insertNode(99);
        mylist.insertNode(88); //what order will these print in?
        mylist.insertLast(9999999); //this one will of course be last.

        mylist.displayList();

        System.out.println("=============================(ArrayList)");

    }

}
