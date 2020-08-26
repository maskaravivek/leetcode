package models;

public class SetNode {
    public long data;
    public int rank;
    public SetNode parent;

    public SetNode(long data, int rank) {
        this.data = data;
        this.rank = rank;
    }
}