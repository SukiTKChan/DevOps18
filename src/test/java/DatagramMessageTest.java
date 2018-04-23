import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.net.InetAddress;

import static org.junit.Assert.*;
//comment
public class DatagramMessageTest
{
    private DatagramMessage dm = new DatagramMessage();

    @Test
    public void putVal() throws Exception
    {

        String msg = "Hi";
        InetAddress add = InetAddress.getByName("localhost");
        int port =7;
        dm.putVal(msg,add,port);

    }

    @Test
    public void getMessage()
    {
        String msg = "Hi";
        dm.setMessage(msg);

        assertEquals(msg,dm.getMessage());
    }

    @Test
    public void getAddress() throws Exception
    {
        InetAddress add = InetAddress.getByName("localhost") ;
        dm.setAddress(add);
        assertEquals(add, dm.getAddress());
    }

    @Test
    public void getPort()
    {
        int port = 7;
        dm.setPort(port);
        assertEquals(port,dm.getPort());
    }
}