public class DoublyLinkedList {
    
    private Node head, tail;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }

    /**
     * Adds a node at the end of the list
     * @param newNode new node to be added
     */
    public void add(Node newNode) {
        if (head == null && tail == null) {
            head = tail = newNode;
        }
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    // wrapper
    private Node getRec(Node cursor, int index) {

        if (index == 0)
            return cursor;

        return getRec(cursor.getNext(), index-1);
    }

    /**
     * Gets the element in the specified position
     * @param index position to read
     * @return the element identified by the index
     * @throws IndexOutOfBoundsException
     */
    public Node get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");

        return getRec(head, index);
    }

    // ------------ INSERT YOUR CODE HERE ----------------

    /**
     * Ritorna l'indice di un nodo nella lista
     * @param n Nodo da trovare
     * @return Valore dell'indice nella lista, se non è presente -1
     */
    public int getIndex(Node n){
        // Inizializzo l'indice e il cursore
        int idx = -1;
        Node cursor = this.head;
        // Ciclo finché non trovo la corrispondenza o fino alla fine della lista
        while (cursor != null && cursor != n){
            // Incremento l'indice e prendo il nodo successivo
            idx++;
            cursor = cursor.getNext();
        }
        return idx;
    }

    /**
     * Stampa la lista
     * @param forward Variabile che controlla se andare dall'inizio alla fine (true), o dalla fine all'inizio (false)
     */
    public void print(boolean forward) {
        System.out.print('[');
        // Parto dalla testa o dalla coda in base al verso
        if (forward)
            printRec(this.head, forward);
        else 
            printRec(this.tail, forward);
        System.out.println(']');

    }

    //Wrapper
    private void printRec(Node cursor, boolean forward){
        // alla fine della lista esco dalla ricorsione
        if (cursor == null)
            return;

        // Se sto stampando l'ultimo valore della lista non metto la virgola, altrimenti sì
        if (forward && cursor.getNext() == null || !forward && cursor.getPrev() == null)
            System.out.print(cursor.getLetter());
        else
            System.out.print(cursor.getLetter() + ", ");

        // Stampo il successivo se vado in avanti, altrimenti stampo il precedente
        if (forward)
            printRec(cursor.getNext(), forward);
        else    
            printRec(cursor.getPrev(), forward);

                 
    }

    /**
     * Metodo per la dimensione della lista
     * @return Dimensione della lista
     */
    public int size() {
        // Inizializzo il cursore e la dimensione
        Node cursor = this.head;
        int sz = 0;
        // Ciclo fino alla fine 
        while (cursor != null){
            // incremento e prendo il successivo
            sz++;
            cursor = cursor.getNext();
        }
        return sz;
    }

    public void merge(DoublyLinkedList otherList) {
        // Se l'altra lista è vuota non faccio nulla
        if (otherList.getHead() == null)
            return;
        // Prendo la coda della mia lista e imposto la testa della lista da attaccare come successivo
        this.tail.setNext(otherList.getHead());
        // Imposto la coda della lista come precedente della testa della lista attaccata
        otherList.getHead().setPrev(this.tail);
        // sposto la coda
        this.tail = otherList.getTail();
    }

    public String slice(int start, int end) throws IndexOutOfBoundsException{
        // controllo indice
        if (start < 0 || start >= size() || end < 0 || end >= size())
            throw new IndexOutOfBoundsException("Invalid index");

        // inizializzo stringa
        String sliced = "";

        //ciclo finche i due nodi sono gli stessi
        while (start != end){
            // Inserisco la lettera del nodo nella stringa
            sliced += get(start).getLetter();
            // vado avanti o indietro se l'inizio è maggiore o minore della fine
            if (start < end)
                start++;
            else 
                start--;
        }
        
        return sliced;
    }

    // I'm recursive!
    public boolean palindrome() {
        return recPalindrome(this.head, this.tail);
    }

    private boolean recPalindrome(Node left, Node right){
        // Quando i nodi controllati si superano è palindroma
        if (getIndex(left) >= getIndex(right))
            return true;

        // Se sono uguali continuo il controllo, altrimenti no e torno falso
        if (left.getLetter() == right.getLetter())
            return recPalindrome(left.getNext(), right.getPrev());
        else 
            return false;
    }

    public void shift(int amount) {
        // Calcolo il numero di posizioni da spostare anche se il valore è maggiore della dimensione,
        // uso size() prima di chiudere la lista, altrimenti sta sempre in loop
        amount = amount % size();

        // "Chiudo" la lista per semplificare la modifica di head e tail
        this.head.setPrev(this.tail);
        this.tail.setNext(this.head);

        //Inizializzo cursore e ciclo finché mi sposto di amount posizioni
        Node cursor = this.head;
        for (int i = 0; i < amount; i++) {
            cursor = cursor.getNext();
        }
        // Imposto nuova testa e coda
        this.head = cursor;
        this.tail = cursor.getPrev();
        // "apro" la lista
        this.head.setPrev(null);
        this.tail.setNext(null);
    }

    public void trim(int newSize) {
        // Controlla cosa deve fare
        if (newSize < size()){
            //taglio la lista
            this.tail = get(newSize -1);
            this.tail.setNext(null);
        } else {
            // aggiungo nodi finché raggiungo la dimensione desiderata
            for (int i = size(); i < newSize; i++) {
                Node toadd = new Node(nextAscii(this.tail.getLetter()));
                this.add(toadd);
            }
        }

    } 

    private char nextAscii(char ch){
        // Prende il valore ascii successivo
        int asciival = (int)ch;
        if (asciival == 90)
            asciival = 65;
        else
            asciival++;

        return (char)asciival;
    }

    
}
