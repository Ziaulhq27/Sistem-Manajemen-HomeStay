import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class mainHomestay {
    public static void main(String[] args){
        
        try
        {           
        File f = new File("backup");
        if(f.exists())
        {
            FileInputStream fin=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fin);
            Homestay.homestay_ob=(holder)ois.readObject();
        }
        Scanner sc = new Scanner(System.in);
        int ch,ch2;
        char wish;
        x:
        do{

        System.out.println("\nMasukkan Pilihan Anda :\n1.Tampilkan detail kamar\n2.Tampilkan ketersedian kamar \n3.Pesan kamar\n4.Pesan makanan\n5.pesan Sekarang\n6.Keluar\n");
        ch = sc.nextInt();
        switch(ch){
            case 1: System.out.println("\nPilih Tipe Kamar :\n1.suite Double Bedroom \n2.family Double Bedroom \n3.Suite Single Bedroom  \n4.Single Bedroom\n");
                    ch2 = sc.nextInt();
                    Homestay.features(ch2);
                break;
            case 2:System.out.println("\nPilih Tipe Kamar :\n1.suite Double Bedroom \n2.family Double Bedroom \n3.Suite Single Bedroom \n4.Single Bedroom\n");
                     ch2 = sc.nextInt();
                     Homestay.availability(ch2);
                break;
            case 3:System.out.println("\nPilih Tipe Kamar :\n1.suite Double Bedroom \n2.family Double Bedroom \n3.Suite Single Bedroom \n4.Single Bedroom\n");
                     ch2 = sc.nextInt();
                     Homestay.bookroom(ch2);                     
                break;
            case 4:
                 System.out.print("Nomor kamar : ");
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println("kamar tidak tersedia");
                     else if(ch2>40)
                         Homestay.order(ch2-41,4);
                     else if(ch2>30)
                         Homestay.order(ch2-31,3);
                     else if(ch2>10)
                         Homestay.order(ch2-11,2);
                     else if(ch2>0)
                         Homestay.order(ch2-1,1);
                     else
                         System.out.println("kamar tidak tersedia");
                     break;
            case 5:                 
                System.out.print("Nomor kamar : ");
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println("kamar tidak tersedia");
                     else if(ch2>40)
                         Homestay.deallocate(ch2-41,4);
                     else if(ch2>30)
                         Homestay.deallocate(ch2-31,3);
                     else if(ch2>10)
                         Homestay.deallocate(ch2-11,2);
                     else if(ch2>0)
                         Homestay.deallocate(ch2-1,1);
                     else
                         System.out.println("kamar tidak tersedia");
                     break;
            case 6:break x;
            default:
            System.out.println("Opsi Salah !!!");
        }
           
            System.out.println("\nLanjutkan : (y/n)");
            wish=sc.next().charAt(0); 
            if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
            {
                System.out.println("Opsi salah!");
                System.out.println("\nLanjutkan : (y/n)");
                wish=sc.next().charAt(0); 
            }
            
        }while(wish=='y'||wish=='Y');    
        
        Thread t=new Thread(new write(Homestay.homestay_ob));
        t.start();
        }        
            catch(Exception e)
            {
                System.out.println("Inputt yang anda masukkan tidak ada ");
            }
    }
}
