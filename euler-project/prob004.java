//
// Largest palindrome product
// Problem 4
//
// A palindromic number reads the same both ways. The largest
// palindrome made from the product of two 2-digit numbers is 9009 =
// 91 × 99.
//
// Find the largest palindrome made from the product of two 3-digit numbers.
// code by Perry A Stoll

import java.util.*;

class Euler004 {

    public static boolean is_palindrome(String s) {
	int i = 0;
	int j = s.length() - 1;
	boolean matches = true;
	while (matches &&  i <= j) {
	    matches = s.charAt(i) == s.charAt(j);
	    i += 1;
	    j -= 1;
	}
	return matches;
    }

    public static void test_palindromes() {
	Set<String> strings = new HashSet<String>();
	strings.add("string");
	strings.add("9009");
	strings.add("able was i ere i saw elba");
	strings.add("90009");
	for (String s: strings) {
	    System.out.println("is_palindrome(" + s + "): " + is_palindrome(s) );
	}
    }
    
    public static void main(String[] args){
	test_palindromes();

	int max_prod = 1;
	int imax = 0, jmax = 0;
	for(int i = 999; i > 1; i--) {
	    for( int j = 999; j > 1; j--) {
		int prod = i*j;
		if ( is_palindrome(Integer.toString(prod))) {
		    if (prod > max_prod) {
			System.out.println("found new prod " + prod);
			max_prod = prod;
			imax = i; jmax = j;
			System.out.println("factors were: " + imax + "," + jmax + "\n");
		    }
		}
	    }
	}
	System.out.println("max prod is: " + max_prod);
	System.out.println("factors were: " + imax + "," + jmax);
    }

}
