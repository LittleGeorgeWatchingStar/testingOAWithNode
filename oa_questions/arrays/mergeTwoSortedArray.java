public int[] mergeTwoSortedArray( int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int index = 0, index1 = 0, index2 = 0;
    while (index1 < arr1.length && index2 < arr2.length) {
        if (arr1[index1] < arr2[index2]) {
            result[index++] = arr1[index1++];
        } else {
            result[index++] = arr2[index2++];
        }
    }
    for (int i = index1; i < arr1.length; i++) {
        result[index++] = arr1[i];
    }
    for (int i = index2; i < arr2.length; i++) {
        result[index++] = arr2[i];
    }
}