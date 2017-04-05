package GraphicsBasico2D;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import static GraphicsBasico2D.Config.Tool.LINE;
import static GraphicsBasico2D.Config.Tool.POINT;

/**
 * 
 * @author Adri
 */
public class Shape implements java.awt.Shape 
{    
    private Config config;    

    public Config getConfig() {
        return config;
    }
    private java.awt.Shape internalShape;

    public Shape(Config config, Point startPoint) 
    {
        this.config = config;
               
        switch (this.config.getSelectedTool())
        {
            case POINT :
            case LINE :
                
                this.internalShape = new Line2D.Double(startPoint, startPoint);
                break;

            case RECTANGLE :
                               
                this.internalShape = new Rectangle(startPoint.x, startPoint.y, 0, 0);
                break;

            case ELLIPSE :

                this.internalShape = new Ellipse2D.Double(startPoint.x, startPoint.y, 0, 0);
                break;

        }

             
    }
    
    
    public void setLocation(Point newStartPoint)
    {          
        Point originalLocation = this.getLocation();
        
        int newx =   (newStartPoint.x -  originalLocation.x);
        int newy =   (newStartPoint.y -  originalLocation.y);
        
        switch (this.config.getSelectedTool())
        {
            case POINT :
            case LINE :
                
                Line2D line = ((Line2D)this.internalShape);
                double dx = newStartPoint.getX() - originalLocation.getX();
                double dy = newStartPoint.getY() - originalLocation.getY();
                
                ((Line2D)this.internalShape).setLine(line.getX1()+dx, line.getY1()+dy, line.getX2()+dx, line.getY2()+dy); 

                break;

            case RECTANGLE :
                
                ((Rectangle)this.internalShape).setLocation(newStartPoint.x , newStartPoint.y);
                //((Rectangle)this.internalShape).setLocation(newx , newy);
                //((Rectangle)this.internalShape).setFrame(newx , newy, 100, 100);
                break;

            case ELLIPSE :

                Ellipse2D ellipse = ((Ellipse2D)this.internalShape);
                ((Ellipse2D)this.internalShape).setFrame(newStartPoint.x , newStartPoint.y, ellipse.getWidth(), ellipse.getHeight());
                break;

        }
     
        //this.resize(startPoint, endPoint);
        //this.startPoint = p;
        
    }
    
    public Shape clone() throws CloneNotSupportedException{
        Shape shape = new Shape(this.config, this.getLocation());
        shape.internalShape = this.internalShape;
        return shape;
    }
    
    public void draw(Graphics2D g2d)
    {
        g2d.setPaint(this.config.getSelectedColor());
        g2d.setStroke(this.config.getStroke());

        if (this.config.getFillColor()) 
            g2d.fill(this);
        g2d.draw(this);
        
    }
    
    public void resize(Point endPoint)
    {
                
        // Aqui almacenaremos las coordenadas
        Point startPoint = this.getLocation();
        
        int width = endPoint.x - startPoint.x;
        int height = endPoint.y - startPoint.y;        
        
        
        if (endPoint.x < startPoint.x)
            width = -1 * ( startPoint.x - endPoint.x);
        
        
        if (endPoint.y < startPoint.y)
            height =  startPoint.y - endPoint.y;
        
        switch (this.config.getSelectedTool())
        {
            case POINT :
               ((Line2D)this.internalShape).setLine(endPoint, endPoint); 
                break;

            case LINE :
                
                ((Line2D)this.internalShape).setLine(startPoint, endPoint); 
                break;

            case RECTANGLE :
                               
                ((Rectangle)this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
                break;

            case ELLIPSE :

                ((Ellipse2D)this.internalShape).setFrame(startPoint.x, startPoint.y, width, height);
                break;

        }
            
    }
    
    private boolean isNear(Point2D p)
    {  
        return ((Line2D)this.internalShape).ptSegDist(p) <= 5.0; 
    } 

    @Override
    public Rectangle getBounds() 
    {
        return this.internalShape.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() 
    {
        return this.internalShape.getBounds2D();
    }

    @Override
    public boolean contains(double x, double y) 
    {
        return this.internalShape.contains(x, y);
    }

    @Override
    public boolean contains(Point2D p) 
    {
        // Si es un punto o una línea hacemos uso del isNear()
        if ( (this.config.getSelectedTool() == POINT || this.config.getSelectedTool() == LINE) && isNear(p))
            return true;
        
        return this.internalShape.contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) 
    {
        return this.internalShape.intersects(x, y, w, h);
    }

    @Override
    public boolean intersects(Rectangle2D r) 
    {
        return this.internalShape.intersects(r);
    }

    @Override
    public boolean contains(double x, double y, double w, double h) 
    {
        return this.internalShape.contains(x, y, w, h);
    }
    
   
    @Override
    public boolean contains(Rectangle2D r) 
    {        
        return this.contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }
    
    @Override
    public PathIterator getPathIterator(AffineTransform at) 
    {
        return this.internalShape.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) 
    {
        return this.internalShape.getPathIterator(at, flatness);
    }
    
    
    private Point getLocation()
    {
         switch (this.config.getSelectedTool())
        {
            case POINT :
            case LINE :
                
                Line2D line = ((Line2D)this.internalShape);
                return new Point((int)line.getX1(), (int)line.getY1());

            case RECTANGLE :

                return  ((Rectangle)this.internalShape).getLocation();

            case ELLIPSE :
                
                Ellipse2D ellipse = ((Ellipse2D)this.internalShape);
                return new Point((int)ellipse.getX(), (int)ellipse.getY());    
        }
         
        return null;
    
    }
    
}
