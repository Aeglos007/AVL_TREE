/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A. Enes
 */
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
    tree.root = tree.insertNode(tree.root, 33);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 13);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 53);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 9);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 21);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 61);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 8);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    tree.root = tree.insertNode(tree.root, 11);
    tree.printTree(tree.root, "", true);
    System.out.println("------------------------------------------");
    }
}
