import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class email {

    public static void main(String[] argv) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("From address: ");
        final String fromAddress = inFromUser.readLine();

        System.out.print("To address: ");
        final String toAddress = inFromUser.readLine();

        System.out.print("Subject: ");
        final String subject = inFromUser.readLine();

        System.out.println("Message body (end with a single '.' on a line by itself): ");
        StringBuilder messageBody = new StringBuilder();
        String line;
        while (!(line = inFromUser.readLine()).equals(".")) {
            messageBody.append(line).append("\n");
        }

        Socket clientSocket = null;
        try {
            clientSocket = new Socket("smtp.chapman.edu", 25);
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read welcome message from the server
            System.out.println("Server: " + inFromServer.readLine());

            // HELO command
            sendCommand(outToServer, inFromServer, "HELO smtp.chapman.edu");

            // MAIL FROM command
            sendCommand(outToServer, inFromServer, "MAIL FROM: " + fromAddress);

            // RCPT TO command
            sendCommand(outToServer, inFromServer, "RCPT TO: " + toAddress);

            // DATA command
            sendCommand(outToServer, inFromServer, "DATA");

            // Send email headers and body
            outToServer.println("From: " + fromAddress);
            outToServer.println("To: " + toAddress);
            outToServer.println("Subject: " + subject);
            outToServer.println(); // Separate header and body with a newline
            outToServer.println(messageBody.toString());
            outToServer.println(".");
            System.out.println("Server: " + inFromServer.readLine()); // Read server response for end of data

            // QUIT command
            sendCommand(outToServer, inFromServer, "QUIT");

            // Close the socket connection
            clientSocket.close();
            System.out.println("Email sent successfully.");
        } catch (Exception e) {
            System.out.println("Failed to open socket connection");
            System.exit(0);
        }
    }

    private static void sendCommand(PrintWriter outToServer, BufferedReader inFromServer, String command) throws Exception {
        System.out.println("Client: " + command);
        outToServer.println(command);
        System.out.println("Server: " + inFromServer.readLine());
    }
}
