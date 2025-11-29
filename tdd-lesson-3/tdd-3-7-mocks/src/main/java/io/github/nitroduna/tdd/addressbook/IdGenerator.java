/*
 * Copyright (C) 2010-2011, Pedro Ballesteros <nitroduna@gmail.com>
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

/**
 * Interfaz del generador de identificadores.
 *
 * <p>
 *  Siguiendo el principio <i>IoC</i> las dependencias o servicios se programan
 *  como interfaces. De esta forma las colaboraciones entre objetos se mantienen
 *  desacopladas al no depender de implementaciones reales.
 * </p>
 *
 * <p>
 *  Configurando externamente las dependencias según IoC, se consigue un
 *  desacoplamiento completo, que permite cambiar la implementación incluso
 *  mediante configuración sin cambiar el código.
 * </p>
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public interface IdGenerator {

    /**
     * Devuelve un nuevo identificador único cada vez que se invoca.
     *
     * @return identificador único generado.
     */
    public String newId();
}

