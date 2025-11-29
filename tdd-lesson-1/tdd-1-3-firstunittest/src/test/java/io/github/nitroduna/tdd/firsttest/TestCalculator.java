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

package io.github.nitroduna.tdd.firsttest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests para la clase Calculator utilizando JUnit 4.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class TestCalculator {

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();

        int result = calculator.add(50, 20);
        assertEquals(70, result);
    }

    /**
     * La implementación de este test es erronea. Para mostrar un ejemplo más
     * claro de los informes de cobertura de test generados por la herramienta
     * <a href="http://cobertura.sourceforge.net/">cobertura</a> al ejecutar el
     * lifecycle <i>"site"</i> de Maven.
     *
     * Si se corrige el metodo "add" se arreglan ambos tests dando por valída
     * la clase. El problema es  que este test es erroneo ya que esta testeando
     * tambien´el metodo "add". El informe de covertura nos puede ayudar a
     * detectar tests con falsos positivos como este.
     */
    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();

        int result = calculator.add(50, 20);
        assertEquals(70, result);
    }
}
