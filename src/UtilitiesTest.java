

import org.testng.annotations.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.testng.AssertJUnit.assertNull;

public class UtilitiesTest {

    public Utilities util;

    @org.junit.Before
    public void setup(){
        util = new Utilities();
    }

    @org.junit.Test
    public void everyNthChar() throws Exception{
        char[] arrayChar = new char[]{'h','e','l','l','o'};
        char[] result = util.everyNthChar(arrayChar,2);
        char[] result2 = util.everyNthChar(arrayChar,8);
        assertArrayEquals(new char[]{'e','l'},result);
        assertArrayEquals(new char[]{'h','e','l','l','o'},result2);
    }

    @org.junit.Test
    public void removePairs_pairRemoved() throws Exception{
        String word = "AABCDDEFF";
        String result = util.removePairs(word);
        assertEquals("ABCDEF",result);
    }

    @org.junit.Test
    public void removePairs_pairRemovedOther() throws Exception{
        String word = "ABCCABDEEF";
        String result = util.removePairs(word);
        assertEquals("ABCABDEF",result);
        assertNull(util.removePairs(null));
        assertEquals("A",util.removePairs("A"));
        assertEquals("",util.removePairs(""));
    }

    @org.junit.Test
    public void converter() throws Exception{
        int a =10;
        int b =5;
        int result = util.converter(a,b);
        assertEquals(300,result);
    }

    @org.junit.Test(expected=ArithmeticException.class)
    public void converter_divideByZero() throws Exception{
        int a =10;
        int b =0;
        int result = util.converter(a,b);
        fail("Should have throw ArithmeticException");
    }

    @org.junit.Test
    public void nullIfOddLength_even() throws Exception{
        String result = util.nullIfOddLength("Tomasz");
        assertEquals(String.class,result.getClass());
    }

    @org.junit.Test
    public void nullIfOddLength_odd() throws Exception{
        String result = util.nullIfOddLength("Tomek");
        assertNull(result);
    }
}