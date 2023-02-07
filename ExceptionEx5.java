package 예외처리예제5번;

import java.io.FileWriter;
import java.io.IOException;

//finally :
public class ExceptionEx5 {
    public static void main(String[] args) {
        FileWriter f = null;
        try {
            f = new FileWriter("test.txt");
            f.write("test");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (f != null){
               try {
                   f.close();
               }catch (IOException e){
                   e.printStackTrace();
               }

            }
        }
    }
}
