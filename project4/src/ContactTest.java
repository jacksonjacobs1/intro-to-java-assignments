import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {
    @Test
    public void testAllGettersAndSetters(){
        Contact c1 = new Contact(null,null,null);
        c1.setName("Jackson");
        c1.setPhoneNum("1234");
        c1.setEmail("asdf");
        assertEquals("Get name", "Jackson", c1.getName());
        assertEquals("Get phone number", "1234", c1.getPhoneNum());
        assertEquals("Get email", "asdf", c1.getEmail());
    }

    @Test
    public void testToString(){
        Contact c1 = new Contact(null, null, null);
        assertEquals("Empty contact", "Name: null, Number: null, Email: null", c1.toString());
        c1 = new Contact("Jackson", "1234", "asdf");
        assertEquals("Filled contact", "Name: Jackson, Number: 1234, Email: asdf", c1.toString());

    }

    @Test
    public void testEquals(){
        Contact c1 = new Contact("Jackson", "1234", "asdf");
        Contact c2 = new Contact("Jackson", "1234", "asdf");
        Contact c3 = new Contact("asasdf", "3456", "asdf");
        assertTrue("Two equal contacts", c1.equals(c2));
        assertFalse("two unequal contacts", c2.equals(c3));
    }

    @Test
    public void testGetComparatorByTrait(){
        Contact c1 = new Contact("Jackson", "1234", "asdf");
        assertTrue("Get name comparator", c1.getComparatorByTrait("name") instanceof Contact.NameComparator);
        assertTrue("Get number comparator", c1.getComparatorByTrait("phone") instanceof Contact.PhoneNumberComparator);
        assertTrue("Get email comparator", c1.getComparatorByTrait("email") instanceof Contact.EmailComparator);
    }
}