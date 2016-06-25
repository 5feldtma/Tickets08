package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

public class VerkaufsFensterService
{

    private int _preis;
    private int _erhaltenerBetrag;
    
    public VerkaufsFensterService()
    {
        
    }
    
    public int berechneRueckgeld()
    {
        return _erhaltenerBetrag - _preis;
    }
    
    public void setErhaltenerBetrag(int betrag)
    {
        _erhaltenerBetrag = betrag;
    }
    
    public int getErhaltenerBetrag()
    {
        return _erhaltenerBetrag;
    }
    
    public void setPreis(int betrag)
    {
        _preis = betrag;
    }
    
    public boolean istBetragAkzeptabel()
    {
        return _erhaltenerBetrag >= _preis;
    }
    
    public void add(int betrag)
    {
        _erhaltenerBetrag = _erhaltenerBetrag*10 + betrag;
    }
    
    public void reset()
    {
        _erhaltenerBetrag = 0;
    }
    
    public void loeschen()
    {
        _erhaltenerBetrag = _erhaltenerBetrag/10;
    }
}
