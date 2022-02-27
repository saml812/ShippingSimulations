public class PostageCalculator {
    private static double totalCost;
    private static double oCountyCode;
    private static double dCountyCode;

    public static double calculatePostage(String oZipCode, String dZipCode, double weight, double length, double width, double height)
    {
        oCountyCode = Integer.parseInt(oZipCode.substring(0,4));
        dCountyCode = Integer.parseInt(dZipCode.substring(0,4));
        double diff = Math.abs(dCountyCode-oCountyCode) / 100.0;
        totalCost = cost(weight,length,width, height) + diff;
        return totalCost;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double length, double width, double height)
    {
        String oZipCode = origin.getZipcode();
        String dZipCode = destination.getZipcode();
        oCountyCode = Integer.parseInt(oZipCode.substring(0,4));
        dCountyCode = Integer.parseInt(dZipCode.substring(0,4));
        double diff = Math.abs(dCountyCode-oCountyCode) / 100.0;
        totalCost = cost(weight,length,width, height) + diff;
        return totalCost;
    }

    public static double calculatePostage(Package pack)
    {
        String oZipCode = pack.getOrigin().getZipcode();
        String dZipCode = pack.getDestination().getZipcode();
        oCountyCode = Integer.parseInt(oZipCode.substring(0,4));
        dCountyCode = Integer.parseInt(dZipCode.substring(0,4));
        double diff = Math.abs(dCountyCode-oCountyCode) / 100.0;
        totalCost = cost(pack.getWeight(),pack.getLength(),pack.getWidth(), pack.getHeight()) + diff;
        return totalCost;
    }

    private static double cost(double weight, double length, double width, double height)
    {
        double c = 0;
        double diff = weight - 40;
        double times = diff/0.1;

        double inch = (length + height + width) - 36;
        if (weight > 40)
        {
            c = weight + (times * .10) * 10 * 0.5 + 3.75;
        }
        else if (length + height + width > 36)
        {
            c = weight + (inch * .10) * 10 * 0.5 + 3.75;
        }
        else
            c = weight * 10 * 0.5 + 3.75;
        return c;
    }
}
