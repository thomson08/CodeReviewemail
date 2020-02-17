# email
This repository contans a TcpServer.java program and a TcpClient.java program.
These programs are similar to the original TCP client and server programs except that 
+ the client waits for a Welcome message from the server before sending anything to the server and
+ the client will send two sentences to the server instead of just one.

Use the TcpClient.java program as a starting point for the Email.java program that you will create for the email assignment.

In the Email.java pogram, 
+ you will collect information from the user to send an email message, 
+ then (and only then!) send the message by  connecting to the smtp.chapman.edu server and transmit the message.  

Your program shuld display all the SMTP commands that you send to the server and all the responses that you receive from the server.

Edit the email.input file, replacing "username" with your username and 'Screen1" and 'Screen2' with the names of yoru test sender and receiver.

Create a Jenkins job for the project following the assignmemt instructions.

For full credit, your program Must 
+ include appropriate documentation 
+ be capable of sending messages with multiple lines 
+ handle the email.input file properly
    - i.e run properly whe exexuted as "java Email < email.input"
+ pass checkstyle review. 
+ pass the Jenkins build.
