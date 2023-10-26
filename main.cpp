#include <iostream>
using namespace std;
#include "quicksort.h"


int main() {
    const int  SIZE = 12;
    int left = 0;
    int right = SIZE - 1;
    int array[SIZE] = {56, 40, 16, 12, 28, 32, 8, 4, 60, 20, 38, 22};

    quicksort(array, left, right);

    for (int i = 0; i < right; i++) {
        cout << array[i] << endl;
    }
}