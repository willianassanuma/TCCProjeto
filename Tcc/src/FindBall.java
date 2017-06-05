import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class FindBall {
	public FindBall() {
	}
    /**
     * @param maskedImage imagem com mascara de contorno
     * @param frame a imagem sem tratamento para estar aplicando a mascara
     * @return retorna a imagem e se tiver uma bola na imagem haverá um contorno sobre ela
     */
	public Mat findAndDrawBalls(Mat maskedImage, Mat frame)
	{
		// init
		List<MatOfPoint> contours = new ArrayList<>();
		Mat hierarchy = new Mat();
		
		// find contours
		Imgproc.findContours(maskedImage, contours, hierarchy, Imgproc.RETR_CCOMP, Imgproc.CHAIN_APPROX_SIMPLE);
		
		// if any contour exist...
		if (hierarchy.size().height > 0 && hierarchy.size().width > 0)
		{
			// for each contour, display it in blue
			for (int idx = 0; idx >= 0; idx = (int) hierarchy.get(0, idx)[0])
			{
				Imgproc.drawContours(frame, contours, idx, new Scalar(0, 250, 0));
			}
		}
		
		return frame;
	}
}
