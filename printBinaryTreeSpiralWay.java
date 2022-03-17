import java.util.ArrayList;

public class printBinaryTreeSpiralWay {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int getHeight(Node root) {
        if (root == null)
            return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return 1 + Math.max(lh, rh);
    }

    static void leftToRight(Node root, int level, ArrayList<Integer> res) {
        if (root == null)
            return;

        if (level == 1)
            res.add(root.data);
        else if (level > 1) {
            leftToRight(root.left, level - 1, res);
            leftToRight(root.right, level - 1, res);
        }
    }

    static void rightToLeft(Node root, int level, ArrayList<Integer> res) {
        if (root == null)
            return;

        if (level == 1)
            res.add(root.data);
        else if (level > 1) {
            rightToLeft(root.right, level - 1, res);
            rightToLeft(root.left, level - 1, res);
        }
    }

    static void clockWiseSpiral(Node root) {
        int i = 1, j = getHeight(root);

        ArrayList<Integer> res = new ArrayList<>();

        int flag = 0;
        while (i <= j) {
            if (flag == 0) {
                leftToRight(root, i, res);
                flag = 1;
                i++;
            } else {
                rightToLeft(root, j, res);
                flag = 0;
                j--;
            }
        }

        for (int el : res)
            System.out.print(el + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(10);

        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        clockWiseSpiral(root);
    }
}
