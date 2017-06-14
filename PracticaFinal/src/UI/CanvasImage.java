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
package UI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import graphics.Shape;

/**
 * @author adri
 * Esta clase hereda de la clase Canvas y le agrega las funciones necearias
 * para asignar una imagen a la misma, así como para pintarle el borde (clip)o
 */
public class CanvasImage extends Canvas implements Cloneable
{
    
    private BufferedImage img;

    /**
     * Establece la imagen que tendrá el lienzo
     * @param img imagen a establecer
     */
    public void setImage(BufferedImage img)
    {
        this.img = img;
        if (img != null)
        {
            setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
            this.setClip(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
        }
    }


    /**
     * Funcion para clonar un objeto lienzo
     * @return una copia del lienzo actual
     */
    @Override
    public CanvasImage clone() throws CloneNotSupportedException
    {
        CanvasImage canvas = new CanvasImage();
        canvas.img = new BufferedImage(this.img.getWidth(), this.img.getHeight(), BufferedImage.TYPE_INT_ARGB);
        canvas.img.setData(this.img.getData());
        canvas.img = this.img;
        for (Shape shape : shapes)

            canvas.shapes.add((Shape) shape.clone());
        return canvas;

    }

    /**
     * Obtiene la imagen con o sin el vector de formas
     * @param drawVector define si se debe dibujar el vector de formas
     * @return la imagen actual con o sin el vector de formas
     */
    public BufferedImage getImage(boolean drawVector)
    {
        if (drawVector)
        {
            BufferedImage image = new BufferedImage(this.img.getWidth(), this.img.getHeight(), this.img.getType());

            //nos guardamos el "clip" en una variable temporal y lo asignamos a null
            java.awt.Shape tmpShape = this.clip;
            this.clip = null;

            // pintamos
            this.paint(image.createGraphics());

            // volvemos a asignar el "clip"
            this.clip = tmpShape;

            return image;
        }
        return this.img;
    }

    /**
     * Pintal los componentes
     * @param g objecto graphics
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (this.img != null)
            g.drawImage(this.img, 0, 0, this);

        if (this.clip != null)
            this.paintBorderClip((Graphics2D) g);

    }

    /**
     * Pinta un borde punteado alrededor de la imagen
     * @param g objecto graphics
     */
    private void paintBorderClip(Graphics2D g)
    {
        Stroke sk = g.getStroke();
        float[] pattern = new float[]
        {
            3.0f, 3.0f
        };
        BasicStroke dotted = new BasicStroke(1.0f, 0, 2, 1.0f, pattern, 0.0f);
        g.setStroke(dotted);
        g.draw(this.clip);
        g.setStroke(sk);
    }

}
