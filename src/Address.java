public class Address {
    private String streetNum;
    private String street;
    private String apartmentNum;
    private String city;
    private String state;
    private String zipcode;
    private boolean isApartmentNum;

    public Address(String streetNum,String street,String apartmentNum,String city, String state, String zipcode)
    {
        this.streetNum = streetNum;
        this.street = street;
        this.apartmentNum = apartmentNum;
        this.city = city;
        this.state = state;
        if(zipcode.length() != 5)
        {
            System.out.println("Not a valid zipcode!");
            this.zipcode = null;
        }
        else {
            this.zipcode = zipcode;
        }
        isApartmentNum = true;
    }
    public Address(String streetNum,String street,String city, String state, String zipcode)
    {
        this.streetNum = streetNum;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        isApartmentNum = false;
    }

    public Address(Address address)
    {
        streetNum = address.getStreetNum();
        street = address.getStreet();
        city = address.getCity();
        state = address.getState();
        zipcode = address.getZipcode();
        if(address.isApartmentNumber())
        {
            apartmentNum = address.getApartmentNum();
            isApartmentNum = true;
        }
        else
        {
            isApartmentNum = false;
        }
    }

    //Number Street Apt Number (optional), City, State Zip
    //
    //1313 Mockingbird Lane Apt 6A, Springfield, MO 65123
    //
    //1313 Mockingbird Lane, Springfield, MO 65123
    public Address(String address)
    {
        if(address.indexOf("Apt") != -1)
        {
            isApartmentNum = true;
        }
        else
        {
            isApartmentNum = false;
        }

        //finds the index of street number
        int i = address.indexOf(" ");
        streetNum = address.substring(0,i);
        address = address.substring(i+1);

        if(isApartmentNum)
        {
            int apt = address.indexOf("Apt");
            street = address.substring(0,apt-1);//cause of space before Apt
            address = address.substring(apt + 4);
            int comma = address.indexOf(",");
            apartmentNum = address.substring(0,comma);
            address = address.substring(comma + 2);
        }
        else
        {
            int a =  address.indexOf(",");
            street = address.substring(0,a);
            address = address.substring(a+2);
        }
        //1313 Mockingbird Lane Apt 6A, Springfield, MO 65123
        //
        //1313 Mockingbird Lane, Springfield, MO 65123
        int c = address.indexOf(",");//city
        city = address.substring(0,c);
        address = address.substring(c+2);
        int s = address.indexOf(" ");//state;
        state = address.substring(0,s);
        address = address.substring(s + 1);
        zipcode = address;
    }

    public boolean compare(Address address)
    {
        boolean same = true;
        if (!(getStreet().equals(address.getStreet())))
        {
            same = false;
        }
        if (!(getStreetNum().equals(address.getStreetNum())))
        {
            same = false;
        }
        if (!(getCity().equals(address.getCity())))
        {
            same = false;
        }
        if (!(getZipcode().equals(address.getZipcode())))
        {
            same = false;
        }
        if (!(getState().equals(address.getState())))
        {
            same = false;
        }
        if(isApartmentNumber() != address.isApartmentNumber())
        {
            return false;
        }
        else {
            if(isApartmentNumber()) {
                if (!(getApartmentNum().equals(address.getApartmentNum()))) {
                    same = false;
                }
            }
        }
        return same;
    }
    public boolean isApartmentNumber()
    {
        return isApartmentNum;
    }
    public String getStreetNum()
    {
        return streetNum;
    }

    public String getStreet()
    {
        return street;
    }

    public String getApartmentNum()
    {
        if(isApartmentNum) {
            return apartmentNum;
        }
        else
        {
            System.out.println("There is no apartment number!");
            return null;
        }
    }

    public String getCity()
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public String toString()
    {
        String str;
        if(isApartmentNum) {
            str = streetNum + " " + street + " Apt " + apartmentNum + ", " + city + ", " + state + " " + zipcode;
        }
        else
        {
            str = streetNum + " " + street + ", " + city + ", " + state + " " + zipcode;
        }
        return str;
    }

}