import java.util.Scanner;

class Homestay
{
    static holder homestay_ob=new holder();
    static Scanner sc = new Scanner(System.in);

    // Method untuk mengambil data pelanggan
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nMasukkan Nama Pelanggan: ");
        name = sc.next();
        System.out.print("Masukkan No Hp: ");
        contact=sc.next();
        System.out.print("Masukkan Jenis Kelamin: ");
        gender = sc.next();
        if(i<3)
        {
        System.out.print("Masukkan Nama Pelanggan ke-2: ");
        name2 = sc.next();
        System.out.print("Masukkan No Hp: ");
        contact2=sc.next();
        System.out.print("Masukkan Jenis Kelamin: ");
        gender2 = sc.next();
        }      
        
        // Menentukan tipe kamar berdasarkan input
          switch (i) {
            case 1:homestay_ob.luxury_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:homestay_ob.deluxe_doublerrom[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:homestay_ob.luxury_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:homestay_ob.deluxe_singleerrom[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Pilihan Salah !");
                break;
        }
    }
    
    // Method untuk memesan kamar
    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nPilih Nomor Kamar Dari  :");
        switch (i) {
            case 1:
                for(j=0;j<homestay_ob.luxury_doublerrom.length;j++)
                {
                    if(homestay_ob.luxury_doublerrom[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nMasukkan Nomor Kamar :");
                try{
                rn=sc.nextInt();
                rn--;
                if(homestay_ob.luxury_doublerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Opsi Salah !");
                    return;
                }
                break;
            case 2:
                 for(j=0;j<homestay_ob.deluxe_doublerrom.length;j++)
                {
                    if(homestay_ob.deluxe_doublerrom[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nMasukkan Nomor Kamar :");
                try{
                rn=sc.nextInt();
                rn=rn-11;
                if(homestay_ob.deluxe_doublerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Opsi Salah !");
                    return;
                }
                break;
            case 3:
                  for(j=0;j<homestay_ob.luxury_singleerrom.length;j++)
                {
                    if(homestay_ob.luxury_singleerrom[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nMasukkan Nomor Kamar :");
                try{
                rn=sc.nextInt();
                rn=rn-31;
                if(homestay_ob.luxury_singleerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                    System.out.println("Opsi Salah !");
                    return;
                }
                break;
            case 4:
                  for(j=0;j<homestay_ob.deluxe_singleerrom.length;j++)
                {
                    if(homestay_ob.deluxe_singleerrom[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nMasukkan Nomor Kamar :");
                try{
                rn=sc.nextInt();
                rn=rn-41;
                if(homestay_ob.deluxe_singleerrom[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(Exception e)
                {
                   System.out.println("Opsi Salah !");
                    return;
                }
                break;
            default:
                System.out.println("Masukkan Plihan Yang Benar !");
                break;
        }
        System.out.println("Kamar Telah Di Pesan");
    }
    
    // Method untuk menampilkan fitur kamar
    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Jumlah tempat tidur ukuran Queen Bed : 2\nPerlengkapan Mandi : Tersedia\nGratis Makanan Pagi : Yes\nBiaya per hari:800000 ");
                break;
            case 2:System.out.println("Jumlah tempat tidur ukuran Queen Bed : 2\nPerlengkapan Mandi : Tersedia\nGratis Makanan Pagi : Yes\nBiaya per hari:600000  ");
                break;
            case 3:System.out.println("Jumlah tempat tidur ukuran 3 Kaki : 1\nPerlengkapan Mandi : Tersedia\nGratis Makanan Pagi : Yes\nBiaya per hari:400000  ");
                break;
            case 4:System.out.println("Jumlah tempat tidur ukuran 3 Kaki : 1\nPerlengkapan Mandi : Tersedia\nGratis Makanan Pagi : Yes\nBiaya per hari:250000 ");
                break;
            default:
                System.out.println("Masukkan Plihan Yang Benar !");
                break;
        }
    }
    
    // Method untuk mengecek ketersediaan kamar
    static void availability(int i)
    {
      int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(homestay_ob.luxury_doublerrom[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0;j<homestay_ob.deluxe_doublerrom.length;j++)
                {
                    if(homestay_ob.deluxe_doublerrom[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0;j<homestay_ob.luxury_singleerrom.length;j++)
                {
                    if(homestay_ob.luxury_singleerrom[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0;j<homestay_ob.deluxe_singleerrom.length;j++)
                {
                    if(homestay_ob.deluxe_singleerrom[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Masukkan Plihan Yang Benar !");
                break;
        }
        System.out.println("Nomor Kamar Yang Tersedia : "+count);
    }
    
    // Method untuk mencetak tagihan
    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={ "Nasi Goreng\t\t  ", "Lobster Sambal\t\t  ", "Mie Aceh\t\t  ", "Teh Dingin\t\t  " };
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
               
        switch(rtype)
        {
            case 1:
                amount+=800000;
                    System.out.println("\nHarga Kamar : "+800000);
                    System.out.println("\n===============");
                    System.out.println("Harga Makanan:  ");
                    System.out.println("===============");
                     System.out.println("Barang\t\t\tJumlah\t\tHarga");
                    System.out.println("-----------------------------------------------");
                    for(Food obb:homestay_ob.luxury_doublerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                    
                break;
            case 2:amount+=600000;
                    System.out.println("Harga Kamar : "+600000);
                    System.out.println("\nHarga Makanan:  ");
                    System.out.println("===============");
                     System.out.println("Barang\t\t\tJumlah\t\tHarga");
                    System.out.println("-----------------------------------------------");
                    for(Food obb:homestay_ob.deluxe_doublerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 3:amount+=400000;
                    System.out.println("Harga Kamar : "+400000);
                    System.out.println("\nHarga Makanan:  ");
                    System.out.println("===============");
                    System.out.println("Barang\t\t\tJumlah\t\tHarga");
                    System.out.println("-----------------------------------------------");
                    for(Food obb:homestay_ob.luxury_singleerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            case 4:amount+=250000;
                    System.out.println("Harga Kamar : "+250000);
                    System.out.println("\nHarga Makanan:  ");
                    System.out.println("===============");
                    System.out.println("Barang\t\t\tJumlah\t\tHarga");
                    System.out.println("-----------------------------------------------");
                    for(Food obb: homestay_ob.deluxe_singleerrom[rn].food)
                    {
                        amount+=obb.price;
                        String format = "%-10s%-10s%10s%n";
                        System.out.printf(format,list[obb.itemno-1],obb.quantity,obb.price );
                    }
                break;
            default:
                System.out.println("Tidak Valid !!!");
        }
        System.out.println("\nTotal harga : "+amount);
    }
    
    static void deallocate(int rn,int rtype)
     // Menampilkan informasi tentang status kamar yang akan didealokasi
    {
        int j;
        char w;
        switch (rtype) {
            case 1:               
                if(homestay_ob.luxury_doublerrom[rn]!=null)
                    System.out.println("Kamar terpakai oleh "+homestay_ob.luxury_doublerrom[rn].name);                
                else 
                {    
                    System.out.println("Kamar telah di pesan ");
                        return;
                }
                System.out.println("Kamu ingin memesan ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    homestay_ob.luxury_doublerrom[rn]=null;
                    System.out.println("Pesenan berhasil dilakukan");
                }
                
                break;
            case 2:
                if(homestay_ob.deluxe_doublerrom[rn]!=null)
                    System.out.println("Kamar terpakai oleh "+homestay_ob.deluxe_doublerrom[rn].name);                
                else 
                {    
                    System.out.println("Kamar telah di pesan ");
                        return;
                }
                System.out.println(" Kamu ingin memesan ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    homestay_ob.deluxe_doublerrom[rn]=null;
                    System.out.println("Pesenan berhasil dilakukan");
                }
                 
                break;
            case 3:
                if(homestay_ob.luxury_singleerrom[rn]!=null)
                    System.out.println("Kamar terpakai oleh "+homestay_ob.luxury_singleerrom[rn].name);                
                else 
                 {    
                    System.out.println("Kamar telah di pesan ");
                        return;
                }
                System.out.println(" Kamu ingin memesan ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    homestay_ob.luxury_singleerrom[rn]=null;
                    System.out.println("Pesenan berhasil dilakukan");
                }
                
                break;
            case 4:
                if(homestay_ob.deluxe_singleerrom[rn]!=null)
                    System.out.println("Kamar terpakai oleh "+homestay_ob.deluxe_singleerrom[rn].name);                
                else 
                 {    
                    System.out.println("Kamar telah di pesan ");
                        return;
                }
                System.out.println(" Kamu ingin memesan ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn,rtype);
                    homestay_ob.deluxe_singleerrom[rn]=null;
                    System.out.println("Pesenan berhasil dilakukan");
                }
                break;
            default:
                System.out.println("\nMasukkan pilihan yang benar ");
                break;
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
         try{
            // Menampilkan menu makanan
             System.out.println("\t\t==========\n   \t\t   Menu  \t\n\t\t==========\n\n1.Nasi Goreng\t\t: Rp. 15000\n2.Lobster sambal\t: Rp. 60000\n3.Mie Aceh\t\t: Rp. 20000\n4.Teh Dingin\t\t: Rp. 5000\n");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity: ");
            q=sc.nextInt();
           
            // Menambahkan pesanan makanan ke kamar yang sesuai
            switch(rtype){
            case 1: homestay_ob.luxury_doublerrom[rn].food.add(new Food(i,q));
                break;
            case 2: homestay_ob.deluxe_doublerrom[rn].food.add(new Food(i,q));
                break;
            case 3: homestay_ob.luxury_singleerrom[rn].food.add(new Food(i,q));
                break;
            case 4: homestay_ob.deluxe_singleerrom[rn].food.add(new Food(i,q));
                break;                                                 
        }
              System.out.println("Apakah kamu ingin mau memesan yang lain? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch(NullPointerException e)
            {
                System.out.println("\nKamar belum di pesan");
            }
         catch(Exception e)
         {
             System.out.println("tidak bisa dilakukan");
         }
    }
}


