import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OfferingItem
{
    private String offeringName;
    private double offeringCost;
   // private double quantity;

    public OfferingItem(String offeringName, double offeringCost)
    {
        super();
        this.offeringName = offeringName;
        this.offeringCost = offeringCost;
       // this.quantity = quantity;
    }

    public String getOfferingName()
    {
        return offeringName;
    }

    public void setOfferingName(String offeringName)
    {
        this.offeringName = offeringName;
    }

    public double getOfferingCost()
    {
        return offeringCost;
    }

    public void setOfferingCost(double offeringCost)
    {
        this.offeringCost = offeringCost;
    }

//    public double getQuantity(){return quantity;}
//
//    public void setQuantity(){
//        this.quantity = quantity;
//    }

    public String getFormattedPrice()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(getOfferingCost());
    }

    public void printRecipie(int quantity)
    {
        this.offeringCost +=quantity;
        System.out.print("You must pay +" +this.offeringCost);
    }

}
