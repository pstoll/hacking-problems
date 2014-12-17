// Largest prime factor
// Problem 3
//    The prime factors of 13195 are 5, 7, 13 and 29.
//
// What is the largest prime factor of the number 600851475143 ?
//
// 

// oops - unnecessary.
// didn't check how java long is 8 bytes/64 bits, which is plenty.
// went to BigInteger too fast
// see prob003a for the long int version.
import java.math.BigInteger;

class Euler003 {

    public static void main(String[] args){
	BigInteger target = new BigInteger("600851475143");
	BigInteger ii = BigInteger.ONE;
	BigInteger largest = BigInteger.ZERO;
	BigInteger prod = BigInteger.ONE;
	
	while (prod.compareTo(target) == -1 && ii.compareTo(target) == -1 ) {
	    if (target.mod(ii).compareTo(BigInteger.ZERO) == 0) {
		System.out.print(ii.toString() +  " * ");
		largest = ii;
		prod = prod.multiply(ii);
	    }
	    ii = ii.add(BigInteger.ONE);
	}
	System.out.println("\nlargest factor: " + largest.toString());
    }

}
