/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;
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
import GraphicsBasico2D.Config;
import GraphicsBasico2D.IShape;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

/**
 * @author Adri
 * Clase text, implementa texto formateado
 */
public class Text extends Shape implements IShape {
    
    private String string;
    private Color color;
    private Font font;
    private Point startPoint;
    
    public Text(Config config, Point startPoint, String string)
    {
        super(config, startPoint);
        this.string = string;
        this.font = config.getFont();
        this.color = config.getSelectedFrontColor();
        this.startPoint = startPoint;
    }
   
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
    
    
}
