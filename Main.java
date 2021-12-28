package com.company;

import java.util.ArrayList;

//array list can use index, and such, java will allocate 4 bytes of memory, 4 bytes in each address, 8 bytes, strings
//strings will work different, memory allocated will point to different addresses, looking at the string java will calculae teh adddress
//java garbage collection will go behind the scene and free up memory
public class Main {

    public static void main(String[] args) {
	// write your code here
        Customer customer = new Customer("Abdulla" , 54.96);
        Customer anotherCustomer = customer;
        anotherCustomer.setBalance(12.18);
        System.out.println("balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i = 0; i < intList.size(); i++) {
            System.out.println(i +":" + intList.get(i));
        }
        intList.add(1, 2); //we store the value at index 1, but in array containing thousands of things, to add things at certain element, and to remove an item we have to m
        //manipulate it and everything has to move up when removing
        //in linked list, it store the pointer to the next element, as well as teh value to store, one value will point to another, and we can iterate, thru it
        //we can see if it links, and we cna grab teh string and iterate through the item to find it. java garbage collection will remove it automatically
        for(int i = 0; i < intList.size(); i++) {
            System.out.println(i +":" + intList.get(i));
        }
    }
}
