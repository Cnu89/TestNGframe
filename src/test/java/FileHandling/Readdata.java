package FileHandling;

import org.testng.annotations.Test;

import java.io.*;

public class Readdata {
    @Test
    public void Textfileread() throws IOException {
        //make connection for the file
        File f = new File("C:\\Users\\SrinivasReddy Pakala\\IdeaProjects\\Testngframework\\Addingtextfile.txt");
        //  By using Filereader
        FileReader fr = new FileReader(f);
        //ascii   System.out.println(fr.read());
        int i = fr.read();
        while (i != -1) {
            System.out.print((char) i);
            i = fr.read();
        }
    }

    @Test
    public void Readtextusingbuff() throws IOException {
        //make connection for the file
        File f = new File("C:\\Users\\SrinivasReddy Pakala\\IdeaProjects\\Testngframework\\Addingtextfile.txt");
        //  By using Filereader
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        while (s != null) {
            System.out.println(s);
            s = br.readLine();
        }
    }

    @Test
    public void Writedatausingfilewiter() throws IOException {
        File f = new File("C:\\Users\\SrinivasReddy Pakala\\IdeaProjects\\Testngframework\\Writingtextfile.txt");
        FileWriter fw = new FileWriter(f);
        fw.write("Hello cnu");
        fw.flush();
        fw.close();
    }

    @Test
    public void Writedatausingbufferwiter() throws IOException {
        File f = new File("C:\\Users\\SrinivasReddy Pakala\\IdeaProjects\\Testngframework\\Writingtextfile.txt");
        FileWriter fw = new FileWriter(f,true);//for addition new line
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("Hello cnu");
        bw.flush();
        bw.close();
    }
}
