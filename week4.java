import java.util.*; 
	public class week4 { 
		public static void main(String[] args) { 
			Scanner scan = new Scanner(System.in); 
			int s = scan.nextInt(); 
			int[] x = new int[s]; 
			int[] y = new int[s]; 

			for(int i=0;i<s;i++){ 
				x[i] = scan.nextInt(); 
				y[i] = scan.nextInt(); 
			} 
			boolean[] bool = new boolean[s]; 
			int answer = -1; 
			for(int i=0;i<s;i++){ 
				if(!bool[i]){ 
					ddd(x,y,bool, i); 
					answer++; 
				} 
 			} 
			System.out.println("DAyana" + answer); 
 		}		 
  		private static void ddd(int[] x, int[] y, boolean[] bool, int a) { 
        	bool[a] = true; 
			for(int i=0;i<x.length;i++){ 
				if( (x[i] == x[a] || y[i] == y[a]) && !bool[i]){ 
				ddd(x,y,bool,i); 
	  		} 
		} 
  	} 
}