package UI;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.image.BufferedImage;

/**
*
* @author Adri
*/
public class CanvasImage extends Canvas 
{

    private BufferedImage img;
    
    public void setImage(BufferedImage img)
    {
        this.img = img;
        if(img!=null) {
          setPreferredSize(new Dimension(img.getWidth(),img.getHeight()));
          this.setClip(new Rectangle(0, 0, img.getWidth(), img.getHeight()));
        }
    }
    public BufferedImage getImage(){
        return img; 
    }
    
    public BufferedImage getImage(boolean drawVector) 
    {
        if (drawVector) 
        {
            BufferedImage image = new BufferedImage(this.img.getWidth(), this.img.getHeight(), this.img.getType());
            
            //nos guardamos el "clip" en una variable temporal y lo asignamos a null
            java.awt.Shape tmpShape = this.clip;
            this.clip = null;
            
            // pintamos
            this.paint(image.createGraphics());
            
            // volvemos a asignar el "clip"
            this.clip = tmpShape;

            return image;
        }
        return this.getImage();
    }
    
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        if (this.img != null) 
            g.drawImage(this.img, 0, 0, this);
       
        if (this.clip != null) 
            this.paintBorderClip((Graphics2D)g);

    }

    private void paintBorderClip(Graphics2D g) 
    {
        Stroke sk = g.getStroke();
        float[] pattern = new float[]{3.0f, 3.0f};
        BasicStroke dotted = new BasicStroke(1.0f, 0, 2, 1.0f, pattern, 0.0f);
        g.setStroke(dotted);
        g.draw(this.clip);
        g.setStroke(sk);
    }
    
    
    
}
