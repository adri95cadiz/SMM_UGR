package audio;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

/**
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
