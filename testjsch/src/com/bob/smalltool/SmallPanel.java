package com.bob.smalltool;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SmallPanel {
    public JLabel jLabelRegex;
    public JFrame jFrame;
    public JPanel jPanel;
    //起始IP框
    JTextField ipBeginText;
    //结束IP框
    JTextField ipEndText;
    //需要登陆的虚拟机IP
    JTextField ipVm;
    //虚拟机用户名
    JTextField vmUserText;
    //fsip输入
    JTextField fsVm;
    //fs用户输入
    JTextField fsUserText;

    //开始按钮
    JButton jButton;

    //停止按钮
    JButton jButtonStop;

    //滚动面板
    JScrollPane scrollPane;
    //虚拟机密码输入框
    public JTextComponent vmPwdText;
    public JRadioButton vmPwdRadio ;

    //虚fs拟机密码输入框
    public JTextComponent fsPwdText;
    public JRadioButton fsPwdRadio ;
    public  String pwdText="";

    public JRadioButton saveData;

    public JRadioButton saveExcel;

    JTextArea textArea ;

    FileUtil fileUtil=new FileUtil();
    public static void main(String[] args) {
        SmallPanel smallPanel=new SmallPanel();
        smallPanel.createPanel();
    }
    public  void  createPanel(){
        //创建JFrame实例
        jFrame=new JFrame("一个IP检测小工具");
        //设置界面的大小
        jFrame.setSize(1500,1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel=new JPanel();
        jFrame.add(jPanel);
        setComponent(jPanel);
       // creatScrllPlane();
        //设置滚动面板
        //jFrame.add(scrollPane);

        jFrame.setVisible(true);
    }
    /*
     用于添加组件
     */
     public  void setComponent(JPanel jPanel){

         jPanel.setLayout(null);
         //起始IP
         JLabel ipBegin=new JLabel("起始IP");
         ipBegin.setBounds(240,50,50,30);
         jPanel.add(ipBegin);

         //起始IP框
         ipBeginText=new JTextField("");
         ipBeginText.setBounds(290,50,200,30);
         ipBeginText.setText(fileUtil.get("ipBegain").trim());
         jPanel.add(ipBeginText);
         ipStyleCheck(ipBeginText);


         //结束IP
         JLabel ipEnd=new JLabel("结束IP");
         ipEnd.setBounds(610,50,50,30);
         jPanel.add(ipEnd);

         //结束IP框
          ipEndText=new JTextField("",28);
         ipEndText.setBounds(670,50,200,30);
         ipEndText.setText(fileUtil.get("ipEnd").trim());
         jPanel.add(ipEndText);
         ipStyleCheck(ipEndText);


         //虚拟机IP
         JLabel vmIp=new JLabel("VMIP");
         vmIp.setBounds(240,110,50,30);
         jPanel.add(vmIp);

         //需要登陆的虚拟机框
         ipVm=new JTextField("",28);
         ipVm.setBounds(290,110,200,30);
         ipVm.setText(fileUtil.get("ipVm").trim());
         jPanel.add(ipVm);
         ipStyleCheck(ipVm);


         //虚拟机用户名
         JLabel vmUser=new JLabel("VM用户名");
         vmUser.setBounds(600,110,70,30);
         jPanel.add(vmUser);

         //虚拟机的用户名输入框
         vmUserText=new JTextField("",28);
         vmUserText.setBounds(670,110,200,30);
         vmUserText.setText(fileUtil.get("vmUser").trim());
         jPanel.add(vmUserText);


         //虚拟机密码
         JLabel vmPassword=new JLabel("VM密码");
         vmPassword.setBounds(970,110,70,30);
         jPanel.add(vmPassword);

         //虚拟机的密码输入框
         vmPwdText=new JPasswordField("",28);
         vmPwdText.setBounds(1040,110,200,30);
         vmPwdText.setText(fileUtil.get("vmPwd").trim());
         jPanel.add(vmPwdText);
         //单选框
         vmPwdRadio = new JRadioButton("隐藏密码");
         vmPwdRadio.setSelected(true);
         vmPwdRadio.setBounds(1270,110,200,30);
         jPanel.add(vmPwdRadio,vmPwdText);
         ipStyleCheck(vmPwdRadio,vmPwdText);

         //fs虚拟机IP
         JLabel fsIp=new JLabel("FSIP");
         fsIp.setBounds(240,170,50,30);
         jPanel.add(fsIp);

         //fs需要登陆的虚拟机框
          fsVm=new JTextField("",28);
         fsVm.setBounds(290,170,200,30);
         fsVm.setText(fileUtil.get("fsIp").trim());
         jPanel.add(fsVm);
         ipStyleCheck(fsVm);


         //fs虚拟机用户名
         JLabel fsUser=new JLabel("FS用户名");
         fsUser.setBounds(600,170,70,30);
         jPanel.add(fsUser);

         //虚拟机的用户名输入框
          fsUserText=new JTextField("",28);
         fsUserText.setBounds(670,170,200,30);
         fsUserText.setText(fileUtil.get("fsUser").trim());
         jPanel.add(fsUserText);


         //fs机密码
         JLabel fsPassword=new JLabel("FS密码");
         fsPassword.setBounds(970,170,70,30);
         jPanel.add(fsPassword);

         //fs的密码输入框
         fsPwdText=new JPasswordField("",28);
         fsPwdText.setBounds(1040,170,200,30);
         fsPwdText.setText(fileUtil.get("fsPwd").trim());
         jPanel.add(fsPwdText);
         //单选框
         fsPwdRadio = new JRadioButton("隐藏密码");
         fsPwdRadio.setSelected(true);
         fsPwdRadio.setBounds(1270,170,200,30);
         jPanel.add(fsPwdRadio,fsPwdText);
         ipStyleCheck(fsPwdRadio,fsPwdText);



         jButton=new JButton("开始");
         jButton.setBounds(290,240,100,30);
         jPanel.add(jButton);

         jButtonStop=new JButton("停止");
         jButtonStop.setBounds(450,240,100,30);
         jPanel.add(jButtonStop);

         //用来记住密码，同时记住其他数据
         saveData=new JRadioButton("记住密码");
         saveData.setBounds(590,240,100,30);
         jPanel.add(saveData);

         saveExcel=new JRadioButton("导出Excel");
         saveExcel.setBounds(700,240,100,30);
         jPanel.add(saveExcel);
         // 创建文本区域组件
         textArea = new JTextArea();
         textArea.setLineWrap(true);                         // 自动换行
         textArea.setFont(new Font(null, Font.PLAIN, 18));   // 设置字体
         textArea.setBounds(10,270,1460,650);

         jPanel.add(textArea);





     }
       public void  creatScrllPlane(){
           // 创建滚动面板, 指定滚动显示的视图组件(textArea), 垂直滚动条一直显示, 水平滚动条从不显示
           scrollPane = new JScrollPane(
                   textArea,
                   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
           );
       }
      public  void  ipStyleCheck(Component component,JTextComponent...components){
         component.addMouseListener(new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
                  if(component instanceof JRadioButton){
                     System.out.println("鼠标点击");
                      pwdText=components[0].getText().trim();
                      Rectangle rc=components[0].getBounds();
                      jPanel.remove(components[0]);
                    if( ((JRadioButton) component).isSelected()){
                        components[0]=new JPasswordField(pwdText);
                        System.out.println("虚拟机密码："+pwdText);
                    }else{
                        System.out.println("虚拟机密码===："+pwdText);
                        components[0]=new JTextField("");
                    }
                      components[0].setText(pwdText);
                      components[0].setBounds(rc);
                      jPanel.add(components[0]);
                      jPanel.repaint();
                      jFrame.setVisible(true);
                  }
             }

             @Override
             public void mousePressed(MouseEvent e) {

             }

             @Override
             public void mouseReleased(MouseEvent e) {

             }

             @Override
             public void mouseEntered(MouseEvent e) {
                 if(component instanceof JTextField){
                     System.out.println("鼠标进入了");
                     if(jLabelRegex!=null){
                         jPanel.remove(jLabelRegex);

                         jPanel.repaint();
                         jFrame.setVisible(true);
                     }
                 }

             }

             @Override
             public void mouseExited(MouseEvent e) {
                 System.out.println("鼠标离开了");
                 if(component instanceof JTextField){
                     jLabelRegex=new JLabel("格式不正确");

                     jLabelRegex.setForeground(new Color(255,0,0));
                     jLabelRegex.setBounds(component.getX()+230,component.getY(),80,30);
                     jPanel.add(jLabelRegex);
                     jPanel.repaint();
                     jFrame.setVisible(true);
                 }

             }
         });

      }
}
