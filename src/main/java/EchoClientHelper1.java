import java.net.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is a module which provides the application logic
 * for an Echo client using connectionless datagram socket.
 * @author M. L. Liu
 */
public class EchoClientHelper1 {
   private MyClientDatagramSocket mySocket;
   private InetAddress serverHost;
   private int serverPort;


   EchoClientHelper1(String hostName, String portNum)
      throws SocketException, UnknownHostException { 
  	   this.serverHost = InetAddress.getByName(hostName);
  		this.serverPort = Integer.parseInt(portNum);

      // instantiates a datagram socket for both sending
      // and receiving data
   	this.mySocket = new MyClientDatagramSocket(); 
   } 
	
   public String login(String username, String password)
      throws SocketException, IOException {                                                                                 
      String msg = "100...Login" + "-" + username + "-" + password;
      //send to server
      mySocket.sendMessage( serverHost, serverPort,msg);
	   // now receive the echo
      msg= mySocket.receiveMessage();
      return msg;
   } //end login

   public String logout(String q)
           throws SocketException, IOException {
      String msg = "200...Logout" + q;
      //send to server
      mySocket.sendMessage( serverHost, serverPort,msg);
      // now receive the echo
      msg= mySocket.receiveMessage();
      return msg;
   } //end logout
   
    public String upload(String username,String fileName)
      throws SocketException, IOException {
       String serverPath = "C:\\DCFileMGTSystem\\";
       Path path = Paths.get(serverPath + fileName);
       byte[] data = Files.readAllBytes(path);
       String byteDataString = new String(data);

       String msg = "300...Upload" + "-" + username + "-" + fileName + "-" + byteDataString ;
      //send to server
       mySocket.sendMessage( serverHost, serverPort,msg);
	   // now receive the echo
       msg= mySocket.receiveMessage();
       return msg;
   } //end upload
   
   public String download(String username, String fileName)
      throws SocketException, IOException {
      String msg = "400...Download" + "-" + username + "-" + fileName;
      FileOutputStream fos = new FileOutputStream("C:\\DCFileMGTSystem\\" + fileName);
      fos.write(msg.getBytes());
      fos.close();
      //send to server
      mySocket.sendMessage( serverHost, serverPort,msg);
	   // now receive the echo
      msg= mySocket.receiveMessage();
      return msg;
   } //end download

   public void done( ) throws SocketException {
      System.out.println("Exit program");
      mySocket.close( );
   }  //end done

   public void createFolder(String username) throws IOException
   {
	  /*

      File createDirectory;
      if (createDirectory.exists() && createDirectory.isDirectory())
      {
         System.out.println("101...Login Successful");
      }
	  else
	  {
		  createDirectory = new File(path+username).mkdir();
		
		  System.out.println("101...Login Successful");
	  }*/

   }

} //end class
