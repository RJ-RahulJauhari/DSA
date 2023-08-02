package DataStructures.Trees;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();

//        Node<Integer> root = new Node<>(1);
//        b.createTree(root,2);
//        b.createTree(root,3);
//        b.createTree(root,4);
//        b.createTree(root,5);
//        b.createTree(root,6);
//        b.InorderTraversal(root);
        Node<Integer> node = new Node<>(1);
        node.setLeft(new Node<>(2));
        node.setRight(new Node<>(3));
        node.getLeft().setLeft(new Node<>(4));
        node.getLeft().setRight(new Node<>(5));
        node.getLeft().getRight().setLeft(new Node<>(7));
        node.getLeft().getRight().setRight(new Node<>(8));

        node.getRight().setRight(new Node<>(6));
        node.getRight().getRight().setRight(new Node<>(9));

        Node<Integer> root = new Node<>(5);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(8);
        arr.add(7);
        arr.add(9);
        BinaryTree c =new BinaryTree();
        c.FormBSTUsingArray(arr,root);


//        System.out.println(b.LevelOrderTraverse(node));
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        BinaryTreePrograms.RightSideViewOfTree(node,0,arr1);
//        ArrayList<Integer> arr2 = new ArrayList<>();
//        BinaryTreePrograms.LeftSideViewOfTree(node,0,arr2);
//
//        System.out.println(arr1);
//        System.out.println(arr2);
//        BinaryTreePrograms.VerticalOrderTraversal(node);
//        System.out.println(BinaryTreePrograms.InorderTraversalWithoutRecursion(node));
//        BinaryTreePrograms.InorderTraversalWithoutRecursion(node);
//        BinaryTreePrograms.PreorderTraversalWithoutRecursion(node);
//        System.out.println(BinaryTreePrograms.PostorderTraversal(node));
//        System.out.println(BinaryTreePrograms.HeightOfBinaryTree(node));
//        System.out.println(BinaryTreePrograms.diameterOfTree(node));
//        ArrayList<Integer> ans = BinaryTreePrograms.fetchAllAncestorsOf(8,node);
//        System.out.println(ans);
//        System.out.println(BinaryTreePrograms.LowestCommonAncestorOf(7,8,node));
//        System.out.println(node.getRight().getRight().getRight().getData());
//        System.out.println(b.SearchBSTFor(9,node).getData());
//        System.out.println(BinaryTree.isBST(node));
//        System.out.println(BinaryTree.FindDistanceFromCurrentTo(7,node));
//        System.out.println(BinaryTree.DistanceBetweenAnyTwoNodes(node,4,9));
//        System.out.println(BinaryTree.isBST_UsingInorderTraversal(node));
        System.out.println(BinaryTree.TwoSumInBST(12,root));

    }
}
