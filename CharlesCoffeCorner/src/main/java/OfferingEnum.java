
public enum OfferingEnum
{
    CAFFE_SMALL ("caffe small", 2.50),
    CAFFE_MEDIUM ("caffe medium", 3.00),
    CAFFE_LARGE ("caffe large", 3.50),
    BACCON_ROLL("bacon roll",4.50),
    FRESHLY_SQUIZED_ORANGE_JUICE("freshly squized orange juice",3.95);

    private final String name;

    private final double cost;

    private OfferingEnum(String name, double cost)
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
