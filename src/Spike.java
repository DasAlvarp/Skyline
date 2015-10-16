/**
 * Created by alvarpq on 10/15/15.
 */
public class Spike
{
    int left;
    int height;
    int right;

    public int getRight()
    {
        return right;
    }

    public void setRight(int right)
    {
        this.right = right;
    }

    public int getLeft()
    {
        return left;
    }

    public void setLeft(int left)
    {
        this.left = left;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }



    public Spike(int h, int w, int r)
    {
        left = h;
        height = w;
        right = r;
    }

    public String toString()
    {
        return new String(left + ", " + height + ", " + right);
    }
}
