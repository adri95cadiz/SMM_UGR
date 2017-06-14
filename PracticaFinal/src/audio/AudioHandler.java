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
package audio;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
 * @author adri
 * Clase para gestionar los eventos del reproductor
 * No utilizada de momento
 */
public class AudioHandler implements LineListener
{

    /**
     * Método llamado cuando se genera un evento en el reproductor
     * @param event evento
     */
    @Override
    public void update(LineEvent event)
    {
        if (event.getType() == LineEvent.Type.START)
        {
            System.out.println("START");
        }
        if (event.getType() == LineEvent.Type.STOP)
        {
            System.out.println("STOP");
        }
        if (event.getType() == LineEvent.Type.CLOSE)
        {
            System.out.println("CLOSE");
        }
    }

}
