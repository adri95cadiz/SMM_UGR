package graphics;

import java.awt.Point;
import java.awt.geom.Ellipse2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * Figura Elipse, implementa una figura Ellipse2D
 */
public class Ellipse extends Shape implements IShape
{

    public Ellipse(Config config, Point startPoint)
    {
        super(config, startPoint);
        this.internalShape = new Ellipse2D.Double(startPoint.x, startPoint.y, 0, 0);
    }

    public Point getLocation()
    {

        Ellipse2D ellipse = ((Ellipse2D) this.internalShape);
        return new Point((int) ellipse.getX(), (int) ellipse.getY());
                
    }

    public void setLocation(Point newStartPoint)
    {
        Ellipse2D ellipse = ((Ellipse2D) this.internalShape);
        ((Ellipse2D) this.internalShape).setFrame(newStartPoint.x, newStartPoint.y, ellipse.getWidth(), ellipse.getHeight());
    }

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
        
        ((Ellipse2D) this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
        
    }

}
