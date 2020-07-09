package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * socket服务端(实现socket长时间连接及通信)
 *
 * @created nero
 * @date 2018/9/19 17:36
 */
public class IMSocketServer {

    private static Map<String, Socket> socketMap = new HashMap<>();

    public static void run() throws IOException, InterruptedException {
        System.out.println("开启socket服务端");
        //实例化服务器socket对象
        ServerSocket serverSocket = new ServerSocket(9065);
//        Scanner sc = new Scanner(System.in);
//        //利用hasNextXXX()判断是否还有下一输入项
//        while (sc.hasNext()) {
//            //利用nextXXX()方法输出内容
//            String str = sc.next();
//            System.out.println(str);
//        }
        //等待客户端连接
        System.out.println("等待客户端连接");
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
                Thread thread = new Thread(new IMSocketReadThread(socket));
                System.out.println("客户端已连接");
                thread.start();
            OutputStream outputStream = socket.getOutputStream();
            String msg = "Hello";
            outputStream.write(msg.getBytes());
            outputStream.flush();
            //获取socket输入流，并读取客户端信息
////            InputStream is = socket.getInputStream();
////            InputStreamReader isr = new InputStreamReader(is);
////            BufferedReader br = new BufferedReader(isr);
////            String info = br.readLine();
////            String[] infos = info.split(";");
////            if (infos.length > 0 && infos[0].split(":")[0].equals("custId")) {
////                socketMap.put(infos[0].split(":")[1], socket);
////                Thread thread = new Thread(new IMSocketReadThread(socket));
////                System.out.println("客户端"+infos[0].split(":")[1]+"已连接");
////
////                thread.start();
////            } else {
////                System.out.println("客户端无法识别");
////                socket.close();
////            }
        }

    }
}
