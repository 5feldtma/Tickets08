package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.verkaufsfenster;

public class VerkaufsFensterService
{

    private int _preis;
    private int _erhaltenerBetrag;
    
    public VerkaufsFensterService()
    {
        _preis=0;
        _erhaltenerBetrag=0;
    }
    
    /**
     * Berechnet das potenzielle Rückgeld.
     * 
     * @return Rückgeld, ein negativer Wert bedeutet, dass noch ein Restbetrag gezahlt werden muss.
     */
    public int berechneRueckgeld()
    {
        return _erhaltenerBetrag - _preis;
    }
    
    /**
     * Gibt den bereits erhaltenen Betrag zurück.
     */
    public int getErhaltenerBetrag()
    {
        return _erhaltenerBetrag;
    }
    
    /**
     * Setzt den Preis fest.
     * 
     * @param betrag Der zu zahlende Preis
     */
    public void setPreis(int betrag)
    {
        _preis = betrag;
    }
    
    /**
     * Gibt zurück ob genug Geld gezahlt wird.
     * 
     * @ensure berechneRueckgeld() >= 0
     */
    public boolean istBetragAkzeptabel()
    {
        return _erhaltenerBetrag >= _preis;
    }
    
    /**
     * Hängt die ausgewählte Ziffer an _erhaltenenBetrag an.
     * 
     * @param betrag eine Ziffer (0-9)
     * 
     * @require betrag <= 9 && betrag >= 0
     */
    public void add(int betrag)
    {
        assert betrag <= 9 && betrag >= 0 : "Vorbedingung verletzt: betrag ist keine Ziffer";
        
        if(_erhaltenerBetrag<1000000)
        {
            _erhaltenerBetrag = _erhaltenerBetrag*10 + betrag;
        }
    }
    
    /**
     * Setzt _erhaltenerBetrag auf 0 zurück.
     * 
     * @ensure getErhaltenerBetrag() == 0
     */
    public void reset()
    {
        _erhaltenerBetrag = 0;
    }
    
    /**
     * Löscht die letzte Ziffer von _erhaltenerBetrag.
     */
    public void loeschen()
    {
        _erhaltenerBetrag = _erhaltenerBetrag/10;
    }
}
