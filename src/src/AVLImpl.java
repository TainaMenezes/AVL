/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import static java.lang.Integer.max;
import static java.lang.Integer.min;


/**
 *
 * @author helenyan
 */
public class AVLImpl implements AVLInterface{
    

    public Node root;

    //Se a arvore esta vazia
    public boolean isEmpty() {
        return (root == null);
    }
    
    
   //Procurar node
    public Node searchNode(Node no, int key) {

       if (no.getKey() > key) {
           if (no.getLeftChild()!= null) {
               //System.out.print("Pesquisando node esquerdo \n");
               return searchNode(no.getLeftChild(),key);
           }
       }
       else if (no.getKey() < key) {
           if (no.getRightChild()!= null){
                //System.out.print("Pesquisando node direito \n");
                return searchNode(no.getRightChild(),key);
                
           }
       }
       return no;
    }
    
 
    
    //Atualizar FB em insercao
    public void updateFbInsert(Node no){
        Node parent = no.getParent();
        do {
            if (no == parent.getLeftChild()){
                parent.setFb(parent.getFb() + 1);
                System.out.println("Pai:"+parent.getKey() +" fb: "+parent.getFb());
            }
            else if (no == parent.getRightChild()){
                parent.setFb(parent.getFb() - 1);
                System.out.println("Pai:"+parent.getKey() +" fb: "+parent.getFb());
            }
            if (parent.getFb()== 0){
                break;
                
            }
            if (parent.getFb()== -2){
                rSLeft(parent);
            }
            if (parent.getFb()== +2){
               return;
            }
            parent = parent.getParent();
            if (no.getParent() == null) break;
            else no = no.getParent();
        } while (parent != null);

        
    }
    
    
    //Atualizar FB em remocao
    public void updateFbRemove(Node no){
    Node parent = no.getParent();
    
    while(parent != null){
        if (no == parent.getLeftChild()){
            parent.setFb(parent.getFb() - 1);
            
        }
        else if (no == parent.getRightChild()){
            parent.setFb(parent.getFb() + 1);
        }
        if (parent.getFb() != 0) break;
        parent = parent.getParent();
        no = no.getParent();
       
    }
}
    
    //Inserir novo node
    public void insertNode(int key){
        Node no = new Node(key);
        
        if (isEmpty()){
            root = no;
        }
        else{
            Node parent = searchNode(root, key);
            
            if (key < parent.getKey()){
                parent.setLeftChild(no);
                no.setParent(parent);
              
            }
            else if (key > parent.getKey()){
                parent.setRightChild(no);
                no.setParent(parent);
               
            }
            System.out.println("Node " +no.getKey()+ " inserido.");
            updateFbInsert(no);
            
        }
    }
    
    //Remover um node
    public void removeNode() {
        
    }

    //ROTACAO SIMPLES A ESQUERDA
    public void rSLeft(Node no) {
       
       System.out.println(no.getKey()+" DESBALANCEADO!");
       System.out.println("\nFAZENDO ROTACAO SIMPLES A ESQUERDA");
       Node son = no.getRightChild(); //FILHO DIREITO DO NO DESBALANCEADO
       Node pai = no.getParent(); //PAI DO NO DESBALANCEADO
       
       if (pai == null){
           root = son;
           son.setParent(null);
           no.setParent(son);
           son.setLeftChild(no);
           no.setRightChild(null);
       }
       else{
           son.setParent(pai);
           pai.setRightChild(son);
           no.setParent(son);
           son.setLeftChild(no);
           no.setRightChild(null);
           
       }
       
       no.setFb(Math.abs(no.getFb()) - 1 - max(Math.abs(son.getFb()),0));
       son.setFb(Math.abs(son.getFb()) - 1 + min(Math.abs(no.getFb()),0));
       
    }
    
    
    //ROTACAO SIMPLES A DIREITA
    public void rSRight(Node no) {
     
       System.out.println(no.getKey()+" DESBALANCEADO!");
       System.out.println("\nFAZENDO ROTACAO SIMPLES A DIREITA");
       Node son = no.getLeftChild(); //FILHO DIREITO DO NO DESBALANCEADO
       Node pai = no.getParent(); //PAI DO NO DESBALANCEADO
       
       if (pai == null){
           root = son;
           son.setParent(null);
           no.setParent(son);
           son.setRightChild(no);
           no.setLeftChild(null);
       }
       else{
           son.setParent(pai);
           pai.setLeftChild(son);
           no.setParent(son);
           son.setRightChild(no);
           no.setLeftChild(null);
           
       }
       
       no.setFb(Math.abs(no.getFb()) + 1 - min(Math.abs(son.getFb()),0));
       son.setFb(Math.abs(son.getFb()) + 1 + max(Math.abs(no.getFb()),0));
       
    }
    
    
    //Calcula a altura
    public int height(Node no){
        
        if (no.getLeftChild()== null && no.getRightChild() == null){
            return 1;
        }
        else{
            
            Node leftchild = no.getLeftChild(), rightchild = no.getRightChild();
            
            if (no.getLeftChild()==null) leftchild = new Node();
            if (no.getRightChild()==null) rightchild = new Node();
            int h = 0;
            h = max(height(leftchild), height(rightchild));
            return 1+h;
        }
    }
    
    //Imprimir a arvore:
    public void printTree(Node no){
        if (no == root){
            System.out.print("Raiz:  ["+ no.getKey()+"] fb("+no.getFb()+")");
        }
        else{
            System.out.print("["+no.getKey()+"] fb("+no.getFb()+")");
        }   
        
        if (no.getLeftChild()==null && no.getRightChild()==null){
            System.out.print(" <-É folha");
        }
        else{

            if (no.getLeftChild()==null) System.out.print("\n[" + no.getKey() + "] Nao tem filho esquerdo");
            else {
                System.out.print("\nFilho esquerdo de " + no.getKey() + ": ");
                printTree(no.getLeftChild());
            }

            if (no.getRightChild()==null) System.out.print("\n[" + no.getKey() + "] Nao tem filho direito");
            else {
                System.out.print("\nFilho direito de " + no.getKey()+ ": ");
                printTree(no.getRightChild());
            }
        }    
    }
    

    @Override
    public void rDLeft(Node no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rDRight(Node no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
