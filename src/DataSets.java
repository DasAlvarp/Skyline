import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by alvarpq on 10/15/15.
 */

public class DataSets
{
    public LinkedList<City> set(int num)
    {
        LinkedList<City> crowdedSky = new LinkedList<City>();
        if(num > 3 || num < 1)
        {
            System.out.println("Not a valid data set.");
            return crowdedSky;
        }
        Scanner scanMan;
        try
        {
            scanMan = new Scanner(new File("src/sky" + num + ".dat"));
            while (scanMan.hasNextLine())
            {
                //System.out.println(scanMan.nextLine());
                int h = scanMan.nextInt();
                int w = scanMan.nextInt();
                int l = scanMan.nextInt();
                crowdedSky.add(new City(h, w, l));
                System.out.println(crowdedSky.getLast().toString() + ", " +crowdedSky.size());
                //scanMan.nextLine();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return  crowdedSky;



    }

}

/*
All data sets:
        30 12 35                30 11 35                6  6 27
        1  9  4                10  7 14               11 11 22
        60 11 65                55  4 58               16 26 17
        52 17 54                16  7 20                3  3 30
        97 20 99                 1  1  4                9  9 24
        63  9 70                36  8 39               13 14 20
        32 17 33                22  6 25                5  5 28
        20 18 26                56  2 60               15 21 18
        13  9 23                 6 10  7                7  7 26
        3  6 12                17  8 18               10 10 23
        6  7 10                45  7 49                4  4 29
        25  6 29                33 13 35                8  8 25
        34  7 42                23 11 26                1  1 32
        38  8 45                46  8 48               14 17 19
        72  6 77                 3  9  8                2  2 31
        75  7 80                40  1 60               12 12 21
        85  8 86                27  9 32
        28  9 33                 2  3  6
        40 10 45                11  8 16
        80  9 83                37 10 38
        65 13 68                 8  4 40
        40  3 47
        55  8 61
        95 12 100
        40 12 43
        82  4 87
        90  3 98
        45  6 51
        86  5 97
        49 10 57
        47  5 53
        14  2 17
*/