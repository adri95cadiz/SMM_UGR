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

import java.awt.Color;
import java.awt.GradientPaint;
import GraphicsBasico2D.Config;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import GraphicsBasico2D.IShape;

/**
 * @author adri
 * Esta clase define una figura de nuestra aplicación, hereda de Shape y le agrega 
 * mas funcionalidad
 */
public class Shape implements java.awt.Shape, Cloneable, IShape
{

    private Config config;
    
    /**
     * Aqui se almacenará la instancia de java.awt.(figura)
     */
    protected java.awt.Shape internalShape;

    /**
     * Cosntructor de la clase
     * @param config una copia del objeto config actual
     * @param startPoint la posicion inicial
     */
    public Shape(Config config, Point startPoint)
    {
        this.config = config;
    }

    /**
     * Clone una imagen en otra
     * @return shape clonada
     * @throws java.lang.CloneNotSupportedException 
     */
    @Override
    public Shape clone() throws CloneNotSupportedException
    {
        super.clone();
        Point startPoint = new Point(this.internalShape.getBounds().x, this.internalShape.getBounds().y);
        Shape shape = null;
        switch (this.config.getSelectedTool())
        {
            case POINT:
                shape = new graphics.Point(this.config.clone(), startPoint);
                break;
            case LINE:
                shape = new graphics.Line(this.config.clone(), startPoint);
                break;
            case RECTANGLE:
                shape= new graphics.Rectangle(this.config.clone(), startPoint);
                break;
            case ROUNDRECTANGLE:
                shape = new graphics.RoundRectangle(this.config.clone(), startPoint);
                break;
            case ELLIPSE:
                shape = new graphics.Ellipse(this.config.clone(), startPoint);
                break;
            case ARC:
                shape = new graphics.Arc(this.config.clone(), startPoint);
                break;
                
                /*                    case POLYLINE:
                {
                if (this.selectedShape != null && this.selectedShape instanceof Polyline && ((Polyline) this.selectedShape).creating)
                if (evt.getClickCount() == 2)
                ((Polyline) this.selectedShape).onDoubleClick(evt.getPoint());
                else
                ((Polyline) this.selectedShape).onClick(evt.getPoint());
                else
                this.selectedShape = new sm.esc.graphics.Polyline(Config.GENERALCONFIG.clone(), evt.getPoint());
                
                }
                break;
                
                case POLYGON:
                {
                if (this.selectedShape != null && this.selectedShape instanceof Polygon && ((Polygon) this.selectedShape).creating)
                if (evt.getClickCount() == 2)
                ((Polygon) this.selectedShape).onDoubleClick(evt.getPoint());
                else
                ((Polygon) this.selectedShape).onClick(evt.getPoint());
                else
                this.selectedShape = new sm.esc.graphics.Polygon(Config.GENERALCONFIG.clone(), evt.getPoint());
                
                }
                break;
                case CURVE:
                {
                if (this.selectedShape != null && this.selectedShape instanceof Curve && ((Curve) this.selectedShape).creating)
                ((Curve) this.selectedShape).onClick(evt.getPoint());
                else
                this.selectedShape = new sm.esc.graphics.Curve(Config.GENERALCONFIG.clone(), evt.getPoint());
                
                }
                break;
                */
                
            }
            
        Point endPoint = new Point(this.internalShape.getBounds().x + this.internalShape.getBounds().width, this.internalShape.getBounds().y+this.internalShape.getBounds().height);

        shape.resize(endPoint);
        
        return shape;
            
 
    }

    /**
     * Establece la nueva posicion de la figura
     * @param newStartPoint 
     */
    @Override
    public void setLocation(Point newStartPoint)
    {

    }

