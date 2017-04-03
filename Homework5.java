//By Noah Ransom

import java.util.*;
import java.util.Collections;

class Homework5
{
    public LinkedList<Triple> alignPoles(LinkedList<Integer> lengths)
    {
        LinkedList<Triple> toReturn = new LinkedList<Triple>();
        for(int i = 0; i < lengths.size(); i++)
        {
            int y1 = lengths.get(i);
            for(int j = 0; j < lengths.size(); j++)
            {
                if((i == j) || (lengths.get(j) < y1))
                {
                    //ensures that we don't consider an identical pole twice in one solution
                    continue;
                }
                int y2 = lengths.get(j);

                for(int k = 0; k < lengths.size(); k++)
                {
                    int y3 = lengths.get(k);
                    if( (k == j) || (k == i) || (y3 < y2))
                    {
                        continue;
                    }

                    if( (y3 == y2) && (y2 == y1))
                    {
                        //y1,y2,y3 collinear
                        //adding -1 as other two elements lets me sort triples later
                        //negative numbers are ignored by the print function,
                        //and the compare function gives greater precedence to
                        //triples with negative elements
                        toReturn.add(Triple.createTriple(y1, y2, y3));
                    }
                    else if(y3 == y2 + y2 - y1)
                    {
                        toReturn.add(Triple.createTriple(y1, y2, y3));
                    }

                }
            }
        }
        return toReturn;
    }

    public void printPoles(LinkedList<Triple> lines)
    {
        Collections.sort(lines, new TripleComparator());
        while(lines.size() > 0)
        {
            System.out.println(lines.remove().toString());
        }
    }

    public static void main(String[] args)
    {
        Homework5 h5 = new Homework5();
        LinkedList<Integer> poles = new LinkedList<Integer>();
        Scanner scan = new Scanner(System.in);

    	while(scan.hasNext())
    	{
            poles.add(scan.nextInt());
    	}
    	scan.close();
        h5.printPoles(h5.alignPoles(poles));

    }
}
