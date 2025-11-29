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

package io.github.nitroduna.tdd.domain;

import io.github.nitroduna.tdd.domain.Contact;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests para la clase Contact.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class TestContact {

    @Test
    public void testAllProperties() {
        // Inicialización del test object
        Contact contact = new Contact();
        contact.setId("id");
        contact.setFirstName("firstName");
        contact.setSurname("surname");
        contact.setPhone("phone");
        Date expectedDate = new Date();
        contact.setBirthday(expectedDate);

        // Aunque no conviente tener mas de un assert en cada test, en este
        // caso es necesario. No tenemos acceso a los atributos, por ser private,
        // y no queremos romper la encapsulación que proporciona OOP

        // Se establecen todas las propiedades en la misma instancia y se prueban
        // que tienen el valor correcto usando los getters.
        assertEquals("id", contact.getId());
        assertEquals("firstName", contact.getFirstName());
        assertEquals("surname", contact.getSurname());
        assertEquals("phone", contact.getPhone());
        assertEquals(expectedDate, contact.getBirthday());
    }
}
