import java.util.HashMap;
import java.util.HashSet;

public class Theater extends AssociationManager{

    private Address location;

    public Theater(Address location){
        this.location = location;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Theater)) return false;
        Theater t = (Theater)obj;
        return location == t.location;
    }
}
