package cn.zsy.eg.arithmetic.digraph;


public enum Node {

    A(0, "A"),
    B(1, "B"),
    C(2, "C"),
    D(3, "D"),
    E(4, "E");

    private int index;
    private String node;

    Node(int index, String node) {
        this.index = index;
        this.node = node;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public static String getNote(int index) {
        for (Node c : Node.values()) {
            if (c.getIndex() == index) {
                return c.getNode();
            }
        }
        return null;
    }

}
