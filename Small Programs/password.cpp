/*
 * Program that asks for a password from the user and checks whether it satisfies all the following conditions:
 * - The password is at least 8 characters long
 * - Each character must not occur more than 2 times
 * - The password contains at least one number
 * - The password contains at least one of the following special characters: *, #, $.
 * After the input, a message will be displayed saying that the password was accepted
 * or does not follow one of the conditions.
 */

#include <iostream>
using namespace std;

char password[100];

int checkPassword() {

	int size = 0;
	
	char* c = password;

	while (*c != 0) {

		size++;
		c++;
	}	

	// check that the length of the password is at least 8
	if (size < 8) {
	
		return 1;
	}

	
	// Make sure that each character does not occur more than 2 times
	int counter;
	for (int i = 0; i < size; i++) {
		
		counter = 0;

		for (int j = i; j < size; j++) {

			if (password[i] == password[j]) {

				counter++;
			}
			
			if (counter > 2) {
				
				return 2; 
			}	
		}	
	}
	
	// Check that the password has at least one number and one of the three special characters required
	bool hasNumber = false;
	bool hasSpecial = false;

	for (int i = 0; i < size; i++) {
		
		if (*(password + i) >= 48 && *(password + i) <= 57) {
			
			hasNumber = true;
		}
		
		if (*(password + i) == 42 || *(password + i) == 35 || *(password + i) == 36) {
		        
			hasSpecial = true;
		}	
	}
	
	if (!hasNumber) {
		
		return 3;	
	}
	
	if (!hasSpecial) {
		
		return 4;
	}	
	
	return 0;
}

int main() {

	cout << "Please enter a password: " << endl;
	cin >> password;
	
	int result = checkPassword();

	switch (result) {

		case 0: cout << "The password has been accepted!" << endl;
		break;

		case 1: cout << "The password must contain at least 8 characters!" << endl;	
		break;

		case 2: cout << "There are characters that occur more than two times in the password!" << endl;
		break;	

		case 3: cout << "The password must contain at least one number!" << endl;
		break;

		case 4: cout << "The password must contain at least a special character from *, # or $" << endl;
		break;
	}	

	return 0;
}


