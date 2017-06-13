package graphics;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;

/**
 * Figura Polilinea, implementa una figura GeneralPath, permite ir definiendo
 * una serie de puntos enlazados hasta que se hace doble click, no se cierra
 * por defecto, para una polilinea cerrada vease el objeto Poligono
 */
public class Polyline extends Shape implements IShape
{
    public boolean creating = true;

    public Polyline(Config config, Point startPoint)
    {
        super(config, startPoint);
        this.internalShape = new Line2D.Double(startPoint, startPoint);
        
        this.internalShape =  new GeneralPath(GeneralPath.WIND_EVEN_ODD);


        ((GeneralPath)this.internalShape).moveTo( startPoint.x,startPoint.y);
        
    }
    
    public void onClick(Point newStartPoint) 
    {
        ((GeneralPath)this.internalShape).lineTo(newStartPoint.x, newStartPoint.y);
    }
    
    public void onDoubleClick(Point newStartPoint) 
    {   
        this.creating = false;
    }

    public Point getLocation()
    {
        GeneralPath line = ((GeneralPath) this.internalShape);
        return new Point((int) line.getBounds().x, (int) line.getBounds().y);
    }

    @Override
    public void setLocation(Point newStartPoint)
    {

                
        Point originalLocation = this.getLocation();

        double dx = newStartPoint.getX() - originalLocation.getX();
        double dy = newStartPoint.getY() - originalLocation.getY();
        
        
        ((GeneralPath) this.internalShape).transform(AffineTransform.getTranslateInstance(dx,dy));
      
    }
    
    @Override
    public void resize(Point endPoint)
    {
        
        
        Point2D current = ((GeneralPath) this.internalShape).getCurrentPoint();
    
        int x = (int)(current.getX() - endPoint.x);
        int y = (int)(current.getY() - endPoint.y);

        ((GeneralPath) this.internalShape).transform(AffineTransform.getTranslateInstance(x,y));
            
    }

}
