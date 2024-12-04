package fileDonwloas;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileSize {
    // Get file size using a HEAD request
    public static long getFileSize(String url) throws IOException {
     URL u=new URL(url);
     HttpURLConnection huc=(HttpURLConnection) u.openConnection();
     huc.setRequestMethod("HEAD");
     huc.connect();
     long size=huc.getContentLengthLong();
     huc.disconnect();
     return size;
    }

}
