package graphics;

import java.awt.geom.Line2D;
import GraphicsBasico2D.Config;

/**
 * Figura Punto, extiende una Linea ya que un punto es una linea con longitud 0
 */
public class Point extends Line 
{

    public Point(Config config, java.awt.Point startPoint)
    {
        super(config, startPoint);
    }
    
    @Override
    public void resize(java.awt.Point endPoint)
    {
        ((Line2D) this.internalShape).setLine(endPoint, endPoint);
    }

}
