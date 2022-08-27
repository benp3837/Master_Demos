package com.revature;

//LinkedLists are made of nodes, which are objects holding some kind of data.
//So before we can make our LinkedList, we need to make a Node Class.
public class Node {

    int data; //each element in this LinkedList will be an int

    public Node next; //represents the neighboring node
    //remember, each node is only aware of its predecessor

    //a method that prints out the value of the Node's data field
    public void displayNode(){
        System.out.println("{"+ data + "}");
    }

}
