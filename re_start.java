
package pc_remote;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class re_start extends JFrame implements ActionListener
{
    Runtime rt;
     Process proc;
    JPanel panel=new JPanel();
    
    JLabel hour_label=new JLabel(" Hours   :");
    JLabel minute_label=new JLabel(" Minutes :");
    JLabel second_label=new JLabel(" Seconds :");
    
    JTextField htf=new JTextField(15);
    JTextField mtf=new JTextField(15);
    JTextField stf=new JTextField(15);
    
    
    JButton b1,b2,b3;
    int a,b,c,d;
    String s1,s2,s3,s4;
   
    re_start()
    {
        super("Project on Computer Remote");
        panel.setLayout(null);
        panel.setBackground(new Color(30,144,255));
    
        add(panel);
        setSize(500, 470);
        setVisible(true);
        setResizable(false);
        add_Component();
        
    }
    
   
  
    void add_Component()
    {
        hour_label.setBounds(40,50, 80, 50);
        panel.add(hour_label);
        add(panel);
        
        htf.setBounds(130, 50,120, 50);
        panel.add(htf);
        add(panel);
        
        minute_label.setBounds(40,140, 80, 50);
        panel.add(minute_label);
        add(panel);
        
        mtf.setBounds(130, 140,120, 50);
        panel.add(mtf);
        add(panel);
        
        second_label.setBounds(40,220, 80, 50);
        panel.add(second_label);
        add(panel);
        
        stf.setBounds(130, 220,120, 50);
        panel.add(stf);
        add(panel);
        
        b1=new JButton("SAVE");
        b1.addActionListener(this);
        b1.setBounds(50, 300, 100, 70);
        panel.add(b1);
        add(panel);
        
        b2=new JButton("BACK");
        b2.addActionListener(this);
        b2.setBounds(170, 300, 100, 70);
        panel.add(b2);
        add(panel);
        
         b3=new JButton("cancle");
        b3.addActionListener(this);
        b3.setBounds(290, 300, 100, 70);
        panel.add(b3);
        add(panel);
        
        
    
        
    }
  
 
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource()==b1)
        {
            s1=new String();
            s2=new String();
            s3=new String();
           if((htf.getText().equals(""))&&(mtf.getText().equals(""))&&(stf.getText().equals("")))
           {
               JOptionPane.showConfirmDialog(null, "Enter connect value");
           }
           else
             {
                 s1=htf.getText();
                 a=Integer.valueOf(s1);
                 s2=mtf.getText();
                 b=Integer.valueOf(s2);
                  s3=stf.getText();
                 c=Integer.valueOf(s3);
                 d=(a*60*60)+(b*60)+c;
                  try{
               
                rt=Runtime.getRuntime();
                proc=rt.exec("shutdown -r -t "+d);
             
               
           }
           catch(Exception e6)
           {
               JOptionPane.showMessageDialog(null,"Eroor!!!");
           }
                 
             }
         
        }
        
        if(e.getSource()==b2)
        {
            PC_Remote ob=new PC_Remote();
            dispose();
        } 
       if(e.getSource()==b3)
        {
            try {
                rt.exec("taskkill " +proc);
            } catch (IOException ex) {
                Logger.getLogger(re_start.class.getName()).log(Level.SEVERE, null, ex);
            }
             
               
           
        } 
                 
           
        }
     
    }
    
    
    
    





