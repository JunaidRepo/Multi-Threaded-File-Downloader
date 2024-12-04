# Multi-Threaded File Downloader

## Description
This project is a Java-based multi-threaded file downloader that splits a large file into chunks, downloads each chunk concurrently using multiple threads, and then merges the chunks into a single output file. The tool demonstrates efficient HTTP range requests and multithreading for faster and reliable file downloads.

## Features
- **Multi-threaded Downloading**: Utilizes multiple threads to download file chunks in parallel, speeding up the process.
- **Chunk Merging**: Combines downloaded chunks into a single output file.
- **Customizable**: Allows customization of the number of threads and output file location.
- **Robust**: Includes error handling for network interruptions and I/O operations.
