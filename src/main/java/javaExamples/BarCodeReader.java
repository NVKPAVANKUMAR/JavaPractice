package javaExamples;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class BarCodeReader {
    private String code = "";
    private String imgPath = "images/Qr-3.png";

    @Test
    public void readBarCode() throws IOException, FormatException, ChecksumException, NotFoundException {
        Reader reader = new MultiFormatReader();

        InputStream barcodeIS = new FileInputStream(imgPath);
        BufferedImage buffImage = ImageIO.read(barcodeIS);

        LuminanceSource lsc = new BufferedImageLuminanceSource(buffImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(lsc));

        Result result = reader.decode(bitmap);
        code = result.getText();

        System.out.println("Image Barcode 'OR' QR Code : " + code);


    }
}

