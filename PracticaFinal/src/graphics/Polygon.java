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
import java.awt.geom.GeneralPath;
import GraphicsBasico2D.Config;

/**
 * @author adri
 * Figura Poligono, implementa una figura Polilinea, ya que un poligono es una 
 * polilínea cerrada
 */
public class Polygon extends Polyline {

    public Polygon(Config config, Point startPoint)
    {
        super(config, startPoint);
    }

    public void onDoubleClick(Point newStartPoint)
    {
        super.onDoubleClick(newStartPoint); 
        
        ((GeneralPath)this.internalShape).closePath();
    }
    
    

}
