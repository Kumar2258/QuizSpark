
import java.awt.*;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.*;

public class End {
    String name;
    float Score;
    String []arr=new String[3];
    int []arr1=new int[3];
    String[]arr2=new String[3];
    
    
    
    
    
    End(int sc,int num){
        String  e ="Kumar";
        String que,dbsub;
        
        
        String dname=collection.dname;
        String dsub=collection.sub;
        Data test=new Data();
        System.out.println("here are the valuse "+dname+sc+dsub);
        double percent=((sc*100)/num);
        test.in(dname,percent,dsub);
        
        
        int opt1;
        
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
            
           
           // String query="SELECT name,score FROM toprank WHERE name = '" + e + "'";
            String query="SELECT name,score,subject FROM toprank ORDER BY score DESC LIMIT 3";
            
            Statement stm=con.createStatement();
            
            ResultSet rs=stm.executeQuery(query);
                int i=0;
                while(rs.next()){
                    
                    que=(rs.getString(1));
                    //System.out.println(que);
                    arr[i]=que;
                    
                    opt1=(rs.getInt(2));
                    //System.out.println(opt1);
                    arr1[i]=opt1;

                    dbsub=(rs.getString(3));
                    arr2[i]=dbsub;
                    i++;

                }
            
            for (int k=0;k<3;k++){
                System.out.println(arr[k]+"     "+arr1[k]);
            }
            
            
            con.close();
            //System.out.println(b1);
            

        }catch (Exception ae){
            ae.printStackTrace();

        }
        //double percent=((sc*100)/num);
        System.out.println(percent);


        JFrame reg=new JFrame();
        reg.setSize(1300,800);
       
        reg.setLocationRelativeTo(null);
        reg.setLocation(130,30);
        reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reg.setLayout(null);

        JLabel toprank=new JLabel("Top Ranking ");
        toprank.setFont(new Font("Mongolian Baiti",Font.BOLD,60));
        toprank.setBounds(850,100,600,60);
        reg.add(toprank);
        
        JLabel na=new JLabel();
        String sc12=name;
        na.setText(sc12);
        na.setFont(new Font("Mongolian Baiti",Font.BOLD,50));
        na.setBounds(200,400,300,60);
        
        JLabel score1=new JLabel();
        String s=Float.toString(Score);
        score1.setText(s);
        score1.setFont(new Font("Mongolian Baiti",Font.BOLD,50));
        score1.setBounds(200,400,300,60);

        JLabel name=new JLabel(arr[0]);
        name.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        name.setBounds(850,200,300,60);
        reg.add(name);
        JLabel name2=new JLabel(arr[1]);
        name2.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        name2.setBounds(850,250,300,60);
        reg.add(name2);
        JLabel name3=new JLabel(arr[2]);
        name3.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        name3.setBounds(850,300,300,60);
        reg.add(name3);
        
        JLabel scr=new JLabel(arr2[0]);
        scr.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        scr.setBounds(1000,200,300,60);
        reg.add(scr);
        JLabel scr2=new JLabel(arr2[1]);
        scr2.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        scr2.setBounds(1000,250,300,60);
        reg.add(scr2);

        JLabel scr3=new JLabel(arr2[2]);
        scr3.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        scr3.setBounds(1000,300,300,60);
        reg.add(scr3);

        JLabel sub=new JLabel(arr1[0]+"%");
        sub.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        sub.setBounds(1150,200,300,60);
        reg.add(sub);
        JLabel sub2=new JLabel(arr1[1]+"%");
        sub2.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        sub2.setBounds(1150,250,300,60);
        reg.add(sub2);
        JLabel sub3=new JLabel(arr1[2]+"%");
        sub3.setFont(new Font("Mongolian Baiti",Font.BOLD,30));
        sub3.setBounds(1150,300,300,60);
        reg.add(sub3);

        
        

        JLabel headingreg=new JLabel("Your Score ");
        headingreg.setFont(new Font("Mongolian Baiti",Font.BOLD,60));
        headingreg.setBounds(100,300,600,60);
        reg.add(headingreg);

        JLabel mainp=new JLabel(new ImageIcon("end.jpg"));
        
        mainp.setBounds(0,0,1300,800);

        JLabel score=new JLabel();
        String sc1=Double.toString(percent);
        score.setText(sc1+" %");
        score.setFont(new Font("Mongolian Baiti",Font.BOLD,50));
        score.setBounds(200,400,300,60);
        
        JProgressBar jb=new JProgressBar(0,2000);
        jb.setBounds(50,150,400,40);
        jb.setFont(new Font("Mongolian Baiti",Font.BOLD,35));
        jb.setValue((int)percent*20);
        jb.setStringPainted(true);
        if(percent<25){
            jb.setForeground(Color.red);

        }
        else if(percent>24 && percent<75){
            jb.setForeground(Color.yellow);

        }
        else{
            jb.setForeground(Color.green);

        }
                reg.add(jb);
        
        
        
        
        
        reg.add(score);
        reg.add(mainp);
        reg.setVisible(true);
        

    }
    
}
