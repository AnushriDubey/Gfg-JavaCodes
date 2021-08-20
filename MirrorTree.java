package Tree;


class Node{
    int data;
    Node left = null,right = null;
    Node(int data) {
        this.data = data;
    }
}

public class MirrorTree {

    static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    static void mirror(Node root) {
        if(root == null) return;
        else {
            Node leftN = root.left;
            Node rightN = root.right;
            root.left = rightN;
            root.right = leftN;
            mirror(root.left);
            mirror(root.right);
        }
    }


    public static void main(String args[]) {
        Node r = new Node(2);
        r.left = new Node(1);
        r.right = new Node(8);
        r.left.left = new Node(12);
        r.right.right = new Node(9);
        inorder(r);
        System.out.println();
        mirror(r);
        inorder(r);
        System.out.println();
    }

}
