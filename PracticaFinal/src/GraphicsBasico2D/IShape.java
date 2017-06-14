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
package GraphicsBasico2D;

import java.awt.Point;

/**
 * @author adri
 * Interface IShape, utilizada para normalizar los métodos que deben aparecer en cada forma
 */
public interface IShape 
{
    /**
     * Obtiene la ubicación
     * @return un Point
     */
    public Point getLocation();
    
    /**
     * Establece la ubicación
     * @param newStartPoint El punto deonde debe aparecer
     */
    public void setLocation(Point newStartPoint);
    
    /**
     * Redimensiona la figura
     * @param endPoint el punto hasta donde debe llegar
     */
    public void resize(Point endPoint);
    
}
