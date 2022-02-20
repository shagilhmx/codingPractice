import java.util.HashMap;
import java.util.Scanner;

class fwk {
    public int[] finwick = new int[100005];
    public int N;

    fwk(int n) {
        N = n;
        for (int i = 0; i < finwick.length; i++)
            finwick[i] = 0;
    }

    void update(int index, int val) {
        for (int i = index; i <= N; i += (i & -i))
            finwick[i] += val;
    }

    int sum(int index) {
        int ans = 0;
        for (int i = index; i > 0; i -= (i & -i)) {
            ans += finwick[i];
        }
        return ans;
    }
};

public class countNoOfUiqueTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nums1Size = in.nextInt();
        int nums2Size = in.nextInt();

        int[] nums1 = new int[nums1Size];
        int[] nums2 = new int[nums2Size];

        for (int i = 0; i < nums1Size; i++)
            nums1[i] = in.nextInt();
        for (int i = 0; i < nums2Size; i++)
            nums2[i] = in.nextInt();

        countNoOfUiqueTriplets obj = new countNoOfUiqueTriplets();
        int ans = obj.solve(nums1, nums1Size, nums2, nums2Size);
        System.out.println(ans);
        in.close();
    }

    int solve(int[] nums1, int nums1Size, int[] nums2, int nums2Size) {
        HashMap<Integer, Integer> indices = new HashMap<>();
        int[] temp = new int[nums1Size];

        for (int i = 0; i < nums2Size; i++)
            indices.put(nums2[i], i);

        for (int i = 0; i < nums1Size; i++)
            temp[i] = indices.get(nums1[i]);

        for (int i = 0; i < temp.length; i++)
            temp[i]++;

        int[] left = new int[nums1Size + 2];
        int[] right = new int[nums1Size + 2];

        left[0] = 0;
        right[nums1Size + 1] = 0;

        fwk L = new fwk(nums1Size);

        for (int i = 1; i <= nums1Size; i++) {
            int elem = temp[i - 1];
            left[i] = L.sum(elem - 1);
            L.update(elem, 1);
        }

        fwk R = new fwk(nums1Size);

        for (int i = nums1Size; i >= 1; i--) {
            int elem = temp[i - 1];
            right[i] = R.sum(nums1Size) - R.sum(elem);
            R.update(elem, 1);
        }

        int ans = 0;

        for (int i = 1; i <= nums1Size; i++) {
            ans += (left[i] * right[i]);
        }

        return ans;
    }
}
