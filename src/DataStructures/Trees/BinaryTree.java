package DataStructures.Trees;


import DataStructures.LinkedList.Pair;

import java.util.*;

public class BinaryTree {
    Scanner sc;

    public BinaryTree(){
        sc = new Scanner(System.in);
    }
    public Node<Integer> createNode(Integer data){
        Node<Integer> node = new Node<>(data);
        node.setLeft(null);
        node.setRight(null);
        return node;
    }

    public void InorderTraversal(Node<Integer> root){
        if(root == null) return;
        InorderTraversal(root.getLeft());
        System.out.println(root.getData()+" ");
        InorderTraversal(root.getRight());
    }

    public static ArrayList<Integer> InorderTraversal(Node<Integer> root,ArrayList<Integer> arr){
        if(root == null) return null;
        InorderTraversal(root.getLeft(),arr);
        arr.add(root.getData());
        InorderTraversal(root.getRight(),arr);
        return arr;
    }

    public void PreorderTraversal(Node<Integer> root){
        if(root == null) return;
        System.out.println(root.getData());
        PreorderTraversal(root.getLeft());
        PreorderTraversal(root.getRight());
    }

    public void PostorderTraversal(Node<Integer> root){
        if(root == null) return;
        PostorderTraversal(root.getRight());
        PostorderTraversal(root.getLeft());
        System.out.println(root.getData());
    }

