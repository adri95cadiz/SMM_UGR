package GraphicsBasico2D;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.Font;


/**
 * Esta clase contiene la configuración de la ventana principal en un momento determinado
 * cada vez que se crea un nuevo Shape se le asigna una copia del estado actual, que pasa a
 * ser independiente para cada instancia de Shape
 */
public class Config implements Cloneable
{

    public static Config GENERALCONFIG = new Config();

    private Tool selectedTool = Tool.POINT;
    private Color selectedFrontColor = Color.BLACK;
    private Color selectedBackColor = Color.WHITE;
    private int fillColor = 0;
    private Stroke stroke = new BasicStroke(1);
    private Boolean antialiasing = false;
    private int alpha = 100;
    private Font font = Font.getFont("SanSerif");
    
    /**
     * Clona el objeto
     *
     * @return the cloned Config instance
     * @throws java.lang.CloneNotSupportedException
     */
    @Override
    public Config clone() throws CloneNotSupportedException
    {
        super.clone();
        
        Config newconfig = new Config();
        newconfig.selectedTool = this.selectedTool;
        newconfig.selectedFrontColor = this.selectedFrontColor;
        newconfig.selectedBackColor = this.selectedBackColor;
        newconfig.fillColor = this.fillColor;
        newconfig.stroke = this.stroke;
        newconfig.antialiasing = this.antialiasing;
        newconfig.alpha = this.alpha;

        return newconfig;
    }

    /**
     * Enumeracion con todas las herramientas que se pueden usar en una imagen
     */
    public enum Tool
    {
        HAND, // para mover
        POINT,
        LINE,
        RECTANGLE,
        ELLIPSE,
        ROUNDRECTANGLE,
        CURVE,
        POLYLINE,
        POLYGON,
        ARC,
        TEXT
    }
    
    /**
     * Sets the current selected tool
     *
     * @param tool The tool to set as selected
     */
    public void setSelectedTool(Tool tool)
    {
        this.selectedTool = tool;
    }

    /**
     * Gets the current selected tool
     *
     * @return the selected tool
     */
    public Tool getSelectedTool()
    {
        return this.selectedTool;
    }

    /**
     * Establece el color actual
     * @param color el color a establecer
     */
    public void setSelectedFrontColor(Color color)
    {
        this.selectedFrontColor = color;
    }

    /**
     * Obtiene el color actual
     * @return un objeto Color
     */
    public Color getSelectedFrontColor()
    {
        return this.selectedFrontColor;
    }
    /**
     * Establece el color actual
     * @param color el color a establecer
     */
    public void setSelectedBackColor(Color color)
    {
        this.selectedBackColor = color;
    }

    /**
     * Obtiene el color actual
     * @return un objeto Color
     */
    public Color getSelectedBackColor()
    {
        return this.selectedBackColor;
    }
    
    /**
     * Establece si se debe rellenar la figura
     * @param fill 0=False, 1=Solid, 2=Horizontal, 3=Vertical
     */
    public void setFillColor(int fill)
    {
        this.fillColor = fill;
    }

    /**
     * Obtiene si se debe rellenar la figura
     * @return true si se debe rellenar
     */
    public int getFillColor()
    {
        return this.fillColor;
    }

    /**
     * Establece el tipo de la linea
     * @param width grosor de la linea
     * @param type el tipo de linea 0=Linea,1=Rayas,2=Punteado
     */
    public void setStroke(int width, int type)
    {
        switch (type)
        {
            case 0:
                this.stroke = new BasicStroke(width);
                break;
            case 1:
                this.stroke = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0); 
                break;
            case 2:
                this.stroke = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{3}, 0);
                break;
        }
        
    }

    /**
     * Obtiene el grosor de la linea
     * @return  grosor de la linea
     */
    public Stroke getStroke()
    {
        return this.stroke;
    }

    /**
     * Establece el suavizado
     * @param antialiasing  true si se debe suavizar
     */
    public void setAntialiasing(Boolean antialiasing)
    {
        this.antialiasing = antialiasing;
    }

    /**
     * Obtiene si esta activado el suavizado
     * @return true si se debe suavizar
     */
    public Boolean getAntialiasing()
    {
        return this.antialiasing;
    }

    /**
     * Establece el valor del canal alfa
     * @param alpha Entero con el valor, 100 desactivado, 0 maximo
     */
    public void setAlpha(int alpha)
    {
        this.alpha = alpha;
    }

    /**
     * Obtiene el valor el canal alpha
     * @return entero con el valor
     */
    public int getAlpha()
    {
        return this.alpha;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

}
