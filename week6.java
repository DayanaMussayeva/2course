import java.util.*;

public class week6
{
   	private static ArrayList<Integer>[] g;
   	private static ArrayList<Integer> r1, r2;
   	private static int n, m;	
   	private static int[] u, x, y;

   	public static void dfs(int v, int p) {
   		u[v] = p;
   		for (int to:g[v]) {
   			if (u[to]==0) dfs(to, (p==1)?(2):(1));
   		}
   	}

    public static void main(String args[])
    {
    	Scanner in = new Scanner(System.in);
    	n = in.nextInt();
    	m = in.nextInt();
    	g = new ArrayList[n];
    	u = new int[n];
    	x = new int[m];
    	y = new int[m];
    	Arrays.fill(u, 0);
		for (int i=0; i<n; i++) g[i] = new ArrayList<Integer>();
		for (int i=0; i<m; i++) {
			x[i] = in.nextInt(); y[i] = in.nextInt();
			x[i]--; 
			y[i]--;
			g[x[i]].add(y[i]);
			g[y[i]].add(x[i]);
		}
		for (int i=0; i<n; i++)
			if (u[i]==0)
				dfs(i, 1);
		r1 = new ArrayList<Integer>();
		r2 = new ArrayList<Integer>();
	  	for (int i=0; i<m; i++) {
	  		if (u[x[i]] == u[y[i]]) {
	  			System.out.printf("-1");
	  			System.exit(0);
	  		}			
	  	}
	  	for (int i=0; i<n; i++)
	  		if (u[i] == 1) r1.add(i+1); else r2.add(i+1);
		System.out.println(r1.size());
		for (int i:r1) System.out.printf("%d ", i);
		System.out.printf("\n");
		System.out.println(r2.size());
		for (int i:r2) System.out.printf("%d ", i);
    }
}