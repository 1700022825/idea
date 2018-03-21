package test;

/**
 * Created by shaojianxuan on 2018/3/12.
 * 测试窗口物体沿着任意角度飞行，实现一个小的台球游戏
 */

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class GameFrame03 extends Frame {   //GUI编程：AWT，swing等。java不适合写桌面软件。现在用的是AWt

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
    private double speed = 10;
    private double x = 100;
    private double y = 100;
    private double degree = 3.14/3; // [0,2pi]
    @Override
    public void paint(Graphics g) {


        g.drawImage(img,(int)x,(int)y,null);
        if (speed>0){
            speed -= 0.05;
        }else{
            speed = 0;
        }

      x+=speed*Math.cos(degree);
      y+=speed*Math.sin(degree);

      if (y>500-30){
          degree = -degree;
      }
      if (y<30){
          degree = -degree;
      }
      if (x<0){
          degree = Math.PI - degree;
      }
      if (x>500-30){
          degree = Math.PI - degree;
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
        GameFrame03 gf = new GameFrame03();
        gf.launchFrame();
    }



}
