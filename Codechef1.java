package Day1;

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

 class Node{
	List<String> adjacentWords;
	String path;

	Node(){
		this.adjacentWords = new ArrayList<String> ();
		this.path = "";

	}
	void addAdjacentNode(String word){
		this.adjacentWords.add(word);
	}
}


class Graph{
    static HashMap<String,Node> words2Adjacent =new  HashMap<String,Node>();

    public static void createGraph(String words[]){

	    for(int x=0;x<words.length;x++){
		     words2Adjacent.put(words[x],new Node());
        }
        for(int x=0;x<words.length;x++){
            for(int y=x;y<words.length&&(words[y].length()==words[x].length());y++){
                if(editDistance(words[x],words[y])){
                    words2Adjacent.get(words[x]).addAdjacentNode(words[y]);
                    words2Adjacent.get(words[y]).addAdjacentNode(words[x]);
//                    System.out.println(words[x]+" "+words[y]);
                }
            }
        }
	}

	public static boolean editDistance(String word,String nextWord){
	    int differenceCount=0;
	    for(int x=0;x<word.length();x++){
	        if(word.charAt(x)!=nextWord.charAt(x)){
	            differenceCount++;
	        }
	    }
	    return differenceCount==1;
	}


	public static String bfs(String start,String end){

    	Queue <String > queue = new LinkedList<String > ();
    	queue.add(start);
//    	words2Adjacent.get(start).path=start;
    	while(queue.size()!=0){
    		String temp_string=queue.peek();
    		Node temp_node = words2Adjacent.get(temp_string);

    		if(temp_string.equals(end)) return temp_node.path+"  "+end;

    		for(int i=0;i<temp_node.adjacentWords.size();i++){
    			String temp_child_string= temp_node.adjacentWords.get(i);
    			Node temp_child_node = words2Adjacent.get(temp_child_string);

    			if(temp_child_node.path.isEmpty())	{
    				temp_child_node.path = temp_node.path+"  " + temp_string;
    				queue.add(temp_child_string);
    			}
    		}
    		queue.remove();

    	}

    	return "no path available";
    }
}

public class Codechef1
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    String arr[]= {"bald","boas","boat","bold","clad","clag","clay","clod","clog","cold","glad","glid","goad","goal","goas","goat","gold","play","slay","stay"};

//		Graph graph =new Graph();
//		Graph.createGraph(arr);
//		System.out.println(graph.bfs("play","cold"));

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
           Graph graph= new Graph();
           graph.createGraph(arrOfWords);
           System.out.println(graph.bfs("play","cold"));

      }
      catch(Exception exception)
      {
    	  exception.printStackTrace();
      }

	}

}
