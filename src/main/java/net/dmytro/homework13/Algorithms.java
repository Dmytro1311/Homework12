package net.dmytro.homework13;




public class Algorithms {

    public static int[] quickSort(int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        quickSorter(arr, min, max);
        return arr;
    }

    private static void quickSorter(int[] arr, int min, int max) {
        if (min < max) {
            int partitionIndex = partition(arr, min, max);
            quickSorter(arr, min, partitionIndex - 1);
            quickSorter(arr, partitionIndex + 1, max);
        }
    }

    private static int partition(int[] arr, int min, int max) {
        int pivot = arr[max];
        int i = min - 1;
        for (int j = min; j < max; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, max);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static int[] shakeSort(int[] array){
        boolean isSwapped = true;
        int start = 0;
        int end = array.length;
        while (isSwapped == true){
            isSwapped = false;
            for (int i = start; i < end -1; ++i){
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false){
                isSwapped = false;
                end = end - 1;

                for (int i = end - 1; i >= start; i-- ){
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                }
                start = start + 1;
            }
        }
        return array;
    }
}
