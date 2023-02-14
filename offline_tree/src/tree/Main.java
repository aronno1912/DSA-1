package tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);



        BSTree<Integer> bst = new BSTree<>();

        BufferedReader reader = new BufferedReader(new FileReader("src\\inputFile.txt"));
        String[] values = reader.readLine().split(" ");

        int size = values.length;
        int i = 0;
        while(i < size){
            String command = values[i];
            if (command.equals("F")){
                int val = Integer.parseInt(values[i+1]);
                bst.Find(val);
            }
            else if(command.equals("I")){
                int val = Integer.parseInt(values[i+1]);
               bst.Insert(val);
            }
            else if(command.equals("T")){
                if(values[i+1].equals("In"))
                    bst.inOrder();
                else if(values[i+1].equals("Pre"))
                    bst.preOrder();
                else if(values[i+1].equals("Post"))
                    bst.postOrder();
            }
            else if(command.equals("D")){
                int val = Integer.parseInt(values[i+1]);
              bst.Delete(val);
            }

            i+=2;
        }
        scanner.close();

    }
}

