package Lesson6;

public class Tree {

    private class TreeNode{
        private int n;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int n){
            this.n = n;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "n=" + n +
                    '}';
        }
    }

    TreeNode root;

    //insert
    public void insert(int n) {
        TreeNode node = new TreeNode(n);
        if (root == null) root = node;
        else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (n < current.n) current = current.left;
                if (current == null) {
                    parent.left = node;
                    return;
                } else if (n > current.n) {
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else return;
            }
        }
    }

    //find
    public boolean find(int n) {
        TreeNode current = root;
        while (current.n != n){
            current = (n < current.n) ? current = current.left : current.right;
            if (current == null) return false;
        }
        return true;
    }

    //display
    public void displayTree(){
        inOrderTravers(root);
    }

    private void inOrderTravers(TreeNode node){
        if (node != null){
            inOrderTravers(node.left);
            System.out.println(node.toString());
            inOrderTravers(node.right);
        }
    }

    //delete
    public boolean delete(int n) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;
        while (current.n != n) {
            parent = current;
            if (n < current.n) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null)
                return false;
        }

        // if a leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // if has one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // if two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode current = node.right;

        while (current != null) {
            parent = s;
            s = current;
            current = current.left;
        }
        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }
}
