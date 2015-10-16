import java.util.LinkedList;

/**
 * Created by alvarpq on 10/15/15.
 */
public class City
{
    LinkedList<Spike> fullSky;
    int[] skyMax;

    //merges 2 spikes into an array, with 0's until the first left.
    public int[] merge(Spike a, Spike b)
    {
        int left;
        int right;
        //finding left and rightmost significant points of both spikes
        if (a.getLeft() < b.getLeft())
        {
            left = a.getLeft();
        }
        else
        {
            left = b.getLeft();
        }

        if (a.getRight() > b.getRight())
        {
            right = a.getRight();
        }
        else
        {
            right = b.getRight();
        }

        //skyline array to be returned
        int[] sketchLine = new int[right];

        //fil leftmost parts with 0's
        for (int x = 0; x < left; x++)
        {
            sketchLine[x] = 0;
        }


        int priority;

        //set priority for higher spike
        if(b.getHeight() > a.getHeight())
        {
            priority = b.getHeight();
        }
        else
        {
            priority = a.getHeight();
        }

        //setting heights by spike
        for(int x = left; x < right; x++)
        {
            boolean both[] = {false, false};

            if(x >= a.getLeft() && x <= a.getRight())
            {
                both[0] = true;
            }
            if(x >= b.getLeft() && x <= b.getRight())
            {
                both[1] = true;
                if(!both[0])
                {
                    sketchLine[x] = b.getHeight();
                }
            }

            if(both[0] && both[1])
            {
                sketchLine[x] = priority;
            }
            else if (both[0] && !both[1])
            {
                sketchLine[x] = a.getHeight();
            }
            else
            {
                sketchLine[x] = 0;
            }
        }
        return sketchLine;
    }
}
