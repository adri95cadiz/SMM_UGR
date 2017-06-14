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
import java.awt.geom.QuadCurve2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * @author adri
 * Figura Arco, implementa una figura QuadCurve2D
 */
public class Arc extends Shape implements IShape
{
    

    public Arc(Config config, Point startPoint)
    {
        super(config, startPoint);
        
        this.internalShape = new QuadCurve2D.Double(); 
        ((QuadCurve2D)this.internalShape).setCurve(startPoint.x, startPoint.y, startPoint.x, startPoint.y, startPoint.x, startPoint.y);
        
    }

    public Point getLocation()
    {
        QuadCurve2D arc = ((QuadCurve2D) this.internalShape);
        //arc.getBounds();
        
        return new Point((int) arc.getX1(), (int) arc.getY1());
    }

    @Override
    public void setLocation(Point newStartPoint)
    {
        ((QuadCurve2D) this.internalShape).setCurve(0, 0, 0, 0, 0, 0);
        
    }

    @Override
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
        
        ((QuadCurve2D) this.internalShape).setCurve(startPoint.x, startPoint.y, 100, 100, width, height);
        
    }

}
