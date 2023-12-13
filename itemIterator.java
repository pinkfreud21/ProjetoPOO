/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import code.Cliente;
import java.util.ArrayList;

/**
 *
 * @author vletr
 */
public class itemIterator implements Iterator{
    private ArrayList<Cliente> lista;
    private int pos=0;

    public itemIterator(ArrayList<Cliente> lista){
        this.lista = lista;
    }



    public boolean temProximo() {
        boolean result=false;
        if ( pos < this.lista.size() )
            result=true;
        return result;
    }

    public Cliente proximo() {
        Cliente item  = this.lista.get(pos);
        return item;
    }

    public void addPos()
    {
        this.pos++;
    }

}
