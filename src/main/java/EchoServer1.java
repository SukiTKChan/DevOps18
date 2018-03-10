import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.net.Socket;
import java.net.*;
import java.nio.file.Paths;


/**
 * This module contains the application logic of an echo server
 * which uses a connectionless datagram socket for interprocess 
 * communication.
 * A command-line argument is required to specify the server port.
 * @author M. L. Liu
 */

public class EchoServer1 {
    public static void main(String[] args) {
        int serverPort = 7;    // default port

        String response = "";
        if (args.length == 1 )
            serverPort = Integer.parseInt(args[0]);

        try {
            // instantiates a datagram socket for both sending
            // and receiving data
            MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort);
            System.out.println("Echo server ready.");
            while (true) {  // forever loop
                DatagramMessage request =
                        mySocket.receiveMessageAndSender();
                System.out.println("Request received");
                String message = request.getMessage();
                System.out.println("Message received: "+ message);

                //get the first 3 character of message
                String strMsg = message.substring(0,3);
                //System.out.println(strMsg);

                //find out what message is used
                if(strMsg.contains("100"))
                {
                    String getMsg = message;

                    //find first - from message
					String[] parts = getMsg.split("-");

					//split message into three parts
					String codePart = parts[0];
					String usernamePart = parts[1];
					String passwordPart = parts[2];

					//creating folder with name of user in C drive under C://DCFileMGTSystem/Users directory
                    File file = new File("C://DCFileMGTSystem/Users/" + usernamePart);

                    boolean created =false;
					
					//check if a folder exist for user
                    if(!file.exists()&& !file.isDirectory())
                    {
						try{
                            System.out.println("101...Login Successful");
                            file.mkdirs();
                            created=true;
						}
						catch(Exception e){
                            System.out.println("102...Login Failed");
							e.printStackTrace();
						}
                    }
                    
                }

                else if(strMsg.contains("200"))
                {
                    System.out.println("101...Logout Successful");
                }
				else if(strMsg.contains("300"))
                {
                    String getMsg = message;
                    //find first - from message
                    String[] parts = getMsg.split("-");

                    //split message into three parts
                    String codePart = parts[0];
                    String usernamePart = parts[1];
                    String fileNamePart = parts[2];

                    try {

                        String uploadParts = parts[2];
                        FileOutputStream fos = new FileOutputStream("C:\\DCFileMGTSystem\\Users\\" + usernamePart + "\\" + fileNamePart);
                        fos.write(uploadParts.getBytes());
                        fos.close();

                        System.out.println("101 Upload successfully");

                    }catch(Exception e){
                        System.out.println("102 Upload Failed");
                        e.printStackTrace();
                    }
                }
                if(strMsg.contains("400"))
                {
                    try {
                        String getMsg = message;
                        //find first - from message
                        String[] parts = getMsg.split("-");

                        //split message into three parts
                        String codePart = parts[0];
                        String usernamePart = parts[1];
                        String fileNamePart = parts[2];

                        String downloadPath = "C:\\DCFileMGTSystem\\users\\" + usernamePart + "\\" + fileNamePart;
                        Path path = Paths.get(downloadPath);
                        byte[] data = Files.readAllBytes(path);
                        String byteDataString = new String(data);

                        System.out.println("101...Download Successful");
                    }catch(Exception e)
                    {
                        System.out.println("102 Download Failed");
                        e.printStackTrace();
                    }
                }

                mySocket.sendMessage(request.getAddress( ),
                        request.getPort( ), message);
            } //end while
        } // end try
        catch (Exception ex) {
            ex.printStackTrace( );
        } // end catch
    } //end main
} // end class