public class Main {
	
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	public static int function(int a, int b, int c) {
		int result = max(a,b);
		result = max(result, c);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(function(123, 32, 2344));
	}

}
