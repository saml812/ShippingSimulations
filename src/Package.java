public class Package {
    private Address origin;
    private Address destination;
    private double weight;//pounds
    private double height;//inches
    private double length;//inches
    private double width;//inches

    public Package(Address origin,Address destination,double weight, double length, double width, double height)
    {
        this.origin = origin;
        this.destination = destination;
        if(weight < .1)
        {
            System.out.println("Not a valid weight! (Less than .1 lbs) Weight will be equal to null");
            this.weight = 0;
        }
        else {
            this.weight = weight;
        }

        if(length < 2 || width < 2 || height < 2)
        {
            System.out.println("Not a valid size! (Less than 2 inches)");
            this.length = 0;
            this.width = 0;
            this.height = 0;
        }
        else {
            this.length = length;
            this.width = width;
            this.height = height;
        }
    }

    public Address getOrigin()
    {
        return  origin;
    }
    public Address getDestination()
    {
        return destination;
    }
    public double getWeight()
    {
        return weight;
    }
    public double getHeight()
    {
        return height;
    }
    public double getLength()
    {
        return length;
    }
    public double getWidth()
    {
        return width;
    }
}