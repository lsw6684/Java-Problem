import java.util.Scanner;

public class Main
{
	public static int max(int a, int b)
	{
		return a>b?a:b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("생성할 배열의 크기 : ");
		int number = sc.nextInt();
		int[] array = new int[number];
		
		for(int i = 0 ; i < number; i++)
		{
			System.out.println("배열에 넣은 정수(양수) 입력 : ");
			array[i] = sc.nextInt();
		}
		int result = -1;
		for(int i = 0 ; i < number; i++)
		{
			result = max(result, array[i]);
		}
		System.out.println("입력한 정수 중에서 가장 큰 것은 : " + result);
	}
}