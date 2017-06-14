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
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * @author adri
 * Figura Rectangulo, implementa una figura Rectangle
 */
public class Rectangle extends Shape implements IShape
{    
    public Rectangle(Config config, Point startPoint)
    {
        super(config, startPoint);
        this.internalShape = new java.awt.Rectangle(startPoint.x, startPoint.y, 0, 0);
    }
    
    public Point getLocation()
    {
        return ((java.awt.Rectangle) this.internalShape).getLocation();
    }

    @Override
    public void setLocation(Point newStartPoint)
    {
        ((java.awt.Rectangle) this.internalShape).setLocation(newStartPoint.x, newStartPoint.y);    
    }

    @Override
    public void resize(Point endPoint)
    {
        // Aqui almacenaremos las coordenadas
        Point startPoint = this.getLocation();
        
        int width = Math.abs( endPoint.x - startPoint.x );
        int height = Math.abs( endPoint.y - startPoint.y );

        ((java.awt.Rectangle) this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
        
    }

}
