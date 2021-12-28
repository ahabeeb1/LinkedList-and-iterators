package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInorder(placesToVisit, "Sydney");
        addInorder(placesToVisit, "Melborne");
        addInorder(placesToVisit, "Brisbane");
        addInorder(placesToVisit, "Perth");
        addInorder(placesToVisit, "Canberra");
        addInorder(placesToVisit, "Adelaide");
        addInorder(placesToVisit, "Darwin");
        printList(placesToVisit);

        addInorder(placesToVisit, "Alice Springs");
        printList(placesToVisit);
        visit(placesToVisit);
//        placesToVisit.add("Sydney");
//        placesToVisit.add("melborne");
//        placesToVisit.add("brisbon");
//        placesToVisit.add("Atl");
//        placesToVisit.add("NYC");
//
//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Alice Springs"); //insert a new record
//        printList(placesToVisit);//this happens automatically
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);
    }
    private static void printList(LinkedList<String> linkedList) {
        //iterator
        Iterator<String> i = linkedList.iterator(); //equivalent to a for loop
        while(i.hasNext()){ //changes the value of the iterator, such as i++
            System.out.println("Now Visiting " + i.next()); //moves on to the next record as well, returns the next value
        }
        System.out.println("=======================");
    }
    private static boolean addInorder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);//this will give a number, if it is 0, that means the values match
            //we ned to use.next to point to the next entry
            if(comparison == 0) {
                //equals, do not add
                System.out.println(newCity + " is already included as a destination");
            } else if(comparison > 0) {
                //new city should appear before this one
                //Brisbane - > adelane, so since we used next, we need to move back
                stringListIterator.previous(); //go back to the record before this one, list iterator allows this function
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0) {
                //move on to the next city, therefore we do not do anything
            }

        }
        stringListIterator.add(newCity);
        return true; //return and modifying, so we should not do it this way
        //this method will sort
    }
    private static void visit(LinkedList cities) {
        Scanner sc = new Scanner(System.in);
        boolean quit =false;
        boolean goingForward = true;
        ListIterator stringListIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No Cities in the Itinerary");
            return;
        } else {
            System.out.println("Now visiting " + stringListIterator.next());
            printMenu();
        }
        while(!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday over");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward) {
                        if(stringListIterator.hasNext()) {
                            stringListIterator.next();
                        }
                        goingForward = true;
                    }
                    if(stringListIterator.hasNext()) {
                        System.out.println("Now visiting " + stringListIterator.next());
                    } else {
                        System.out.println("Reached teh end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) { //controlling the state
                        if(stringListIterator.hasPrevious()) {
                            stringListIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(stringListIterator.hasPrevious()) {
                        System.out.println("Now Visiting " + stringListIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }

    }
    private static void printMenu() {
        System.out.println("Available Actions: \n press" );
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }
}
