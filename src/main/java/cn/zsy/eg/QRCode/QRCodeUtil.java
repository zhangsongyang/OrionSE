package cn.zsy.eg.QRCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/2/11.
 */
public class QRCodeUtil {

    public static void main(String[] args) throws Exception{
//        ByteArrayOutputStream out = QRCode.from("QRCode").to(ImageType.PNG).stream();
        String contents = "QRCode~";
        contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");
        ByteArrayOutputStream out = QRCode.from(contents).withSize(250, 250).to(ImageType.PNG).stream();

        try {
            FileOutputStream fout = new FileOutputStream(new File("E:/QR_Code.JPG"));

            fout.write(out.toByteArray());

            fout.flush();
            fout.close();

        } catch (FileNotFoundException e) {
            // Do Logging
        } catch (IOException e) {
            // Do Logging
        }

        // get QR file from text using defaults
        File file = QRCode.from("Hello World").file();
        // get QR stream from text using defaults
        ByteArrayOutputStream stream = QRCode.from("Hello World").stream();

        // override the image type to be JPG
        QRCode.from("Hello World").to(ImageType.JPG).file();
        QRCode.from("Hello World").to(ImageType.JPG).stream();

        // override image size to be 250x250
        QRCode.from("Hello World").withSize(250, 250).file();
        QRCode.from("Hello World").withSize(250, 250).stream();

        // override size and image type
        QRCode.from("Hello World").to(ImageType.GIF).withSize(250, 250).file();
        QRCode.from("Hello World").to(ImageType.GIF).withSize(250, 250).stream();

        //		 Website Link (URLs) QR Code in Java
        ByteArrayOutputStream out1 = QRCode.from("http://viralpatel.net")
                .to(ImageType.PNG).stream();





        /////////////////////////////////////////////////////////
        String contentss = "QRcode";
        int width = 250;
        int height = 250;
        String imgPath = "e:/";
        String fileName = "1212.JPG";
        String filePostfix = "JPG";
        Map<EncodeHintType,String> hints = new HashMap<EncodeHintType, String>();
        //内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(contentss, BarcodeFormat.QR_CODE,
                width, height,hints);
        File file11 = new File(imgPath, fileName);
        MatrixToImageWriter.writeToFile(bitMatrix, filePostfix, file11);
    }

}

//http://blog.sina.com.cn/s/blog_6ba6492f0101i0hd.html
