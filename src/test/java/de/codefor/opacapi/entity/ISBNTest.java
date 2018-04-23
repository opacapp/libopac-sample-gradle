package de.codefor.opacapi.entity;

import de.codefor.opacapi.exception.InvalidISBN;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ISBNTest {

    @Test
    public void testISBN_3551551677_valid_10() {

        ISBN isbnUnderTest = new ISBN("3551551677");

        assertEquals(ISBN.ISBNType.ISBN_10, isbnUnderTest.type());
        assertTrue(isbnUnderTest.isValid());
        isbnUnderTest.checkValidity();
    }

    @Test
    public void testISBN_978_3551551672_valid_13() {

        ISBN isbnUnderTest = new ISBN("978-3551551672");

        assertEquals(ISBN.ISBNType.ISBN_13, isbnUnderTest.type());
        assertTrue(isbnUnderTest.isValid());
        isbnUnderTest.checkValidity();
    }

    @Test
    public void testISBN_3557771677_inalid_10() {

        ISBN isbnUnderTest = new ISBN("3557771677");

        assertEquals(ISBN.ISBNType.ISBN_10, isbnUnderTest.type());
        assertFalse(isbnUnderTest.isValid());
        assertThrows(InvalidISBN.class, isbnUnderTest::checkValidity);
    }

    @Test
    public void testISBN_978_3557771672_invalid_13() {

        ISBN isbnUnderTest = new ISBN("978-3557771672");

        assertEquals(ISBN.ISBNType.ISBN_13, isbnUnderTest.type());
        assertFalse(isbnUnderTest.isValid());
        assertThrows(InvalidISBN.class, isbnUnderTest::checkValidity);
    }

    @Test
    public void testISBN_9783866801929_valid_13() {

        ISBN isbnUnderTest = new ISBN("978-3-86680-192-9");

        assertEquals(ISBN.ISBNType.ISBN_13, isbnUnderTest.type());
        assertTrue(isbnUnderTest.isValid());
        isbnUnderTest.checkValidity();
    }

    @Test
    public void testISBN_123456789_invalid() {

        ISBN isbnUnderTest = new ISBN("123456789");

        assertEquals(ISBN.ISBNType.INVALID, isbnUnderTest.type());
        assertFalse(isbnUnderTest.isValid());
        assertThrows(InvalidISBN.class, isbnUnderTest::checkValidity);
    }

    @Test
    public void testISBN_123456789112_invalid() {

        ISBN isbnUnderTest = new ISBN("123456789112");

        assertEquals(ISBN.ISBNType.INVALID, isbnUnderTest.type());
        assertFalse(isbnUnderTest.isValid());
        assertThrows(InvalidISBN.class, isbnUnderTest::checkValidity);
    }

    @Test
    public void testISBN_12345678911114_invalid() {

        ISBN isbnUnderTest = new ISBN("12345678911114");

        assertEquals(ISBN.ISBNType.INVALID, isbnUnderTest.type());
        assertFalse(isbnUnderTest.isValid());
        assertThrows(InvalidISBN.class, isbnUnderTest::checkValidity);
    }


}
