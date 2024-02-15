#include "quicksort.h"

void quicksort(int arr[], int left, int right) {
    if (left < right) {
        int pivot = getPivot(arr, left, right);
        quicksort(arr, left, pivot - 1);
        quicksort(arr, pivot + 1, right);
    }
}

int getPivot(int arr[], int left, int right) {
    int pivot = arr[right];
    int i = left - 1;
    int j = left;
    int k = right - 1;

    while (j <= k) {
        if (arr[j] < pivot) {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        } else if (arr[j] > pivot) {
            int temp = arr[k];
            arr[k] = arr[j];
            arr[j] = temp;
            k--;
        } else {
            j++;
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[right];
    arr[right] = temp;

    return i + 1;
}       
