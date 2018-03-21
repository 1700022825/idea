package test;

/**
 * Created by shaojianxuan on 2018/3/12.
 * 测试窗口物体沿着水平纵向轨迹动
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class GameFrame02 extends Frame {   //GUI编程：AWT，swing等。java不适合写桌面软件。现在用的是AWt

    Image img = GameUtil.getImage("images/sun.jpg");


    /**
     * 加载窗口
     */

    public void launchFrame(){
        setSize(500,500);
        setLocation(100,100);           //加载窗口
        setVisible(true);


        new PaintThread().start();  //启动线程


        addWindowListener(new WindowAdapter() {         //关闭窗口可行
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    private double x = 100;
    private double y = 100;
    private boolean left;
    private boolean up;
    @Override
    public void paint(Graphics g) {


        g.drawImage(img,(int)x,(int)y,null);

        if (left){
            x-=5;
        }else {
            x+=5;
        }
        if (x>500-30){
            left = true;
        }
        if(x<0){
            left = false;
        }
        if (up){
            y+=5;
        }else {
            y-=5;
        }
        if (y<30){
            up = true;
        }
        if (y>500-30){
            up = false;
        }


    }

    /***
     * 定义一个重画窗口的线程类
     */
    class PaintThread extends Thread{
        public void run(){
            while (true){
                repaint();
                try {
                    Thread.sleep(40);   //1s = 1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        GameFrame02 gf = new GameFrame02();
        gf.launchFrame();
    }



}
