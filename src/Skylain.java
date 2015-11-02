import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by alvarpq on 10/15/15.
 */
public class Skylain
{
    public static void main(String[] args)
    {
        //Getting input
        Scanner scanMan = new Scanner(System.in);
        System.out.println("0 for inductive, 1 for divide and conquer");
        int type = scanMan.nextInt();
        System.out.println("What data set? (1-3 plz)");
        int set = scanMan.nextInt();

        //dataSets is the object that retrives data from the sky.dat files
        DataSets info = new DataSets();
        LinkedList<City> cloudySky = info.set(set);

        Skyline sky = new Skyline(cloudySky);//creating

        if(type == 0)
            sky.mergeInductive();
        else
            sky.mergeRecursive();

        System.out.print(sky.toString());
    }
}
