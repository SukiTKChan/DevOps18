import org.junit.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

import static org.junit.Assert.*;



public class EchoClient1Test
{   private final ByteArrayOutputStream outputName = new ByteArrayOutputStream();
    //private final ByteArrayOutputStream outputPassword = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputName));
        //System.setOut(new PrintStream(outputPassword));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void main()throws Exception
    {

        try
        {
            String name = "suki";
            System.out.print("suki");
            assertEquals(name,outputName.toString());

        }
        catch (Exception e)
        {
            Assert.fail("Exception " + e);
        }

    }
}