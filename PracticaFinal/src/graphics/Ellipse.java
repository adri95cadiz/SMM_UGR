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
package graphics;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * @author adri
 * Figura Elipse, implementa una figura Ellipse2D
 */
public class Ellipse extends Shape implements IShape
{

    public Ellipse(Config config, Point startPoint)
    {
        super(config, startPoint);
        this.internalShape = new Ellipse2D.Double(startPoint.x, startPoint.y, 0, 0);
    }

    public Point getLocation()
    {

        Ellipse2D ellipse = ((Ellipse2D) this.internalShape);
        return new Point((int) ellipse.getX(), (int) ellipse.getY());
                
    }

    public void setLocation(Point newStartPoint)
    {
        Ellipse2D ellipse = ((Ellipse2D) this.internalShape);
        ((Ellipse2D) this.internalShape).setFrame(newStartPoint.x, newStartPoint.y, ellipse.getWidth(), ellipse.getHeight());
    }

    public void resize(Point endPoint)
    {

        // Aqui almacenaremos las coordenadas
        Point startPoint = this.getLocation();
        
        int width = endPoint.x - startPoint.x;
        int height = endPoint.y - startPoint.y;

        if (endPoint.x < startPoint.x)
            width = -1 * (startPoint.x - endPoint.x);

        if (endPoint.y < startPoint.y)
            height = startPoint.y - endPoint.y;
        
        ((Ellipse2D) this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
        
    }

}
