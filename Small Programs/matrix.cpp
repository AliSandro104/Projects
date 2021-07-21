/**
* Program that generates two random 5x5 matrices and prints their content to the screen
* Then, it multiplies them and prints the resulting matrix.
* The numbers are positive integers ranging from 0 to 25.
*/

#include <cstdlib>
#include <iostream>

using namespace std;

const int rows = 5;
const int cols = 5;

// fill a matrix with random numbers ranging from 0 to 25
void fillMatrix(int matrix[rows][cols]) {
	
	for (int i = 0; i < rows; i++) {
		
		for (int j = 0; j < cols; j++) {
			
			matrix[i][j] = rand() % 26;
		}
	}
}

// print an input matrix to the screen
void printMatrix(int matrix[rows][cols]) {
	
	for (int i = 0; i < rows; i++) {
		
		for (int j = 0; j < cols; j++) {
			
			cout << matrix[i][j];
			
			if (j != cols - 1) {
				
				cout << " | ";
			}
		}
		
		cout << "\n------------------------------\n";
	}
}

// multiply two matrices and store the result in a result matrix
void multiplyMatrices(int matrix1[rows][cols], int matrix2[rows][cols], int matrix_res[rows][cols]) {
					  	
	for (int i = 0; i < rows; i++) {
		
		for (int j = 0; j < cols; j++) {
			
			matrix_res[i][j] = 0;
			
			for (int k = 0; k < rows; k++) {
                
				matrix_res[i][j] += matrix1[i][k] * matrix2[k][j];
		
			}
		}
	}	
}

int main() {
	
	int matrix1[rows][cols];
	int matrix2[rows][cols];
	int matrix_res[rows][cols];
	
	// fill matrices A and B
	fillMatrix(matrix1);
	fillMatrix(matrix2);
	
	// print matrices A and B to the screen
	cout << "      Matrix A\n" ;
	printMatrix(matrix1);
	
	cout << endl << "      Matrix B\n" ; 
	printMatrix(matrix2);
	
	// multiply matrices A and B and store the result in matrix_res
	multiplyMatrices(matrix1, matrix2, matrix_res);
	
	// print the result of the matrix multiplication
	cout << endl << "      Multiplication Result\n" ; 
	printMatrix(matrix_res);
	
	return 0;
}
