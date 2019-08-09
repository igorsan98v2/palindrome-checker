import com.ygs.palindrome.PalindromeFinder;
import com.ygs.palindrome.PalindromeRange;
import org.junit.Test;

import static org.junit.Assert.*;
public class PolindromeFeatures {

    @Test
    public void isPolindromeEven(){
        PalindromeFinder palindrome = new PalindromeFinder("301103");
        PalindromeFinder notPalindrome  = new PalindromeFinder("112333");

        assertEquals(true,palindrome.isPalindrome());
        assertEquals(false,notPalindrome.isPalindrome());
    }
    @Test
    public void isPolindromeOdd(){
        PalindromeFinder palindrome = new PalindromeFinder("3010103");
        PalindromeFinder notPalindrome  = new PalindromeFinder("1120333");
        PalindromeFinder oneDigit = new PalindromeFinder("1");
        assertEquals(true,palindrome.isPalindrome());
        assertEquals(false,notPalindrome.isPalindrome());
        assertEquals(true,oneDigit.isPalindrome());
    }
    @Test
    public void containOnly9s(){
        PalindromeFinder palindrome = new PalindromeFinder("999");
        assertEquals(true,palindrome.all9Case());
        PalindromeFinder notNineOnly = new PalindromeFinder("919");
        assertEquals(false,notNineOnly.all9Case());
    }
    @Test
    public void containOnlyOneDigit(){
        PalindromeFinder palindrome = new PalindromeFinder("7");
        assertEquals("8",palindrome.getNearnest());
    }
    @Test
    public void easyPoli(){
        PalindromeFinder palindromeFinder = new PalindromeFinder("1");
        assertEquals("1",palindromeFinder.getNearnest());
        palindromeFinder= new PalindromeFinder("11");
        assertEquals(null,palindromeFinder.getNearnest());
        palindromeFinder = new PalindromeFinder("999");
        assertEquals("1001",palindromeFinder.getNearnest());
    }

}
