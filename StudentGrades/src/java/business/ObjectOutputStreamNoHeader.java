/**
 *
 * @author KBowe
 */
package business;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamNoHeader extends ObjectOutputStream
{
    public ObjectOutputStreamNoHeader (FileOutputStream fos)
            throws IOException
    {
        super(fos);
    }
    
    @Override
    public void writeStreamHeader()
    {
        //do nothing
    }
}
