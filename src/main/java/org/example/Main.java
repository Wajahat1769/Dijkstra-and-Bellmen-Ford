package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException,NullPointerException {
        ArrayList <String>data=new ArrayList<String>();
        int [] nodes = new int[100];
        int [] edges = new int[100];

       Scanner sc = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\AlgoProject\\src\\main\\java\\org\\example\\data.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            data.add(line);
        }


       for(int i=0;i< 100;i++){
            String []item = data.get(i).split("\t");
            nodes[i]=Integer.parseInt(item[0]);
            edges[i]=Integer.parseInt(item[1]);
        }
        System.out.println(nodes[nodes.length-1]);
        LinkedList<Integer>[] vertex= new LinkedList[nodes[nodes.length-1]+1];

        for(int i=0;i<100;i++){
            if(vertex[nodes[i]]==null){
                vertex[nodes[i]]=new LinkedList<>();

            }
            vertex[nodes[i]].add(edges[i]);

        }
        System.out.println("Size : "+vertex.length);
        for(int i=0;i<vertex.length;i++){
            System.out.print("[");
            try {
                for(int j=0;j< vertex[i].size();j++) {
                    try {
                        System.out.print(vertex[i].get(j) + ",");
                    }catch (IndexOutOfBoundsException e){
                        e.getStackTrace();
                    }

                }
            }catch(NullPointerException e){
                e.getStackTrace();
            }

            System.out.println("]");
        }
    }
}
