/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_remote;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Properties;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPasswordField;


/**
 *
 * @author arn
 */
public class SendMailTLS extends JFrame implements ActionListener {
    JPanel panel=new JPanel();
    
    JLabel hour_label=new JLabel(" your mail address:");
    JLabel minute_label=new JLabel("your password:");
    JLabel second_label=new JLabel("TO:");
    JLabel microsecond_label=new JLabel("mail subject:");
    JLabel milisecond_label=new JLabel(" type your mail:");
    
    JTextField htf=new JTextField(100);
    JPasswordField mtf=new JPasswordField(50);
    JTextField stf=new JTextField(100);
    
    JTextField mistf=new JTextField(200);
JTextField micstf=new JTextField(50);    
    JButton b1,b2;
    
     String s1,s2,s3,s4,s5;
   
    SendMailTLS()
    {
        super("Project on Computer Remote");
        panel.setLayout(null);
        panel.setBackground(new Color(112,128,144));
    
        add(panel);
        setSize(600, 650);
        setVisible(true);
        setResizable(false);
        add_Component();
        
    }
   
   
  
    void add_Component()
    {
        hour_label.setBounds(10,50, 140, 50);
        panel.add(hour_label);
        add(panel);
        
        htf.setBounds(200, 50,120, 50);
        panel.add(htf);
        add(panel);
        
        minute_label.setBounds(10,140, 120, 50);
        panel.add(minute_label);
        add(panel);
        
        mtf.setBounds(200, 140,120, 50);
        panel.add(mtf);
        add(panel);
        
        second_label.setBounds(10,220, 120, 50);
        panel.add(second_label);
        add(panel);
        
        stf.setBounds(200, 220,120, 50);
        panel.add(stf);
        add(panel);
          microsecond_label.setBounds(10,300,120, 50);
        panel.add(microsecond_label);
        add(panel);
        
        micstf.setBounds(200,300,300, 100);
        panel.add(micstf);
        add(panel);
        
        milisecond_label.setBounds(10,410,120, 50);
        panel.add(milisecond_label);
        add(panel);
        
        mistf.setBounds(200,410,300, 100);
        panel.add(mistf);
        add(panel);
        
        b1=new JButton("SEND");
        b1.addActionListener(this);
        b1.setBounds(250, 520, 100, 70);
        panel.add(b1);
        add(panel);
        
        b2=new JButton("BACK");
        b2.addActionListener(this);
        b2.setBounds(370, 520, 100, 70);
        panel.add(b2);
        add(panel);
        
        
        
    
        
    }
   /* public static void main(String args[])
    {
       // shut_down ob2=new shut_down();
        
    }
 */
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            s1=new String();
            s2=new String();
            s3=new String();
            s4=new String();
            s5=new String();
           if((htf.getText().equals(""))&&(mtf.getText().equals(""))&&(stf.getText().equals(""))&&(mistf.getText().equals("")))
           {
               JOptionPane.showConfirmDialog(null, "Enter connect value");
           }
           else
             {
                 s1=htf.getText();
                 
                 s2=mtf.getText();
                
                  s3=stf.getText();
                  s4=mistf.getText();
                 s5=micstf.getText();
                 Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(s1, s2);
			}
		  });

                
                    
                    
			Message message = new MimeMessage(session);
                try {
                    message.setFrom(new InternetAddress(s1));
                } catch (MessagingException ex) {
                    Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(s3));
                } catch (MessagingException ex) {
                    Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    message.setSubject(s5);
                } catch (MessagingException ex) {
                    Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    message.setText(s4);
                } catch (MessagingException ex) {
                    Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    Transport.send(message);
                } catch (MessagingException ex) {
                    Logger.getLogger(SendMailTLS.class.getName()).log(Level.SEVERE, null, ex);
                }

			JOptionPane.showMessageDialog(null, "Message sent");

		
                  
                 
             }
         
        }
        if(e.getSource()==b2)
        {
            PC_Remote ob=new PC_Remote();
            dispose();
        }
        
        
      
     
    }

    private String passwordFiled(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

