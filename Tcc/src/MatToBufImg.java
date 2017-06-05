/**********************************************************************   

    MatToBufImg is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    MattoBufImg is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with MatToBufImg.  If not, see <http://www.gnu.org/licenses/>.

/**********************************************************************/   


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.*;


public class MatToBufImg {
     Mat matrix;
     MatOfByte mob;
     String fileExten;


	public MatToBufImg(Mat amatrix, String fileExtension){
		
		matrix = amatrix;
		fileExten = fileExtension;
		mob = new MatOfByte();
	}
	public BufferedImage getImage(){
		//convert the matrix into a matrix of bytes appropriate for
		//this file extension

		Imgcodecs.imencode(fileExten, matrix ,mob); 
		//convert the "matrix of bytes" into a byte array
		 byte[] byteArray = mob.toArray();
		 BufferedImage bufImage = null;
		 try {
		        InputStream in = new ByteArrayInputStream(byteArray);
		        bufImage = ImageIO.read(in);
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		 return bufImage;
	}
}