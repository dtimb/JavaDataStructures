/**
 * COSC 310 Assignment 7 Heaps
 * Astro.java
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
 * this file, Astro.java, helps accomplish this goal through
 * name, xCoord, yCoord, distance paramaters as well as compareTo
 * which returns the distance between objects in the heap.
 */

public class Astro implements Comparable <Astro>{
	private String name;	 // name of astronomical objects
	private int  xCoord,	 // x coord of astronomical object	
		 		 yCoord;	 // y coord of astronomical object
	private double distance; // distance of astronomical object

	public Astro(String name, int xCoord, int yCoord, double distance) {
		super();
		this.name = name;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.distance = distance;
	}

	// getters
	 // get name
	public String getName() {
		return name;
	}

	 // get xCoord
	public int getxCoord() {
		return xCoord;
	}

	 // get yCoord
	public int getyCoord() {
		return yCoord;
	}
	
	 // get distance
	public double getDistance() {
		return distance;
	}
	
	@Override
    // Compare to function for distance
    public int compareTo( Astro other ) {
        if (this.distance < other.distance) {
            return -1;
        } else if (this.distance > other.distance) {
            return 1;
        } else {
            return 0;
        }
	}
	
    @Override
    // formatted toString method (not used in program but used in testing for general csv output)
    public String toString() {
        return String.format("%-9s %-4s %-4s %0.2f", name, xCoord, yCoord, distance);
    }
}