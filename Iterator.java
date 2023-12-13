/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import code.Cliente;
/**
 *
 * @author vletr
 */
public interface Iterator {

    public abstract boolean temProximo();

    public abstract Cliente proximo();

    public void addPos();
}
