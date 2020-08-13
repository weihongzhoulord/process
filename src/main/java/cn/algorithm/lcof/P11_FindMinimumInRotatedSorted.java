package cn.algorithm.lcof;

/**
 * @author hongzhou.wei
 * @date 2020/7/22
 */
public class P11_FindMinimumInRotatedSorted {
    public static void main(String[] args) {
//        int d[] = new int[]{3,4,5,1,2};
//        int d[] = new int[]{2,2,2,0,1};
        int d[] = new int[]{0,1,2,3,-1};


        System.out.println(findMin(d));
    }
    static public int findMin(int[] numbers) {
        int len = numbers.length;
        if(len == 0){
            return 0;
        }
        if(len == 1){
            return numbers[0];
        }
        for (int i = 1; i < len; i++) {
            if(numbers[i] < numbers[i-1]){
                return numbers[i];
            }
        }
        return numbers[0];
    }

    /**
     * 【二分法】局部有序，且旋转点两边的元素满足左边的元素>=右边的元素
     *
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int pivot = (right + left) / 2;
            if (numbers[pivot] < numbers[right]) {
                right = pivot;
            } else if (numbers[pivot] > numbers[right]) {
                left = pivot + 1;
            } else {
                right --;
            }
        }
        return numbers[left];
    }
}