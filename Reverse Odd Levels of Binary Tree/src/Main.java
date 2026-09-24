import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        TreeNode result = reverseOddLevels(root);

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(result);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                System.out.print(node.val + " ");
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            System.out.println();
        }
    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        //so first i define queue:
        Queue<TreeNode> q = new ArrayDeque<>();

        //then i push root into q:
        q.offer(root);

        //now i define the level counter:
        int level = 0;

        //now i run the while loop:
        while (!q.isEmpty()) {
            //now grab current level size:
            int size = q.size();

            //list to swap nodes:
            List<TreeNode> list = new ArrayList<>();

            //run loop over size:
            for (int i = 0; i < size; i++) {
                //pop the node:
                TreeNode popped = q.poll();

                //check if childrens are not null:
                if (popped.left != null) {
                    q.offer(popped.left);
                }

                if (popped.right != null) {
                    q.offer(popped.right);
                }

                //check if level is odd then add the poppedNode into list:
                if (level % 2 == 1) {
                    list.add(popped);
                }
            }

            //now check if list has size > 0 meaning level was odd:
            //if yes then set two pointers left and right and swap values of nodes:
            if (list.size() > 0) {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    TreeNode leftNode = list.get(left);
                    TreeNode rightNode = list.get(right);

                    int tempVal = rightNode.val;

                    //now swap values:
                    rightNode.val = leftNode.val;
                    leftNode.val = tempVal;

                    left++;
                    right--;
                }
            }

            //after performing above processing increment level counter:
            level++;
        }

        return root;
    }
}

//  so here i am gonna use breadth first search algo:
//  i will use a queue which implements an array deque.
//  Queue<TreeNode> q = new ArrayDeque
//  so i will first push the root into q.
//  i will define an int variable called level and set it to 0 initially.

//  after that i will run a while loop until q is not empty:
//  to flow will be:
//  while q is not empty:
//  grab current level size.
//  run a for loop over size, inside for loop:
//  pop current node:
//  if level % 2 == 1 meaning if its odd then define a list which will hold Treenode
//  check if left and right childs of popped node are not null if not null then push them into q.
//  after pushing add the current poppedNode the list which will hold the Treenode
// then i set two pointers, left and right at start and end of list.
// then run a while loop until left < right:
// at each iteration i set right pointer nodes value as left pointers node value and vice versa and then i do left++ and right--;
// after this loop gets over i then increment level counter and flow continue.
