// Largest prime factor
// Problem 3
//    The prime factors of 13195 are 5, 7, 13 and 29.
//
// What is the largest prime factor of the number 600851475143 ?
//
// 

import java.util.*;

class Euler003b {

    public static void main(String[] args){
	long target = 600851475143L;

	long val = 3;
	Set<Long> primes = new HashSet<Long>();
	primes.add(2L);
	
	while (val < Math.sqrt(target)) {
	    boolean isPrime = true;
	    
	    for( long k : primes) {
		if (val % k == 0) {
		    if (isPrime) {
			val += 2;
		    }
		    isPrime = false;
		}
	    }
	    if (isPrime) {
		primes.add(val);
		if (target % val == 0)  {
		    System.out.println("factor: " + val);
		    target /= val;
		}
	    }
	}

	System.out.println("largest factor: " + target);
    }

}
