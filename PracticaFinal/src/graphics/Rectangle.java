package graphics;

import java.awt.Point;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;
/**
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
