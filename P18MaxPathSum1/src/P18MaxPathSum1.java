public class P18MaxPathSum1 {

   static class Node {

        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    public static void main(String[] args) {
       String triangle = "75\n" +
               "95 64\n" +
               "17 47 82\n" +
               "18 35 87 10\n" +
               "20 04 82 47 65\n" +
               "19 01 23 75 03 34\n" +
               "88 02 77 73 07 63 67\n" +
               "99 65 04 28 06 16 70 92\n" +
               "41 41 26 56 83 40 80 70 33\n" +
               "41 48 72 33 47 32 37 16 94 29\n" +
               "53 71 44 65 25 43 91 52 97 51 14\n" +
               "70 11 33 28 77 73 17 78 39 68 17 57\n" +
               "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
               "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
               "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
       String nums = triangle.replace("\n", " ");
       String[] nodes = nums.split(" ");
       Node root = makeTree(nodes);
       System.out.println(maxPathSum(root));
    }

    public static Node makeTree(String[] nStrings) {
        Node root = new Node(Integer.parseInt(nStrings[0]));
        Node[] nodes = new Node[nStrings.length];
        nodes[0] = root;
        for (int i = 1; i < nStrings.length; i++) {
            nodes[i] = new Node(Integer.parseInt(nStrings[i]));
        }
        int level = 0;
        int branchesMade = 0;
        for (int i = 0; i + level + 2 < nodes.length; i++) {
            if (2 * (level + 1) == branchesMade) {
                level++;
                branchesMade = 0;
            }
            nodes[i].left = nodes[i + level + 1];
            nodes[i].right = nodes[i + level + 2];
            branchesMade += 2;
        }
        return root;
    }

    public static int maxPathSum(Node root) {
       int maxSum = 0;
        if (root.left == null || root.right == null) {
            return root.value;
        }
       maxSum += root.value +  Integer.max(maxPathSum(root.left), maxPathSum(root.right));
       return maxSum;
    }

}
