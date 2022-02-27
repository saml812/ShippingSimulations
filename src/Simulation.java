import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {

    private static ArrayList<Address> listOfAddress = new ArrayList<Address>();

    public static void importText(String fileName) {
        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {

                String streetNum = line.substring(0,line.indexOf(" "));

                String current = line.substring(line.indexOf(" ") + 1);

                String street = current.substring(0, current.indexOf(","));

                current = current.substring(current.indexOf(",") + 2);

                String city = current.substring(0, current.indexOf(","));

                current = current.substring(current.indexOf(",") + 2);

                String state = current.substring(0, current.indexOf(" "));
                String zipcode = current.substring(current.indexOf(" ") + 1);

                Address address = new Address(streetNum, street, city, state, zipcode);
                listOfAddress.add(address);

            }
            bufferedReader.close();
        } catch (IOException exception) {
            // Print out the exception that occurred
            System.out.println("Unable to access " + exception.getMessage());
        }
    }

    public static void main(String[] args) {
        importText("src/gistfile1.txt");

        ArrayList<Address> testList = new ArrayList<Address>();
        for(int i = 0; i < 30; i++)
        {
            int random = (int)(Math.random() * listOfAddress.size());
            Address test = new Address(listOfAddress.get(random));
            testList.add(test);
        }

        for(int i = 0; i < 30; i++)
        {
            int random = (int) (Math.random() * 9);//1-10 in
            double weight = (Math.random() * 9);
            double height = (Math.random() * 9);
            double length = (Math.random() * 9);
            double width = (Math.random() * 9);
            Package pack = new Package(testList.get(i),testList.get(random),weight, height, length, width);
            System.out.println(PostageCalculator.calculatePostage(pack));//calculates prices
        }
    }
}
