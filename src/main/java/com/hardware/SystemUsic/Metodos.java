package com.hardware.SystemUsic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class Metodos {
    
    private final Logger log = LoggerFactory.getLogger(getClass());
    
    public void QR(String data, String IMG_PATH) throws FileNotFoundException, IOException {
		int qr_image_width = 120;
		int qr_image_height = 120;
		String IMAGE_FORMAT = "png";

		// Encode URL in QR format
		BitMatrix matrix;
		Writer writer = new QRCodeWriter();

		try {
			matrix = writer.encode(data, BarcodeFormat.QR_CODE, qr_image_width, qr_image_height);
		} catch (WriterException e) {
			e.printStackTrace(System.err);
			return;
		}
		// Create buffered image to draw to
		BufferedImage image = new BufferedImage(qr_image_width, qr_image_height, BufferedImage.TYPE_INT_RGB);
		// Iterate through the matrix and draw the pixels to the image
		for (int y = 0; y < qr_image_height; y++) {
			for (int x = 0; x < qr_image_width; x++) {
				int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
				image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
			}
		}
		// Write the image to a file
		FileOutputStream qrCode = new FileOutputStream(IMG_PATH);
		ImageIO.write(image, IMAGE_FORMAT, qrCode);
		qrCode.close();
	}

    public String guardarArchivo(MultipartFile archivo) {
		String uniqueFilename = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename();

		Path rootPath = Paths.get("uploads/").resolve(uniqueFilename);
		Path rootAbsolutPath = rootPath.toAbsolutePath();

		log.info("rootPath: " + rootPath);
		log.info("rootAbsolutPath: " + rootAbsolutPath);

		try {

			Files.copy(archivo.getInputStream(), rootAbsolutPath);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return uniqueFilename;
	}
}
