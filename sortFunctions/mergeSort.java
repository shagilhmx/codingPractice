package sortFunctions;

import java.util.ArrayList;

public class mergeSort<T extends Comparable<? super T>> implements mySort<T> {
    @Override
    public void solve(int start, int end, ArrayList<T> arr, ArrayList<T> ans) {
        if (start < end) {
            int mid = (start + end) / 2;
            solve(start, mid, arr, ans);
            solve(mid + 1, end, arr, ans);
            merge(start, mid, end, arr, ans);
        }
    }

    void merge(int start, int mid, int end, ArrayList<T> arr, ArrayList<T> ans) {
        int p = start, q = mid + 1, r = start;

        while (p <= mid && q <= end) {
            System.out.println("leftHalf: " + Integer.parseInt(arr.get(p).toString()));
            System.out.println("rightHalf: " + Integer.parseInt(arr.get(q).toString()));
            if (arr.get(q).compareTo(arr.get(q)) < 0) {
                ans.add(r, arr.get(p));
                p++;
            } else {
                ans.add(r, arr.get(q));
                q++;
            }
            r++;
        }

        if (p > mid) {
            while (q <= end) {
                ans.add(r, arr.get(q));
                r++;
                q++;
            }
        } else {
            while (p <= mid) {
                ans.add(r, arr.get(p));
                r++;
                p++;
            }
        }

        for (int i = start; i <= end; i++)
            arr.add(i, ans.get(i));
    }

}
