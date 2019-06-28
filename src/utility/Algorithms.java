package utility;

import java.util.LinkedList;
import java.util.List;

public class Algorithms {
    public static int binarySearch(long x, long[] array) {
        int first = 0, last = array.length - 1, mid = 0;
        if (array.length == 0 || x > array[array.length - 1] || x < array[0])
            return -1;
        while (first < last) {
            mid = first + (last - first) / 2;
            if (x <= array[mid])
                last = mid;
            else
                first = mid + 1;
        }
        if (x == array[last])
            return last;
        else
            return -1;
    }

    public static void swap(int[] array, int i, int j) {
        int template = array[i];
        array[i] = array[j];
        array[j] = template;
    }

    public static void quickSort(int[] array, int begin, int end) {
        int b = begin, e = end, pivot = array[(begin + end) / 2];
        do {
            while (array[b] < pivot && b < end){
                b++;
            }
            while (array[e] > pivot && e > begin){
                e--;
            }
            if (b <= e) {
                swap(array, b, e);
                b++;
                e--;
            }
        }
        while (b <= e);

//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.println();

        if (begin < e) {
            quickSort(array, begin, e);
        }
        if (b < end) {
            quickSort(array, b, end);
        }
    }

    public static int[] prefixFunction(String s) {
        int stringLength = s.length();
        char[] chars = s.toCharArray();
        int[] prefix = new int[stringLength];
        int j;
        for(int i = 1; i < stringLength; ++i) {
            j = prefix[i - 1];
            while (j > 0 && chars[i] != chars[j]) {
                j = prefix[j - 1];
            }
            if (chars[i] == chars[j]) {
                ++j;
            }
            prefix[i] = j;
        }
        return prefix;
    }

    public static int getFamiliarStrings(String subString, String mainString) {
//        subString = "drew";
//        mainString = "dhdrewjadrewewshdrasddrewndsjdredrwdrsewd";
        String newString = subString + "@" + mainString;
        int[] p;
        p = prefixFunction(newString);
//        for (int i = 0; i < p.length; i++) {
//            System.out.print(p[i] + " ");
//        }
//        System.out.println();
        int counter = 0;
        for (int item: p){
            if(item == subString.length()) {
//                System.out.print(true);
                counter++;
            }
        }
        //System.out.println(counter);
        return counter;
    }

    public static List<Integer> getFamiliarStringsUsingHash(String subString, String mainString)
    {
        //mainString = "asdfj dr drew dia sdnh drew sdccdrewccc";
        //subString = "dr";
        final int p = 31;
        long[] hash = new long[mainString.length()];
        hash[0] = 0;
        long pow = 1;
        char[] chars = mainString.toCharArray();

        for (int i = 0; i < mainString.length(); i++) {
            hash[i] = (chars[i] - 'a' + 1) * pow;
            pow *= p;
            if (i > 0)
                hash[i] += hash[i - 1];
        }

        long[] pows = new long[mainString.length() + 1];
        pows[0] = 1;

        for (int i = 1; i < pows.length; ++i) {
            pows[i] = pows[i - 1] * p;
        }

        long hashSub = hash(subString);
        List<Integer> targetWordIndexes = new LinkedList<>();

        for (int i = 0; i + subString.length() - 1 < mainString.length(); i++) {
            long h = hash[i + subString.length() - 1];
            if (i > 0) {
                h -= hash[i - 1];
            }
            if (h == hashSub * pows[i]) {
                //System.out.println(i);
                targetWordIndexes.add(i);
            }
        }

        return targetWordIndexes;
    }

    public static long hash(String s)
    {
        int p = 31;// либо p = 53 если буквы могут быть и заглавными и маленькими
        long hash = 0, p_pow = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i)
        {
            hash += (chars[i] - 'a' + 1) * p_pow;
            p_pow *= p;
        }
        return hash;
    }

    public static long HashArray(String s)
    {
        int p = 31;
        long[] hash = new long[s.length()];
        hash[0] = 0;
        long pow = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); ++i)
        {
            hash[i] = (chars[i] - 'a' + 1) * pow;
            pow *= p;
            if (i > 0)
                hash[i] += hash[i - 1];
        }
        return hash[s.length() - 1];
    }
}
