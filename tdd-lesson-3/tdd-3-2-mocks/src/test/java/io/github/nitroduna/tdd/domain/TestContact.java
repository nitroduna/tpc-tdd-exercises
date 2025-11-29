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
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Tests para la clase Contact.
 *
 * <p>
 * <b>INTERROGANTE:</b><br/>
 * ¿Es necesario crear tests para los getters y setters de un JavaBean o
 *  de métodos tan sencillos como estos?</p>
 *
 * <p>
 * <b>RESPUESTA:</b><br/>
 * Depende de...  "Se volverá a esto en siguientes ejercicios".</p>
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class TestContact {

    @Test
    public void testIdProperty() {
        Contact contact = new Contact();

        contact.setId("Id");

        // INTERROGANTE:
        // ¿Sería correcto probar un setter mediante su getter?
        // ¿Y cuando el JavaBean tiene más de una propiedad?
        // Se volverá a esto en siguientes ejercicios.
        assertEquals("Id", contact.getId());
    }

    @Test
    public void testFirstName() {
        Contact contact = new Contact();
        contact.setFirstName("Pedro");

        assertEquals("Pedro", contact.getFirstName());
    }
}
