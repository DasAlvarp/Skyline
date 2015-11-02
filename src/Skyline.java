import java.util.LinkedList;

/**
 * Created by alvarpq on 11/2/15.
 */
public class Skyline
{
    public LinkedList<City> outline = new LinkedList<>();

    public Skyline(LinkedList<City> out)
    {
        outline = out;
    }

    public Skyline(City tCity)
    {
        outline.add(tCity);
    }

    //divide and stuff.
    //merges 2 skylines by splitting it into more.
    public LinkedList<City> mergeRecursive(LinkedList<City> tempLine, LinkedList<City> line2)
    {
        LinkedList<City> tret = new LinkedList<City>();//Makes base cases easier
        if(tempLine.size() == 1 && line2.size() == 1)//2 things, so merge
        {
            tret.add(tempLine.get(0).merge(line2.get(1)));
            return tret;
        }
        else if(tempLine.size() == 1)//just 1 is itself.
        {
            tret.add(tempLine.get(0));//1, so combine with self
            return tret;
        }
        else if(line2.size() == 1)//just the other one.
        {
            tret.add(line2.get(0));
            return tret;
        }
        else
        {
           return mergeRecursive(mergeRecursive(split(tempLine)[0], split(tempLine)[1]),mergeRecursive(split(line2)[0],split(line2)[1]));//kinda funky call here: basically, it splits it more.
        }
    }


    private LinkedList<City>[] split(LinkedList<City> chop)//cuts it in half.
    {
        LinkedList<City>[] skyHalves = new LinkedList[2];

        for (int x = 0; x < chop.size() / 2; x++)
        {
            skyHalves[0].add(chop.get(x));
        }
        for (int x = chop.size() / 2 + 1; x < chop.size(); x++)
        {
            skyHalves[1].add(chop.get(x));
        }
        return skyHalves;
    }

}
