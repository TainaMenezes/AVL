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
        tree.insertNode(4);
        tree.insertNode(3);
        tree.insertNode(5);
        tree.insertNode(2);
        tree.insertNode(6);
        tree.insertNode(7);
        
        
        tree.printTree(tree.root);
        System.out.println(" ");

        
    }


    
}
