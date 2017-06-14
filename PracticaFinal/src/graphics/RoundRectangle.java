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

import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;
import java.awt.Point;
import java.awt.geom.RoundRectangle2D;

/**
 * @author adri
 * Figura Rectangulo Redondeado, implementa una figura RoundRectangle2D
 */
public class RoundRectangle extends Shape implements IShape
{
    
    public RoundRectangle(Config config, Point startPoint)
    {
        super(config, startPoint);
        this.internalShape = new RoundRectangle2D.Double(startPoint.x, startPoint.y, 0, 0, 20, 20);
        
        
    }
    
    @Override
    public void setLocation(Point newStartPoint)
    {
        RoundRectangle2D rectangle = ((RoundRectangle2D) this.internalShape);
        ((RoundRectangle2D) this.internalShape).setFrame(newStartPoint.x, newStartPoint.y, rectangle.getWidth(), rectangle.getHeight());    }
    
    public Point getLocation()
    {
        RoundRectangle2D g = ((RoundRectangle2D)this.internalShape);
        return new Point((int) g.getX(), (int) g.getY());
        
    }
    
    @Override
    public void resize(java.awt.Point endPoint)
    {
        // Aqui almacenaremos las coordenadas
        Point startPoint = this.getLocation();

        int width = endPoint.x - startPoint.x;
        int height = endPoint.y - startPoint.y;

        if (endPoint.x < startPoint.x)
            width = -1 * (startPoint.x - endPoint.x);

        if (endPoint.y < startPoint.y)
            height = startPoint.y - endPoint.y;        
        
        ((RoundRectangle2D) this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
    }
    

}
