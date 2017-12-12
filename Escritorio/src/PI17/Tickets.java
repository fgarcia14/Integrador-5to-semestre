package PI17;

/**
 *
 * @author Fidel
 */
public class Tickets {
    
    Ticket inicio, temp;
    
    public Tickets(){
        inicio=null;
    }
    
    public void agregar(Ticket t){
        if (inicio==null) {
            inicio=t;
        }else{
            temp=inicio;
            while (temp.siguiente!=null) {
                temp=temp.siguiente;
            }
            temp.siguiente=t;
        }
    }
    
    public Ticket buscar(int n){
        temp=inicio;
        Ticket r=null;
        while(temp!=null){
            if (temp.getNo_Ticket()==n) {
                r=temp;
            }
            temp=temp.siguiente;
        }
        return r;
    }
}
