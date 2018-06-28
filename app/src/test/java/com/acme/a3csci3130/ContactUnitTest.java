package com.acme.a3csci3130;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ContactUnitTest {

    private static Contact contact;
    @Before
    public void setup() {
        contact = new Contact("LG0nQ9fmpqmCqIFN8Sh", "Dave", "dave@test.com");
    }

    @Test
    public void createNewContact() {
        assertEquals(contact.uid, "LG0nQ9fmpqmCqIFN8Sh");
        assertEquals(contact.name, "Dave");
        assertEquals(contact.email, "dave@test.com");
    }

    @Test
    public void mapContact() {
        HashMap<String, Object> result = new HashMap();
        result.put("uid", contact.uid);
        result.put("name", contact.name);
        result.put("email", contact.email);
        assertEquals(result.size(), contact.toMap().size());
        assertEquals(result.get("uid"), contact.toMap().get("uid"));
        assertEquals(result.get("name"), contact.toMap().get("name"));
        assertEquals(result.get("email"), contact.toMap().get("email"));
    }
}