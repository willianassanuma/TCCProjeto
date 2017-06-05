import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

public class ObjectDetect {
	private FindBall ball = new FindBall();

	/**
	 * @param frame
	 *            imagem a ser encontrado o objeto
	 * @return retorna a imagem com contorno sobre o objeto
	 */
	private Mat morphOutput = new Mat();
    MatToBufImg mat2Img;
	public BufferedImage getMorphOutput() {
		Mat morphOutput = this.morphOutput;
		Size size = new Size(320, 240);
		Imgproc.resize(morphOutput, morphOutput, size);
		mat2Img = new MatToBufImg(morphOutput, ".jpg");
	    return mat2Img.getImage();
		
	}


	public Mat findObject(Mat frame) {
		//System.out.println(frame.width() + " x " + frame.height());
		// init
		Mat blurredImage = new Mat();
		Mat hsvImage = new Mat();
		Mat mask = new Mat();
		

		// remove some noise
		Imgproc.blur(frame, blurredImage, new Size(12, 12));

		// convert the frame to HSV
		Imgproc.cvtColor(blurredImage, hsvImage, Imgproc.COLOR_BGR2HSV);

		// get thresholding values from the UI
		// remember: H ranges 0-180, S and V range 0-255
		Scalar minValues = new Scalar(Tela.hueStart, Tela.saturationStart, Tela.valueStart);
		Scalar maxValues = new Scalar(Tela.hueStop, Tela.saturationStop, Tela.valueStop);

		// threshold HSV image to select object
		Core.inRange(hsvImage, minValues, maxValues, mask);
		// show the partial output

		// morphological operators
		Mat dilateElement = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(24, 24));
		Mat erodeElement = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(12, 12));

		Imgproc.erode(mask, morphOutput, erodeElement);
		Imgproc.erode(morphOutput, morphOutput, erodeElement);

		Imgproc.dilate(morphOutput, morphOutput, dilateElement);
		Imgproc.dilate(morphOutput, morphOutput, dilateElement);
	
		frame = ball.findAndDrawBalls(morphOutput, frame);
		// adicionar função que coloca moldura retangular para identificar objeto.
		return frame;
	}


}
