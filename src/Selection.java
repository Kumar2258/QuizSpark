import java.awt.*;
import javax.swing.*;

import java.awt.event.*;


public class Selection {
    int n,number;
    public static String subject1;
    public static int r;
    Selection(){
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
        JLabel t1=new JLabel("How Many Questions ?");
        t1.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        t1.setBounds(600,200,400,60);
        rul.add(t1);

        JLabel t2=new JLabel("Enter between 5 to 50");
        t2.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        t2.setBounds(600,240,400,60);
        rul.add(t2);

        JTextField no=new JTextField();
        no.setBounds(950,230,200,40);
        no.setFont(new Font("Times New Roman",Font.PLAIN,30));
        rul.add(no);

        
        JLabel t3=new JLabel("Select the Subject");
        t3.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        t3.setBounds(630,330,400,60);
        rul.add(t3);


        String [] subject={"Select","Java","Python"};
        JComboBox comboBox= new JComboBox<>(subject);
        comboBox.setBounds(950, 330, 200, 50);
        comboBox.setFont(new Font("Times New Roman",Font.PLAIN,30));
        rul.add(comboBox);

        

        JButton backBt=new JButton("Back");
        backBt.setFont(new Font("Mongolian Baiti",Font.PLAIN,20));
        backBt.setBounds(750, 500, 120, 40);
        backBt.setBackground(new Color(30,144,254));
        backBt.setForeground(Color.WHITE);
        rul.add(backBt);
        JButton startBt=new JButton("Start");
        startBt.setFont(new Font("Mongolian Baiti",Font.PLAIN,20));
        startBt.setBounds(1000, 500, 120, 40);
        startBt.setBackground(new Color(30,144,254));
        startBt.setForeground(Color.WHITE);
        rul.add(startBt);
        

        JLabel back=new JLabel(new ImageIcon("selection.jpg"));
        back.setBounds(0,0,1300,800);
        rul.add(back);
        rul.setVisible(true);
        
        class RegisterListener implements ActionListener,ItemListener {
            
            public void itemStateChanged(ItemEvent ie){
                
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    Object item = ie.getItem();
                    subject1=item.toString();
                }
                collection s=new collection();
                s.dbsub(subject1);
                
            
        }


            public void actionPerformed(ActionEvent ae){
                
                if(ae.getSource()==startBt)
                {   number=Integer.parseInt(no.getText());
                    random();
                    new Main(number,n);
                    rul.setVisible(false);
    
                }
                else if(ae.getSource()==backBt){
                    new App();
                    rul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    rul.setVisible(false);
                    
                }
                
    
            }
    
        }
        
        RegisterListener ml=new RegisterListener();
        startBt.addActionListener(ml);
        backBt.addActionListener(ml);
        comboBox.addItemListener(ml);
        
    }
    public void random(){
        n= (int)(Math.random()*(10)+1);
        
    }
}    


