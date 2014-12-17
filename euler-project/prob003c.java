// Largest prime factor
// Problem 3
//    The prime factors of 13195 are 5, 7, 13 and 29.
//
// What is the largest prime factor of the number 600851475143 ?
//
// 

import java.util.BitSet;

class Euler003c {

    public static void main(String[] args){
	long target = 600851475143L;
	
	// ugh, this is ugly. relies on needing only an int worth of bits
	// because BitSet only accepts int arguments. 
	// we kinda get lucky here because sqrt of target == 775146.1
	int n = (int)Math.sqrt(target) + 1;

	BitSet primes = new BitSet(n);
	primes.set(0, n, true);
	for( int i = 2; i < n; i += 2) {
	    primes.set(i, false);
	}
	for( int i = 3; i < n; i +=2) {
	    for( int a = i + i; a < n; a += i) {
		primes.set(a, false);
	    }
	}
	
	int largest = 0;
	for( int ii = 2 ;  ii <= n; ii += 1) {
	    if (primes.get(ii) && (target % ii == 0) ) {
		System.out.println("factor: " + ii);
		largest = ii;
	    }
	}

	System.out.println("largest factor: " + largest);
    }

}
