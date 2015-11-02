import java.util.LinkedList;

/**
 * Created by alvarpq on 10/15/15.
 */
public class City
{

    /*
    This uses my patentded "derpMode" skyline measuring system. Instead of worrying about efficency, we take the most intuitive method:
    Measuring every point! Each linkedList is full of 0's until they hit something that's not a 0. so 2, 4, 5 = 0444, and so on.
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


    //combines two city skylines into one. Easy logic because of the data structure. Had a lot of trouble, so this is the one that got super-easy to make.
    public City merge(City theSecond)
    {
        //to become the final skyline.
        LinkedList<Integer> significant = new LinkedList<>();

        int comp;//longest array
        if(fullSky.size() > theSecond.fullSky.size())
            comp = fullSky.size();
        else
            comp = theSecond.fullSky.size();

        for(int x = 0; x < comp; x++)//for both of the LL's.
        {

            if(x >= theSecond.fullSky.size())//first two are if one of the ll's don't actually have elements b/c they're two small
            {
                significant.add(fullSky.get(x));
            }
            else if(x >= fullSky.size())
            {
                significant.add(theSecond.fullSky.get(x));
            }
            else
            {
                if (theSecond.fullSky.get(x) > fullSky.get(x))//if none of them are too small, compare sizes
                {
                    significant.add(theSecond.fullSky.get(x));
                }
                else
                {
                    significant.add(fullSky.get(x));
                }
            }
        }
        return new City(significant);//guess what this does! It merges!
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
        int prevH = fullSky.get(0);//initial points. Apparently I'm supposed to start at 1, but...eh.
        int prevPT = 0;
        LinkedList<Integer> points = new LinkedList<>();
        LinkedList<Integer> heights = new LinkedList<>();

        for(int x = 0; x < fullSky.size(); x++)//filling the point/height pairs
        {
            if(fullSky.get(x) != prevH)
            {
                points.add(prevPT);
                heights.add(prevH);
                prevH = fullSky.get(x);
                prevPT = x;
            }
        }
        points.add(prevPT);//add last point/height pair for ending.
        heights.add(prevH);
        String out = "Points: ";
        for(int x = 0; x < points.size(); x++)
        {
            out += points.get(x) + ", " + heights.get(x) + "; ";
        }
        out += fullSky.size() + " , 0;";//lenght of final one to mark as endpoint.
        return out;
    }
}
