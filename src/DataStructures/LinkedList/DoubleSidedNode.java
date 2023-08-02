package DataStructures.LinkedList;

public class DoubleSidedNode <Type>{
    private Type data;
    private DoubleSidedNode<Type> prev;
    private DoubleSidedNode<Type> next;

    public DoubleSidedNode(Type data) {
        this.data = data;
        this.setPrev(null);
        this.setNext(null);
    }

    public Type getData() {
        return data;
    }

    public void setData(Type data) {
        this.data = data;
    }

    public DoubleSidedNode<Type> getPrev() {
        return prev;
    }

    public void setPrev(DoubleSidedNode<Type> prev) {
        this.prev = prev;
    }

    public DoubleSidedNode<Type> getNext() {
        return next;
    }

    public void setNext(DoubleSidedNode<Type> next) {
        this.next = next;
    }
}
