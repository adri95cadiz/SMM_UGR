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
package UI;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;

/**
 * @author adri
 * Esta clase extiende un JButton y hace que al hacer click en el mismo despligue un 
 * panel jColorChooser, una vez seleccionado pondra el color seleccionado como fondo del botón
 */
public class ColorChooserButton extends JButton
{

    private Color current;

    /**
     * Constructor de la clase
     * @param c se le indica el color por defecto que tendrá el botón
     */
    public ColorChooserButton(Color c)
    {
        setSelectedColor(c);
        addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0)
            {
                Color newColor = JColorChooser.showDialog(null, "Seleccione un color", current);
                setSelectedColor(newColor);
            }
        });
    }
    
    /**
     * método para obtener el color seleccionado
     * @return el color seleccionado
     */
    public Color getSelectedColor()
    {
        return current;
    }
    
    /**
     * método para establecer el color seleccionado
     * @param newColor se le indica el color que tendrá el botón
     */
    public void setSelectedColor(Color newColor)
    {
        setSelectedColor(newColor, true);
    }
    /**
     * método para establecer el color seleccionado
     * @param newColor se le indica el color que tendrá el botón
     * @param notify se le indica que debe generar un evento cuando cambie el color
     */
    public void setSelectedColor(Color newColor, boolean notify)
    {

        if (newColor == null)
            return;

        current = newColor;
        setIcon(createIcon(current, 16, 16));
        repaint();

        if (notify)
            // Notify everybody that may be interested.
            for (ColorChangedListener l : listeners)
                l.colorChanged(newColor);
    }

    /**
     * Listener que podemos implementar para detectar el cambio de color
     */
    public static interface ColorChangedListener
    {

        public void colorChanged(Color newColor);
    }

    private List<ColorChangedListener> listeners = new ArrayList<ColorChangedListener>();

    /**
     * Método para asociar un determinado evento a una funcion y almacenarlos en la lista de eventos
     * @param toAdd puntero a la funcion a llamar cuando cambie el color
     */
    public void addColorChangedListener(ColorChangedListener toAdd)
    {
        listeners.add(toAdd);
    }

    /**
     * Crea un icono para asignarselo como fondo al botón
     * @param main
     * @param width
     * @param height
     * @return icon icono de imagen para asignar.
     */
    private static ImageIcon createIcon(Color main, int width, int height)
    {
        BufferedImage image = new BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(main);
        graphics.fillRect(0, 0, width, height);
        graphics.setXORMode(Color.DARK_GRAY);
        graphics.drawRect(0, 0, width - 1, height - 1);
        image.flush();
        ImageIcon icon = new ImageIcon(image);
        return icon;
    }
}
