package exception_handling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Try_Catch {

     int div(int a, int b){
        try {
            return a / b;
        } finally {
            System.out.println("Always");
        }
    }

     void fileRead() throws UserNotFoundException{
        try {
            FileReader fr = new FileReader("C:\\Users\\Shashi\\Desktop\\Test_Projects\\Apps\\src\\file_handling\\d.txt");
            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
            fr.close();
        } catch (Exception e){
            System.out.println(e);
            throw new UserNotFoundException("File nhi mila");
        }
    }
    void ReadAnotherFile(){

    }

    public static void main(String[] args) throws UserNotFoundException{

        Try_Catch obj = new Try_Catch();
        try {
            int c = obj.div(10, 0);
        }catch (Exception e){
            System.out.println(e);
        }

        int c = obj.div(10, 2);
        System.out.println(c);

        System.out.println("Hi ");
        // throw --> throws

        try {
            obj.fileRead();
        }catch (Exception e){
            System.out.println("This line ");
            System.out.println(e);
            throw new UserNotFoundException("I wont' handle it");
            //obj.ReadAnotherFile();

        }

        obj.fileRead();

        System.out.println("Hi after read");

    }
}
