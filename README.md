# email
This repository contains a TcpServer.java program and a TcpClient.java program.
These programs are similar to the original TCP client and server programs except that
+ the client will send two sentences to the server instead of just one, as you were asked to do in the Programming Assignment 0.

Use the TcpClient.java program as a starting point for the Email.java program that you will create for the email assignment by copying the TcpClient.java file to a file named Email.java

In the Email.java program,
+ you will collect information from the user to send an email message,
+ then (and only then!) send the message by  connecting to the smtp.chapman.edu server and transmit the message.  

Your program should display all the SMTP commands that you send to the server and all the responses that you receive from the server.

Before testing your program, make sure it passes checkstyle audit.

To test your program, edit the email.input file and replace
+ "sender_email_address" with "username@chapman.edu" wehre "username" is your actual username
+ "receiver_email_address" with your email sender_email_address
+ "sender_name" with your name
+ "receiver_name" with a different version of your name

Run the program with the test input by typing

java Email < email.input

Create a Jenkins job for the project following the assignment instructions.

For full credit, your program Must
+ include appropriate documentation
+ be capable of sending messages with multiple lines
+ handle the email.input file properly
    - i.e. run properly when executed as "java Email < email.input"
+ pass checkstyle review.
+ pass the Jenkins build.

Edit the text above so that it describes your Email program rather than the assignment
Edit the text below as appropriate.

## Identifying Information

* Name: 
* Student ID:
* Email: 
* Course: 
* Assignment: 

## Source Files

* 

## References

* 

## Known Errors

*

## Build Insructions

* 

## Execution Instructions

*
