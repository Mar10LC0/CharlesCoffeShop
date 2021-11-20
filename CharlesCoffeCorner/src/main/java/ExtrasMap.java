import java.util.Collection;
import java.util.TreeMap;
/*
 * The ExtrasMap is the data structure for the  Extras costs
 *  It stores a collection of ExtrasItem keyed by their
 * ExtrasName name.
 * Its data is populated from ExtrasEnum.
 */

public class ExtrasMap extends TreeMap<String, ExtrasItem>
{
    private static final long serialVersionUID = 0L;
    /*
     * Populate data structure from data in the Enum.
     */

    public ExtrasMap()
    {
        for (ExtrasEnum i : ExtrasEnum.values())
        {
            put(i.getName(), new ExtrasItem(i.getName(), i.getCost()));
        }
    }

    public double getCost(ExtrasEnum e) {
        return get(e.getName()).getCost();
    }


    public boolean sellUnit(OfferingItem item)
    {
        //logic should go here
        //not completed yet.

        return true;
    }

    /*
     * Allows simpler code for looping through the TreeMap.
     */
    public Collection<ExtrasItem> asCollection() {
        return this.values();
    }

}
