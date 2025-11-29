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

import io.github.nitroduna.tdd.addressbook.IdGenerator;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Clase base con tests que ejecutan las pruebas comunes de cualquier
 * implementación de IdGenerator.
 *
 * <p>
 * Como es una clase abstracta no se lanzará ninguno de sus tests, pero
 * las clases derivadas heredarán estos tests y se lanzarán todos para 
 * cada una.</p>
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public abstract class TestIdGenerator {

    /**
     * Se debe sobreescribir para obtener la implementación de IdGenerator
     * que se quiere testear.
     *
     * @return Implementación de IdGenerator
     */
    protected abstract IdGenerator newIdGenerator();

    @Test
    public void testNewId() {
        IdGenerator idGenerator = newIdGenerator();

        String oldId = idGenerator.newId();
        // Se prueba que siempre se genera un id nuevo
        // ¿cuantas veces se prueba?
        for(int i=0; i < 10; i++) {
            String newId = idGenerator.newId();
            assertFalse(oldId.equals(newId));
            oldId = newId;
        }
    }

    @Test
    public void testNewIdDifferentInstances() {
        // La API IdGenerator especifica que todas las instancias
        // deben devolver ids diferentes.
        String oldId = newIdGenerator().newId();

        // Se prueba que siempre se genera un id nuevo
        // ¿cuantas veces se prueba?
        for(int i=0; i < 10; i++) {
            String newId = newIdGenerator().newId();
            assertFalse(oldId.equals(newId));
            oldId = newId;
        }
    }
}
