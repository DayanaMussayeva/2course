import java.io.IOException;
import java.util.*; 
import java.math.*; 

public class aaaa { 

static int n; 
static List<Integer> [] g; 
static int [] dist,p; 
static List<Integer> cycle; 

public static void main(String[] args) throws IOException { 
Scanner sc = new Scanner(System.in); 

n = sc.nextInt(); 
g = new List[n]; 
for(int i=0; i<n; i++) 
g[i] = new ArrayList<>(); 

for(int i=0; i<n; i++) { 
int a,b; 
a = sc.nextInt() - 1; 
b = sc.nextInt() - 1; 

g[a].add(b); 
g[b].add(a); 
} 

cycle = new ArrayList<>(); 
p = new int[n]; 
dist = new int[n]; 

dist[0] = 1; 
p[0] = 0; 
dfs(0); 

Queue<Integer> q = new LinkedList<>(); 
Arrays.fill(dist, -1); 

for(int u : cycle) { 
dist[u] = 0; 
q.add(u); 
} 

while(!q.isEmpty()) { 
int u = q.remove(); 

for(int v : g[u]) { 
if(dist[v]==-1) { 
dist[v] = dist[u]+1; 
q.add(v); 
} 
} 
} 
String Budd = ""; 
Budd += dist[0]; 
for(int i=1; i<n; i++) 
Budd += " " + dist[i]; 

System.out.println(Budd); 
} 

static void dfs(int u) { 
for(int v : g[u]) { 
if(dist[v]==0) { 
dist[v] = 1; 
p[v] = u; 
dfs(v); 
} else if(cycle.isEmpty() && v != p[u]) { 
while(u != v) { 
cycle.add(u); 
if(u==p[u]) break; 
u = p[u]; 
} 
cycle.add(v); 
} 
} 
} 
}