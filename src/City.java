import java.util.LinkedList;

/**
 * Created by alvarpq on 10/15/15.
 */
public class City
{

    /*
    This uses my patentded "derpMode" skyline measuring system. Instead of worrying about efficency, we take the most intuitive method:
    Measuring every point! We know the left point on the skyline, and we know every one in between. This makes merging skylines easy too.
    It also makes in seem kinda stupid. But whatever.
     */

    LinkedList<Integer> fullSky = new LinkedList<>();
    //merges 2 spikes into an array, with 0's until the first left.
    public City(int l, int h, int r)//filling list with H's.
    {
        for(int x = 0; x < l; x++)
            fullSky.add(0);
        for(int x = 0; x < r - l; x++)
        {
            fullSky.add(h);
        }
    }

    //creates a city the obious way
    public City(LinkedList<Integer> skyline)
    {
        fullSky = skyline;
    }


    //combines two city skylines into one. Probably janky as hell.
    public City merge(City theSecond)
    {
        LinkedList<Integer> significant = new LinkedList<>();

        int comp;
        if(fullSky.size() > theSecond.fullSky.size())
            comp = fullSky.size();
        else
            comp = theSecond.fullSky.size();

        for(int x = 0; x < comp; x++)
        {

            if(x >= theSecond.fullSky.size())
            {
                significant.add(fullSky.get(x));
            }
            else if(x >= fullSky.size())
            {
                significant.add(theSecond.fullSky.get(x));
            }
            else
            {
                if (theSecond.fullSky.get(x) > fullSky.get(x))
                {
                    significant.add(theSecond.fullSky.get(x));
                }
                else
                {
                    significant.add(fullSky.get(x));
                }
            }
        }
        return new City(significant);//guess what this does!
    }

    //returns the greater value of 2 things in an array

    private int compare(int[] compary)
    {
        if(compary[0] > compary[1])
            return compary[0];
        return compary[1];
    }

    @Override
    public String toString()
    {
        String theBase = "!";
        for (int x = 0; x < fullSky.size(); x++)
        {
            theBase += ", " + fullSky.get(x);
        }
        theBase += ";\n";
        return theBase;

    }

    public String toSpike()
    {
        //derp notation translator
        int prevH = fullSky.get(0);
        int prevPT = 0;
        LinkedList<Integer> points = new LinkedList<>();
        LinkedList<Integer> heights = new LinkedList<>();

        for(int x = 0; x < fullSky.size(); x++)
        {
            if(fullSky.get(x) != prevH)
            {
                points.add(prevPT);
                heights.add(prevH);
                prevH = fullSky.get(x);
                prevPT = x;
            }
        }
        points.add(prevPT);
        heights.add(prevH);
        String out = "Points: ";
        for(int x = 0; x < points.size(); x++)
        {
            out += points.get(x) + ", " + heights.get(x) + "; ";
        }
        return out;
    }
}
