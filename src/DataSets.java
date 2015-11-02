import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by alvarpq on 10/15/15.
 * Designed to go through the data sets.
 */

public class DataSets
{
    public LinkedList<City> set(int num)
    {
        LinkedList<City> crowdedSky = new LinkedList<>();
        if(num > 3 || num < 1)//just in case you put in something stupid.
        {
            System.out.println("Not a valid data set.");
            return crowdedSky;
        }

        Scanner scanMan;
        try
        {
            scanMan = new Scanner(new File("src/sky" + num + ".dat"));
            while (scanMan.hasNextLine())//input until the file's empty. Had to get rid of newLines at the end of the files, hopefully that's OK
            {
                int l = scanMan.nextInt();
                int h = scanMan.nextInt();
                int r = scanMan.nextInt();
                crowdedSky.add(new City(l, h, r + 1));//so that things are ending on this one.Not sure if I interpreted the input right,
                // I interpreted that 2, 4, 5 means that pt 2 has height 4, pt 3 has height 4, point 4 has height 4, and pt 5 has height 5
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return  crowdedSky;
    }
}