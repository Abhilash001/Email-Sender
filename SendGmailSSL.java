/*
* Author: Abhilash Misra 
* Version: v1.0
* 
* Created: Thursday, August 11, 2016, ‏‎7:02:03 PM
* Copyright (C) 2016 under the GNU General Public License. All rights reserved.
* 
*/

import java.io.*;
import java.util.Scanner;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendGmailSSL
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your email id(username@gmail.com): ");
		final String from = sc.next();
		System.out.print("\nEnter password: ");
		String pass1 = sc.next();
		final String pass2 = pass1;
		boolean password_wrong;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		System.out.println("\nAuthenticating. Please wait.....");
		Session session = Session.getDefaultInstance(props, 
		new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(from, pass2);
			}
		});
		do
		{
			final String pass = pass1;
			password_wrong = false;
			Transport transport;
			try
			{
				transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", from, pass);
				transport.close();
			}
			catch(AuthenticationFailedException e)
			{
				password_wrong = true;
				System.out.print("Authentication failed. Please enter another password: ");
				pass1 = sc.next();
				final String pass3 = pass1;
				System.out.println("\nAuthenticating. Please wait.....");
				session = Session.getDefaultInstance(props, 
				new javax.mail.Authenticator()
				{
					protected PasswordAuthentication getPasswordAuthentication()
					{
						return new PasswordAuthentication(from, pass3);
					}
				});
			}
			catch(NoSuchProviderException e2){}
			catch (MessagingException e3){}
		}while(password_wrong);

		try
		{
			System.out.println("\nAuthentication successfull.");
			System.out.print("\nEnter recipient's email id(username@domain.com): ");
			String to = sc.next();
			System.out.print("\nEnter subject of email: ");
			String subject = br.readLine();
			System.out.println("\nEnter message text: ");
			String mtext = br.readLine();
			System.out.println("\nSending message. Please wait....");
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			message.setSubject(subject);
			message.setText(mtext);

			Transport.send(message);
			System.out.println("Message sent successfully.");
		}
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
}