/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.crm.facades;

import com.co.crm.entities.Contacto;
import javax.ejb.Stateless;

/**
 *
 * @author Andrés Peña Mantilla
 */
@Stateless
public class ContactoFacade extends PersistentManager<Contacto> {

    /*Este método persiste un 'Contacto' en la base de datos*/
    public void persistirContacto(Contacto contactoPersistir) {
        persistir(contactoPersistir);
    }


    /*Este método actualiza un 'Contacto' en la base de datos*/
    public void actualizarUsuario(Contacto contactoModificar) {
        actualizar(contactoModificar);
    }

}
