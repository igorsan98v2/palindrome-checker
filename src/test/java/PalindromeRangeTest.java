import com.ygs.palindrome.PalindromeRange;
import org.junit.Test;
import static org.junit.Assert.*;
public class PalindromeRangeTest {
    @Test
    public void easyRange(){
        PalindromeRange palindromeRange = new PalindromeRange("1",20);
        String[] excepted ={"1","2","3","4","5","6","7","8","9"
                ,"11","22","33","44","55","66","77","88","99",
                "101","111"};

        assertArrayEquals (excepted,palindromeRange.getPalindromes());
    }
}
