package com.gxf.sort;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 2, 5, 4};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
//        insertSort(arr);
//        selectSort(arr);
//        bubboSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        for(int i : arr){
            System.out.print(i + ", ");
        }
    }

    public static void mergeSort(int[] array, int start, int end, int[] temp){
        if(start < end){
            int middle = (end + start) / 2;
            mergeSort(array, start, middle, temp);
            mergeSort(array, middle + 1, end, temp);
            mergeArray(array, start, middle, end, temp);

        }

    }

    private static void mergeArray(int[] array, int start, int middle, int end, int[] temp){
        int tempIndex = 0;
        int s = start;
        int m = middle + 1;
        int e = end;

        while(s <= middle && m <= e){
            if(array[s] <= array[m])
                temp[tempIndex ++] = array[s ++];
            else
                temp[tempIndex ++] = array[m ++];
        }
        while(s <= middle)
            temp[tempIndex ++] = array[s ++];
        while(m <= e)
            temp[tempIndex ++] = array[m ++];
        for(int i = 0; i < tempIndex; i++)
            array[start + i] = temp[i];

    }

    public static void insertSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j > 0 && j< array.length; j--){
                if(array[j] < array[j - 1]){
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] array){
        for(int i = 0; i < array.length; i ++){
            int maxIndex = i;
            for(int j = i + 1; j < array.length; j ++){
                maxIndex = array[maxIndex] < array[j] ? j : maxIndex;
            }
            if(maxIndex != i){
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    public static void bubboSort(int[] array){
        boolean isExchanged = true;
        for(int i = array.length - 1; i > 0 && isExchanged; i --){
            isExchanged = false;
            for(int j = 0; j < i; j ++){
                if(j < array.length - 1 && array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isExchanged = true;
                }
            }
        }
    }


    public static void quickSort(int[] array, int l, int r){
        if(l < r){
            int s = l;
            int e = r;
            int pivotValue = array[l];
            while(l < r){
                while(l < r && array[r] > pivotValue){
                    r --;
                }
                if(l < r)
                    array[l ++] = array[r];
                while(l < r && array[l] < pivotValue){
                    l ++;
                }
                if(l < r)
                    array[r --] = array[l];
            } //while
            array[l] = pivotValue;
            quickSort(array, s, l - 1);
            quickSort(array, l + 1, e);
        }

    }
}
