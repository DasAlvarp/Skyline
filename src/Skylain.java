import java.util.LinkedList;

/**
 * Created by alvarpq on 10/15/15.
 */
public class Skylain
{
    public static void main(String[] args)
    {
        DataSets boo = new DataSets();
        LinkedList<City> dood = boo.set(2);
        System.out.println(dood.size());
        Skyline sky = new Skyline(dood);

        sky.mergeInductive();
        System.out.print(sky);
        //System.out.print(sky.mergeRecursive());
    }
}
