package ifrn.nc.moxa.apresentacao;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class IntegerDocument extends PlainDocument{
	
	public void insertString (int offset, String str, AttributeSet attr)
	throws BadLocationException {
		
		if (str == null)
			return;
		
		try{
			Integer.parseInt(str);
			
		} catch (Exception e){
			return;
		}
		super.insertString(offset, str, attr);
	}

}
