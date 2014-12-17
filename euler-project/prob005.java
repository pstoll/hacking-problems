//
// Smallest multiple
// Problem 5
//
// 2520 is the smallest number that can be divided by each of the
// numbers from 1 to 10 without any remainder.
//
// What is the smallest positive number that is evenly divisible by
// all of the numbers from 1 to 20?
//
// code by Perry A Stoll

import java.util.*;

class Euler005 {

    public static void main(String[] args){
	// lcm of numbers 1 through 20
	// 2, 3, 2, 5, 7, 2, 3, 11, 13, 2, 17, 19
	int num = 2 * 3 * 2 * 5 * 7 * 2 * 3 * 11 * 13 * 2 * 17 * 19;
	System.out.println("smallest is " + num);
	for(int ii = 2; ii <=20; ii++) {
	    int rem = num % ii;
	    System.out.println("num % " + ii + " = " + rem);
	}
    }

}
