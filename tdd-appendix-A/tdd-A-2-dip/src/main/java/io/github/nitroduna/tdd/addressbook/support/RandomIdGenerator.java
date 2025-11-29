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

import io.github.nitroduna.tdd.addressbook.IdGenerator;
import java.util.Random;

/**
 * Implementación de IdGenerator basado en la generación aleatoria de
 * un int.
 *
 * Esta implementación puede generar muchos ids repetidos, pero la semantica
 * o contrato de la interfaz IdGenerator nos permite esto.
 *
 * Ahora podemos tener varias implementaciones del IdGenerator.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class RandomIdGenerator implements IdGenerator {
    private static Random random = new Random();

    @Override
    public String newId() {
        return Integer.toString(random.nextInt());
    }
}
