import java.io.*;

public class weirdAssProgram {
    public static void main(String[] args) throws IOException {
        File file1  = new File("C:\\Users\\JackMa\\IdeaProjects\\Soulboy\\Data Structure\\Labs\\Lab 1\\L1Q2\\text1.txt");
        File file2  = new File("C:\\Users\\JackMa\\IdeaProjects\\Soulboy\\Data Structure\\Labs\\Lab 1\\L1Q2\\text2.txt");
        File file3  = new File("C:\\Users\\JackMa\\IdeaProjects\\Soulboy\\Data Structure\\Labs\\Lab 1\\L1Q2\\text3.txt");
        File file4  = new File("C:\\Users\\JackMa\\IdeaProjects\\Soulboy\\Data Structure\\Labs\\Lab 1\\L1Q2\\text4.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                String cleaned = line.replaceAll("[^a-zA-Z0-9]","\n");
                sb.append(cleaned);
            }

            int charCount1 = sb.length();
            
            System.out.print("Text 1:");
            System.out.println(sb); 
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
