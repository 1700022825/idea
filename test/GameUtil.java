package test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * Created by shaojianxuan on 2018/3/12.
 * 游戏开发中常用的工具类（图片加载等）
 */
public class GameUtil {

    private GameUtil(){}        //工具类一般将构造方法私有


    public static Image getImage(String path){
        URL u = GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;

        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;


    }



}
