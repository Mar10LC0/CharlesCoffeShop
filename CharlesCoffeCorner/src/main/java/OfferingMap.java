import java.util.Collection;
import java.util.TreeMap;

public class OfferingMap extends TreeMap<String, OfferingItem>
{
    private static final long serialVersionUID = 0L;

    public OfferingMap()
    {
        for (OfferingEnum i : OfferingEnum.values())
        {
            put(i.getName(), new OfferingItem(i.getName(), i.getCost()));
        }
    }

    public double getCost(OfferingEnum e) {
        return get(e.getName()).getOfferingCost();
    }

    public Collection<OfferingItem> asCollection() {
        return this.values();
    }

    public OfferingItem getRecipeByOrdinal(int n)
    {
        int count = 0;
        for (OfferingItem r : asCollection())
        {
            if (count == n) return r;
            ++count;
        }
        return null;
    }
}