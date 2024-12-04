package fileDonwloas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread implements Runnable{
    private final String URLconn;
    private final String output;
    private final long begin;
    private final long end;

    public DownloadThread(String url, String output, long begin, long end) {
        URLconn = url;
        this.output = output;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            URL u=new URL(URLconn);
            HttpURLConnection ht=(HttpURLConnection) u.openConnection();
            ht.setRequestProperty("Range","TotalBytes="+begin+"-"+end);
           // ht.setRequestProperty("Range", "bytes=" + begin + "-" + end);

            ht.connect();
            try(InputStream i=ht.getInputStream();
                FileOutputStream go=new FileOutputStream(output)){
                byte []b=new byte[1024];
                int r=i.read(b);
                while(r !=-1){
                    go.write(b,0,r);
                    r=i.read(b);
                }

            }
            System.out.println("downloaded");

        } catch (IOException e) {
            System.out.println("not downloaded"+e.getMessage());
        }
    }


}
