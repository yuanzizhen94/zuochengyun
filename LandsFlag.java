package zuochengyun_123;
/*
荷兰国旗问题:给定一个数组arr， 和一个数num， 请把小于num的数放在数组的
左边， 等于num的数放在数组的中间， 大于num的数放在数组的
右边。
 */
public class LandsFlag {
    public static int[] partiton(int[] arr, int L, int R, int P) {
        int less = L - 1;
        int more = R + 1;
        while(L < more) {
            if (arr[L] < P) {
                swap(arr, ++less, L++);
            } else if (arr[L] > P) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }
        return new int[]{less + 1, more - 1};
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
