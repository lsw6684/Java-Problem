import java.util.Scanner;

public class Main {
	
	// 사용자 정의 함수. 자바에서 함수 = 메소드.
	// public static "int" 반환 값을 써야함.
	public static int function(int a, int b, int c) {
		int min;
		if(a>b)
		{
			if(b>c)	min = c;
			else min = b;
		}
		else
		{
			if(a>c)	min = c;
			else min = b;
		}
		for(int i = min; i>0; i--)
		{
			if(a%i==0&&b%i==0&&c%i==0)	return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("정수 3개 넣어라.");
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(function(a,b,c));
	}

}
