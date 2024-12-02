/**
 * COSC 310 Assignment 7 Heaps
 * Prog7.java
 * 
 * @author Dylan Timbrook
 * 
 * takes user input for x and y coordinates as well as k.
 * the output takes the nearest objects in a heap calculated using
 * the entered x and y inputs and a separate distance variable.
 * 
 * the objects, their coordinates are obtained through a
 * comma separated value (csv) file.
 * 
 * this file, Prog7.java, uses class Astro.java to accomplish this goal.
 */

import java.io.*;
import java.util.*;

public class Prog7
{
	public static void main(String[] args) {
		// init
		 // create astro heap
		Heap<Astro> heap =  new Heap<Astro>(50); 
		
		 // var initialization
		int  x,			// x coordinate of point in space
		xCoord,			// x coordinate within astro heap
			 y,			// y coordinate of point in space
		yCoord,			// y coordinate within astro heap
			 k;			// number of objects desired
		double distance; 	// distance between object objects in space 
		String name;	// name of astronomical objects
		
		 // initialize scanners
		Scanner inFile = null;
		Scanner input = new Scanner(System.in);
		
		// take user input for coordinates x and y, as well as the number of objects printed in the output
		System.out.print("Enter desired x-coordinate: ");
        x = input.nextInt(); // take user input for x coordinate
        
        System.out.print("Enter desired y-coordinate: ");
        y = input.nextInt(); // take user input for y coordinate
        
        System.out.print("Enter number of desired objects: ");
        k = input.nextInt(); // take user input for desired objects
        
		
        // find astro.txt csv file
		try {
			inFile = new Scanner(new File("astro.txt"));
		} catch (FileNotFoundException e) { // error handling
			System.out.println("Error: File not found");
			System.exit(1);
		}
		
		// insert contents of csv into heap for each line in file
		while (inFile.hasNext()) {
			String record = inFile.nextLine();
			String[] tokens = record.split(",[ ]*");
			
			// put csv values into respective tokens to be entered into heap
			name = tokens[0];
			xCoord = Integer.parseInt(tokens[1].trim());
			yCoord = Integer.parseInt(tokens[2].trim());
			distance = Math.sqrt(Math.pow((xCoord - x), 2) + Math.pow((yCoord - y), 2)); // gets distance using formula
			
			Astro astro = new Astro(name, xCoord, yCoord, distance); // astro object
			heap.enqueue(astro); // insert astro object into heap
		}
		
		inFile.close(); // close inFile scanner
		input.close(); // close input scanner
		
		// print header listing user inputs as well as column headings
		System.out.printf("\n%d closest objects to (%d, %d)\n\n", k, x, y);
		System.out.printf("%-14s %-4s %-4s %s\n", "Name", " x", " y", "Distance");
		System.out.printf("%-14s %-4s %-4s %s\n", "-----------", "---", "---", "--------");
        
		// print name, x, y, and distance of nearest objects in space to entered coordinates
		try {
            for (int i = 0; i < k; i++) {
                Astro astro = heap.dequeue();
                System.out.printf("%-14s %-4d %-4d %8.2f \n", 
                		astro.getName(), astro.getxCoord(), 
                		astro.getyCoord(), astro.getDistance());
            } 
        // error handling for null value
        } catch (NullPointerException e) {
            System.exit(1);
        }
	}
}