import java.util.ArrayList;

public class Locker
{
    private int lockernumber;
    private String[] combinations = new String[5];
    private int combination = 0;
    private ArrayList<String> contents = new ArrayList<String>();

    // 1332

    /**
     *
     * @param combo
     */
    public Locker(int combo)
    {
        lockernumber = combo;

        Math.floor(Math.random()*50); // generate a random number between 0-49

        // loop 5 times
        for (int i = 0; i < combinations.length; i++) {
            String combo1 = Integer.toString((int)(Math.random()*50));
            int range = (i*10+9) - (i*10);
            String combo2 = Integer.toString((int)(Math.random()*range) + i*10);
            String combo3 = Integer.toString((int)(Math.random()*50));

            combinations[i] = combo1 + "-" + combo2+ "-" + combo3;
        }

    }

    /**
     *
     * @return
     */
    public String getCombination()
    {
        return combinations[combination];
    }


    public void nextCombination()
    {
        // increment combination instance variable by 1, up to 4, then wrap back to 0
        // 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0 , 1, 3, ... (abcde)
        combination += 1;
        if (combination == 5) {
            combination = 0;
        }

    }

    /**
     *
     * @param c
     */
    public void addItem(String c)
    {
        contents.add(0, c);
    }

    /**
     *
     * @return
     */
    public String getContents()
    {
        return String.join(", ", contents);
    }

    /**
     *
     * @param c
     */
    public void removeItem(String c)
    {
        int index = contents.indexOf(c);
        if(index != -1)
        {
            contents.remove(c);
        }
    }

    /**
     *
     * @return
     */
    public String toString() //prints out everything
    {
        return "Locker: " + lockernumber + "\n"
                + "A: " + combinations[0] + "\n"
                + "B: " + combinations[1] + "\n"
                + "C: " + combinations[2] + "\n"
                + "D: " + combinations[3] + "\n"
                + "E: " + combinations[4] + "\n"
                + "Contents: " + getContents() + "\n";
    }

}
