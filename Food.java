
import java.io.Serializable;


class Food implements Serializable
{
    int itemno;
    int quantity;   
    float price;
    
    Food(int itemno,int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*15000;
                break;
            case 2:price=quantity*60000;
                break;
            case 3:price=quantity*20000;
                break;
            case 4:price=quantity*5000;
                break;
        }
    }
}