import javax.imageio.IIOException;
import java.util.*;
import DataStructure.Pair;
import DataStructure.Queue;

public class GrootsPie {
    public static void main(String[] args) throws IIOException {
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 1));
        int desiredSweet = 6;
        ArrayList<Integer> ans = new ArrayList<>();

        GrootsPie ob = new GrootsPie();
        ob.solve(0, arrList, desiredSweet, ans);

        for (int e : ans)
            System.out.println(e + ",");
    }

    void solve(int index, ArrayList<Integer> arrayList, int desiredSweet, ArrayList<Integer> ans) {
        if (index >= arrayList.size() - 1)
            return;

        if (desiredSweet == 0)
            return;

        ans.add(index);
        solve(index + 1, arrayList, desiredSweet - arrayList.get(index), ans);
        ans.remove(index);
        solve(index + 1, arrayList, desiredSweet, ans);
    }
}
