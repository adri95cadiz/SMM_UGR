/*
 * Copyright (C) 2017 Adri
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
/**
 *
 * @author Adri
 */
public class SepiaOp extends BufferedImageOpAdapter {
    
    private final float[][] matrix = new float[][]
    {
        {
            0.393f, 0.769f, 0.189f
        }, 
        {
            0.349f, 0.686f, 0.168f
        }, 
        {
            0.272f, 0.534f, 0.131f
        }
    };

    /**
     * Sobrecarga del método filter de BufferedImageOpAdapter
     * @param src imagen de origen
     * @param dest imagen de destino
     * @return la imagen de destino
     */ 
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest)
    {
        if (src == null)
            throw new NullPointerException("src image is null");

        
        if (dest == null)
            dest = createCompatibleDestImage(src, null);

        BufferedImagePixelIterator.PixelData pixel;

        WritableRaster destRaster = dest.getRaster();

        for (BufferedImagePixelIterator it = new BufferedImagePixelIterator(src); it.hasNext();)
        {
            pixel = it.next();
            //Por hacer: efecto sepia

            if (pixel.sample.length > 1) // en iamgenes en blanco y negro solo hay un canal de color
            {
                float inputRed = pixel.sample[0];
                float inputGreen = pixel.sample[1];
                float inputBlue = pixel.sample[2];
                
                float outputRed = inputRed * this.matrix[0][0] + inputGreen * this.matrix[0][1] + inputBlue * this.matrix[0][2];
                float outputGreen = inputRed * this.matrix[1][0] + inputGreen * this.matrix[1][1] + inputBlue * this.matrix[1][2];
                float outputBlue = inputRed * this.matrix[2][0] + inputGreen * this.matrix[2][1] + inputBlue * this.matrix[2][2];
                
                pixel.sample[0] = outputRed > 255.0f ? 255 : (int) outputRed;
                pixel.sample[1] = outputGreen > 255.0f ? 255 : (int) outputGreen;
                pixel.sample[2] = outputBlue > 255.0f ? 255 : (int) outputBlue;
                
                destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
            }
        }
        return dest;
    }
}