    public void LevelOrderTraversal(Node<Integer> root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<Node<Integer>> queue = new ArrayDeque<>();

        queue.add(root);
        ArrayList<Integer> first = new ArrayList<>();
        first.add(root.getData());
        ans.add(first);

        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            Node<Integer> node = queue.poll();
            if(node.getData() == null){
                if(queue.size() == 0){
                    break;
                }
            }else {
                Node<Integer> left = node.getLeft();
                Node<Integer> right = node.getRight();
                if (left != null) {
                    level.add(left.getData());
//                    System.out.print(left.getData()+" ");
                    queue.add(left);
                }
                if (right != null) {
                    level.add(right.getData());
//                    System.out.print(right.getData()+" ");
                    queue.add(right);
                }
                if(right == null && left == null){
                    queue.add(new Node<>(null));
                }
            }
            ans.add(level);
        }
        System.out.println(ans);
    }

    public ArrayList<ArrayList<Integer>> LevelOrderTraverse(Node<Integer> root){
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        Queue<Node<Integer>> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        ArrayList<Integer> first = new ArrayList<>();
        first.add(root.getData());
        answer.add(first);

        ArrayList<Integer> level = new ArrayList<>();

        while(!q.isEmpty()){
            Node<Integer> node = q.poll();
            if(node == null){
                if(q.isEmpty()) return answer;
                answer.add(level);
                q.offer(null);
                level = new ArrayList<>();
            }else{
                Node<Integer> left = node.getLeft();
                Node<Integer> right = node.getRight();

                if(left != null){
                    q.offer(left);
                    level.add(left.getData());
                }
                if(right != null){
                    q.offer(right);
                    level.add(right.getData());
                }
            }
        }
        return answer;
    }

    public Node<Integer> SearchBSTFor(int key,Node<Integer> root){

        if(root.getData() == key) return root;
        while(root.getRight() != null || root.getLeft() != null) {
            if (key > root.getData()) return SearchBSTFor(key, root.getRight());
            if (key < root.getData()) return SearchBSTFor(key, root.getLeft());
        }
        return null;
    }
    public Node<Integer> SearchBSTFor_Iterative(int key,Node<Integer> root){
        if(root == null) return null;
        if(root.getData() == key){
            return root;
        }else{
            Node<Integer> cur = root;
            while(cur.getRight() != null){
                if(key > cur.getData()){
                    cur = cur.getRight();
                }else if(key < cur.getData()){
                    cur = cur.getLeft();
                }
            }
            return cur;
        }
    }

    public void InsertIntoBSTValue_Itterative(int key,Node<Integer> root){
        Node<Integer> node = new Node<>(key);
        if(root == null) {
            root = node;
        }
        Node<Integer> parent = null;
        Node<Integer> cur = root;
        while(cur.getLeft() != null || cur.getRight() != null){
            parent = cur;
            if(key > cur.getData()){
                cur = cur.getRight();
            }else{
                cur = cur.getLeft();
            }
        }

        if(key > parent.getData()){
            cur.setRight(node);
        }else{
            cur.setLeft(node);
        }
    }

    public void InsertIntoBSTArrayOfValues_Itterative(ArrayList<Integer> arr,Node<Integer> root){
        for(int ele: arr) {
            int key = ele;
            Node<Integer> node = new Node<>(key);
            if (root == null) {
                root = node;
            }
            Node<Integer> parent = null;
            Node<Integer> cur = root;
            while (cur.getLeft() != null || cur.getRight() != null) {
                parent = cur;
                if (key > cur.getData()) {
                    cur = cur.getRight();
                } else {
                    cur = cur.getLeft();
                }
            }
            if (key > parent.getData()){
                cur.setRight(node);
            } else {
                cur.setLeft(node);
            }

        }
    }

    public Node<Integer> InsertIntoBSTValue_Recursive(int key, Node<Integer> root){
        if(root == null) root = new Node<>(key);

        if(key > root.getData()) {
            root.setRight(InsertIntoBSTValue_Recursive(key, root.getRight()));
        }else if(key < root.getData()) {
            root.setLeft(InsertIntoBSTValue_Recursive(key, root.getLeft()));
        }

        return root;
    }

    public Node<Integer> FormBSTUsingArray(ArrayList<Integer> arr,Node<Integer> root){
        for(int ele: arr){
            InsertIntoBSTValue_Recursive(ele,root);
        }
        return root;
    }

    public static boolean isBST(Node<Integer> root){
        // Only works on some cases
        if(root == null) return true;
        if(root.getLeft() == null && root.getRight() == null) return false;
        if(root.getLeft() != null && root.getRight() != null && root.getLeft().getData() < root.getData() && root.getRight().getData() > root.getData()) return true;

        boolean left = isBST(root.getLeft());
        boolean right = isBST(root.getRight  ());

        return left && right;
    }

    public static boolean isBST(Node<Integer> root, long min, long max){
        if(root == null) return true;
        if(root.getData() <= min || root.getData() >= max) return false;
        return isBST(root.getLeft(),min, root.getData()) && isBST(root.getRight(), root.getData(),max);
    }

    public static boolean isSorted(ArrayList<Integer> arr){
        int prev = arr.get(0);
        for(int i = 1; i<arr.size();i++){
            if(arr.get(i)>prev){
                prev = arr.get(i);
            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean isBST_UsingInorderTraversal(Node<Integer> root){
        ArrayList<Integer> inorder = new ArrayList<>();
        InorderTraversal(root,inorder);
        return isSorted(inorder);
    }

    public static int FindDistanceFromCurrentTo(int key,Node<Integer> root){
        if(root == null || root.getData() == key) return 0;
        if(key < root.getData()) {
            return 1 + FindDistanceFromCurrentTo(key,root.getLeft());
        }else{
            return 1 + FindDistanceFromCurrentTo(key,root.getRight());
        }
    }

    public static int DistanceBetweenAnyTwoNodes(Node<Integer> root,int a,int b){
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        if(root == null) return 0;

        if(min < root.getData() && max < root.getData()){
            return DistanceBetweenAnyTwoNodes(root.getLeft(),a,b);
        }

        if(min > root.getData() && max > root.getData()){
            return DistanceBetweenAnyTwoNodes(root.getRight(),a,b);
        }

        return FindDistanceFromCurrentTo(min,root) + FindDistanceFromCurrentTo(max,root);
    }

    public static Pair<Integer> TwoSumInBST(int sum,Node<Integer> root){
        // This uses 2 pointer algo on the inorder form of the BST to get the Two Sum
        // We can do the same using a HashSet

        ArrayList<Integer> inorder = new ArrayList<>();
        InorderTraversal(root,inorder);
        int i = 0;
        int j = inorder.size()-1;
        System.out.println(inorder);
        int cur = inorder.get(i) + inorder.get(j);
        System.out.println(cur + " i = "+i+" j = "+j);

        while(i < j){
            if(cur < sum){
                i++;
            }else if(cur > sum){
                j--;
            }else{
                break;
            }
            cur = inorder.get(i) + inorder.get(j);
            System.out.println(cur + " i = "+i+" j = "+j);
        }

        return new Pair<>(inorder.get(i),inorder.get(j));

    }

    public Node<Integer> createTree(){
            int data = sc.nextInt();
            if(data == -1){
                return null;
            }

            Node<Integer> node = new Node<>(data);

            System.out.println("Set left of "+data+" node...");
            node.setLeft(createTree());

            System.out.println("Set right of "+data+" node...");
            node.setRight(createTree());

            return node;
        }
}

