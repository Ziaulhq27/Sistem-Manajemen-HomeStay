import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

class write implements Runnable
{
    holder homestay_ob;
    write(holder homestay_ob)
    {
        this.homestay_ob=homestay_ob;
    }
    @Override
    public void run() {
          try{
        FileOutputStream fout=new FileOutputStream("backup");
        ObjectOutputStream oos=new ObjectOutputStream(fout);
        oos.writeObject(homestay_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }         
        
    }
    
}