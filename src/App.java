public class App {
    public static void main(String[] args) throws Exception {
        
        DoublyLinkedList dl1 = new DoublyLinkedList();
        DoublyLinkedList dl2 = new DoublyLinkedList();
        DoublyLinkedList dl3 = new DoublyLinkedList();

        Node n1 = new Node('A');
        Node n2 = new Node('B');
        Node n3 = new Node('C');
        Node n4 = new Node('D');
        Node n5 = new Node('E');
        Node n6 = new Node('F');
        Node n7 = new Node('G');
        Node n8 = new Node('G');
        Node n9 = new Node('F');
        
        
        dl1.add(n1);
        dl1.add(n2);
        dl1.add(n3);
        dl1.print(true);
        dl1.print(false);
        System.out.println("dl1 size: " + dl1.size());
        
        dl2.add(n4);
        dl2.add(n5);
        dl1.merge(dl2);
        dl1.print(true);
        dl1.print(false);
        System.out.println("dl1 size: " + dl1.size());
        System.out.println("N4 index: " + dl1.getIndex(n4));
        
        System.out.println("Slice");
        System.out.println(dl1.slice(2, 4));
        System.out.println(dl1.slice(4, 1));

        System.out.println("palindrome");
        dl3.add(n6);
        dl3.add(n7);
        dl3.add(n8);
        dl3.add(n9);
        
        System.out.println("Dl1 Palindrome? " + dl1.palindrome());
        System.out.println("Dl3 Palindrome? " + dl3.palindrome());

        System.out.println("shift");
        dl1.shift(1);
        dl1.print(true);

        System.out.println("trim");
        dl2.print(true);
        dl2.trim(8);
        dl2.print(true);
        dl2.trim(4);
        dl2.print(true);
        
        // and so on...
    }
}
