import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    Node root;

    public void addNode (int data) {
        root = addNodeHelper(data, root);
    }

    public Node addNodeHelper (int data, Node currentNode) {
        if (currentNode == null) {
            return new Node(data);
        }
        if (data < currentNode.val) {
            currentNode.left = addNodeHelper(data, currentNode.left);
        }
        if (data > currentNode.val) {
            currentNode.right = addNodeHelper(data, currentNode.right);
        }
        return currentNode;
    }

    public void printTree () {
        System.out.println("Pre Order:");
        printHelper(root);
    }

    private void printHelper (Node currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.print(currentNode.val + "->");
        printHelper(currentNode.left);
        printHelper(currentNode.right);
    }

    public List<String> binaryTreePaths () {
        List<String> list = new ArrayList<>();
        treeHelper(root, "", list);
        return list;
    }

    private void treeHelper (Node currentNode, String path, List<String> list) {
        if (currentNode == null) {
            return;
        }

        path+= currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            list.add(path);
        }
        else {
            path += "->";
            treeHelper(currentNode.left, path, list);
            treeHelper(currentNode.right, path, list);
        }
    }


}
