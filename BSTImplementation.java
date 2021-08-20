public class BSTImplementation {
    class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Node search(Node root, int key) {
        if(root == null || root.data == key) return root;
        if(key > root.data) return search(root.right, key);
        else return search(root.left,key);
    }

     Node insert(Node root, int key) {
        if(root == null) {
            root = new Node(key);
            return root;
        }
        if(key < root.data) root.left = insert(root.left,key);
        else if(key > root.data) root.right = insert(root.right, key);
        return root;
    }

    Node delete(Node root, int key) {
        if(root == null) return root;
        if(key < root.data) root.left = delete(root.left, key);
        else if(root.data < key) root.right = delete(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                root.data = minValue(root.right);
                root.right = delete(root.right, root.data);
            }
            return root;
        }
       return root;
    }

    int minValue(Node root) {
        int min = root.data;
        while(root != null) {
            min = root.data;
            root = root.left;
        }
        return min;
    }

    public static void main(String args[]) {

    }
}
