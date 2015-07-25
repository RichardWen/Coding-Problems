package rWen;

public class Summer2015 {
	public static void printPrimeSums() 
	{
		for(int runner1 = 2; runner1 < 50; runner1++) {
			for(int runner2 = runner1; runner2 < 98; runner2++)
			{ 
				if(isPrime(runner1 + runner2) && isPrime(runner1) && isPrime(runner2)) 
				{
					System.out.println(runner1 + runner2);
				}
			}
		}	
	}
	public static void switchArrayContents(int[] arr1, int[] arr2) 
	{
		if(arr1.length % 2 != 0) {
		for(int i = 0; i < arr1.length/2 + 1; i++) 
			{
				int temp = arr1[i];
				arr1[i] = arr2[arr2.length - i - 1];
				arr2[arr2.length - i - 1] = arr1[arr1.length - i - 1];
				arr1[arr1.length - i - 1] = arr2[i];
				arr2[i] = temp;
			}
		}
		else {
			for(int i = 0; i < arr1.length/2; i++) 
			{
				int temp = arr1[i];
				arr1[i] = arr2[arr2.length - i - 1];
				arr2[arr2.length - i - 1] = arr1[arr1.length - i - 1];
				arr1[arr1.length - i - 1] = arr2[i];
				arr2[i] = temp;
			}
		}
	}
	public static void printArray(int[] input) 
	{
		for(int i = 0; i < input.length; i++) 
		{
			System.out.print(input[i]+ " ");
		}
	}
	public static boolean isPrime(int input) 
	{
		for(int i = 2; i < input/2 + 1; i++)
		{
			if(input%i == 0)
	 		{
				return false;
			}
		}	
		return true;
	}
	public static void FizzBuzz() {
		for(int i = 1; i < 101; i++) {
			if(i % 5 == 0 && i % 3 == 0) {
				System.out.println("FizzBuzz");
			}
			else if(i % 3 == 0) {
				System.out.println("Fizz");
			}
			else if(i % 5 == 0) {
				System.out.println("Buzz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	public static String reverseString(String input) 
	{
		String res = "";
		for(int i = input.length() - 1; i >= 0; i--) 
		{
			if(i == input.length() - 1) 
			{
				res += input.substring(i);
			}
			else
			{
				res += input.substring(i, i + 1);
			}
		}
		return res;
	}
	public static int reverseInteger(int input) {
		int res = 0;
		while(input/10 != 0) {
			int digit = input%10;
			res = res * 10 + digit;
			input = input/10;
		}
		res = res * 10 + input;
		return res;
	}
	public static void main(String[] args) {
		String a = "My King";
		System.out.println(reverseString(a));
	}

}
