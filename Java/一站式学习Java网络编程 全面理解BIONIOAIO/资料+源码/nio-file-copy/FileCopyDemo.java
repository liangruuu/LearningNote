import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

interface FileCopyRunner {

    void copyFile(File source, File target);

}

public class FileCopyDemo {
    private static final int ROUNDS = 5;

    private static void benchmark(FileCopyRunner test, File source, File target) {
        long elapsed = 0L;
        for (int i = 0; i < ROUNDS; i++) {
            long startTime = System.currentTimeMillis();
            test.copyFile(source, target);
            elapsed += System.currentTimeMillis() - startTime;
            target.delete();
        }
        System.out.println(test + ": " + elapsed / ROUNDS);
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        FileCopyRunner noBufferStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                InputStream fin = null;
                OutputStream fout = null;
                try {
                    fin = new FileInputStream(source);
                    fout = new FileOutputStream(target);

                    int result;
                    while ((result = fin.read()) != -1) {
                        fout.write(result);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }

            @Override
            public String toString() {
                return "noBufferStreamCopy";
            }
        };

        FileCopyRunner bufferedStreamCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                InputStream fin = null;
                OutputStream fout = null;
                try {
                    fin = new BufferedInputStream(new FileInputStream(source));
                    fout = new BufferedOutputStream(new FileOutputStream(target));

                    byte[] buffer = new byte[1024];

                    int result;
                    while ((result = fin.read(buffer)) != -1) {
                        fout.write(buffer, 0, result);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }

            @Override
            public String toString() {
                return "bufferedStreamCopy";
            }
        };

        FileCopyRunner nioBufferCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel fin = null;
                FileChannel fout = null;

                try {
                    fin = new FileInputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();

                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 把文件通道里的数据读入buffer
                    while (fin.read(buffer) != -1) {
                        buffer.flip();
                        // 只要Buffer里有未读完的数据结果就为true
                        while (buffer.hasRemaining()) {
                            // 把数据从buffer写到目标文件的Channel里
                            fout.write(buffer);
                        }
                        buffer.clear();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }

            @Override
            public String toString() {
                return "nioBufferCopy";
            }
        };

        FileCopyRunner nioTransferCopy = new FileCopyRunner() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel fin = null;
                FileChannel fout = null;
                try {
                    fin = new FileInputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();
                    long transferred = 0L;
                    long size = fin.size();
                    // fin.transferTo无法保证一次就能将Input管道内的所有数据读取完
                    while (transferred != size) {
                        // transferTo通道间传参数，第一个参数为数据起始位置
                        // transferred记录总共传递多少参数
                        transferred += fin.transferTo(0, size, fout);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }

            @Override
            public String toString() {
                return "nioTransferCopy";
            }
        };

        File smallFile = new File("/var/tmp/smallFile");
        File smallFileCopy = new File("/var/tmp/smallFile-copy");

        System.out.println("---Copying small file---");
        benchmark(noBufferStreamCopy, smallFile, smallFileCopy);
        benchmark(bufferedStreamCopy, smallFile, smallFileCopy);
        benchmark(nioBufferCopy, smallFile, smallFileCopy);
        benchmark(nioTransferCopy, smallFile, smallFileCopy);

        File bigFile = new File("/var/tmp/bigFile");
        File bigFileCopy = new File("/var/tmp/bigFile-copy");

        System.out.println("---Copying big file---");
        //benchmark(noBufferStreamCopy, bigFile, bigFileCopy);
        benchmark(bufferedStreamCopy, bigFile, bigFileCopy);
        benchmark(nioBufferCopy, bigFile, bigFileCopy);
        benchmark(nioTransferCopy, bigFile, bigFileCopy);

        File hugeFile = new File("/var/tmp/hugeFile");
        File hugeFileCopy = new File("/var/tmp/hugeFile-copy");

        System.out.println("---Copying huge file---");
        //benchmark(noBufferStreamCopy, hugeFile, hugeFileCopy);
        benchmark(bufferedStreamCopy, hugeFile, hugeFileCopy);
        benchmark(nioBufferCopy, hugeFile, hugeFileCopy);
        benchmark(nioTransferCopy, hugeFile, hugeFileCopy);

    }

}
