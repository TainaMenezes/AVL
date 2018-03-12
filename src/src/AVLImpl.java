/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import static java.lang.Integer.max;


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
        do{
            if (no == parent.getLeftChild()){
                parent.setFb(parent.getFb() + 1);
                System.out.println("Pai:"+parent.getKey() +" fb: "+parent.getFb());
            }
            else if (no == parent.getRightChild()){
                parent.setFb(parent.getFb() - 1);
                System.out.println("Pai:"+parent.getKey() +" fb: "+parent.getFb());
            }
            parent = parent.getParent();
            no = no.getParent();
        //if (parent.getFb() == 0) break;    
            
        }while(parent != null);
        
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

    //ROTACAO SIMPLES A ESQUERDA
    public void rSLeft(Node no) {
       Node top = no.getParent();
       Node parentTree = top.getParent();
       
       no.setParent(parentTree);
       top.setParent(no);
       Node leftson = no.getLeftChild();
       no.setLeftChild(top);
       top.setRightChild(leftson);
       leftson.setParent(top);
       if (no.getKey()>parentTree.getKey()){
           parentTree.setRightChild(no);
       }
       else{
           parentTree.setLeftChild(no);
       }
       
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
    public void removeNode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void rSRight(Node no) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
