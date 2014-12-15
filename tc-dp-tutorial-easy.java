//
// Coded up solution to http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=dynProg
// 
// Given a list of N coins, their values (V1, V2, ... , VN), and the
// total sum S. Find the minimum number of coins the sum of which is S
// (we can use as many coins of one type as we want), or report that
// it's not possible to select coins in such a way that they sum up to
// S.
//
// by Perry A. Stoll
// public domain
// 
// compile: javac  tc-dp-tutorial-easy.java
// run java java HelloDPWorld 4 2 3

import java.util.Arrays;

class TC_Tutorial_DP_Easy {
    
    static int _VERBOSE = 1;

    public static class DPResult {
	int[] counts;
	int[] values;
    }
    
    public static class DPInput {
	int targetSum;
	int[] coins;
    }
    
    static int _FLAG = java.lang.Integer.MAX_VALUE;

    public static DPResult solve_coins(DPInput in) {
	return solve_coins(in.targetSum, in.coins);
    }

    public static void dump_array(int[] a, String s) {
	System.out.print("array " + s + ":");
	for( int i: a) {
	    System.out.print(i + ",");
	}
	System.out.println("");
    }

    public static DPResult solve_coins(int sum, int[] coins) {
	if (sum == 0) return null;
	if (coins.length == 0) return null;

	DPResult res = new DPResult();

	res.counts = new int[sum+1];
	Arrays.fill(res.counts, _FLAG);

	res.values = new int[sum+1];
	Arrays.fill(res.values, 0);

	res.counts[0] = 0;
	for (int curSum = 0; curSum <= sum; curSum++) {
	    for (int curCoin = 0; curCoin < coins.length; curCoin++ ){
		int coinValue = coins[curCoin];
		if (coinValue <= curSum && res.counts[curSum - coinValue] == _FLAG) {
		    System.out.println("previous value not possible @ " + curSum + "/" + curCoin);
		}
		if (coinValue <= curSum) {
		    int prev_count = res.counts[curSum - coinValue];
		    // look at count of coins before this coin, see if that count is less then current count
		    // but only allow valid previous counts, i.e. not _FLAG value.
		    // this was necessary if there is no 1 coin option
		    if ((prev_count != _FLAG) && (prev_count + 1 < res.counts[curSum])) {
			res.counts[curSum] = res.counts[curSum - coinValue] + 1;
			res.values[curSum] = coinValue;
		    }
		}
		if (_VERBOSE > 1) {
		    dump_array(res.counts,"counts_ " + curSum + "/" + curCoin);
		    dump_array(res.values,"values_"  + curSum + "/" + curCoin);
		    System.out.println("");
		}
	    }
	}

	if (res.counts[sum] == java.lang.Integer.MAX_VALUE) {
	    System.out.println("no solution found");
	    res = null;
	    return null;
	}
	return res;
    }

    public static void print_results(DPResult res) {
	if (res == null) return;
	
	int targetSum = res.counts.length - 1;
	System.out.println("Solution N Coins: " + res.counts[targetSum]);

	int ii = targetSum;
	int offset;
	do {
	        System.out.println("\tCoin: value "  + res.values[ii]
				   + " counts: " + res.counts[ii]
				   + " value sum: "  + ii);
		offset =  res.values[ii];
		ii -= offset;
	} while (offset > 0 && ii >= 1);

    }

    public static DPInput parse_args( String[] args) {

	if (args.length < 2) {
	    System.err.println("not enough arguments");
	    //System.exit(1);
	    return null;
	}

	DPInput in = new DPInput();

	int arg_offset = 0;
	in.targetSum = Integer.parseInt( args[arg_offset] );

	arg_offset=1;
	in.coins = new int[args.length - arg_offset];
	for ( int ii = 0; ii < args.length - 1; ii++) {
	    int val = Integer.parseInt(args[ii+arg_offset]);
	    if (val == 0) {
		System.err.println("zero value coin not allowed");
		return null;
	    }
	    in.coins[ii] = val;
	}

	System.out.println("Target sum: " + in.targetSum);
	for(int ii = 0; ii < in.coins.length; ii++) {
	    System.out.println("\tcoin value[" + ii + "]=" + in.coins[ii]);
	}
	return in;
    }

    public static void main(String[] args) {
        System.out.println("Hello DP World!"); // Display the string.
	
	DPInput in = parse_args(args);
	if (in == null ) {
	    System.exit(1);
	}
	DPResult r = solve_coins(in);
	if (null != r) {
	    print_results(r);
	}
	
    }
}

