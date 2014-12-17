// Largest prime factor
// Problem 3
//    The prime factors of 13195 are 5, 7, 13 and 29.
//
// What is the largest prime factor of the number 600851475143 ?
//
// 

class Euler003a {

    public static void main(String[] args){
	long target = 600851475143L;
	long ii;
	long largest = 0;
	long sum = 1;

	long maxtarget = (long)Math.sqrt(target);
	for( ii = 1 ;  sum < target && ii <= maxtarget; ii += 1) {
	    if (target % ii == 0) {
		System.out.println("factor: " + ii);
		largest = ii;
		sum *= ii;
	    }
	}

	System.out.println("largest factor: " + largest);
    }

}
