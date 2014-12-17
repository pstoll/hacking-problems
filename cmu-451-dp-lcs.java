
// solutions to sections in here:
// http://www.cs.cmu.edu/~avrim/451f09/lectures/lect1001.pdf
//
// compile as: 
//  javac cmu-451-dp-lcs.java
// sample runs:
//  java CMU_451_DP_LCS alpha alpalkjdfkalphalkjdkfjd
class CMU_451_DP_LCS {


    static public class DPInput {
	String s1;
	String s2;
    }

    static public class DPResult {
	int x;
	int y;
	int[][] state;
    }
    
    public static DPResult compute_lcs(DPInput in) {
	return compute_lcs(in.s1, in.s2);
    }

    public static void dump_lcs_state(int[][] s) {
	int yy = s.length;
	int xx = s[0].length;
	System.out.println("y,x: : " + yy + "," + xx);
	for (int ii = 0; ii < yy; ii++) {
	    for(int jj = 0; jj < xx; jj++) {
		System.out.print(" " + s[ii][jj]);
	    }
	    System.out.println("");
	}
    }

    public static DPResult compute_lcs(String s1, String s2) {
	int yy = s1.length();
	int xx = s2.length();

	int[][] state = new int[yy][xx];
	for ( int ii = 0; ii < yy; ii++) {
	    for (int jj=0; jj<xx; jj++) {
		if (s1.charAt(ii) != s2.charAt(jj)) {
		    int v1 = (ii == 0) ? 0 : state[ii-1][jj];
		    int v2 = (jj == 0) ? 0 : state[ii][jj-1];
		    int new_val = Math.max(v1,v2);
		    state[ii][jj] = new_val;
		} 
		if (s1.charAt(ii) == s2.charAt(jj)) {
		    int prev_val = (ii < 1 || jj < 1)? 0: state[ii-1][jj-1];
		    state[ii][jj] = 1 + prev_val;
		}
	    }
	    dump_lcs_state(state);
	}

	DPResult res = new DPResult();
	res.state = state;
	res.x = xx;
	res.y = yy;
	return res;
    }

    public static void  main(String[] args) {

	if (args.length < 2) {
	    System.err.println("expected 2 input strings to match");
	    System.exit(1);
	}

 	DPInput in = new DPInput();
	in.s1 = args[0];
	in.s2 = args[1];

	DPResult res = compute_lcs(in);
	if (null != res) {
	    int len = res.state[res.y-1][res.x-1];
	    System.out.println("length of longest common substring: " + len);
	}
    }

}
