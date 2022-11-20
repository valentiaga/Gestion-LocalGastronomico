package test;

import org.junit.Assert;
import org.junit.Test;

import modelo.Sueldo;

public class testSueldo
{

	@Test
	public void testSetRemBasic()
	{
		Sueldo.setRemBasic(279);
		Sueldo sueldo = new Sueldo();
		Assert.assertEquals("Nueva remBasica registrada erroneamente. remBasica: ",279,sueldo.getRemBasic(),0);
	}
	
	@Test
	public void testCalculaSueldo()
	{
		Sueldo.setRemBasic(279);
		double montoSueldo = Sueldo.calculaSueldo(3);
		Assert.assertEquals("Sueldo calculado erroneamente",279*(1+0.05*3),montoSueldo,0);
	}

}
