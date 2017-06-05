import java.awt.image.BufferedImage;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.*;

public class VideoCap {
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    private ObjectDetect objeto = new ObjectDetect();
    VideoCapture cap;
    MatToBufImg mat2Img;
    /**
     * @param cam o valor inteiro referente a camera conectada ao computador
     */
    VideoCap(int cam){
        cap = new VideoCapture();
        cap.open(cam);
    } 
    public void camClose(){
		cap.release();;
	
	}
    /**
     * @return retorna uma imagem no formato .jpg
     */
    BufferedImage getOneFrame() {
    	Mat frame = new Mat();
        cap.read(frame);
        try
		{
			if (!frame.empty())
			{
				frame = objeto.findObject(frame);
				Size size = new Size(320, 240);
				Imgproc.resize(frame, frame, size);
			}
		}
		catch (Exception e)
		{
			// log the (full) error
			System.err.print("Erro!");
			e.printStackTrace();
		}
        
        // converte a imagem em formato jpg
		
        mat2Img = new MatToBufImg(frame, ".jpg");
        return mat2Img.getImage();
    }
    BufferedImage getMorph(){
    	return objeto.getMorphOutput();
    }

}