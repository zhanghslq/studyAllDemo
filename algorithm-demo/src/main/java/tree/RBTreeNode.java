package tree;

import java.util.Objects;

public class RBTreeNode {
    /**
     * 红 默认false
     */
    private final boolean RED = false;
    /**
     * 默认为黑节点
     */
    private final boolean BLACK = true;
    /**
     * key
     */
    private int key;
    private boolean color;
    private RBTreeNode left;
    private RBTreeNode right;
    private RBTreeNode parent;

    public RBTreeNode(int key) {
        this.key = key;
        this.color = RED;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public RBTreeNode getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode left) {
        this.left = left;
    }

    public RBTreeNode getRight() {
        return right;
    }

    public void setRight(RBTreeNode right) {
        this.right = right;
    }

    public RBTreeNode getParent() {
        return parent;
    }

    public void setParent(RBTreeNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "RBTreeNode{" +
                ",key=" + key +
                ", color=" + color +
                '}';
    }
}

