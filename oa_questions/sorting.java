public class sorting {
    public void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 1; j < (n - i); j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                return;
        }
    }

    public void insertSort(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            int j = i;
            for (j = i; j > 0; j--) {
                if (temp < nums[j - 1]) {
                    nums[j] = nums[j - 1];
                } else {
                    break;
                }
            }
            nums[j] = temp;
        }
        return input;
    }

    public void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length - 1; i++) {
            int min = nums[i];
            int minIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    num = nums[j];
                    minIdx = j;
                }
            }
            nums[minIdx] = nums[i];
            nums[i] = min;
        }
    }

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(nums, begin, min);
            mergeSort(nums.mid + 1, end);
            merge(nums, begin, mid, end);
        }
    }

    public void merge(int[] nums, int left, int leftEnd, int rightEnd) {
        int[] result = new int[nums.length];
        int[] arr1 = new int[leftEnd - left];
        int[] arr2 = new int[rightEnd - leftEnd];
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

    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int pivotPosition = partition(nums, begin, end);
        quickSort(nums, begin, pivotPosition - 1);
        quickSort(nums, pivotPosition + 1, end);
    }

    public int partition(int[] nums, int begin, int end) {
        int pivot = nums[begin];

        while(begin < end) {
            while (begin < end && nums[end] >= pivot) {
                end--;
            }
            nums[begin] = nums[end];
            while(begin < end && nums[begin] <= pivot) {
                begin++;
            }
            nums[end] = nums[begin];
        }
        nums[begin] = pivot;
        return begin;
    }
}
