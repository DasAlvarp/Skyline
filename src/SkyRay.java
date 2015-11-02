import java.util.LinkedList;

/**
 * Created by alvarpq on 11/2/15.
 */
public class SkyRay
{
    private LinkedList<City> s1;
    private LinkedList<City> s2;

    public SkyRay(LinkedList<City> one, LinkedList<City> two)
    {
        s1 = one;
        s2 = two;
    }
    public LinkedList<City> get(int x)
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
