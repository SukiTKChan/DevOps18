import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import static org.junit.Assert.*;

public class MyClientDatagramSocketTest
{
    private MyClientDatagramSocket mdm = new MyClientDatagramSocket();
    DatagramMessage dm = new DatagramMessage();

    public MyClientDatagramSocketTest() throws SocketException {
    }

    @Test
    public void sendMessage() throws Exception
    {
        InetAddress recieverHost = InetAddress.getByName("localhost");
        int port = 7;
        String msg = "hi";
        mdm.sendMessage(recieverHost,port,msg);

    }

    /*@Test
    public void receiveMessage() throws IOException
    {


    }*/
}