import java.util.Comparator;

public class TripleComparator implements Comparator<Triple>
{
    @Override
    public int compare(Triple arg0, Triple arg1)
    {
        //need lexicographic sorting
        //First: handle case where arg0 has only one value
        if(arg0.getElement1() < 0)
        {
            if(arg1.getElement1() >= 0)
            {
                return -1;
            }
            else if(arg0.getElement0() == arg1.getElement0())
            {
                return 0;
            }
            else
            {
                return arg0.getElement0() < arg1.getElement0() ? -1 : 1;
            }
        }
        //Second is same as first, but for arg1
        else if(arg1.getElement1() < 0)
        {
            if(arg0.getElement1() >= 0)
            {
                return 1;
            }
            else if(arg1.getElement0() == arg0.getElement0())
            {
                return 0;
            }
            else
            {
                return arg0.getElement0() < arg1.getElement0() ? -1 : 1;
            }
        }
        else
        {
            if(arg0.getElement0() < arg1.getElement0())
            {
                return -1;
            }
            else if(arg0.getElement0() == arg1.getElement0())
            {
                /*
                    This case is a bit convoluted, due to the possible values of the triples.
                    Using properties derived from the solution to the problem, we know the following:
                        1. Once any two of the points are found, the third has only one possible value,
                            as all 3 points are collinear
                        2. If the second elements of the two arguments are not the same, then they cannot have the same
                            value for the third argument
                        3. Since both arg0 and arg1 have the same first element, if arg0 has a smaller second element,
                            then its third element will be smaller as well. This allows us to return -1 without further examination.
                */
                if(arg0.getElement1() < arg1.getElement1())
                {
                    return -1;
                }

                else if(arg0.getElement1() == arg1.getElement1())
                {
                    /* They must be equal because we built our triples such that
                       if the first and second elements are identical, then so must the third
                       because the value of the third element is determined by the values of the
                       first and second elements
                    */
                    return 0;

                }
                else
                {
                    //second element of arg0 greater, so arg1 needs to go first
                    return 1;
                }
            }
            else
            {
                //since first element of arg0 is greater, arg1 needs to go before it
                return 1;
            }
        }
    }
}
