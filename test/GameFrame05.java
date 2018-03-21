package test;

import java.awt.*;

/**
 * Created by shaojianxuan on 2018/3/12.
 */
public class GameFrame05 extends MyFrame {
    Image img = GameUtil.getImage("images/sun.jpg");


    private double x=100,y=100;
    private double degree=3.14/3;    //[0,2pi]
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, (int)x, (int)y, null);

        x =100+ 100*Math.cos(degree);
        y =200+ 50*Math.sin(degree);

        degree +=0.1;

    }

    public static void main(String[] args) {
        GameFrame05 gf = new GameFrame05();
        gf.launchFrame();
    }


}
