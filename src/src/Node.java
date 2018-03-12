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
public class Node {
    
    private int key;
    private int fb;
    private Node leftChild;
    private Node rightChild;
    private Node parent;

    //Constructor
    public Node() {
        
    }
    
    public Node(int key){
        this.key = key;
        this.fb = 0;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }
    
    public String toString(){
        
        return key+"\n";
    }

    //Getters and Setters
    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }
    
    public int getFb() {
        return fb;
    }

    public int getKey() {
        return key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
    
    
    
    

}
