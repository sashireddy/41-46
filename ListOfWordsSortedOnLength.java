import java.util.*;
import java.lang.*;
import java.io.*;
public class ListOfWordsSortedOnLength{

     public static void main(String [] args)
     {

      try{
       File file = new File("/Users/yuva/Desktop/java/sowpods.txt");
       ArrayList<String> words=new ArrayList<>();
       BufferedReader br = new BufferedReader(new FileReader(file));
       String st;
       while ((st = br.readLine()) != null)
       {
         //System.out.println(st);
         words.add(st);

       }
       //System.out.println(words);
       Collections.sort(words, Comparator.comparing(String::length));

       String[] arrOfWords = new String[words.size()];
       arrOfWords = words.toArray(arrOfWords);
       for (String x : arrOfWords)
       System.out.println(x);

      }
      catch(Exception exception)
      {
        System.out.println("oh no");
      }
    }
}
