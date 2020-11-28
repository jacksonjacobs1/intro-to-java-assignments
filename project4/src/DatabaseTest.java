import org.junit.Test;

import java.util.ArrayList;
import java.util.Hashtable;

import static org.junit.Assert.*;

public class DatabaseTest {
    @Test
    public void testAllGettersAndSetters(){
        Database<Contact> db1 = new Database<>();
        db1.setNode(new LLNode<Contact>(new Contact("jackson", "917917917", "asd"), null));
        Hashtable<String, ArrayList<Contact>> hashtable1 = new Hashtable<>();
        db1.setHashtable(hashtable1);
        db1.setLastNode(db1.getNode());
        db1.setNumElements(1);
        assertEquals("Node getter and setter", "jackson", db1.getNode().getElement().getName());
        assertEquals("Last node getter and setter", "jackson", db1.getLastNode().getElement().getName());
        assertEquals("Hashtable getter and setter", hashtable1, db1.getHashtable());
        assertEquals("NumElements getter and setter", 1, db1.size());
    }

    @Test
    public void testAdd(){
        Database<Contact> db2 = new Database<>();
        db2.setNode(new LLNode<Contact>(new Contact("jackson", "917917917", "asd"), null));
        db2.setLastNode(db2.getNode());
        db2.add(new Contact("bleh","34563647", "memeail"));
        Contact compareContact = new Contact("bleh", "34563647", "memeail");
        assertTrue("Added contact, also testing .equals()", db2.getLastNode().getElement().equals(compareContact));
        db2.add(new Contact("jeff", "3456", "dfgh"));
        assertFalse("added contact, test setting the last node", db2.getLastNode().getElement().equals(compareContact));

    }

    @Test
    public void testDelete(){
        Database<Contact> db3 = new Database<>();
        Contact c1 = new Contact("jackson", "917917917", "asd");
        db3.setNode(new LLNode<>(c1, null));
        db3.setLastNode(db3.getNode());
        db3.delete(c1);
        assertEquals("On a single element array",null, db3.getLastNode().getElement());
        Contact c2 = new Contact("emma", "2345", "bleh");
        db3.add(c1);
        db3.add(c2);
        db3.delete(c1);
        assertTrue("On an array with two elements", c2.equals(db3.getNode().getElement()));
    }

    @Test
    public void testLookupInList(){
        Database<Contact> db4 = new Database<>();
        Contact c1 = new Contact("jackson", "917917917", "asd");
        Contact c2 = new Contact("emma", "223452", "sdfg");

        db4.setNode(new LLNode<>(c1, null));
        db4.setLastNode(db4.getNode());

        assertEquals("single element", "", db4.lookupInList(c1, c1.getComparatorByTrait("name")).getFirstNode().getElement().toString());
        db4.add(c2);
        assertEquals("multiple element database", null, db4.lookupInList(c2, c1.getComparatorByTrait("name")).getFirstNode().getElement().toString());
    }

    @Test
    public void testLookupInIndex(){
        Database<Contact> db3 = new Database<>();
        Contact c1 = new Contact("jackson", "917917917", "asd");
        db3.setNode(new LLNode<>(c1, null));
        db3.setLastNode(db3.getNode());
    }

    @Test
    public void testMakeIndex(){
        Database<Contact> db3 = new Database<>();
        Contact c1 = new Contact("jackson", "917917917", "asd");
        db3.setNode(new LLNode<>(c1, null));
        db3.setLastNode(db3.getNode());
    }

    @Test
    public void lookup(){
        Database<Contact> db3 = new Database<>();
        Contact c1 = new Contact("jackson", "917917917", "asd");
        db3.setNode(new LLNode<>(c1, null));
        db3.setLastNode(db3.getNode());
    }

    @Test
    public void getList(){
        Database<Contact> db3 = new Database<>();
        Contact c1 = new Contact("jackson", "917917917", "asd");
        db3.setNode(new LLNode<>(c1, null));
        db3.setLastNode(db3.getNode());
    }
}