
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
	int[][] state;
    }
    
    public static void dump_state(int[][] s) {
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
    
    public static int clamp(int v1, int vmin, int vmax) {
	if (v1 < vmin) return vmin;
	if (v1 > vmax) return vmax;
	return v1;
    }

    public static String backtrack_state(String s1, String s2, DPResult r) {
	int max_i = s1.length() - 1;
	int max_j = s2.length() - 1;
	int i = max_i;
	int j = max_j;
	StringBuffer buf = new StringBuffer();

	while (i > 0 || j > 0) {
	    System.out.println("(i,j) = " + i + "," + j);
	    int next_i = clamp(i - 1, 0, max_i);
	    int next_j = clamp(j - 1, 0, max_j);
	    System.out.println( "(next_i,nextj) = " + next_i + "," + next_j );
	    if (r.state[i][j] == r.state[next_i][j] && i > 0) {
		System.out.println("going up");
		i = next_i;
	    } else if (r.state[i][j] == r.state[i][next_j]  && j > 0) { 
		System.out.println("going left");
		j = next_j;
	    } else {
		System.out.println("appending char at ("+i+","+j+") " + s1.charAt(i));
		buf.append( s1.charAt(i) );
		i--;
		j--;
	    }
	    System.out.println("(i,j) = " + i + "," + j + "\n");
	}

	return buf.reverse().toString();
    }

    public static DPResult compute_lcs(DPInput in) {
	return compute_lcs(in.s1, in.s2);
    }

    public static DPResult compute_lcs(String s1, String s2) {
	int yy = s1.length();
	int xx = s2.length();

	int[][] state = new int[yy][xx];
	for ( int ii = 0; ii < yy; ii++) {
	    for (int jj=0; jj < xx; jj++) {
		if (s1.charAt(ii) != s2.charAt(jj)) {
		    // handle boundary conditions.
		    int v1 = (ii == 0) ? 0 : state[ii-1][jj];
		    int v2 = (jj == 0) ? 0 : state[ii][jj-1];
		    int new_val = Math.max(v1,v2);
		    state[ii][jj] = new_val;
		} 
		if (s1.charAt(ii) == s2.charAt(jj)) {
		    // again, handle boundary conditions
		    int prev_val = (ii < 1 || jj < 1)? 0: state[ii-1][jj-1];
		    state[ii][jj] = 1 + prev_val;
		}
	    }
	    dump_state(state);
	}

	DPResult res = new DPResult();
	res.state = state;
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
	    int y = res.state.length-1;
	    int x = res.state[0].length - 1;
	    int len = res.state[y][x];
	    System.out.println("length of longest common substring: " + len);
	    String m = backtrack_state(in.s1, in.s2, res);
	    System.out.println("match: " + m);
	}
    }

}
