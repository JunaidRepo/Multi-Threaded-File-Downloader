package fileDonwloas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Merge {
    public static void mergeChunks(String Loc,int Threadcount){
        try(FileOutputStream fos=new FileOutputStream(Loc)){
            for (int i = 0; i < Threadcount; i++) {
                File mini=new File("mini"+i+".temp");
                try(FileInputStream fis=new FileInputStream(mini)) {
                    byte []data=new byte[1024];
                    int read= fis.read();
                    while (read!=-1){
                        fos.write(data,0,read);
                        read = fis.read();
                    }

                }

            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
