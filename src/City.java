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
    }

    public City(int l, LinkedList<Integer> skyline)
    {
        left = l;
        fullSky = skyline;
    }

    public City merge(City theSecond)
    {
        City bigCity;
        City smallCity;
        int newLeft;
        int secondLeft;
        int newRight;
        int secondRight;
        //there are effectively 4 sections to each combination. So yeah.
        if(theSecond.left < left)
        {
            newLeft = theSecond.left;
            secondLeft = left;
            bigCity = theSecond;
            smallCity = this;
        }
        else
        {
            newLeft = left;
            secondLeft = theSecond.left;
            bigCity = this;
            smallCity = theSecond;
        }

        if(theSecond.fullSky.size() < fullSky.size())
        {
            newRight = fullSky.size() + this.left;
            secondRight = theSecond.fullSky.size() + theSecond.left;
        }
        else
        {
            newRight = theSecond.fullSky.size() + theSecond.left;
            secondRight = fullSky.size() + this.left;
        }

        int significantMidOrder[] = new int[2];
        if(secondRight < secondLeft)
        {
            significantMidOrder[0] = secondRight;
            significantMidOrder[1] = secondLeft;
        }
        else
        {
            significantMidOrder[0] = secondLeft;
            significantMidOrder[1] = secondRight;
        }


        LinkedList<Integer> significant = new LinkedList<Integer>();

        for(int x = 0; x < significantMidOrder[0]; x++)
        {
            significant.add(bigCity.fullSky.get(x));
        }
        for(int x = significantMidOrder[0]; x < significantMidOrder[1]; x++)
        {
            if(bigCity.fullSky.get(x) > this.fullSky.get(x - significantMidOrder[0]))
            {
                significant.add(bigCity.fullSky.get(x));
            }
            else
            {
                significant.add(this.fullSky.get(x - significantMidOrder[0]));
            }
        }
        if(bigCity.fullSky.size() > significantMidOrder[1])
        {
            for (int x = significantMidOrder[1]; x < newRight; x++)
            {
                significant.add(bigCity.fullSky.get(x));
            }
        }
        else
        {
            for (int x = significantMidOrder[1]; x < newRight; x++)
            {
                significant.add(smallCity.fullSky.get(x - significantMidOrder[0]));
            }
        }

        return new City(newLeft, significant);

    }
}
