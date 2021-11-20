import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CharlesMain implements CharlesConstants
{

    private ExtrasMap extras = new ExtrasMap();
    private OfferingMap offeringMap = new OfferingMap();



    public static void main(String[] args)
    {
        Menu.menu();
        Menu.extras();
        CharlesMain app = new CharlesMain();
        processInput(app, System.in, System.out);
    }

    private static void processInput(CharlesMain app, InputStream inputStream, PrintStream outputStream)
    {
        outputStream.print(app.createMenu());
        boolean appRunning = true;
        Scanner in = new Scanner(inputStream);
        while (appRunning) {
            int action = EXIT;
            String userInput = "";
            if (in.hasNext())
            {
                userInput = in.nextLine().trim();
                action = app.validateSelection(userInput);
            }

            StringBuilder sb = new StringBuilder();
            switch (action)
            {
                case EXIT:
                    appRunning = false;
                    sb.append(EXIT_MESG);
                    break;

                case INVALID:
                    sb.append(app.invalidMessage(userInput)).append(EOL);
                    sb.append(app.createMenu());
                    break;
                default:
                    OfferingItem r = app.offeringMap.getRecipeByOrdinal(action - 1);
                    if (app.extras.sellUnit(r))
                    {
                        sb.append(app.dispensingMessage(r.getOfferingName())).append(EOL);
                    }

                    sb.append(app.createMenu());
            }
            outputStream.print(sb.toString());
        }
        in.close();
    }

    /*
     * Translates user input to action codes.
     */
    private int validateSelection(String command)
    {
        String s = command.toLowerCase();
        int result = 0;

        if (s.equals("q"))
        {
            result = EXIT;
        }
        else
        {
            try
            {
                result = Integer.parseInt(s);
            }
            catch (NumberFormatException e)
            {
                // Should not be possible
            }
            if (result < 1 || result > offeringMap.size()) {
                result = INVALID;
            }
        }
        return result;
    }

    /*
     * Create combined inventory list and drinks menu.
     */
    private String createMenu()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(INVENTORY_MESG).append(EOL).append(buildExtrasListing()).append(EOL);
        sb.append(MENU_MESG).append(EOL).append(buildOfferingsMenu()).append(EOL);
        return sb.toString();
    }

    /*
     * Creates Extras list.
     */
    private String buildExtrasListing()
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (ExtrasItem i : extras.asCollection())
        {
            sb.append(i.getName()).append(COMMA).append(i.getCost());
            if (count++ < extras.size()) sb.append(EOL);
        }
        return sb.toString();
    }
    /*
     * Creates Offering menu.
     */
    private String buildOfferingsMenu()
    {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (OfferingItem r : offeringMap.asCollection())
        {
            sb.append(count).append(COMMA).append(r.getOfferingName()).append(COMMA)
                    .append(r.getFormattedPrice()).append(COMMA);

            if (count++ < offeringMap.size()) sb.append(EOL);
        }
        return sb.toString();
    }

    public String invalidMessage(String badInput) {
        return INVALID_MESG + badInput;
    }
    public String dispensingMessage(String drinkName) {
        return DISPENSING_MESG + drinkName;
    }

}
