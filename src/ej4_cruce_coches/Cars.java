/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4_cruce_coches;

/**
 *
 * @author dam203
 */
public class Cars {
	private int number;
    
	public Cars(int t) {
    	number = t;
	}
    
	public int getNumber() {
    	return number;
	}
    
	public synchronized void waiting(Cars t) {
    	System.out.format("Car " + number + " is waiting for Car " + t.getNumber() + "\n");
    	t.lane(this);
	}
    
	public synchronized void lane(Cars t) {
    	System.out.format("Car " + t.getNumber() + " is NOT waiting for " + number  + " anymore\n");
	}
}
