



import java.sql.DriverManager;

import java.sql.*;

public class Data {
    String email,password,name;
    void reg(String n,String e,String p){
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
            
           
            String query="insert into regdb (name,email,password) values (?,?,?);"; 
            //data=()
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,n);
            pstm.setString(2,e);
            pstm.setString(3,p);
            pstm.executeUpdate();
            
            con.close();
            //System.out.println(b1);
            

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
    
    void log(String e,String p){
        collection s=new collection();
        
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
            
           
            String query="SELECT name,email,password FROM regdb WHERE email = '" + e + "'";
            
            Statement stm=con.createStatement();
            
            ResultSet rs=stm.executeQuery(query);
            
            while(rs.next()){

                name=(rs.getString(1));
                s.dbname(name);
                email=(rs.getString(2));
                //System.out.println(queno);
                password=(rs.getString(3));
                

            }
            
            
            con.close();
            //System.out.println(b1);
            

        }catch (Exception ae){
            ae.printStackTrace();

        }

    }
int queno;
String que,opt1,opt2, opt3,opt4,ans;
    void que(int no){

        String selected=Selection.subject1;
        if(selected=="Java"){
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
                
            
                String query="SELECT * FROM java WHERE queid = '" + no + "'";
                System.out.println("data number is : "+no);
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery(query);
                while(rs.next()){
                    queno=(rs.getInt(1));
                    que=(rs.getString(2));
                    opt1=(rs.getString(3));
                    opt2=(rs.getString(4));
                    opt3=(rs.getString(5));
                    opt4=(rs.getString(6));
                    ans=(rs.getString(7));

                }

        
                con.close();
                

            }catch (Exception ae){
                ae.printStackTrace();

            }
        }
        else{
            try{
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
                
            
                String query="SELECT * FROM python WHERE queid = '" + no + "'";
                System.out.println("data number is : "+no);
                Statement stm=con.createStatement();
                ResultSet rs=stm.executeQuery(query);
                while(rs.next()){
                    queno=(rs.getInt(1));
                    que=(rs.getString(2));
                    opt1=(rs.getString(3));
                    opt2=(rs.getString(4));
                    opt3=(rs.getString(5));
                    opt4=(rs.getString(6));
                    ans=(rs.getString(7));

                }

        
                con.close();
                

            }catch (Exception ae){
                ae.printStackTrace();

            }
        }

    }

    
    void in(String name,double score ,String sub){
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
            
           
            String query="insert into toprank (name,score,subject) values (?,?,?);"; 
            //data=()
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setDouble(2,score);
            pstm.setString(3,sub);
            pstm.executeUpdate();
            
            con.close();
            //System.out.println(b1);
            

        }catch (Exception ae){
            ae.printStackTrace();
        }
    }
}

