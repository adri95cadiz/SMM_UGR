package graphics;

import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * Figura Curva, implementa una figura QuadCurve2D
 */
public class Curve extends Shape implements IShape
{
    
    public boolean creating = true;
    private Point middle;

    public Curve(Config config, Point startPoint)
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
        
        ((QuadCurve2D) this.internalShape).setCurve(startPoint.x, startPoint.y, this.middle.x, this.middle.y, width, height);
        
    }
    
    
    public void onClick(Point newStartPoint) 
    {
        this.creating = false;
        middle = newStartPoint;
    }
    

}
