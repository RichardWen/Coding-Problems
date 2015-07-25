// CodingInterviewProblems.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

//This method reverses a string
void reverseString(char *p)
{

	char* end = p;
	char temp;

	//Runs a char pointer to the end of the input char
	//The if statement is a check for is NULL or not
	if (p) {
		while (*end) {
			++end;
		}
		end--;

		//Swap code
		while (*p < *end) {
			temp = *p;
			*p++ = *end;
			*end-- = temp;
		}
	}
}

void FizzBuzz()
{
	for (int i = 1; i < 101; i++)
	{
		if (i % 5 == 0 && i % 3 == 0) {
			cout << "FizzBuzz" << endl;
		}
		else if (i % 3 == 0) {
			cout << "Fizz" << endl;
		}
		else if (i % 5 == 0) {
			cout << "Buzz" << endl;
		}
		else {
			cout << i << endl;
		}
	}
}

int _tmain(int argc, _TCHAR* argv[])
{
	FizzBuzz();
	return 0;
}

