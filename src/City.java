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
    LinkedList<Integer> fullSky = new LinkedList<Integer>();
    int left;
    //merges 2 spikes into an array, with 0's until the first left.
    public City(int l, int h, int r)//filling list with H's.
    {
        for(int x = 0; x < r - l; x++)
        {
            fullSky.add(h);
        }
        left = l;
    }

    //creates a city the obious way
    public City(int l, LinkedList<Integer> skyline)
    {
        left = l;
        fullSky = skyline;
    }


    //combines two city skylines into one. Probably janky as hell.
    public City merge(City theSecond)
    {
        int newLeft;
        int newRight;

        //there are effectively 4 sections to each combination. So yeah.
        if(theSecond.left < left)//find leftmost part
        {
            newLeft = theSecond.left;
        }
        else
        {
            newLeft = left;

        }

        //finding faruthes right sinde of the thing.
        if(theSecond.fullSky.size() + theSecond.left > left + fullSky.size())
        {
            newRight = theSecond.left + theSecond.fullSky.size();
        }
        else
        {
            newRight = left + fullSky.size();
        }

        //add the thigmgs to the linkedlist
        LinkedList<Integer> significant = new LinkedList<>();
        int comparisons[] = new int[2];
        for(int x = newLeft; x < newRight; x++)
        {
            comparisons[0] = 0;
            comparisons[1] = 0;
            if(theSecond.left > newLeft)
            {
                if(theSecond.fullSky.size() > x - newLeft)
                    comparisons[0] = theSecond.fullSky.get(x - newLeft);
            }
            if(left > newLeft)
            {
                if(fullSky.size() > x - newLeft)
                    comparisons[1] = fullSky.get(x - newLeft);
            }


            significant.add(compare(comparisons));
        }
        return new City(newLeft, significant);//guess what this does!
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
        theBase += left;
        for (int x = 0; x < fullSky.size(); x++)
        {
            theBase += ", " + fullSky.get(x);
        }
        theBase += ";\n";
        return theBase;

    }
}
