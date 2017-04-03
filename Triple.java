public class Triple
{
    private int element0;
    private int element1;
    private int element2;

    public Triple(int first, int second, int third)
    {
        this.element0 = first;
        this.element1 = second;
        this.element2 = third;
    }

    public static Triple createTriple(int first, int second, int third)
    {
        return new Triple(first, second, third);
    }

    public int getElement0()
    {
        return element0;
    }

    public int getElement1()
    {
        return element1;
    }

    public int getElement2()
    {
        return element2;
    }

    public String toString()
    {
        return (Integer.toString(this.element0) + " " +
                Integer.toString(this.element1) + " " +
                Integer.toString(this.element2));
    }
}
