import java.io.*;
import java.util.Scanner;

public class ReadMyLetter_25006825 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\JackMa\\IdeaProjects\\Soulboy\\Data Structure\\Labs\\Lab 1\\L1Q1\\BruceWayne_25006825.txt");
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    String output = reader.nextLine();
                    System.out.println(output);
                }
            }

        try (Scanner sc = new Scanner(System.in)){
        System.out.println("Type yo thing twin: ");
        String input = sc.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
            writer.newLine();
            writer.write(input);

            System.out.println("\nAight we done.\n");
        }}

        System.out.println("Now take a look:\n");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        


                
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }
}
