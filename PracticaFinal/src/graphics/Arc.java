package graphics;

import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
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
