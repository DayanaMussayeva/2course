import java.util.*;
public class week5{
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		if (y > 2 * k|| (x > 2 && y == 1)) {
			System.out.println("-1");
		} else{
			for (int i = 1; i <= k; i++) {
				System.out.println(i + " " + (i + 1));
			}
			for (int i = k+1; i<=y; i++){
				if (i ==k+1)
					System.out.println( "1"+ " " + (i+1));
				else 
					System.out.println(i + " " + (i+1));

			}
		}
 
			for (int i = y + 1; i < x; i++) {
				if (k == y)
					System.out.println("2" + " " + (i+1));
				else 
					System.out.println("1" + " " + (i+1));
			}
		}
	}