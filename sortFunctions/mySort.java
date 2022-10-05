package sortFunctions;

import java.util.ArrayList;

public interface mySort<T> {
    default ArrayList<T> sort(ArrayList<T> arr) {
        ArrayList<T> ans = new ArrayList<>();
        solve(0, arr.size() - 1, arr, ans);

        return arr;
    };

    public void solve(int start, int end, ArrayList<T> arr, ArrayList<T> ans);
}
