//recursion
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node node : root.children){
            preorder(node);
        }
        return list;
    }
}

//iteration
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        if (root == null) return list;
        stack.addLast(root);
        while (!stack.isEmpty()){
            Node node = stack.removeLast();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--)
                stack.addLast(node.children.get(i));
        }
        return list;
    }
}
