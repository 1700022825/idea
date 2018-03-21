package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by shaojianxuan on 2018/3/12.
 * 游戏窗口类
 */
public class GameFrame extends Frame {   //GUI编程：AWT，swing等。java不适合写桌面软件。现在用的是AWt

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

    @Override
    public void paint(Graphics g) {
        g.drawLine(100,100,200,200);
        g.drawRect(100,100,200,200);
        g.drawOval(100,100,200,200);




        g.drawString("我是",200,200);

        Color c = g.getColor();   //先把原先的颜色保存起来。
        g.setColor(Color.red);

        g.fillOval(100,100,100,100);

        g.setColor(c);          //原先是什么颜色，还回去就是什么颜色。避免乱套

        g.drawImage(img,(int)x,(int)y,null);

        x+=3;

        y+=3;

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
        GameFrame gf = new GameFrame();
        gf.launchFrame();
    }



}
