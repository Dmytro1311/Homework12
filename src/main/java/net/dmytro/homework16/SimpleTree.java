package net.dmytro.homework16;

import lombok.Data;

@Data
public class SimpleTree {
    Node root;

    private Node addRecursive(Node current, int value){
        if (current == null){
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {

            return current;
        }

        return current;
    }
    public void add(int value){
       root = addRecursive(root,value);
    }

    private void traverseInOrderRecursive(Node node){
        if (node != null){
            traverseInOrderRecursive(node.left);
            System.out.print(" " + node.getValue());
            traverseInOrderRecursive(node.right);
        }
    }
    public void traversInOrder(){
        traverseInOrderRecursive(root);

    }
}
