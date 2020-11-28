import java.util.*;
import java.util.Collections;

/**
 * @author Jackson Jacobs
 * Type acts as a linkedList in order to store data
 * */
public class Database<T extends DatabaseType> {
    private LLNode<T> node;
    private LLNode<T> lastNode;
    private Hashtable<String, ArrayList<T>> hashtable = null;
    private int numElements = 0;

    /**
     * Constructor for Database type.
     **/
    public Database(){
    }

    /**
     * Getter method for node field.
     * @return the node
     **/
    public LLNode<T> getNode(){
        return node;
    }
    /**
     * Setter method for field node.
     * @param node the new first node in the database.
     **/
    protected void setNode(LLNode<T> node){
        this.node = node;
    }
    /**
     * Getter method for the hashtable field.
     * @return the hashtable.
     **/
    public Hashtable<String, ArrayList<T>> getHashtable(){
        return this.hashtable;
    }
    /**
     * Setter method for the hashtable field.
     * @param hashtable the new hashtable
     **/
    public void setHashtable(Hashtable<String, ArrayList<T>> hashtable){
        this.hashtable = hashtable;
    }
    /**
     * Getter method for the last node in the database.
     * @return the last node.
     **/
    public LLNode<T> getLastNode(){
        return this.lastNode;
    }
    /**
     * Setter method for the last node in the database.
     * @param lastNode the new last node.
     **/
    protected void setLastNode(LLNode<T> lastNode){
        this.lastNode = lastNode;
    }
    /**
     * Getter method for numElements.
     * @return the number of elements in the database.
     **/
    public int size(){
        return numElements;
    }
    /**
     * Setter method for numElements.
     * @param newNumber the new number of elements.*/
    public void setNumElements(int newNumber){
        this.numElements = newNumber;
    }

    /**
     * Adds a node to the last item in the linked list.
     * @param element the element to add.
     **/
    public void add(T element){
        setHashtable(null);
        getLastNode().setNext(new LLNode<>(element,null));
        setLastNode(getLastNode().getNext());
    }

    /**
     * Deletes all instances of the given element from the list.
     * @param element the element to target in the linked list.
     **/
    public void delete(T element){
        LLNode<T> nodeptr = getNode();
        setHashtable(null);
        if(nodeptr.getElement().equals(element)){
            setNode(getNode().getNext());
        }
        while(nodeptr.getNext() != null){
            if(nodeptr.getNext().getElement() == element){
                nodeptr.setNext(nodeptr.getNext().getNext());
                nodeptr = nodeptr.getNext();
                setNumElements(size() - 1);
            }
        }
    }

    /**
     * Compiles a list of all instances of a target in the database.
     * @param element the target.
     * @param comparator the method of comparing the two objects.
     * @return the linked list of all found instances.
     **/
    public LinkedList<T> lookupInList(T element, Comparator<T> comparator){
        LLNode<T> nodeptr = getNode();
        LinkedList<T> output = new LinkedList<>();
        while(nodeptr.getNext() != null){
            if(comparator.compare(element, nodeptr.getElement()) == 0){
                output.addToBack(nodeptr.getElement());
            }
            nodeptr = nodeptr.getNext();
        }
        return output;
    }

    /**
     * Quickly checks for the existence of a particular target element, then adds all instances of the element
     * to a linked list.
     * @param value the target element.
     * @param index the ArrayList to be searched through.
     * @param comparator the means of comparing value to various elements.
     **/
    public LinkedList<T> lookupInIndex(T value, ArrayList<T> index, Comparator<T> comparator){
        LinkedList<T> output = new LinkedList<>();
        if(!(Collections.binarySearch(index, value, comparator) < 0)){
            for (T element : index) {
                if (comparator.compare(value, element) == 0) {
                    output.addToBack(element);
                }
            }
        }
        return output;
    }

    /**
     * */
    public void makeIndex(String trait){
        if(getNode() != null){
            ArrayList<T> arrayList = new ArrayList<>();
            LLNode<T> nodeptr = getNode();
            Comparator<T> currentComparator = getNode().getElement().getComparatorByTrait(trait);
            for(int i = 0; i < size(); i++){
                arrayList.add(i, nodeptr.getElement());
                nodeptr = nodeptr.getNext();
            }
            arrayList.sort(currentComparator);
            /*Hashtable<String, ArrayList<T>> table = new Hashtable<>(size());
            table.entrySet();*/
        }
    }

    public LinkedList<T> lookup(String trait, T value){
        if(getHashtable().get(trait) != null){
            return lookupInIndex(value, getHashtable().get(trait), value.getComparatorByTrait(trait));
        }
        else{
            return lookupInList(value, value.getComparatorByTrait(trait));
        }
    }

    public ArrayList<T> getList(String trait){
        if(getHashtable().get(trait) == null){
            makeIndex(trait);
        }
        return getHashtable().get(trait);
    }

}
