package com.ycit.io;

import com.ycit.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by xlch on 2017/1/11.
 */
public class InputStreamTest {

    private static final Logger logger = LoggerFactory.getLogger(InputStreamTest.class);

    @Test
    public void ObjectInputStream() throws Exception {
        //创建序列化对象
        User user = new User();
        user.setName("xlch");
        user.setEmail("xlch@163.com");
        user.setCreateTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        try (FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
             ObjectInputStream in = new ObjectInputStream(fileInputStream);) {
            //写入序列化对象到 文件流中
            out.writeObject(user);
            //从文件流中写出序列化对象
            User user1 = (User) in.readObject();
            logger.info("user name is {}", user1.getName());
            logger.info("user createTime is {}", user1.getCreateTime());
        }
    }

    @Test
    public void objectOutputStreamNoFlush() throws Exception {
        User user = new User();
        user.setName("xlch");
        user.setEmail("xlch@163.com");
        user.setCreateTime(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
        ObjectInputStream in = new ObjectInputStream(fileInputStream);
        //写入序列化对象到 文件流中
        out.writeObject(user);
        //从文件流中写出序列化对象
        User user1 = (User) in.readObject();
        logger.info("user name is {}",user1.getName());
        logger.info("user createTime is {}",user1.getCreateTime());
    }


    /**
     * 一个字节一个字节的读
     */
    @Test
    public void byteArrayInputStreamTest() throws Exception {
        byte[] bytes = new byte[]{'a', 'b'};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        int size = in.available();
        logger.info("the available size == {}", size); // 2
        int binary = in.read();
        while (binary != -1) {
            logger.info("the binary is {}", binary); //分别 输出 97 98
            binary = in.read();
        }
        in.close();
    }

    /**
     * 一次读取多个数据
     */
    @Test
    public void readUseBuffer() throws IOException {
        byte[] data = new byte[]{'a', 'b', 'c'};
        try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
            byte[] buffer = new byte[1024];
            int len = in.read(buffer, 2, 5);
            while (len != -1) {
                logger.info("read data size is {}", len); //3
                logger.info("buffer[0] is {}", buffer[0]); //0
                logger.info("buffer[2] is {}", buffer[2]); //97 即 a 的 Ascii
                logger.info("buffer[3] is {}", buffer[3]); //98
                logger.info("binary data is {}", new String(buffer));//abc
                len = in.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void byteArrayOutputStream() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write('a');
        logger.info("out convert string is {}", new String(out.toByteArray(), "utf-8")); // a
        logger.info("out convert string is {}", out.toString()); // a
        out.write(new byte[]{'b', 'c', 'd'}, 1, 2);
        logger.info("out convert string is {}", out.toString()); // acd
        //将 ByteArrayInputStream 中的数据 写到  ByteArrayOutputStream 中
        byte[] bytes = new byte[]{'a', 'b'};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        while (len != -1) {
            out.write(buffer);
            len = in.read(buffer);
        }
        logger.info("out convert string is {}", new String(out.toByteArray(), "utf-8")); // acdab
    }

    /**
     * copy 文件
     * 一个字节一个字节的读
     *
     * @throws Exception
     */
    @Test
    public void FileInputStreamTest() throws Exception {
        String sourcePath = "E:\\study\\jdk\\io\\InputStream.PNG";
        String destinationPath = "E:\\study\\jdk\\io\\11.PNG";
//        String sourcePath = "D:\\test.txt";
//        String destinationPath = "D:\\111.txt";
        try (FileInputStream in = new FileInputStream(sourcePath); FileOutputStream out = new FileOutputStream(destinationPath, true)) { // 这个时候 流中已经包含了这张图片
            int binary = 0;
            while ((binary = in.read()) != -1) {
                out.write(binary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("流已关闭");
        }
    }

    /**
     * copy 文件
     * 一次读取多个字节
     *
     * @throws Exception
     */
    @Test
    public void useBuffer() throws Exception {
        String sourcePath = "E:\\study\\jdk\\io\\InputStream.PNG";
        String destinationPath = "E:\\study\\jdk\\io\\11.PNG";
        try (FileInputStream in = new FileInputStream(sourcePath);
             FileOutputStream out = new FileOutputStream(destinationPath)) { // 这个时候 流中已经包含了这张图片
            byte[] buffer = new byte[32];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            logger.info("流已关闭");
        }
    }

    /**
     * 文件 copy  使用缓冲
     *
     * @throws Exception
     */
    @Test
    public void userBuffered() throws Exception {
        String sourcePath = "E:\\study\\jdk\\io\\InputStream.PNG";
        String destinationPath = "E:\\study\\jdk\\io\\11.PNG";
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destinationPath));) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer);
                out.flush();
            }
        }
    }

    @Test
    public void userBufferedNoFlushNoClose() throws Exception {
        String sourcePath = "E:\\study\\jdk\\io\\InputStream.PNG";
        String destinationPath = "E:\\study\\jdk\\io\\11.PNG";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destinationPath));
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer);
            out.flush();
        }

    }

    @Test
    public void dataInputStreamTest() {
        try (FileOutputStream out = new FileOutputStream("D:\\test.txt"); DataOutputStream dataOut = new DataOutputStream(out);//文件不存在，先调用 FileOutputStream 会创建文件
             FileInputStream in = new FileInputStream("D:\\test.txt"); DataInputStream dataIn = new DataInputStream(in);) {//文件不存在，如果先调用 FileInputStream 会 抛出 FileNotFoundException
            dataOut.writeDouble(0.12);
            Double d = dataIn.readDouble();
            logger.info("the double is {}", d);//0.12
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 单字节的从输入流中读出,并写入到 输出流中保存
     */
    @Test
    public void stringReaderTest() {
        String data = "hello world~~";
        try (StringReader in = new StringReader(data);
             StringWriter out = new StringWriter();) {
            int len = 0;
            while ((len = in.read()) != -1) {
                out.write(len);
            }
            logger.info("the data is {}", out.toString());//hello world~~
            logger.info("the data is {}", out.getBuffer().toString());//hello world~~
        } catch (Exception e) {

        }
    }

    /**
     * 一次读取多个字符
     */
    @Test
    public void readMore() {
        String data = "新年快乐~~";
        char[] buf = new char[1024];
        try (StringReader in = new StringReader(data);) {
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                logger.info("character is {}", new String(buf));//新年快乐~~
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inputStreamReaderTest() throws Exception {
        String path = "D:\\test.txt";
        byte[] buffer = new byte[1024];
        try (FileOutputStream out = new FileOutputStream(path);
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(out, "utf-8");
             FileInputStream fileInputStream = new FileInputStream(path);) {
            outputStreamWriter.write("新年快乐~~");// 将字符串写到了字节流 FileOutputStream 中，即所谓的 字符 → 字节
            outputStreamWriter.flush();//此时如果不 冲洗 则 下面读不到。
            fileInputStream.read(buffer);
            logger.info("result is {}", new String(buffer, "utf-8"));//新年快乐~~
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void diff() throws Exception {
        String path = "D:\\byte.txt";
        String copyPath = "D:\\copy.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        FileInputStream in = new FileInputStream(copyPath);
        byte buffer[] = new byte[]{'h'};
        out.write(buffer);
    }

    @Test
    public void diff2() throws Exception {
        String path = "D:\\char.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter out = new FileWriter(file);
        char buffer[] = new char[]{'h'};
        out.write(buffer);
    }

    @Test
    public void diff3() throws Exception {
        String path = "D:\\file.txt";
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        byte buffer[] = new byte[]{'h'};
        out.write(buffer);
    }


    /**
     * copy
     */
    @Test
    public void useTogether() {
        String path = "D:\\test.txt";
        String copyPath = "D:\\copy.txt";
        char buffer[] = new char[1024];
        try (FileInputStream inputStream = new FileInputStream(path); Reader in = new InputStreamReader(inputStream, "utf-8");//保持和文件保存时的 编码方式相同
             FileOutputStream outputStream = new FileOutputStream(copyPath, false); Writer out = new OutputStreamWriter(outputStream, "utf-8")) {
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer);
                logger.info("the buffer string is {}", new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bufferedTest() {
        String path = "D:\\test.txt";
        String copyPath = "D:\\copy.txt";
        char buffer[] = new char[1024];
        try (Reader in = new BufferedReader(new FileReader(path)); Writer out = new BufferedWriter(new FileWriter(copyPath))) {
            int len = 0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer);
                logger.info("the buffer string is {}", new String(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void printStream() {
        String path = "D:\\222.txt";
        try (PrintStream out = new PrintStream(path);) {
            out.print(true);        //向 文件中写入 boolean 值
            out.println("新年快乐");  //向文件中写入 字符串,并且 换行 ，相当于执行了写操作和 newLine()
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void console() {
//        try {
//            BufferedReader strin=new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("请输入一个字符串：");
//            String str = strin.readLine();
//
//            System.out.println("第一个："+str);
//
//            System.out.println("请输入第二个字符串：");
//            String str2 = strin.readLine();
//            System.out.println("第2个："+str2);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void console2() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入第一个boolean值(true/false):");
//        if(sc.nextBoolean()){
//            System.out.println("输入布尔：真的");
//        }else{
//            System.out.println("输入布尔：假的");
//        }
//
//
//        System.out.println("输入第一个数字:");
//        System.out.println("输入数字："+sc.nextInt());
//
//        System.out.println("输入一个字符串:");
//        System.out.println("输入字符串："+sc.next());
//
//        System.out.println("输入一个长整型:");
//        System.out.println("输入长整型："+sc.nextLong());
//    }

}
