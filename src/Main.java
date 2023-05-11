import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.Timer;



public class Main {
    int count=1;
    
    int btndeselect;
    int nextcount=1;
    int i=0;
    int number=0;
    JLabel quesno ,que,countLabel;
    JRadioButton j1,j2,j3,j4;
    Timer timer;	
	int second, minute;
	String ddSecond, ddMinute;	
	DecimalFormat dFormat = new DecimalFormat("00");
    
    Main(int num,int sn){
        
        
        int[] arr = new int[50];
        Random rand = new Random();

        // Add numbers 1 to 50 to a list
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= 50; i++) {
            numbers.add(i);
        }

        // Shuffle the list and add the first 50 elements to the array
        Collections.shuffle(numbers);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = numbers.get(i);
        }


        number=num;
    
       
        
        JFrame rul=new JFrame();
        rul.setSize(1300,800);
        
        rul.setLocationRelativeTo(null);
        rul.setLocation(130,30);
        rul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rul.setLayout(null);

        

        JLabel mainp=new JLabel(new ImageIcon("backgroundForQuiz.png"));
        
        mainp.setBounds(0,0,1300,220);
        

        

        JButton backBt=new JButton("Back");
        backBt.setBounds(800, 700, 100, 30);
        backBt.setBackground(new Color(30,144,254));
        backBt.setForeground(Color.WHITE);
        rul.add(backBt);
        JButton nextBt=new JButton("Next");
        nextBt.setBounds(950, 700, 100, 30);
        nextBt.setBackground(new Color(30,144,254));
        nextBt.setForeground(Color.WHITE);
        rul.add(nextBt);
        
        JButton endBt=new JButton("End Quiz");
        endBt.setBounds(1100, 700, 100, 30);
        endBt.setBackground(Color.RED);
        endBt.setForeground(Color.WHITE);
        rul.add(endBt);

        quesno=new JLabel();
        quesno.setBounds(110,350,80,30);
        quesno.setFont(new Font("Times New Roman",Font.BOLD,20));
        rul.add(quesno);

        que=new JLabel();
        que.setBounds(140,350,1000,30);
        que.setFont(new Font("Times New Roman",Font.BOLD,20));
        rul.add(que);

        j1=new JRadioButton();
        j1.setFont(new Font("Times New Roman",Font.BOLD,17));
        j1.setBounds(110,400,900,30);
        j1.setBackground(Color.WHITE);

        j2=new JRadioButton();
        j2.setBounds(110,440,900,30);
        j2.setFont(new Font("Times New Roman",Font.BOLD,17));
        j2.setBackground(Color.WHITE);

        j3=new JRadioButton();
        j3.setBounds(110,480,900,30);
        j3.setFont(new Font("Times New Roman",Font.BOLD,17));
        j3.setBackground(Color.WHITE);

        j4=new JRadioButton();
        j4.setBounds(110,520,900,30);
        j4.setFont(new Font("Times New Roman",Font.BOLD,17));
        j4.setBackground(Color.WHITE);

        countLabel=new JLabel("Time : ");
        countLabel.setBounds(890,250,130,30);
        countLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        rul.add(countLabel);


        countLabel=new JLabel();
        countLabel.setBounds(1000,250,80,30);
        countLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        rul.add(countLabel);
        countLabel.setText(num+":00");
        second=0;
        minute=num;
        countdownTimer();
        timer.start();


        j1.setEnabled(true);
        j2.setEnabled(true);
        j3.setEnabled(true);
        j4.setEnabled(true);
                
        rul.add(j1);
        rul.add(j2);
        rul.add(j3);
        rul.add(j4);
        
        ButtonGroup groupoptions=new ButtonGroup();
        groupoptions.add(j1);
        groupoptions.add(j2);
        groupoptions.add(j3);
        groupoptions.add(j4);

        start(arr[nextcount-1]);
        rul.add(mainp);
        rul.setVisible(true);
        
        
        
       

        class RegisterListener implements ActionListener,ItemListener {
            String label;
            String ans;
            int i=0;
            
            public void itemStateChanged(ItemEvent ie){
                
                    AbstractButton a=(AbstractButton)ie.getSource();
                    label=a.getText();
                    
                
            }
            public void scorecheck(int no,String check){
                String selected=Selection.subject1;
                int demo=0;
                if(selected=="Java"){
                    try{
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
                       // System.out.println()
                    
                        String query="SELECT * FROM java WHERE queid = '" + arr[nextcount-1] + "'";
            
                        Statement stm=con.createStatement();
                        ResultSet rs=stm.executeQuery(query);
                        
                        while(rs.next()){
                            
                            ans=(rs.getString(7));
                            System.out.println("This is data:"+ans);
                        }
                        System.out.println("this is check :"+check);
                        if (ans.equals(check)){
                            
                            i++;
                            System.out.println("Score "+i);
            
            
                        }
                        
                        con.close();
                        
            
                    }catch (Exception ae){
                        ae.printStackTrace();
            
                    }
                }

                else{
                    try{
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
                            
                    
                        String query="SELECT * FROM python WHERE queid = '" + arr[nextcount-1] + "'";
            
                        Statement stm=con.createStatement();
                        ResultSet rs=stm.executeQuery(query);
                        
                        while(rs.next()){
                            
                            ans=(rs.getString(7));
                            System.out.println("This is data:"+ans);
                        }
                        System.out.println("this is check :"+check);
                        if (ans.equals(check)){
                            
                            i++;
                            System.out.println("Score "+i);
            
            
                        }
                        
                        con.close();
                        
            
                    }catch (Exception ae){
                        ae.printStackTrace();
            
                    }

                }
            }


            public void actionPerformed(ActionEvent ae){
                
                
                
                if(ae.getSource()==endBt)
                {   
                    scorecheck( count,label);
                    System.out.println("Selection "+ label );
                    
                    start(arr[nextcount]);
                    nextcount++;
                     
                    groupoptions.clearSelection();
                    
                    rul.setVisible(false);
                    
                    new End(i,num);
                    
                    
                    System.out.println("Score in end :" +i);
                   
                
                    
                }
                
                
                    
                else if (ae.getSource()==backBt){
                    if(count>1){
                        
                       
                        nextcount--;
                        btndeselect=num+1;
                        start(arr[nextcount]);

                        
                        nextBt.setEnabled(true);
                        
                       
                    }
                    
       
                }   
                else if(ae.getSource()==nextBt){
                    
                    
                    if(count<num){
                       
                        //System.out.println("Array random number : "+ran[count-1]);
                       // System.out.println(label);
                        btndeselect=num-1;
                        if (nextcount==btndeselect){
                            
                             nextBt.setEnabled(false);
                         }
                        
                        scorecheck( nextcount,label);
                        
                        //System.out.println("Selection "+ label );
                        count++;
                        //start(ran[count-1]);

                        start(arr[nextcount]);
                       // System.out.println("next count :"+ arr[nextcount]);
                        
                        nextcount=nextcount+1;
                         
                        groupoptions.clearSelection();
                        
                        
                    }
                    
                }
            }

                    
                
    
                
    
            
    
        }
        
        RegisterListener ml=new RegisterListener();
        endBt.addActionListener(ml);
        nextBt.addActionListener(ml);
        backBt.addActionListener(ml);
        j1.addItemListener(ml);
        j2.addItemListener(ml);
        j3.addItemListener(ml);
        j4.addItemListener(ml);
       

        
        
         
    }
    
    
    public void countdownTimer() {
		
		timer = new Timer(1000, new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);	
				countLabel.setText(ddMinute + ":" + ddSecond);
				
				if(second==-1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);	
					countLabel.setText(ddMinute + ":" + ddSecond);
				}
				if(minute==0 && second==0) {
					timer.stop();
                    new End(i, number);
                    
				}
			}
		});		
	}
   
   
    
    
    public void start (int random){
        Data st=new Data();
        //System.out.println("random isd igfhfdg : "+random);
        st.que(random);
        //String queno=Integer.toString(st.queno);
        String question=st.que;
        String opt1=st.opt1;
        String opt2=st.opt2;
        String opt3=st.opt3;
        String opt4=st.opt4;
        quesno.setText(count+")");
        //quesno.setText(count+")");
        que.setText(question);
        j1.setText(opt1);
        j2.setText(opt2);
        j3.setText(opt3);
        j4.setText(opt4);


    }

}
