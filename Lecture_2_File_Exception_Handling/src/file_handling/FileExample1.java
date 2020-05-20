package file_handling;

import java.io.*;

public class FileExample1 {
    public static void main(String[] args) throws IOException {

        try {
            File file = new File("C:\\Users\\Shashi\\Desktop\\Test_Projects\\Apps\\src\\file_handling\\a.txt");
            if (file.createNewFile()) {
                System.out.println("New File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try{
            FileWriter fw=new FileWriter("C:\\Users\\Shashi\\Desktop\\Test_Projects\\Apps\\src\\file_handling\\b.txt");
            fw.write("Welcome to Java World.");
            fw.close();
        }catch(Exception e){
            System.out.println("No file found");
            System.out.println(e);
        }

        FileReader fr=new FileReader("C:\\Users\\Shashi\\Desktop\\Test_Projects\\Apps\\src\\file_handling\\c.txt");
        int i;
        while((i=fr.read())!=-1)
            System.out.print((char)i);
        fr.close();

    }



}
