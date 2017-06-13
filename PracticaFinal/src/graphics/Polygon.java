package graphics;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import GraphicsBasico2D.Config;

/**
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
