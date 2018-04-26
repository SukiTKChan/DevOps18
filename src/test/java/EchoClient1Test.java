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
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String name = "suki";
        String password = "123456";
        try
        {



            System.out.print("Welcome! Please enter username");
            String fname = br.readLine();
            assertEquals(name,fname);


            System.out.print("Please enter password");
            String userPass = br.readLine();
            assertEquals(password,userPass);


        }
        catch (Exception e)
        {
            Assert.fail("Exception " + e);
        }
    }
}