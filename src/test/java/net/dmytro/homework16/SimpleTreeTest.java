package net.dmytro.homework16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SimpleTreeTest {
    @Test
    void addTest(){
        SimpleTree st = new SimpleTree();

        st.add(6);
        st.add(4);
        st.add(8);
        st.add(3);
        st.add(5);
        st.add(7);
        st.add(9);

        Assertions.assertEquals(6, st.getRoot().getValue());
        Assertions.assertEquals(4, st.getRoot().getLeft().getValue());
        Assertions.assertEquals(3, st.getRoot().getLeft().getLeft().getValue());
        Assertions.assertEquals(5, st.getRoot().getLeft().getRight().getValue());
        Assertions.assertEquals(8, st.getRoot().getRight().getValue());
        Assertions.assertEquals(7, st.getRoot().getRight().getLeft().getValue());
        Assertions.assertEquals(9, st.getRoot().getRight().getRight().getValue());

    }
    @Test
    void traverseInorderTest(){
        SimpleTree st = new SimpleTree();
        st.add(6);
        st.add(4);
        st.add(8);
        st.add(3);
        st.add(5);
        st.add(7);
        st.add(9);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        st.traversInOrder();

        Assertions.assertEquals(" 3 4 5 6 7 8 9", outputStream.toString());


    }
}
