public class ConstructTreeIP {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int in[], pr[];
    static Node rt = null;
    public static Node constTree(int lI, int hI, int lP, int hP) {
        if(lI > hI || lP > hP) return null;
        Node root = new Node(pr[lP]);
        if(rt == null) rt = root;
        int p = 0;
        for(int i =lI;i<=hI;i++) {
            if(in[i] == pr[lP]) {
                p = i;
                break;
            }
        }
        int leftLen = 0;
        if((p-lI) > 0) leftLen = p-lI;
        root.left = constTree(lI, lI+leftLen-1, lP+1, lP+leftLen);
        root.right = constTree( p+1, hI, lP+leftLen+1,hP);
        return root;
    }

    static void postOrder(Node root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");

    }
    public static void main(String args[]) {
        int io[] = {3, 1, 4, 0, 5, 2};
        in = io;
        int po[] = {0, 1, 3, 4, 2, 5};
        pr = po;
        constTree( 0, 5, 0, 5);
        postOrder(rt);
        //System.out.print(rt.left.data + " ");
        System.out.println();
    }
}
