public class Main {
	public static int factorial(int number)
	{
		if(number == 1)
			return number;
		else
			return number * factorial(number-1);
	}
	
	public static void main(String[] args) {
		System.out.println("factorial of 10 is " + factorial(10));
	}
}