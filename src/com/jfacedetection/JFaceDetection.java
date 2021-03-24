package com.jfacedetection;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class JFaceDetection {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		//System.out.println("Hi Ankit Raj Biswal");
		// IMPORTANT 1 
		String imgFile= "images/a (2).jpg"; //here we take the input of file whose face detection 
	                                    	//we have to do.
		Mat src= Imgcodecs.imread(imgFile);// this will read image from string
		
		
		String xmlFile = "xml/lbpcascade_frontalface.xml"; // to store the xml file
 // xml file is present in the openCV extract, it tells the application how a face looks like
		CascadeClassifier cc = new CascadeClassifier(xmlFile); // read the xml file
		
		
		MatOfRect faceDetection = new MatOfRect();
		cc.detectMultiScale(src, faceDetection);
		System.out.println(String.format("Detected faces:%d", faceDetection.toArray().length));
		
		
		for (Rect rect: faceDetection.toArray()) {
			Imgproc.rectangle(src,new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(0,0,225),3);
		}
		
		Imgcodecs.imwrite("images/a (2) out.jpg" , src); // IMPORTANT 2
		System.out.println("Image Face Detection Finished");
	}
	

}
