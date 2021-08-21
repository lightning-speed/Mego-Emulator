

import java.io.*;

public class FileManager {
    public static void write(String path,String text){
        try {
            if(!new File(path).exists())new File(path).createNewFile();
            FileWriter fw = new FileWriter(new File(path));
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String read(String path){
        if(!new File(path).exists()){
            try {
                new File(path).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
        String out = "";
        try {
            String temp = null;
            BufferedReader bf = new BufferedReader(new FileReader(path));
            while((temp = bf.readLine())!=null){out+=temp+'\n';}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
