

public class ArrayAlgorithms {




    public static void printExclamation(String[] wordList) {
        for (int i = 0; i < wordList.length; i++)
        {
            System.out.println(wordList[i]+"!");
        }




    }




    public static void addExclamation(String[] wordList)
    {
        for (int i = 0; i < wordList.length; i++)
        {
            wordList[i]=(wordList[i]+"!");
        }
    }








    public static int sum(int[] numList)
    {
        int sum=0;
        for (int i = 0; i < numList.length; i++)
        {




            sum+=(numList[i]);
        }
        return(sum);
    }




    public static double average(int[] numList)
    {
        int sum=0;
        for (int i = 0; i < numList.length; i++)
        {




            sum+=(numList[i]);
        }
        return((double)sum/numList.length);
    }




    public static int minimum(int[] numList)
    {
        int smolNumber=999999999;
        for (int i = 0; i < numList.length; i++)
        {
            if(smolNumber>numList[i]){
                smolNumber=numList[i];
            }




        }
        return(smolNumber);
    }




    public static int maximum(int[] numList)
    {         int beegNumber=-999999999;
        for (int i = 0; i < numList.length; i++)
        {
            if(beegNumber<numList[i]){
                beegNumber=numList[i];
            }




        }
        return(beegNumber);
    }








    public static void multiplyBy(int[] numList, int multiplier)
    {
        for (int i = 0; i < numList.length; i++)
        {
            numList[i]=(numList[i]*multiplier);
        }
    }




    public static int[] squares(int[] numList)
    {
        int[] list=new int[numList.length];
        for (int i = 0; i < numList.length; i++)
        {
            list[i]=(numList[i]*numList[i]);
        }


        return list;
    }


    public static void flipBool(boolean[] boolList)
    {
        for (int i = 0; i < boolList.length; i++) {
            if (boolList[i] == true) {
                boolList[i] = false;
            } else {
                boolList[i] = true;
            }
        }
    }
    /** Returns a String representing the array of ints as a printable String,
     *  including open and closing brackets, with values separated by commas.
     *  This method should function identically to Arrays.toString()!


     *  Does NOT mutate (modify) original numList.
     *  PRECONDITION: numList.length > 0
     *
     *  @param numList  original array of ints to be represented in String form
     */
    public static String customToString(int[] numList)
    {
        String list="";
        for (int i = 0; i < numList.length; i++)
        {




            list+=(numList[i])+", ";
        }
        return ("["+list+"]");
    }
    /** Returns the length of the longest String(s) in an array of Strings.
     *  Does NOT mutate (modify) stringList.
     *  PRECONDITION: stringList.length > 0
     *
     *  @param stringList  original array of Strings; does not get modified
     *  @return  length of the longest String in the array
     */

    public static int longestString(String[] stringList)
    {
        int stringLength=-999999999;
        for (int i = 0; i < stringList.length; i++)
        {
            if(stringLength<stringList[i].length()){
                stringLength=stringList[i].length();

            }




        }
        return(stringLength);
    }

    /** Changes all words in an array of words to uppercase.
     *  DOES mutate (modify) original wordList.
     *  PRECONDITION: wordList.length > 0
     *
     *  @param wordList  original array of Strings, modified by method
     */
    public static void makeUppercase(String[] wordList)
    {  for (int i = 0; i < wordList.length; i++)
            wordList[i]=wordList[i].toUpperCase();
    }

}
