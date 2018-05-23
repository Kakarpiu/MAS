import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class AssociationManager {

    private Hashtable<String, HashMap<Object, AssociationManager>> associations = new Hashtable<String, HashMap<Object, AssociationManager>>();

    private static HashSet<AssociationManager> allParts = new HashSet<AssociationManager>();

    private void addAssociation(String roleName, String reverseRoleName, AssociationManager associateObject, Object qualifier, int counter) throws Exception{
        HashMap<Object, AssociationManager> objectAssociations;
        if(counter < 1) return;

        if(associations.containsKey(roleName)){
            objectAssociations = associations.get(roleName);
        }
        else{
            objectAssociations = new HashMap<Object, AssociationManager>();
            associations.put(roleName, objectAssociations);
        }
        if(!objectAssociations.containsKey(qualifier)){
            objectAssociations.put(qualifier, associateObject);
            associateObject.addAssociation(reverseRoleName, roleName, this, this, counter-1);
        }
        else{
            throw new Exception("This qualifier is already associated with an object");
        }
    }

    public void addAssociation(String roleName, String reverseRoleName, AssociationManager associateObject, Object qualifier){
        addAssociation(roleName, reverseRoleName, associateObject, qualifier, 2);
    }

    public void addAssociation(String roleName, String reverseRoleName, AssociationManager associateObject){
        addAssociation(roleName, reverseRoleName, associateObject, associateObject);
    }

    public void addPart(String roleName, String reverseRoleName, AssociationManager partObject) throws Exception {
        if(allParts.contains(partObject)){
            throw new Exception("This part is already associated with another object");
        }
        addAssociation(roleName, reverseRoleName, partObject);
        allParts.add(partObject);
    }

    public AssociationManager[] getAssociations(String roleName) throws Exception{
        HashMap<Object, AssociationManager> objectAssociations;
        if(!associations.containsKey(roleName)){
            throw new Exception("Role is not associated with any objects");
        }
        objectAssociations = associations.get(roleName);
        return (AssociationManager[]) objectAssociations.values().toArray(new AssociationManager[0]);
    }
}
