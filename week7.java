import java.io.*;
import java.util.*;

public class week7 {
	static class Edge {
		int a, i, u, v;
		Edge(int a, int i) {
			this.a = a;
			this.i = i;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Edge[] ee = new Edge[m];
		Edge[] ff = new Edge[n - 1];
		Edge[] gg = new Edge[m - n + 1];
		int f = 0, g = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Edge e = new Edge(a, i);
			ee[i] = e;
			if (b == 1)
				ff[f++] = e;
			else
				gg[g++] = e;
		}
		Arrays.sort(ff, (p, q) -> p.a - q.a);
		Arrays.sort(gg, (p, q) -> p.a - q.a);
		for (int i = 0; i < n - 1; i++) {
				ff[i].u = i + 1;
				ff[i].v = i + 2;
		}
		int u = 0, v = 2;
		for (int i = 0; i < m - n + 1; i++) {
			if (++u == v - 1) {
				v++;
				u = 1;
			}
			if (v > n || ff[v - 2].a > gg[i].a) {
				System.out.println(-1);
				return;
			}
			gg[i].u = u;
			gg[i].v = v;
		}
		PrintWriter pw = new PrintWriter(System.out);
		for (int i = 0; i < m; i++)
			pw.println(ee[i].u + " " + ee[i].v);
		pw.close();
	}
}