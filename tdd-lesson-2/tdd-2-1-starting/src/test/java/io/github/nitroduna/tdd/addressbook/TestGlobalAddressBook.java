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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Implementación del primer test siguiendo los siguientes pasos.
 * <p/>
 *
 * <pre>
 * 1. Se selecciona el User Story <i>Añadir Contactos</i>.
 * 2. Se selecciona algún test de aceptación de dicho User Story.
 * 3. Se idean tests unitarios de nivel más granular, a partir de un
 *    diseño preliminar:
 *
 *    El servicio se implementará en la clase GlobalAddressBook. Deberá
 *    disponer de un método <i>addContact</i> y un método <i>getAll</i> que
 *    permita verificar que los contactos se añaden correctamente.
 *
 * 4. Primer test:
 *    GlobalAddressBook permite añadir un Contacto (Contact), y se verifica
 *    que se añade correctamente implementando y usando <i>getAll</i>.
 *
 * 5. Segundo test:
 *    Implementando <i>addContact</i> se deduce que será útil devolver un "id",
 *    que será utilizado en el método <i>getContact</i>. GlobalAddressBook debe
 *    devolver un id que permita recuperar un contacto usando dicho id.
 *
 *    Se han localizado detalles de implementación. Los test de aceptación no
 *    deben mencionar nada de ids, ya que usan el vocabulario del negocio.
 *    A nivel de implementación se localizan nuevas necesidades y por tanto
 *    aparecen nuevos test unitarios al margen de los test de aceptación.
 * </pre>
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class TestGlobalAddressBook {

    /**
     * TODO: Implementar el primer test.
     * <p/>
     *
     * Implementamos un small scaled test para un método de añadir contactos
     * (addContact) de nuestro servicio (GlobalAddressBook).
     */
    @Test
    public void testAddContact() {
        fail("TODO: addContact Test");
    }
}

