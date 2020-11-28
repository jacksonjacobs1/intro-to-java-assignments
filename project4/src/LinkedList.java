import java.util.NoSuchElementException;
import java.util.Iterator;

/** the linked list class as an abstract data type */
public class LinkedList<T> implements Iterable {

    // the first node of the linked list
    private LLNode<T> firstNode;
    private LLNode<T> lastNode;
    /** Create an empty linked list */
    public LinkedList() {
        firstNode = null;
        lastNode = null;
    }

    /**
     * returns the first node of the list
     * @return the first node of the list
     */
    protected LLNode<T> getFirstNode() {
        return firstNode;
    }

    protected LLNode<T> getLastNode(){
        return lastNode;
    }

    /**
     * sets a new first node of the list
     * @param node the node that is now the start of the linked list
     */
    protected void setFirstNode(LLNode<T> node) {
        firstNode = node;
    }

    protected  void setLastNode(LLNode<T> node){
        lastNode = node;
    }
    /** Is the linked list empty?
     * @return true if the linked list is empty
     */
    public boolean isEmpty() {
        return getFirstNode() == null;
    }

    /** Add an element to the front of the linked list
     * @param element the element to add
     */
    public void addToFront(T element) {
        setFirstNode(new LLNode<T>(element, getFirstNode()));
    }

    public void addToBack(T element){
        getLastNode().setNext(new LLNode<>(element, null));
        setLastNode(getLastNode().getNext());
    }

    /** Remove the first element from the linked list
     * @return  thie first element of the list
     * @throws NoSuchElementException if the list is empty
     */
    public T removeFromFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        else {
            T save = getFirstNode().getElement();
            setFirstNode(getFirstNode().getNext());
            return save;
        }
    }

    /**
     * Return the number of elements stored in the linked list
     * @return the number of elements in the list
     */
    public int length() {
        LLNode<T> nodeptr = getFirstNode();
        int count = 0;   // count stores the number of nodes visited so far
        while (nodeptr != null) {
            nodeptr = nodeptr.getNext();
            count++;
        }
        return count;
    }

    /**
     * Print the contents of the linked list
     */
    public void printList() {
        LLNode<T> nodeptr = getFirstNode();
        while (nodeptr != null) {
            System.out.print(nodeptr.getElement() + " ");
            nodeptr = nodeptr.getNext();
        }
        System.out.println();
    }

    /**
     * Return an iterator for this linked list
     * @return an iterator for the list
     */
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(getFirstNode());
    }


    /**
     * Print the contents of the input linked list (a static method)
     * An example of a static method declaring a generic.
     * @param list a linked list
     */
    public static <S> void printList(LinkedList<S> list) {
        LLNode<S> nodeptr = list.getFirstNode();
        while (nodeptr != null) {
            System.out.print(nodeptr.getElement() + " ");
            nodeptr = nodeptr.getNext();
        }
        System.out.println();
    }

    /**
     * Print the contents of the input linked list (a static method)
     * An example of the generic type wildcard
     * @param list a linked list
     */
    public static void printList2(LinkedList<?> list) {
        LLNode<?> nodeptr = list.getFirstNode();
        while (nodeptr != null) {
            System.out.print(nodeptr.getElement() + " ");
            nodeptr = nodeptr.getNext();
        }
        System.out.println();
    }

    public class LinkedListIterator<T> implements Iterator<T>{
        private LLNode<T> nodeptr;

        public LinkedListIterator(LLNode<T> firstNode){
            nodeptr = firstNode;
        }

        public LLNode<T> getNodeptr(){
            return nodeptr;
        }
        public void setNodeptr(LLNode<T> nodeptr){
            this.nodeptr = nodeptr;
        }

        public boolean hasNext(){
            return getNodeptr() != null;
        }

        public T next(){
            T element = nodeptr.getElement();
            setNodeptr(getNodeptr().getNext());
            return element;
        }
    }

}