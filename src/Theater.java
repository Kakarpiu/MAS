import java.util.HashMap;
import java.util.HashSet;

public class Theater extends AssociationManager{

    private Address location;
    private HashSet<Seat> seats;


    public Theater(Address location){
        this.location = location;
    }

}
