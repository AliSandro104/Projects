/**
 * Program that takes a word and translate each letter into its corresponding phonetic alphabet.
 * Example:
 * Please enter a word: Hello
 * Output: Hotel Echo Lima Lima Oscar
 */

#include <iostream>
using namespace std;

char word[100];

string alphabet[26] = {"Alfa", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliett", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "X-ray", "Yankee", "Zulu"}; 

int convertPhonetic() {
	
	int size  = 0;
	char* c = word;
	
	while (*c != 0) {
		
		size++;
		c++;
	}

	char temp;

	// loop through every character of the input word
	for (int i = 0 ; i < size; i++) {
		
		temp = *(i + word); 
		
		// if character is a capital letter
		if (temp >= 65 && temp <= 90) {
			
			temp -= 65;
			cout << alphabet[temp] << " ";
		
		// if character is a small letter
		} else if (temp >= 97 && temp <= 122) {

			temp -= 97;
			cout << alphabet[temp] << " ";
		
		// if character is not a valid letter, print it without modification
		} else {
			
			cout << temp << " "; 
		}
	}
	cout << endl;

	return 0;
}

int main() {
	
	cout << "Please enter a word: ";
	
	cin >> word;
	
	convertPhonetic();
	
	return 0;
}



