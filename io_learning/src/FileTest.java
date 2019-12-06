import org.junit.Test;

import java.io.File;

public class FileTest {
    @Test
    public void test1(){
        File file = new File("F:\\BitPractice\\Practice.sql/01.book.sql");
        System.out.println(file.exists());

    }

}
