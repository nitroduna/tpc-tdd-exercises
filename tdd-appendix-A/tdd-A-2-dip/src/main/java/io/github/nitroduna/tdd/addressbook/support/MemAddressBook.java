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

package io.github.nitroduna.tdd.addressbook.support;

import io.github.nitroduna.tdd.addressbook.GlobalAddressBook;
import io.github.nitroduna.tdd.addressbook.IdGenerator;
import io.github.nitroduna.tdd.addressbook.InvalidIdException;
import io.github.nitroduna.tdd.domain.Contact;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementación de un servicio Agenda de Contactos Global basado en el
 * almacenamiento en memoria.
 *
 * Desacoplando las dependencias entre detalles de implementación usando
 * las interfaces como abstracciones intermedias.
 *
 * Ahora MemGlobalAddressBook ya no depende de una implementación concreta
 * de IdGenerator, si no de una interfaz que nunca cambiar. Aunque la
 * implementación entregada contenga otros métodos publicos o interfaces
 * sabemos que esta clase unicamente utilizará la API IdGenerator.
 *
 * Es decir, ya no depende de detalles de implementación, si no de una
 * abstracción intermedia.
 *
 * Podemos cambiar una implementación por otra, sabiendo que no será
 * necesario cambiar ni una sola linea de código de acceso a IdGenerator.
 *
 * AUN SE PUEDE DESACOPLAR MAS
 *
 * Por muchos interfaces intermedios que se tengan, MemAddressBook necesita
 * acceso a una implementación concreta para crear la instancia.
 *
 *  <code>idGenerator = new RandomIdGenerator();</code>
 *
 * Aunque el cambio ahora tendrá menos impactos, necesitamos seguir
 * cambiando el código de MemAddressBook si queremos cambiar su implementación.
 *
 * ¿Hemos ganado mucho usando interfaces?
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class MemAddressBook implements GlobalAddressBook {

    private Map<String, Contact> addressBookMap = new HashMap();

    // Acceso un servicio de generación de ids 
    private IdGenerator idGenerator;

    public MemAddressBook() {
        idGenerator = new RandomIdGenerator();
    }
   
    /**
     * Añade un nuevo contacto devolviendo el id generado.
     *
     * @param contact Datos del contacto a añadir
     * @return Devuelve el id asignado al contacto
     */
    @Override
    public String addContact(Contact contact) {
        String id = idGenerator.newId();
        
        // Como el servicio de generación de ids puede proporcionar
        // ids repetidos, se debe comprobar si el id ya fue asignado.

        // Se podría implementar una lógica de reintentos, pero finalmente
        // decidimos que es mejor informar del error y que sean los
        // clientes los encargados de decidir la politica de reintentos.
        if(addressBookMap.get(id) != null) {
            throw new InvalidIdException();
        }

        contact.setId(id);                
        addressBookMap.put(id, contact);
        return id;
    }

    /**
     * Obtiene el contacto asociado al id entregado.
     *
     * @param contactId id del contacto
     * @return Devuelve el contacto
     */
    @Override
    public Contact getContact(String contactId) {
        Contact result = addressBookMap.get(contactId);
        if(result == null) {
           throw new InvalidIdException();
        } 
        return result;
    }   
}
