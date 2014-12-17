//
// Multiples of 3 and 5
// Problem 1
//
//    If we list all the natural numbers below 10 that are multiples
//    of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is
//    23.
//
//
// Find the sum of all the multiples of 3 or 5 below 1000

class Euler001 {

    public static void main(String[] args) {
	int ii = 0;
	long sum = 0;
	boolean done = false;

	for(ii = 1; ii < 1000; ii++) {
	    // don't double count multlples of both 3 and 5
	    if (ii % 3 == 0) {
		sum += ii;
	    } else if (ii % 5 == 0){ 
		sum += ii;
	    }
	}
	System.out.println("Sum is: " + sum + " after " + ii + " loops");

    }

}