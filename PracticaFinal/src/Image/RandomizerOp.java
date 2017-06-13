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
 * Ejecuta una operación de randomizado propia que cambia el color de algunos pixeles entre 5 puntos hacia arriba y 5 puntos hacia abajo para cada valor RGB.
 * @author Adri
 */
public class RandomizerOp extends BufferedImageOpAdapter {
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
                
            pixel.sample[0] = pixel.sample[0] + (int)((5 * Math.random()) - (5 * Math.random()));
            pixel.sample[1] = pixel.sample[1] + (int)((5 * Math.random()) - (5 * Math.random()));
            pixel.sample[2] = pixel.sample[2] + (int)((5 * Math.random()) - (5 * Math.random()));

            destRaster.setPixel(pixel.col, pixel.row, pixel.sample);
            
        }
        return dest;
    }
}
