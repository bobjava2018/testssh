package com.bob.smalltool;


import com.jcraft.jsch.*;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.apache.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: testjsch
 * @description: jsh测试类
 * @author: Mr.Bob
 * @create: 2019-10-26 21:48
 **/
public class TestSshSendCommand {


    private static Logger logger = Logger.getLogger(TestSshSendCommand.class);
    private JSch jSch;
    private Session session;
    private ChannelShell channelShell;
    private final String ENCODEING = "UTF-8";

    public static void main(String[] args) {
        logger.info("开始了");
        TestSshSendCommand testSshSendCommand = new TestSshSendCommand();

        try {
            testSshSendCommand.creatConnection();
            testSshSendCommand.execCommand();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             testSshSendCommand.closeConnection();
        }

    }

    public boolean creatConnection() {
        logger.info("开始连接了");

        try {
            jSch = new JSch();
            session = jSch.getSession("baibo", "192.168.0.107", 22);
            session.setConfig("StrictHostKeyChecking", "no");//第一次访问服务器时候不需要输入yes
            session.setPassword("406963");
            session.setTimeout(60 * 50 * 1000);
            session.connect();
            channelShell = (ChannelShell) session.openChannel("shell");

            logger.info("session创建成功");
        } catch (JSchException e) {
            e.printStackTrace();
            logger.error("连接失败，请检查是否可以访问：" + e.getMessage());
        }

        return false;
    }

    public void execCommand() {
        BufferedReader reader = null;
        InputStream in = null;
        OutputStream out = null;
        logger.info("准备执行命令");
        List<String> commands = new ArrayList<String>();
        //commands.add("ls \n\r");
        //commands.add("cd Desktop \n\r");
       // commands.add("ls \n\r");
        commands.add("ifconfig \n\r");
        commands.add("ping 192.168.0.107 -c 4 \n\r");
        commands.add("exit \n\r");
        try {
            channelShell.connect();
            //channelShell.setCommand(str);

            in = channelShell.getInputStream();
            out = channelShell.getOutputStream();
            for (String str : commands) {


                out.write(str.getBytes());
                out.flush();
            }
            reader = new BufferedReader(new InputStreamReader(in, Charset.forName(ENCODEING)));
            String buf = null;
            System.out.println(reader.readLine());
            while ((buf = reader.readLine()) != null) {
                System.out.println(buf);
            }


        } catch (JSchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (channelShell != null) {
            channelShell.disconnect();
        }
        if (channelShell != null) {
            channelShell.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }

    }
}
