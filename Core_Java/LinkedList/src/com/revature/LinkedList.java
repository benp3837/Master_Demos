package com.revature;

//A LinkedList is a data structure for storing a collection of items that we can traverse front to back.
//One benefit of LinkedLists over Arrays is that they are dynamically sized - the size can change.
public class LinkedList {

    private Node first; //a reference to the first Node in the Linked List. Starts null.
    private Node last; //the last node will always be null, and this is how we can find the end of the LL

    //method that returns true if the first element is null
    public boolean isEmpty(){
        return (first == null);
    }

    //method to insert at the beginning of the LL (shifting a previously inserted first to a higher index)
    public void insertNode(int data){
        Node newNode = new Node(); //create a new Node...
        newNode.data = data; //...and fill it with the user inputted data.
        newNode.next = first;
        first = newNode; //we are inserting at the head...
        //...and replacing the head with the new Node we're inserting
        //so the newNode becomes the new "first"
    }

    //method to delete the first element in the LL
    public Node deleteFirst(){
        Node temp = first; //temporary node holds the 1st node.
        first = first.next; //the 1st node now == the 2nd node,
        return temp; //shifting the 2nd in line to the head
    }

    //method that iterates through the LinkedList and displays node
    //recall the displayNode() method from the Node Class
    public void displayList(){
        System.out.println("LinkedList: ");

        Node current = first; //temporary node holding the first element of the LL

        //once current == null, we know we're at the end of the LL so the while loop breaks
        while(current != null){
            current.displayNode(); //remember this method prints the data value of the Node
            current = current.next; //move the current Node to the next Node in the LL
        }
        //System.out.println();
    }

    /**
     *  Note: this is NOT efficient! We have to traverse an entire list of
     *  nodes just to insert something at the end. Solution to this would be
     *  a CircularLinkedList or a DoublyLinkedList.
     */


    //Maybe just paste this in for them
    //Method to insert at the end of the LL Note: this is NOT efficient! We have to traverse an entire LL
    //just to insert something at the end.
    //one solution to this would be a DoublyLinkedList.
    public void insertLast(int data){

        Node current = this.first;
        while(current.next != null){
            current = current.next; // we'll loop until current.next is null
        }

        Node newNode = new Node();
        newNode.data = data; // add the passed through data to a new Node
        current.next = newNode; // make the 2nd to last node = new Node.
    }

}
