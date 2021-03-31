package BST;

import java.util.LinkedList;
import java.util.Queue;




// import lib.function;

public class BST {
    class Node{
        Node left;
        Node right;
        int val;
        
        Node(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    Node root;
    int cnt;
    BST(){
        root=null;
        cnt=0;
    }
    int size(){
        return cnt;
    }
    boolean isEmpty(){
        return cnt==0;
    }
    void print(){
        BTreePrinter.printNode(root);
    }
    void inser(int val){
        root=insert(root, val);
    }
    //向以node为根的二叉树中插入新节点val，返回插入操作后新的树根
    Node insert(Node node,int val){
        if(node==null){
            cnt++;
            return new Node(val);
        }
        else if(node.val==val)
            return node;
        else if(node.val>val)
            node.left=insert(node.left, val);
        else
            node.right=insert(node.right, val);
        return node;
    }
    boolean contain(int val){
        return contain(root, val);
    }
    boolean contain(Node node,int val){
        if(node==null){
            System.out.println("notfound");
            return false;
        }
            
        System.out.print(node.val+"->");
        if(node.val==val){
            System.out.println("end");

            return true;

        }
            
        else if(node.val>val)
            return contain(node.left, val);
        else 
            return contain(node.right, val);

    }
    Node search(int val){
        return search(root, val);
    }
    Node search(Node node,int val){
        if(node==null){
            System.out.println("notfound");
            return null;
        }
            
        System.out.print(node.val+"->");
        if(node.val==val){
            System.out.println("end");
            return node;

        }
            
        else if(node.val>val)
            return search(node.left, val);
        else 
            return search(node.right, val);
    }
    void preOrder(){
        preOrser(root);
        System.out.println();
    }
    void inOrder(){
        inOrder(root);
        System.out.println();

    }
    void postorder(){
        postOrder(root);
        System.out.println();

    }
    void preOrser(Node node){
        if(node==null)
            return;
        System.out.print(node.val+" ");
        preOrser(node.left);
        preOrser(node.right);
    }
    void inOrder(Node node){
        if(node==null)
            return;
        // System.out.print("[check:"+node.val+"]");
        inOrder(node.left);
        System.out.print(node.val+" ");
        inOrder(node.right);
    }
    void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val+" ");
    }
    void levelOrder(){
        levelOrder(root);
    }
    void levelOrder(Node node){
        if(node==null)
            return;
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            Node n=queue.poll();
            System.out.print(n.val+" ");
            if(n.left!=null)
                queue.add(n.left);
            if(n.right!=null)
                queue.add(n.right);
        }
        System.out.println();


    }
    Node minimum(){
        return mininum(root);
    }
    Node mininum(Node node){
        if(node==null)
            return null;
        if(node.left==null)
            return node;
        else
            return mininum(node.left);


    }
    Node maximum(){
        return maximum(root);
    }
    Node maximum(Node node){
        if(node==null)
            return null;
        if(node.right==null)
            return node;
    
        else
            return maximum(node.right);


    }
    void deleteMin(){
        root=deleteMin(root);
    }
    //删除掉以node 为根的二叉树中的最小节点，返回新树根
    Node deleteMin(Node node){
        if(node==null)
            return null;
        
        if(node.left==null){
            cnt--;
            return node.right;
        }
        node.left=deleteMin(node.left);
        return node;
        

    }
    Node deleteMax(Node node){
        if(node==null)
            return null;
        
        if(node.right==null){
            cnt--;
            return node.left;
        }
        node.right=deleteMax(node.right);
        return node;
    }
    void deleteMax(){
        root=deleteMax(root);
    }
    //删除以node 为根的节点中值为val的节点,返回新根
    Node delete(Node node,int val){
        if(node==null)
            return null;
        if(node.val==val){
            if(node.left==null){
                cnt--;
                return node.right;
            }
            else if(node.right==null){
                cnt--;
                return node.left;
            }
            else{
                Node successor=mininum(node.right);
                successor.right=deleteMin(node.right);
                successor.left=node.left;
                // cnt--;由于返回的是successor相当于node丢失了，不用减1
                return successor;
            }

        }
        else if(node.val>val)
            node.left=delete(node.left, val);
        else
            node.right=delete(node.right, val);
        cnt--;
        return node;

        
    }
    void delete(int val){
        root=delete(root, val);
    }
    public static void main(String[] args) {
        int [] testData={45, 75, 38, 64, 54, 97, 37, 3, 57, 29, 82, 65, 31, 49,88};
        // testData=function.generateTestArray(15, 0, 100);
        BST bst=new BST();
        for(int val:testData)
            bst.inser(val);
        bst.print();
        
        bst.contain(3);
        bst.search(100);

        bst.preOrder();
        bst.inOrder();
        bst.postorder();
        bst.levelOrder();
        System.out.println(bst.minimum().val);
        System.out.println(bst.maximum().val);

        bst.deleteMin();
        bst.deleteMax();
        bst.print();

        bst.delete(45);
        bst.print();
        System.out.println(bst.size());
    }

}
