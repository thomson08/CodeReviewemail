# email
This respository contans a TCPServer.java program and a TCPClient.java program.
These programs are similar to the UDP client and server programs except that the client will send two sentences to the server instead of just one.
This is to demonstrate how you can re-use a TCP socket and send multiple messages over teh same socket connection instead of creating a new socket coneection for eash message as you do with UCP.
Use the TCPClient.jva program as a starting point for the Email.java program that you will create for the email assignment.

In the Email.java pogram, you will collect the infotmation from the user to send an email message by using the smpt.chapman.edu email server and then (and only then!) connect to the server and transmit the messaage.  Your program shuld display all the SMTP commands that you send to the server and all the responses that you receive from the server.

For full credit, your program Must include appropriate documentation and must be capable of sending messages with multiple lines.  
