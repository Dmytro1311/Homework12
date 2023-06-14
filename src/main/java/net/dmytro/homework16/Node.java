package net.dmytro.homework16;

import lombok.Data;

@Data
public class Node {
    int value;
    Node right;
    Node left;

    public Node(int value) {
        this.value = value;
    }

}
