
import java.io.PrintWriter;
import java.io.*;
import java.util.*;

class Test
{
    public boolean writeToFile(String toWrite)
    {
        //I found the code below online. I make no claim to its creation
        try
        {
            FileWriter writer = new FileWriter("test-data.txt", true);
            writer.append(toWrite);
            writer.close();
            return true;
        } catch (IOException e)
        {
            System.err.println("File issue");
            return false;
        }
    }

    public boolean writeToFile(String toWrite, String fileName, boolean append)
    {
        //I found the code below online. I make no claim to its creation
        try
        {
            FileWriter writer = new FileWriter(fileName, append);
            writer.append(toWrite);
            writer.close();
            return true;
        } catch (IOException e)
        {
            System.err.println("File issue");
            return false;
        }
    }

    public double average(long[] data)
    {
        double toReturn = 0.0;
        for(int i = 0; i < data.length; i ++)
        {
            toReturn += data[i];
        }
        return(toReturn/data.length);
    }

    private void addTimes(LinkedList<Integer> list, Integer value, int times)
    {
        for(int i = 0; i < times; i++)
        {
            list.add(value);
        }
    }

    private void createRands()
    {
        Random rand = new Random();
        this.writeToFile("", "RandomInts.txt", false);
        for(int i = 0; i < 25; i ++)
        {
            this.writeToFile((rand.nextInt(25) + 1) + ", ", "RandomInts.txt", true);
        }
    }

    private LinkedList<Integer> getRands()
    {
        LinkedList<Integer> rands = new LinkedList<Integer>();
        //retrieves the random numbers from the file and puts them in a list
        try
        {
            Scanner read = new Scanner(new File("RandomInts.txt"));
            while (read.hasNextInt())
            {
                rands.add(read.nextInt());
                //int foo = read.nextInt();
                //System.out.println(foo);
            }
            read.close();

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return rands;
    }

    private void test()
    {
        Homework5 aligner = new Homework5();
        long startTime;
        long endTime;
        long testTimes[] = new long[5];
        //test consecutive numbers 1 to 25 in 1 num increments, starting at 3
        writeToFile("Testing consecutive numbers from 3 to 25, 1 copy each\n");
        LinkedList<Integer> poles = new LinkedList<Integer>();
        poles.add(1);
        poles.add(2);
        for(int i = 3; i <= 25; i++)
        {
            poles.add(i);
            writeToFile("n = " + poles.size() + ":\tRUNS: ");
            for(int j = 0; j < 5; j++)
            {
                startTime = System.currentTimeMillis();
                aligner.alignPoles(poles);
                endTime = System.currentTimeMillis();
                testTimes[j] = (endTime-startTime);
                writeToFile(testTimes[j] + " ");
            }
            writeToFile(" AVERAGE: " +(this.average(testTimes)) + "\n");
        }

        poles.clear();
        writeToFile("\nTesting consecutive numbers from 3 to 25, 3 copies each. \n");
        this.addTimes(poles, 1, 3);
        this.addTimes(poles, 2, 3);
        for(int i = 3; i <= 25; i++)
        {
            this.addTimes(poles, i, 3);
            writeToFile("n = " + poles.size() + ":\tRUNS: ");
            for(int j = 0; j < 5; j++)
            {
                startTime = System.currentTimeMillis();
                aligner.alignPoles(poles);
                endTime = System.currentTimeMillis();
                testTimes[j] = (endTime-startTime);
                writeToFile(testTimes[j] + " ");
            }
            writeToFile(" AVERAGE: " +(this.average(testTimes)) + "\n");
        }


        poles.clear();
        writeToFile("\nTesting predetermined random numbers from 1 to 25, with n between 3 and 25. \n");
        LinkedList<Integer> rands = new LinkedList<Integer>();
        rands = this.getRands();
        poles.add(rands.remove());
        poles.add(rands.remove());
        for(int i = 3; i <= 25; i++)
        {
            poles.add(rands.remove());
            writeToFile("n = " + poles.size() + ":\tRUNS: ");
            for(int j = 0; j < 5; j++)
            {
                startTime = System.currentTimeMillis();
                aligner.alignPoles(poles);
                endTime = System.currentTimeMillis();
                testTimes[j] = (endTime-startTime);
                writeToFile(testTimes[j] + " ");
            }
            writeToFile(" AVERAGE: " +(this.average(testTimes)) + "\n");
        }
    }

    public static void main(String[] args)
    {
        Test t = new Test();
        t.test();
        t.getRands();
        //List<String> testData = new ArrayList<String>();
        //Test with consecutive numbers
        //Test with random numbers
        //Test with a lot of repeats
        //Test with only repeats
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
    }
}
