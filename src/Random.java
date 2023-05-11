

public class Random {
    int number;
    public void main(String [] args ){
        
        int [] ran=new int[50];
        while(ran.length<50){
            int flag=0;
            number= (int)(Math.random()*(50)+1);
            //new Random();
            for(int i=0;i<ran.length;i++){
                
                if (ran[i]==number){
                    flag=1;
                }
                else{
                    
                    ran[i]=number;
                }
            }
            for(int i=0;i<ran.length;i++){
                System.out.println(ran[i]);
            }


        }    
    

        
    }

    
}
