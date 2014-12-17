//
// Sum square difference
// Problem 6
// The sum of the squares of the first ten natural numbers is,
//      1^2 + 2^2 + ... + 10^2 = 385
//
// The square of the sum of the first ten natural numbers is,
//      (1 + 2 + ... + 10)^2 = 552 = 3025
// Hence the difference between the sum of the squares of the first
// ten natural numbers and the square of the sum is 3025 − 385 = 2640.
//
// Find the difference between the sum of the squares of the first one
// hundred natural numbers and the square of the sum.


import java.util.*;

class Euler006 {

    public static void main(String[] args){
	
	int b = (101*100)/2;
	int b2 = b*b;
	int a2 = 0;

	for(int ii = 1; ii <= 100; ii++) {
	    a2 += ii*ii;
	}
	int diff = b2 - a2;
	System.out.println("Diff between " + b2 + " - " + a2 + " = " + diff);
    }

}
