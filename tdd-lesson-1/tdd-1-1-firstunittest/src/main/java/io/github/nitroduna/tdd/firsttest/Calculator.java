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

/**
 * Implementación de una calculadora con operaciones sencillas.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class Calculator {

    /**
     * Suma de dos números.<br/>
     *
     * <p>
     * La implementación es erronea para observar los fallos de los tests.</p>
     *
     * @param number1
     * @param number2
     * @return
     */
    public int add(int number1, int number2) {
        return number1 - number2;        
    }

    /**
     * Resta de dos números.<br/>
     *
     * <p>
     * La implementación es erronea para observar los fallos de los tests.</p>
     *
     * @param number1
     * @param number2
     * @return
     */
    public int subtract(int number1, int number2) {
        return number1 + number2;
    }
}
