import java.util.LinkedList;

/**
 * Created by alvarpq on 11/2/15.
 * Holds all the cities, and meshes them, ideally. Can hold n cities, n <= 0
 */
public class Skyline
{
    public LinkedList<City> outline = new LinkedList<>();//stores the all of the cities involved. Cities can be more than one skyline.

    //constructor class
    public Skyline(LinkedList<City> out)
    {
        outline = out;
    }


    //inductive merge
    public void mergeInductive()
    {
        City thefancyOne = outline.get(0);//starts the city
        for(int x = 1; x < outline.size(); x++)
        {//just keep smooshing them together
            thefancyOne = thefancyOne.merge(outline.get(x));
        }
        LinkedList<City> ol = new LinkedList<>();

        ol.add(thefancyOne);
        outline = ol;
    }



    //divide and stuff.
    //merges 2 skylines by splitting it into more.
    public void mergeRecursive()
    {
        Skyline skydoot = new Skyline(mergeRecursive(split(outline).get(0), split(outline).get(1)));
        outline = skydoot.outline;
    }

    public LinkedList<City> mergeRecursive(LinkedList<City> tempLine, LinkedList<City> line2)
    {
        if(tempLine.size() == 1 && line2.size() == 1)//2 things, so merge
        {
            LinkedList<City> tret = new LinkedList<>();//Makes base cases easier. Single-size linked list
            tret.add(tempLine.get(0).merge(line2.get(0)));
            return tret;
        }
        else if(tempLine.size() == 1 && line2.size() > 1)//just 1 is itself. Mirror of this can't happen b/c of how split works.
        {
            return mergeRecursive(tempLine, mergeRecursive(split(line2).get(0), split(line2).get(1)));//returns merge of the right two with the left one.
        }
        else
        {
            LinkedList<City> left = mergeRecursive(split(tempLine).get(0), split(tempLine).get(1));
            LinkedList<City> right = mergeRecursive(split(line2).get(0), split(line2).get(1));//kinda funky call here: basically, it splits it more.
            return mergeRecursive(left, right);//base recursive call
        }
    }

    public String toString()//to display stuff for me.
    {
        String or = "";
        for(int x = 0; x < outline.size(); x++)
        {
            or += outline.get(x).toSpike();
        }

        return or;
    }

    private SkyRay split(LinkedList<City> chop)//cuts one linkedList into two
    {
        LinkedList<City> s1 = new LinkedList<>();
        LinkedList<City> s2 = new LinkedList<>();

        for (int x = 0; x < chop.size() / 2; x++)
        {
            s1.add(chop.get(x));
        }
        for (int x = chop.size() / 2; x < chop.size(); x++)
        {
            s2.add(chop.get(x));
        }
        return new SkyRay(s1, s2);
    }

}
