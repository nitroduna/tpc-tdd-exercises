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

package io.github.nitroduna.tdd.data.template;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Interfaz de callback usado en {@link JdbcDaoTemplate} para permitir
 * a los clientes puedan implementar el procesado completo de la sentencia.
 *
 * <p>Se deben entregar implementaciones de esta interfaz al utilizar los
 * los métodos de {@link JdbcDaoTemplate}.</p>
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public interface PreparedCallback {

    /**
     * Callback que se ejecuta cuando la sentencia ya está preparada, lo que
     * permite ejecutarla y devolver el resultado final.
     *
     * @param statement
     * @return
     * @throws SQLException
     */
    public Object process(PreparedStatement statement) throws SQLException;
}
