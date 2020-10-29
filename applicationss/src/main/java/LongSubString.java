import java.util.HashSet;

/**
 * @Author: wuzhijun
 * @Date: 2020/10/18 23:53
 */
public class LongSubString {

    public String longestDupSubstring(String str) {
        int[] arr = new int[str.length()];
        for(int i=0; i<str.length();i++) {
            arr[i] = str.charAt(i) - 'a';
        }
        // 二分法+RK法
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if(checkRK(arr, mid) > 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int start = checkRK(arr, left);
        if (start == -1) {
            return "";
        } else {
            return str.substring(start, start + left);
        }
    }

    final long modulus = (long)Math.pow(2,32);
    final int a = 26;

    private int checkRK(int[] arr, int length) {
        long curHash = 0;
        HashSet<Long> seen = new HashSet<>();
        // 首先统计0----length-1 这个长为length的的哈希值
        for (int i=0; i < length; i++) {
            curHash = (curHash * a + arr[i]) % modulus;
        }
        seen.add(curHash);
        // aL 代表a的L次方
        long aL = 1;
        for (int i=1; i<=length; i++) {
            aL = (aL*a) % modulus;
        }
        // 统计(1----length) (2------length+1) ............ (arr.length-length -----arr.length-1) 的哈希值
        for (int start = 1; start <= arr.length - length; start++) {
            curHash = (curHash * a - arr[start-1]*aL%modulus + modulus) % modulus;
            curHash = curHash + arr[start+length-1] % modulus;
            if (seen.contains(curHash)) {
                return start;
            }
            seen.add(curHash);
        }
        return -1;
    }

    public static void main(String[] args) {
        LongSubString ss = new LongSubString();
        System.out.println(ss.longestDupSubstring("banana"));
        System.out.println(ss.longestDupSubstring("123456"));
        System.out.println(ss.longestDupSubstring("bananacncnc"));
    }
}
