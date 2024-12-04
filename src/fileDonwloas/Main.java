package fileDonwloas;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static fileDonwloas.FileSize.getFileSize;
import static fileDonwloas.Merge.mergeChunks;

public class Main {
    private static final int THREAD_COUNT = 10; // Number of threads
    private static final String FILE_URL = "file location";
    private static final String OUTPUT_FILE = "systemloc & filename with extension";

    public static void main(String[] args) {
        try {
            // Step 1: Get the file size
            long fileSize = getFileSize(FILE_URL);
            System.out.println("File size: " + fileSize + " bytes");

            // Step 2: Divide the file into chunks
            long chunkSize = fileSize / THREAD_COUNT;

            // Step 3: Create a thread pool
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

            for (int i = 0; i < THREAD_COUNT; i++) {
                long startByte = i * chunkSize;
                long endByte = (i == THREAD_COUNT - 1) ? fileSize - 1 : startByte + chunkSize - 1;

                // Step 4: Assign a thread to download a chunk
                executor.execute(new DownloadThread(FILE_URL,"chunk_" + i + ".tmp", startByte, endByte ));
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
                // Wait for all threads to finish
            }
            mergeChunks( OUTPUT_FILE,THREAD_COUNT);
            System.out.println("File downloaded successfully: " + OUTPUT_FILE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
