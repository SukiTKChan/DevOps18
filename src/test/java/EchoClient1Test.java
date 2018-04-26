import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class EchoClient1Test
{    static final String endMessage = "";

    @Test
    public void main()throws Exception
    {
        try
        {
            String name = "suki";
            String password = "123456";


            assertEquals(name,"suki");
            assertEquals(password,"123456");
        }
        catch (Exception e)
        {
            Assert.fail("Exception " + e);
        }



    }
}