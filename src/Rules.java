import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Rules {
    int n;
    Rules(){
        JFrame rul=new JFrame();
        rul.setSize(1300,800);
        
        rul.setLocationRelativeTo(null);
        rul.setLocation(130,30);
        rul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rul.setLayout(null);

        JLabel headingreg=new JLabel("Rules");
        headingreg.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        headingreg.setBounds(580,30,300,60);
        rul.add(headingreg);

/*        JLabel select=new JLabel("* Seclect Subject ");
        select.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
        select.setBounds(250,230,500,60);
        rul.add(select);
*/ 
        JLabel enterq=new JLabel("Hey Vertos! how its going.... ");
        enterq.setFont(new Font("Mongolian Baiti",Font.BOLD,40));
        enterq.setBounds(120,50,900,60);
        rul.add(enterq);

/*      JTextField no=new JTextField();
        no.setBounds(950,300,200,40);
        no.setFont(new Font("Times New Roman",Font.PLAIN,30));
        rul.add(no);
*/
        JButton backBt=new JButton("Back");
        backBt.setBounds(800, 700, 100, 30);
        backBt.setBackground(new Color(30,144,254));
        backBt.setForeground(Color.WHITE);
        rul.add(backBt);
        JButton startBt=new JButton("Start");
        startBt.setBounds(1050, 700, 100, 30);
        startBt.setBackground(new Color(30,144,254));
        startBt.setForeground(Color.WHITE);
        rul.add(startBt);
        rul.setVisible(true);

        class RegisterListener implements ActionListener {
            public void actionPerformed(ActionEvent ae){
               // int number=Integer.parseInt(no.getText());
                if(ae.getSource()==startBt)
                {
                    random();
                    new Main();
                    rul.setVisible(false);
    
                }
                else if(ae.getSource()==backBt){
                    
                    rul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    rul.setVisible(false);
                    new App();
                }
    
            }
    
        }
        
        RegisterListener ml=new RegisterListener();
        startBt.addActionListener(ml);
        backBt.addActionListener(ml);
        
    }
    public void random(){
        n= (int)(Math.random()*(50)+1);
        //System.out.println("Random Number is : "+n);
    }
}    


