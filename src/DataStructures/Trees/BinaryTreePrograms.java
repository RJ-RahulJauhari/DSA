package DataStructures.Trees;

import java.util.*;

public class BinaryTreePrograms {

    public static void RightSideViewOfTree(Node<Integer> root, int level, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.getData());
        }
        RightSideViewOfTree(root.getRight(),level+1,ans);
        RightSideViewOfTree(root.getLeft(),level+1,ans);
    }

    public static void LeftSideViewOfTree(Node<Integer> root, int level, ArrayList<Integer> ans){
        if(root == null){
            return;
        }
        if(ans.size() == level){
            ans.add(root.getData());
        }
        LeftSideViewOfTree(root.getLeft(),level+1,ans);
        LeftSideViewOfTree(root.getRight(),level+1,ans);
    }

    public static int largestListSize(ArrayList<ArrayList<Integer>> arr){
        int max = 0;
        for(ArrayList<Integer> sublist: arr){
            if(sublist.size() > max){
                max = sublist.size();
            }
        }
        return max;
    }

    public static void VerticalOrderTraversal(Node<Integer> root){
        Queue<Pair<Node<Integer>>> q = new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        // Generate Initial Pair
        Pair<Node<Integer>> RootPair = new Pair<>(0, root);
        // Adding the first Node to the Queue
        q.add(RootPair);
        ArrayList<Integer> rootList = new ArrayList<>();
        rootList.add(root.getData());
        map.put(0,rootList);

        while(!q.isEmpty()){
            Pair<Node<Integer>> pair = q.poll();

            Node<Integer> left = pair.getData().getLeft();
            Node<Integer> right = pair.getData().getRight();

            if(left != null){
                int leftHD = pair.getHD()-1;
                Pair<Node<Integer>> leftPair = new Pair<>(leftHD,left);
                q.add(leftPair);
                if(map.containsKey(leftHD)){
                    map.get(leftHD).add(left.getData());
                }else {
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(left.getData());
                    map.put(leftHD,arr);
                }
            }
            if(right != null){
                int rightHD = pair.getHD()+1;
                Pair<Node<Integer>> rightPair = new Pair<>(rightHD,right);
                q.add(rightPair);
                if(map.containsKey(rightHD)){
                    map.get(rightHD).add(right.getData());
                }else{
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(right.getData());
                    map.put(rightHD,arr);
                }
            }
        }
        System.out.println(map);
        // Generating Answer:
        ArrayList<Integer> answer = new ArrayList<>();
        for(ArrayList<Integer> list: map.values()){
            answer.add(list.get(list.size()-1));
        }
        System.out.println(answer);
    }

    static class Pair<Type>{

        int HD;
        Type data;

        public Pair(int HD, Type data) {
            this.HD = HD;
            this.data = data;
        }

        public int getHD() {
            return HD;
        }

        public void setHD(int HD) {
            this.HD = HD;
        }

        public Type getData() {
            return data;
        }

        public void setData(Type data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> InorderTraversalWithoutRecursion(Node<Integer> root){
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();

        Node<Integer> cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }

            Node<Integer> pop = stack.pop();
            answer.add(pop.getData());

            cur = pop.getRight();

        }
        return answer;
    }

    public static ArrayList<Integer> PreorderTraversalWithoutRecursion(Node<Integer> root){
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Node<Integer>> stack = new Stack<>();

        Node<Integer> cur = root;

        while(cur != null || !stack.isEmpty()){

            while(cur != null){
                stack.push(cur);
                answer.add(cur.getData());
                cur = cur.getLeft();
            }

            Node<Integer> pop = stack.pop();
            cur = pop.getRight();
        }
        return answer;
    }

    public static ArrayList<Integer> PreorderTraversalWithoutRecursion_Version_2(Node<Integer> root){
        ArrayList<Integer> answer = new ArrayList<>();
        if(root == null) return answer;
        ArrayDeque<Node<Integer>> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node<Integer> pop = stack.pop();
            answer.add(pop.getData());

            if(pop.getLeft() != null){
                stack.push(pop.getRight());
            }
            if(pop.getRight() != null){
                stack.push(pop.getLeft());
            }
        }
        return answer;
    }

    public static ArrayDeque<Integer> PostorderTraversal(Node<Integer> root){
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(root);

        Node<Integer> cur = root;

        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                answer.addFirst(cur.getData());
                stack.push(cur);
                cur = cur.getRight();
            }

            Node<Integer> pop = stack.pop();
            cur = pop.getLeft();
        }
        return answer;

    }

    public static int HeightOfBinaryTree(Node<Integer> root){
        if(root == null) return 0;

        int left = HeightOfBinaryTree(root.getLeft());
        int right = HeightOfBinaryTree(root.getRight());

        return Math.max(left, right) + 1;
    }

    public static int diameterOfTree(Node<Integer> root){

        // Finding the height of left and right subtree, which the node which is farest from the root on both sides and then we add them up.
        int left = HeightOfBinaryTree(root.getLeft());
        int right = HeightOfBinaryTree(root.getRight());

        return left + right;

    }

    public static boolean isPresent(int key, Node<Integer> root,ArrayList<Integer> ans){
        if(root.getData() == key) {
            return true;
        }

        if(root.getLeft() != null && root.getRight() != null) {
            boolean left = isPresent(key, root.getLeft(),ans);
            boolean right = isPresent(key, root.getRight(),ans);
            if(left || right){
                ans.add(root.getData());
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public static ArrayList<Integer> fetchAllAncestorsOf(int key, Node<Integer> root){
        ArrayList<Integer> ans = new ArrayList<>();
        isPresent(key,root,ans);
        return ans;
    }

    public static int LowestCommonAncestorOf(int a, int b, Node<Integer> root){
        ArrayList<Integer> ancestor1 = fetchAllAncestorsOf(a,root);
        ArrayList<Integer> ancestor2 = fetchAllAncestorsOf(b,root);
        System.out.println(ancestor1);
        System.out.println(ancestor2);

        int i = ancestor1.size()-1;
        int j = ancestor2.size()-1;

        int common = 0;

        while(i > 0 && j > 0){
            if(Objects.equals(ancestor1.get(i), ancestor2.get(j))){
                i--;
                j--;
                common = ancestor1.get(i);
            }else{
                break;
            }
        }
        return common;
    }

    public static Node<Integer> LowestCommonAncestor_Fast(Node<Integer> root, Node<Integer> a,Node<Integer> b){
        if(root == null) return null;
        if(root.getData() == a.getData() || root.getData() == b.getData()) return root;

        Node<Integer> left = LowestCommonAncestor_Fast(root.getLeft(),a,b);
        Node<Integer> right = LowestCommonAncestor_Fast(root.getRight(),a,b);

        if(right == null) return left;
        if(left == null) return right;

        return root;
    }


}
