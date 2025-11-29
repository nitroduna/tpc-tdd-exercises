/*
 * Copyright (C) 2010, Pedro Ballesteros <nitroduna@gmail.com>
 *
 * This file is part of nitroduna Test-Driven Development Exercises
 * Exercises(https://nitroduna.github.io/)
 *
 * This copyrighted material is free software: you can redistribute it
 * and/or modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This material is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this material. This copy is available in LICENSE-GPL.txt
 * file. If not, see <http://www.gnu.org/licenses/>.
 */

package io.github.nitroduna.tdd.addressbook;

import io.github.nitroduna.tdd.domain.Contact;
import java.util.List;

/**
 * Interfaz del servicio GlobalAddressBook
 *
 * <p><b>
 * Refactorización:</b></p>
 *
 * <p>
 * Se ha extraido el GlobalAddressBook como un interface para conseguir
 * un acoplamiento más debil, reforzado por el uso de IoC.</p>
 *
 * <p>
 * La propiedad IdGenerator <b>NO DEBE IR EN LA INTERFAZ:</b><br/>
 *   Son detalles de configuración de una implementación especifica que
 *   en este caso necesita un generador de ids, otra implementación podría
 *   no necesitar dicho generador.</p>
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public interface GlobalAddressBook {

    /**
     * Añade un nuevo contacto devolviendo el id generado.
     *
     * @param contact Datos del contacto a añadir
     * @return Devuelve el id asignado al contacto
     */
    String addContact(Contact contact);

    /**
     * Elimina el contacto con el id entregado.
     *
     * @param id
     */
    void deleteContact(String id);

    /**
     * Obtiene todos los contactos del sistema.
     *
     * @return
     */
    List<Contact> getAll();

    /**
     * Obtiene el contacto asociado al id entregado.
     *
     * @param contactId id del contacto
     * @return Devuelve el contacto
     */
    Contact getContact(String contactId);
}
