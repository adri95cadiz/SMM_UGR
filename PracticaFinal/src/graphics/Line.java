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
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * @author adri
 * Figura Linea, implementa una figura Line2DW
 */
public class Line extends Shape implements IShape
{

    public Line(Config config, Point startPoint)
    {
        super(config, startPoint);
        this.internalShape = new Line2D.Double(startPoint, startPoint);
    }
    
    public Point getLocation()
    {
        Line2D line = ((Line2D) this.internalShape);
        return new Point((int) line.getX1(), (int) line.getY1());
    }

    public void setLocation(Point newStartPoint)
    {
        Point originalLocation = this.getLocation();

        Line2D line = ((Line2D) this.internalShape);
        double dx = newStartPoint.getX() - originalLocation.getX();
        double dy = newStartPoint.getY() - originalLocation.getY();

        ((Line2D) this.internalShape).setLine(line.getX1() + dx, line.getY1() + dy, line.getX2() + dx, line.getY2() + dy);

        
    }

    /**
     * Comprueba si un determinado punto está cerca de la posición indicada
     * @param p punto
     * @return true si está cerca (a menos de 5 pixeles)
     */
    private boolean isNear(Point2D p)
    {
        return ((Line2D) this.internalShape).ptSegDist(p) <= 5.0;
    }
    
    /**
     * Comprueba si el objeto está en las cordenadas
     * @param p punto en forma de objeto Point2D
     * @return true si está dentro
     */
    public boolean contains(Point2D p)
    {
        // Si es un punto o una línea hacemos uso del isNear()
        return isNear(p);
    }
    
    public void resize(Point endPoint)
    {
        // Aqui almacenaremos las coordenadas
        Point startPoint = this.getLocation();
        
        ((Line2D) this.internalShape).setLine(startPoint, endPoint);
        
    }

}
