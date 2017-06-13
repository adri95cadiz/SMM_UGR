package GraphicsBasico2D;

import java.awt.Point;

/**
 * Interface IShape, utilizada para normalizar los métodos que deben aparecer en cada forma
 */
public interface IShape 
{
    /**
     * Obtiene la ubicación
     * @return un Point
     */
    public Point getLocation();
    
    /**
     * Establece la ubicación
     * @param newStartPoint El punto deonde debe aparecer
     */
    public void setLocation(Point newStartPoint);
    
    /**
     * Redimensiona la figura
     * @param endPoint el punto hasta donde debe llegar
     */
    public void resize(Point endPoint);
    
}
