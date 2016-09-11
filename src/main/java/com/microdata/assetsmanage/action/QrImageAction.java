package com.microdata.assetsmanage.action;

import com.microdata.assetsmanage.util.ImageUtil;

import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * 返回二维码Action测试
 * Created by Longder on 2016/9/8.
 */
public class QrImageAction {
    //ouput
    private InputStream imageStream;

    public String execute() {
        try {
            BufferedImage qrImage = ImageUtil.encode("123456");
            imageStream = ImageUtil.getInputStream(qrImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public InputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(InputStream imageStream) {
        this.imageStream = imageStream;
    }
}
