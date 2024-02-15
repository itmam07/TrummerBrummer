/*
author: Itmam Alam
file: bubblesort.cpp
task: Arrays mit bubblesort sortieren
date: 19.12.2022
*/


#include <iostream>
#include "bubblesort.h"


using namespace std;


int main() {

	int size;

	cout << "\nsize of array: ";
	cin >> size;
	cout << endl;
    int a[size];

	fill(a, size);	
	printArray(a, sizeof(a)/sizeof(int));
	cout << endl;

    bubblesort(a, size);
    printArray(a, sizeof(a)/sizeof(int));
}


//fills array
void fill(int a[], int len) {
    int wert;

    for (int i = 0; i < len; i++) {
        cout << "Wert eingeben: ";
        cin >> wert;
        a[i] = wert;
    }
}


//prints array
void printArray(int a[], int len) {
	cout << endl;
	for (int i = 0; i < len; i++)
    	cout << a[i] << endl << endl;
}


//bubblesorts array
void bubblesort(int a[], int len) {
    for (int i = len - 1; i >= 0; i--) {
        for (int j = 0; j < i; j++) {
            if (a[j] > a [j + 1]) {
                int h = a[j];
                a[j] = a[j + 1];
                a[j + 1] = h;
            }
        }
    }
}
