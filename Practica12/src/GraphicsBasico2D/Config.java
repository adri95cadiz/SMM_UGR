package GraphicsBasico2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

/**
 *
 * @author Adri
 */
public class Config implements Cloneable
{
    public static Config GENERALCONFIG = new Config();
    
    private Tool selectedTool = Tool.POINT;
    private Color selectedColor = Color.BLACK;
    private Boolean fillColor = false;
    private Stroke stroke = new BasicStroke(1);
    private Boolean antialiasing = false;
    private Boolean alpha = false;

    public Config duplicate()
    {
        Config newconfig = new Config();
        newconfig.selectedTool = this.selectedTool;
        newconfig.selectedColor = this.selectedColor;
        newconfig.fillColor = this.fillColor;
        newconfig.stroke = this.stroke;
        newconfig.antialiasing = this.antialiasing;
        newconfig.alpha = this.alpha;

        return newconfig;
    }
    
    public enum Tool
    {
        HAND, // para mover
        POINT,
        LINE,
        RECTANGLE,
        ELLIPSE,
        SELECT,
    }

    public void setSelectedTool(Tool tool)
    {
        this.selectedTool = tool;
    }

    public Tool getSelectedTool()
    {
        return this.selectedTool;
    }

    public void setSelectedColor(Color color)
    {
        this.selectedColor = color;
    }

    public Color getSelectedColor()
    {
        return this.selectedColor;
    }

    public void setFillColor(Boolean fill)
    {
        this.fillColor = fill;
    }

    public Boolean getFillColor()
    {
        return this.fillColor;
    }

    public void setStroke(int pStroke)
    {
        this.stroke = new BasicStroke(pStroke);
    }

    public Stroke getStroke()
    {
        return this.stroke;
    }
    
    public void setAntialiasing(Boolean antialiasing)
    {
        this.antialiasing = antialiasing;
    }

    public Boolean getAntialiasing()
    {
        return this.antialiasing;
    }
    
    public void setAlpha(Boolean alpha)
    {
        this.alpha = alpha;
    }

    public Boolean getAlpha()
    {
        return this.alpha;
    }

}
