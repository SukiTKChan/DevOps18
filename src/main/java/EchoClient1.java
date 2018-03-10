import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This module contains the presentaton logic of an Echo Client.
 * @author M. L. Liu
 */
public class EchoClient1 {
   static final String endMessage = "";

   public static void main(String[] args) {
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);

      try {
         System.out.println("Welcome! Please enter username");
         String username = br.readLine();

         System.out.println("Please enter password");
         String password = br.readLine();

         String host = "localhost";
         String port = "7";
         String message,echo,response;

         EchoClientHelper1 helper = new EchoClientHelper1(host, port);
         echo = helper.login(username,password);

         boolean done = false;
		
         while (!done)
         {
            System.out.println("Type u to upload a file, d to download a file and q to logout");
            message = br.readLine( );
            if (message.equalsIgnoreCase("q"))
            {
               echo = helper.logout(endMessage);
               done = true;
               helper.done( );
            }

			else if(message.equalsIgnoreCase("u"))
			{
               System.out.println("Enter name of text file you want to upload");
               String fileName = br.readLine();
               echo = helper.upload(username,fileName);

			}

            else if(message.equalsIgnoreCase("d"))
            {
               System.out.println("Enter name of text file you want to download");
               String fileName = br.readLine();
               echo = helper.download(username,fileName);
            }

          } // end while

      } // end try
      catch (Exception ex) {
         ex.printStackTrace( );
      } // end catch
   } //end main
} // end class      
