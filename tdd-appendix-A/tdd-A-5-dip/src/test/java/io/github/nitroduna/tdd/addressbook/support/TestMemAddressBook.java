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

import io.github.nitroduna.tdd.addressbook.support.IncrementIdGenerator;
import io.github.nitroduna.tdd.addressbook.support.MemAddressBook;
import io.github.nitroduna.tdd.addressbook.IdGenerator;
import io.github.nitroduna.tdd.addressbook.InvalidIdException;
import io.github.nitroduna.tdd.domain.Contact;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests de GlobalAddressBook
 *
 * En el "testAddContactRepeatedId" ahora vemos que la aplicación de DIP
 * incluso nos facilita el probar partes de la implementación que dependian
 * del comportamiento de las dependencias.
 *
 * Ahora MemAddressBook está mejor preparada para el unit testing, podemos
 * aislar los tests de las dependencias, no los basamos ni en RandomIdGenerator
 * ni en IncrementIdGenerator, solo queremos probar que el código de esta clase
 * es válido sin importarnos el de otras clases.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class TestMemAddressBook {

    MemAddressBook addressBook;

    @Before
    public void setUp() {
        // Por defecto usamos un MemAddressBook basado en
        // IncrementalIdGenerator.
        addressBook = new MemAddressBook(new IncrementIdGenerator());
    }

    /**
     * Necesitamos un test que verifique si el addContact se comporta
     * como lo hemos diseñado al recibir ids repetidos.
     */
    @Test
    public void testAddContactRepeatedId() {
        // Para probar que se comporta bien, configuramos un mock de 
        // idgenerator que produce ids siempre repetidos.
        IdGenerator idGenerator = new IdGenerator() {

            @Override
            public String newId() {
                return "thesame";
            }
        };
        addressBook.setIdGenerator(idGenerator);
        addressBook.addContact(new Contact());
        
        // El siguiente contacto debe lanzar excepción ya que
        // se obtiene un id repetido.
        try {
            addressBook.addContact(new Contact());   
            fail("repeated id not detected");
        }
        catch(InvalidIdException ex) {
            assertTrue(true);
        }
    }



    @Test
    public void testAddContact() {
        // Creación de datos de prueba: "Test Object"
        // Diseño: Decidimos que una clase Contact tendrá los datos de los contactos.
        Contact contact = new Contact();

        // Ejecución del Test
        String contactId = addressBook.addContact(contact);

        // Se verifica el addContact. Por ahora lo unico que se puede es
        // asegurar que no lanza excepciones y que devuelve un id válido.
        assertNotNull(contactId);
        assertTrue(contactId.trim().length() > 0);
    }

    @Test
    public void testGetContact() {
        // Creación de datos de prueba: "Test Object" e inicialización
        // del entorno de tests: Fixtures.
        Contact expected = new Contact();
        String expectedId = addressBook.addContact(expected);

        // Ejecución del test
        Contact actual = addressBook.getContact(expectedId);

        // Verificación
        // ¿Como probamos que el contacto recibido es el mismo que se ha añadido?
        assertEquals(expectedId, actual.getId());
    }

    @Test(expected = InvalidIdException.class)
    public void testGetContactInvalidId() {
        addressBook.getContact("INVALID");
    }
}
