package Tree;


public class isSymmetric {
    public static boolean isSymmetric(Node r1, Node r2) {
        if(r1 == null && r2 == null) return true;
        else if((r1 != null && r2 == null) || (r1 == null && r2 != null)) return false;
        else if(r1.data == r2.data) {
            return isSymmetric(r1.left, r2.right) && isSymmetric(r1.right, r2.left);
        }
        else return false;
    }
}
