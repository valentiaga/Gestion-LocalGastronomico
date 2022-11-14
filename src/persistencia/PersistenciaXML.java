package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersistenciaXML implements IPersistencia{

	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private FileOutputStream fileoutput;
	private FileInputStream fileinput;
	
	
	@Override
	public void abrirInput(String nombre) throws IOException {
		this.fileinput = new FileInputStream(nombre);
		this.xmlDecoder = new XMLDecoder(this.fileinput);
	}

	@Override
	public void abrirOutput(String nombre) throws IOException {
		this.fileoutput = new FileOutputStream(nombre);
		this.xmlEncoder = new XMLEncoder(this.fileoutput);
	}

	@Override
	public void cerrarInput() throws IOException {
		this.xmlDecoder.close();
	}

	@Override
	public void cerrarOutput() throws IOException {
		if(this.xmlEncoder != null)
			this.xmlEncoder.close();
	}

	@Override
	public void escribir(Object objeto) throws IOException {
		this.xmlEncoder.writeObject(objeto);
	}

	@Override
	public Object leer() throws IOException, ClassNotFoundException {
	Object o = null;
	
		if(this.xmlDecoder != null)
			o = this.xmlDecoder.readObject();
		
		return o;
	}
}
