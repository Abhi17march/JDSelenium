package utility;

public class TaskKill {
	
	public static void main(String args[])

    {

        try {

      

          Process process =Runtime.getRuntime().exec("c:/taskkill/taskkill.bat");
          System.out.println("done");
          // Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","start"});        
          process.destroy();
    

        
        } catch( Exception e) {

          e.printStackTrace();

        }

 

 

    }

}
