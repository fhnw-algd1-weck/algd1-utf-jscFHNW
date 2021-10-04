package ch.fhnw.algd1.converters.hex;

import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import ch.fhnw.algd1.converters.base.AbstractDocListener;
import ch.fhnw.algd1.converters.base.ConverterModel;

/*
 * Created on 05.09.2014
 */
/**
 * @author Wolfgang Weck
 */
public class HexDocListener extends AbstractDocListener<Integer> {
	public HexDocListener(ConverterModel<Integer> model) {
		super(model);
	}

	@Override
	protected void anyUpdate(DocumentEvent e) {
		try {
			final Document doc = e.getDocument();
			final String s = doc.getText(0, doc.getLength());
			final int x = (s.length() == 0 || s.equals("-")) ? 0 : HexConverter.fromString(s.toUpperCase());
			updateModel(e, x);
		}
		catch (BadLocationException e1) {
			e1.printStackTrace();
		}
	}
}
