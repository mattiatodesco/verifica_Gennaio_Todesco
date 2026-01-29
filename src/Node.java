public class Node {
    private char letter;
    private Node prev;
    private Node next;

    public Node(char newLetter) {
        
        this.letter = newLetter;
        this.next = null;
        this.prev = null;
    }

    public char getLetter() {
        return letter;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setLetter(char newLetter) {
        this.letter = newLetter;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "{" + letter + "}";
    }

    // checks what happens when equals() is called
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) return false;
        
        if (this == obj) return true;

        if (getClass() != obj.getClass()) return false;

        Node n = (Node)obj;
        if (letter != n.getLetter()) return false;

        return true;
    }
}

    