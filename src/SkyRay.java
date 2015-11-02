import java.util.LinkedList;

/**
 * Created by alvarpq on 11/2/15.
 */
public class SkyRay //"Skyline array," or skyray of size 2, basically
{
    private LinkedList<City> s1;
    private LinkedList<City> s2;

    public SkyRay(LinkedList<City> one, LinkedList<City> two)//constructor
    {
        s1 = one;
        s2 = two;
    }

    public LinkedList<City> get(int x)//returns the first or the second. B/c I'm the only one using it, I know I'll only use 1 or 0
    {
        if(x == 0)
        {
            return s1;
        }
        else
        {
            return s2;
        }
    }
}
