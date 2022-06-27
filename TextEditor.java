import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Editor {
    void NewFile() {
        String fileName;
        Scanner ip = new Scanner(System.in);
        System.out.print("Write your file name ");
        fileName = ip.nextLine();
        String name = fileName + ".txt";
        try {
            File f = new File(name);
            FileWriter fw = new FileWriter(f);
            try {
                if (f.createNewFile()) {
                    System.out.println("Your new file Succefull created");
                } else {
                    System.out.println("file Already Exit ");
                }
            } catch (IOException i) {
                System.out.println("something error ");

            }
            try {
                String text;
                text = ip.nextLine();
                fw.write(text);

            } finally {
                fw.close();
                System.out.println("Your input is succefull pushed in file ");
            }
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    void ReadFile() {
        String fileName;
        Scanner ip = new Scanner(System.in);
        System.out.print("Write your file name to open ");
        fileName = ip.nextLine();
        String name = fileName + ".txt";
        try {
    
            FileReader r = new FileReader(name);
            System.out.println(" Your File data is \n \n");
            try {
                int i;
                while ((i = r.read()) !=-1) {
                    System.out.print((char)i);
                }

            } finally {
                r.close();
            }
        } catch (IOException i) {
            System.out.println(i);
        }
    }
    void SearchFile() {
        String fileName;
        Scanner ip = new Scanner(System.in);
        System.out.print("Write your file name to open ");
        fileName = ip.nextLine();
        String name = fileName + ".txt";

        try {
    
            FileReader r = new FileReader(name);
            BufferedReader bw=new BufferedReader(r);
            System.out.println("Enter to search ");
            String sr=ip.next();
            try {
                
                String s;
                while((s=bw.readLine())!=null) {
                if(s.contains(sr)){
                    System.out.println("Your data is present in file");
                    break;
                }else{
                    continue;
                }
                
                }
               

            } finally {
                r.close();
                System.out.println("Data not found");
            }
        } catch (IOException i) {
            System.out.println(i);
        }
    }
    void DeleteFile() {
        String fileName;
        Scanner ip = new Scanner(System.in);
        System.out.print("Write your file name to open ");
        fileName = ip.nextLine();
        String name = fileName + ".txt";
        
           
            File file=new File(name);
            if(file.delete()){
                System.out.println("File is deleted");
            }else{
                System.out.println("Error to deleting file");
            }
            
    }
}
public class TextEditor {
    void Topoperation() {
        Editor ed = new Editor();
        int option;
        Scanner ip = new Scanner(System.in);
        System.out.println();
        System.out.print("1  New \t");
        System.out.print("2  Search  \t");
        System.out.print("3  Delete \t");
        System.out.print("4  Open \t");
        System.out.println("5 Exit  ");
        System.out.print("Your Option : ");

        option = ip.nextInt();

        switch (option) {
            case 1:
                ed.NewFile();
                break;
                case 2:ed.SearchFile();
                break;
                case 3:ed.DeleteFile();
                break;
            case 4 : ed.ReadFile();
            break;
           
            case 5: System.exit(0);
        }

    }

    public static void main(String[] args) {
        TextEditor t = new TextEditor();
        t.Topoperation();
    }
}