package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class VerkaufsFensterServiceTest
{
    @Test
    public void testeKonstruktoren()
    {
        VerkaufsFensterService vfs = new VerkaufsFensterService();
        assertEquals(0, vfs.getErhaltenerBetrag());
        assertEquals(0, vfs.berechneRueckgeld());
        assertNotNull(vfs);
    }
    
    @Test
    public void testeBerechneRueckgeld()
    {
        VerkaufsFensterService vfs = new VerkaufsFensterService();
        vfs.setPreis(100);
        assertEquals(-100, vfs.berechneRueckgeld());
        vfs.add(3);
        vfs.add(0);
        assertEquals(-70, vfs.berechneRueckgeld());
        vfs.add(0);
        assertEquals(200, vfs.berechneRueckgeld());
        vfs.add(0);
        assertEquals(2900, vfs.berechneRueckgeld());
    }
    
    @Test
    public void testeIstPreisAkzeptabel()
    {
        VerkaufsFensterService vfs = new VerkaufsFensterService();
        vfs.setPreis(1000);
        assertFalse(vfs.istBetragAkzeptabel());
        vfs.add(9);
        vfs.add(9);
        vfs.add(9);
        assertFalse(vfs.istBetragAkzeptabel());
        vfs.add(0);
        assertTrue(vfs.istBetragAkzeptabel());
    }

    @Test
    public void testeAdd()
    {
        VerkaufsFensterService vfs = new VerkaufsFensterService();
        vfs.add(1);
        assertEquals(1, vfs.getErhaltenerBetrag());
        vfs.add(0);
        assertEquals(10, vfs.getErhaltenerBetrag());
        vfs.add(9);
        assertEquals(109, vfs.getErhaltenerBetrag());
        vfs.add(9);
        assertEquals(1099, vfs.getErhaltenerBetrag());
    }
    
    @Test
    public void testeReset()
    {
        VerkaufsFensterService vfs = new VerkaufsFensterService();
        vfs.add(1);
        vfs.add(0);
        vfs.add(0);
        vfs.reset();
        assertEquals(0, vfs.getErhaltenerBetrag());
    }
    
    @Test
    public void testeLöschen()
    {
        VerkaufsFensterService vfs = new VerkaufsFensterService();
        vfs.add(1);
        vfs.add(0);
        vfs.add(0);
        vfs.loeschen();
        assertEquals(10, vfs.getErhaltenerBetrag());
        vfs.loeschen();
        assertEquals(1, vfs.getErhaltenerBetrag());
        vfs.loeschen();
        assertEquals(0, vfs.getErhaltenerBetrag());
        vfs.loeschen();
        assertEquals(0, vfs.getErhaltenerBetrag());
    }
}
