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
public interface AVLInterface {
    
    
    public boolean isEmpty();
    public void insertNode(int key);
    public void removeNode();
    public Node searchNode(Node no, int key);
    public int height(Node no);
    public void printTree(Node no);
    
    //rotations methods
    public void rSLeft(Node no);
    public void rSRight(Node no);
    
    public void rDLeft(Node no);
    public void rDRight(Node no);
    
    
    
}
