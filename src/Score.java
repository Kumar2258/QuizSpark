

import java.sql.DriverManager;
import java.sql.*;

public class Score  {
    String ans;
  
    Score(int no , String check ){
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","root","Kumar@2258");
                 
        
            String query="SELECT * FROM java WHERE queid = '" + (no-1) + "'";

            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(query);
            
            while(rs.next()){
                
                ans=(rs.getString(7));
                System.out.println(ans);
            }
            System.out.println(check);
            if (ans.equals(check)){
                
                
                //System.out.println("Score "+;
                i++;
                System.out.println("Value"+i);


            }
            
            con.close();
            

        }catch (Exception ae){
            ae.printStackTrace();

        }

    }
    

}
