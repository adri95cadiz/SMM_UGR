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

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import sm.image.BufferedImageOpAdapter;
import sm.image.BufferedImagePixelIterator;
import sm.image.ImageTools;
import sm.image.KernelProducer;
/**
 *
 * @author Adri
 */
public class SobelOp extends BufferedImageOpAdapter {
    
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
            dest = this.createCompatibleDestImage(src, null);
        KernelTypes kx = KernelTypes.SOBELX;
        Kernel kSobelX = KernelProducer.createKernel(kx.value);
        ConvolveOp cOpGradienteX = new ConvolveOp(kSobelX);
        BufferedImage gradienteX = cOpGradienteX.filter(src, null);

        KernelTypes ky = KernelTypes.SOBELY;
        Kernel kSobelY = KernelProducer.createKernel(ky.value);
        ConvolveOp cOpGradienteY = new ConvolveOp(kSobelY);
        BufferedImage gradienteY = cOpGradienteY.filter(src, null);

        BufferedImagePixelIterator itX = new BufferedImagePixelIterator(gradienteX);
        BufferedImagePixelIterator itY = new BufferedImagePixelIterator(gradienteY);

        while (itX.hasNext())
        {
            BufferedImagePixelIterator.PixelData pixelX = itX.next();
            BufferedImagePixelIterator.PixelData pixelY = itY.next();
            int sY = 0, sX = 0;

            for (int s = 0; s < pixelX.numSamples; ++s)
            {
                sX += pixelX.sample[s];
                sY += pixelY.sample[s];
            }
            int mag = (int) Math.hypot(sX, sY);
            mag = ImageTools.clampRange(mag, 0, 255);
            Color c = new Color(mag, mag, mag);
            dest.setRGB(pixelX.col, pixelX.row, c.getRGB());
        }
        return dest;

    }
    
}
