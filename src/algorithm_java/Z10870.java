import java.util.Scanner;

public class Z10870 {
 
	static int n = 0;
	
	final static int fiboSum = 0;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		System.out.println(fibo(n));
		scan.close();
		
	}
	
	public static int fibo(int index){
				
		if(index == 0){
			return 0;
		} else if(index == 1){
			return 1;
		} else {
			return fibo(index-1) + fibo(index-2);
		}
				
	}
}