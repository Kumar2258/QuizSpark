
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
public class Register {
    Register(){
        
        JFrame reg=new JFrame();
        reg.setSize(1300,800);
        reg.setVisible(true);
        reg.setLocationRelativeTo(null);
        reg.setLocation(130,30);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reg.setLayout(null);
        JLabel regp=new JLabel(new ImageIcon("registration.png"));
        
        regp.setBounds(0,0,1300,720);

        JLabel headingreg=new JLabel("Quiz Platform ");
        headingreg.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        headingreg.setBounds(550,30,300,60);
        reg.add(headingreg);

        JButton exitBt=new JButton("Back");
        exitBt.setBounds(850, 650, 100, 30);
        exitBt.setBackground(new Color(30,144,254));
        exitBt.setForeground(Color.WHITE);
        reg.add(exitBt);
        JButton regBt=new JButton("Register");
        regBt.setBounds(1060, 650, 100, 30);
        regBt.setBackground(new Color(30,144,254));
        regBt.setForeground(Color.WHITE);
        reg.add(regBt);
        
        JLabel namelogin=new JLabel("Name");
        namelogin.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        namelogin.setBounds(700,230,100,60);
        reg.add(namelogin);
       
        JLabel emaillogin=new JLabel("Email");
        emaillogin.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        emaillogin.setBounds(700,290,100,60);
        reg.add(emaillogin);
       
        JLabel passlogin=new JLabel("Password");
        passlogin.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        passlogin.setBounds(700,350,300,60);
        reg.add(passlogin);

        JLabel passlogin2=new JLabel("Confirm Password");
        passlogin2.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        passlogin2.setBounds(700,410,300,60);
        reg.add(passlogin2);

        JTextField name=new JTextField();
        name.setBounds(960,240,200,30);
        name.setFont(new Font("Times New Roman",Font.PLAIN,16));
        reg.add(name);

        JTextField email=new JTextField();
        email.setBounds(960,300,200,30);
        email.setFont(new Font("Times New Roman",Font.PLAIN,16));
        reg.add(email);

        JPasswordField pass=new JPasswordField();
        pass.setBounds(960,360,200,30);
        pass.setFont(new Font("Times New Roman",Font.PLAIN,16));
        reg.add(pass);

        JPasswordField pass2=new JPasswordField();
        pass2.setBounds(960,410,200,30);
        pass2.setFont(new Font("Times New Roman",Font.PLAIN,16));
        reg.add(pass2);
        reg.add(regp);

        
        
    class RegisterListener implements ActionListener {
        public void actionPerformed(ActionEvent ae){
            Data st=new Data();
            String n=name.getText();
            String m=email.getText();
            char [] p=pass.getPassword();
            char [] p2=pass2.getPassword();


            
            boolean check =Arrays.equals(p, p2);
            

            
            if(ae.getSource()==exitBt)
            {
                reg.setVisible(false);
                new App();
            }
            else if(ae.getSource()==regBt){

                if(n.length()==0|| p.length==0 ||p2.length==0 || m.length()==0){
                    JOptionPane.showMessageDialog(reg,"Fill Details !");
                    return;
                }
                if (check == false){
                    JOptionPane.showMessageDialog(reg,"Password Does't match !");
                    return;
                }
                String s=new String(p);
                st.reg(n,m,s);
                JOptionPane.showMessageDialog(reg,"Registration Successful");
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setVisible(false);
                new App();
            }

            

        }

    }
    
    RegisterListener ml=new RegisterListener();
    exitBt.addActionListener(ml);
    regBt.addActionListener(ml);
    
    }

}


