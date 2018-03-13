/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author helenyan
 */
public class AVLmain {
    public static void main(String[] args) {
        
        AVLImpl tree = new AVLImpl();
        System.out.println("INSERINDO A ARVORE");
        tree.insertNode(50);
        tree.insertNode(20);
        tree.insertNode(10);
        tree.insertNode(9);
        tree.insertNode(6);
        tree.insertNode(8);
        tree.removeNode(50);
        /*
        System.out.println(" ");
        System.out.println("IMPRIMINDO A ARVORE");
        tree.printTree(tree.root);
        System.out.println("\n ");
        System.out.println("INSERINDO O 7");
        tree.insertNode(7);
        
        System.out.println(" ");
        System.out.println("IMPRIMINDO A ARVORE");
        tree.printTree(tree.root);
        
        System.out.println("\n ");
        System.out.println("INSERINDO O 1");
        tree.insertNode(1);*/
 
        System.out.println(" ");
        System.out.println("IMPRIMINDO A ARVORE");
        tree.printTree(tree.root);
    }


    
}
