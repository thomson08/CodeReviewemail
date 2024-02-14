import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/* SMTP Client-Server Program
*   program prompts  the user to get appropriate information 
*	(e.g. "From" address, "To" address, Subject, message body) 
*   and stores the information in variables.  

*   Once the program recieves all the information from the user,
*   program makes a TCP connection to the Chapman smtp.chapman.edu server on port 25, 
*   and transmits the message.  
*   Program Displays the commands that you send to the server and 
*   the responses from the server on your program's screen.
*   Closes the socket and exits.

*  author: Decker Mecham
*  Email:  dmecham@chapman.edu
*  Date:  2/12/2024
*  version: 1.5




*/


class Email {

    public static void main(String[] argv) {
    try {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.print("Enter the 'From' address: ");
            final String fromEmail = inFromUser.readLine();
            System.out.print("Enter the 'To' address: ");
            final String toEmail = inFromUser.readLine();
            System.out.print("Enter the 'From' user name: ");
            final String fromUserName = inFromUser.readLine();
            System.out.print("Enter the 'To' user name: ");
            final String toUserName = inFromUser.readLine();
            System.out.print("Enter the Subject: ");
            final String subject = inFromUser.readLine();
            
            System.out.println("Enter the message body (end with a single '.' on a line by itself): ");
            StringBuilder messageBody = new StringBuilder();
            String line;
     while (!(line = inFromUser.readLine()).equals(".")) {
     messageBody.append(line).append("\n");
            }

            // Connect to the SMTP server
     Socket clientSocket = new Socket("smtp.chapman.edu", 25);
     PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
     BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            
            // Read the welcome message from the server
     System.out.println("SERVER: " + inFromServer.readLine());
            
            // Send HELO command to the server
     sendCommand(outToServer, inFromServer, "HELO icd.chapman.edu");

            // Send MAIL FROM command
     sendCommand(outToServer, inFromServer, "MAIL FROM: " + fromEmail);

            // Send RCPT TO command
     sendCommand(outToServer, inFromServer, "RCPT TO: " + toEmail);

            // Send DATA command
     sendCommand(outToServer, inFromServer, "DATA");
            

     System.out.println("CLIENT: From: " + fromUserName);
     outToServer.println("From: " + fromUserName);

            System.out.println("CLIENT: To: " + toUserName);
            outToServer.println("To: " + toUserName );

            System.out.println("CLIENT: Subject: " + subject);
            outToServer.println("Subject: " + subject);

            outToServer.println(); // Send a blank line to separate headers from the body, this won't be visible in console

            // Print each line of the message body to the console before sending
            for (String bodyLine : messageBody.toString().split("\n")) {
                System.out.println("CLIENT: " + bodyLine);
                outToServer.println(bodyLine);
                                                                        }

            System.out.println("CLIENT: ."); // This line indicates the end of the email body to the SMTP server
            outToServer.println(".");
            System.out.println("SERVER: " + inFromServer.readLine());
            // Send QUIT command
            sendCommand(outToServer, inFromServer, "QUIT");
            
            // Close the socket
            clientSocket.close();
            System.out.println("Finished: SUCCESS");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void sendCommand(PrintWriter outToServer, BufferedReader inFromServer, String command) throws Exception {
   System.out.println("CLIENT: " + command);
   outToServer.println(command);
   System.out.println("SERVER: " + inFromServer.readLine());
 }
}
