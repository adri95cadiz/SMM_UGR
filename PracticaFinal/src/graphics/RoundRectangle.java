package graphics;

import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;
import java.awt.Point;
import java.awt.geom.RoundRectangle2D;

/**
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
