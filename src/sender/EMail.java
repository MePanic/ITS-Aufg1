package sender;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EMail {

	public static void main(String[] args) {

		// Recipient's email ID needs to be mentioned.
//		String to = "berthold.wiblishauser@haw-hamburg.de";
		String to = "zappper@trash-mail.com";

		// Sender's email ID needs to be mentioned
		String from = "Donald.Duck@Disneyland.de";

		// Assuming you are sending email from localhost
//		String host = "localhost";
		String host = "haw-mailer.haw-hamburg.de";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("a", host);
		try {
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);
		
		String user = "abb664";
		String pw = "xxx";

		Transport transport = session.getTransport("smtp");
			
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			transport.connect(host,995,user,pw);
		    transport.sendMessage(message,message.getAllRecipients());
		    transport.close();
//			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
