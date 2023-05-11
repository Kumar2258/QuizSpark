import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class App {
    static int i=0;
    App(){
        
        
        JFrame login=new JFrame();
        login.setSize(1300,800);
        
        login.setLocationRelativeTo(null);
        login.setLocation(130,30);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setLayout(null);
        
        JLabel loginb=new JLabel(new ImageIcon("FinalLogin.png"));
        
        loginb.setBounds(0,0,1300,720);



        JLabel headinglogin=new JLabel("QuizSpark");
        headinglogin.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        headinglogin.setBounds(550,30,300,60);
        login.add(headinglogin);
        

        JLabel namelogin=new JLabel("User Name");
        namelogin.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        namelogin.setBounds(845,230,100,60);
        login.add(namelogin);
        



        JLabel passlogin=new JLabel("Password");
        passlogin.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        passlogin.setBounds(850,290,300,60);
        login.add(passlogin);

        JTextField name=new JTextField();
        name.setBounds(960,240,200,30);
        name.setFont(new Font("Times New Roman",Font.PLAIN,16));
        login.add(name);

        JPasswordField pass=new JPasswordField();
        pass.setBounds(960,300,200,30);
        pass.setFont(new Font("Times New Roman",Font.PLAIN,16));
        login.add(pass);
        JLabel regt=new JLabel("Don't have an Account ?");
        regt.setBounds(860,500,200,30);
        regt.setFont(new Font("Times New Roman",Font.PLAIN,16));
        login.add(regt);

        JButton logBt=new JButton("Login");
        logBt.setBounds(870, 400, 100, 30);
        logBt.setBackground(new Color(30,144,254));
        logBt.setForeground(Color.WHITE);
        
        login.add(logBt);
        JButton exitBt=new JButton("Exit");
        exitBt.setBounds(1050, 400, 100, 30);
        exitBt.setBackground(new Color(30,144,254));
        exitBt.setForeground(Color.WHITE);
       // logBt.addActionListener(this);
        login.add(exitBt);
        JButton register=new JButton("Register");
        register.setBackground(Color.WHITE);
        register.setBounds(1030, 500, 100, 30);
        register.setForeground(Color.BLUE);
        login.add(register);
        
        


        login.add(loginb);
        login.setVisible(true);
        class loginListener implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                Data st=new Data();
                
                
                String n=name.getText();
                char [] p=pass.getPassword();
                String p1=new String(p);

                

                if(ae.getSource()==exitBt)
                {
                    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    login.setVisible(false);

                }
                else if(ae.getSource()==logBt){
                    st.log(n, p1);
                    String demail=st.email;
                    String dpass=st.password;

                    if(n.length()==0|| p.length==0){
                        JOptionPane.showMessageDialog(login,"Fill Details !");
                        return;
                    }
                    else if(!(n.equals(demail) || p1.equals(dpass))){
                        JOptionPane.showMessageDialog(login,"Invalid Login !");
                        
                    }
                    else {
                        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        login.setVisible(false);
                        new Selection();
                        
                    }
                }
                else if(ae.getSource()==register){
            
                    login.setVisible(false);
                    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    new Register();
                }
            }

        }
        loginListener ml=new loginListener();
        exitBt.addActionListener(ml);
        logBt.addActionListener(ml);
        register.addActionListener(ml);
        
    

        
    }


  
  
    public static void main(String[] args)  {
        new App();
        //new End(i,50);
        //new Selection();
        //new Main(5, 1);
    }
}


