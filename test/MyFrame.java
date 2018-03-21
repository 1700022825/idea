package test;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by shaojianxuan on 2018/3/12.
 */
public class MyFrame extends Frame {

    /**
     * 加载窗口
     */

    public void launchFrame(){
        setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGTH);
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
}