    /**
     * Pinta la figura
     * @param g2d objeto Graphics2D
     */
    public void draw(Graphics2D g2d)
    {
        
        g2d.setStroke(this.config.getStroke());

        if (this.config.getFillColor()> 0)
        {
            
            switch (this.config.getFillColor())
            {
                case 1: // solido
                    g2d.setPaint(this.config.getSelectedBackColor());
                    break;
                case 2: // derecha
                    g2d.setPaint(new GradientPaint(this.internalShape.getBounds().x, this.internalShape.getBounds().y, this.config.getSelectedFrontColor(), this.internalShape.getBounds().x + this.internalShape.getBounds().width, this.internalShape.getBounds().y, this.config.getSelectedBackColor()));
                    break;
                case 3: // abajo
                    g2d.setPaint(new GradientPaint(this.internalShape.getBounds().x, this.internalShape.getBounds().y, this.config.getSelectedFrontColor(), this.internalShape.getBounds().x, this.internalShape.getBounds().y + this.internalShape.getBounds().height, this.config.getSelectedBackColor()));
                    break;
                case 4: // radial
                    
                    Point2D center = new Point2D.Float( this.internalShape.getBounds().width, this.internalShape.getBounds().height);
                    float radius = this.internalShape.getBounds().width/2;
                    float[] dist = {0.0f, 1.0f};
                    Color[] colors ={this.config.getSelectedFrontColor(), this.config.getSelectedBackColor()} ;
                    RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, colors);

                    g2d.setPaint(p);
                    break;
                case 5: // diagonal 1
                    g2d.setPaint(new GradientPaint(this.internalShape.getBounds().x, this.internalShape.getBounds().y, this.config.getSelectedFrontColor(), this.internalShape.getBounds().x + this.internalShape.getBounds().width, this.internalShape.getBounds().y + this.internalShape.getBounds().height, this.config.getSelectedBackColor()));
                    break;
                case 6: // diagonal 2
                    g2d.setPaint(new GradientPaint( this.internalShape.getBounds().x + this.internalShape.getBounds().width, this.internalShape.getBounds().y + this.internalShape.getBounds().height, this.config.getSelectedFrontColor(),this.internalShape.getBounds().x, this.internalShape.getBounds().y, this.config.getSelectedBackColor()));
                    break;
                default:
                    break;
            }
            g2d.fill(this);
        } 
                
        g2d.setPaint(this.config.getSelectedFrontColor());
        g2d.draw(this);

    }
    
    public Config getConfig()
    {
        return this.config;
    }

    /**
     * Redimensiona la figura
     * @param endPoint 
     */
    @Override
    public void resize(Point endPoint)
    {

    }
    
    /**
     * Obtiene las dimensiones de la figura
     * @return un objeto Rectangle
     */
    @Override
    public Rectangle getBounds()
    {
        return this.internalShape.getBounds();
    }

    /**
     * Obtiene las dimensiones de la figura
     * @return un objeto Rectangle2D
     */
    @Override
    public Rectangle2D getBounds2D()
    {
        return this.internalShape.getBounds2D();
    }

    /**
     * Comprueba si el objeto está en las cordenadas
     * @param x punto del eje x
     * @param y punto del eje y
     * @return true si está dentro
     */
    @Override
    public boolean contains(double x, double y)
    {
        return this.internalShape.contains(x, y);
    }

    /**
     * Comprueba si el objeto está en las cordenadas
     * @param p punto en forma de objeto Point2D
     * @return true si está dentro
     */
    @Override
    public boolean contains(Point2D p)
    {
        return this.internalShape.contains(p);
    }

    /**
     * Dice si el punto está en una interseccion
     * @param x
     * @param y
     * @param w
     * @param h
     * @return true si el punto está en una intersección 
     */
    @Override
    public boolean intersects(double x, double y, double w, double h)
    {
        return this.internalShape.intersects(x, y, w, h);
    }

    /**
     * Dice si el punto está en una interseccion
     * @param r
     * @return true si el punto está en una intersección
     */
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

    /**
     * OBtiene el objeto pathIterator
     * @param at
     * @return pathIterator
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at)
    {
        return this.internalShape.getPathIterator(at);
    }

    /**
     * Obtiene el objeto pathIterator
     * @param at
     * @param flatness
     * @return pathIterator
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness)
    {
        return this.internalShape.getPathIterator(at, flatness);
    }

    /**
     * Obtiene la posición de la figura en el lienzo
     * @return un objeto Point con la posicion
     */
    @Override
    public Point getLocation()
    {

        return null;

    }

}
