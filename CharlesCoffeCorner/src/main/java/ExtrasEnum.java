
/*
 * Enumeration for extras and their price
 */
public enum ExtrasEnum
{
    EXTRA_MILK ("Extra milk", .30),
    FOAMED_MILK ("Foamed Milk", .50),
    SPECIAL_ROAST_COFFE ("Special Roast Coffe", .90);

    private final String name;

    private final double cost;

    private ExtrasEnum(String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

}
