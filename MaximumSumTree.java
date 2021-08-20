package Tree;

public class MaximumSumTree {
    static class Node
    {
        int key;
        Node left, right;
    }
    static int ans = Integer.MIN_VALUE;
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.key = key;
        temp.left = temp.right = null;
        return temp;
    }

    static int maxSum(Node root) {
        if(root == null) return 0;
        int l = maxSum(root.left);
        int r = maxSum(root.right);
        int sum = root.key + l+r;
        ans = Math.max(ans, sum);
        return sum;
    }
    public static void main(String args[]) {
        Node root = newNode(1);
        root.left = newNode(-2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(-6);
        root.right.right = newNode(2);
        System.out.println(maxSum(root));
    }
}
