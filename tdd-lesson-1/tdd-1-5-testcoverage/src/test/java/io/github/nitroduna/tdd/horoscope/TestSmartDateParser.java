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

package io.github.nitroduna.tdd.horoscope;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Test para la clase encargada de parsear un texto en varios
 * formatos diferentes.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class TestSmartDateParser {

    private SmartDateParser dateParser = new SmartDateParser();
    private Calendar calendar = Calendar.getInstance(new Locale("es"));

    @Before
    public void setUp() {
        calendar.clear();
    }

    @Test
    public void testParseShortFormat() {
        String dateTest = "2/4/2010";

        calendar.set(2010, 4 - 1, 2);
        Date expected = calendar.getTime();

        assertEquals(expected, dateParser.parse(dateTest));
    }

    @Test
    public void testParseFormatWithZeros() {
        String dateTest = "02/04/2010";

        calendar.set(2010, 4 - 1, 2);
        Date expected = calendar.getTime();

        assertEquals(expected, dateParser.parse(dateTest));
    }

    @Test
    public void testParseLongFormat() {
        String dateTest = "2 de abril de 2010";

        calendar.set(2010, 4 - 1, 2);
        Date expected = calendar.getTime();

        assertEquals(expected, dateParser.parse(dateTest));
    }

    @Test
    public void testParseMonthDayFormat() {
        String day = "10";

        calendar.setTime(new Date());
        calendar.clear(Calendar.HOUR);
        calendar.clear(Calendar.MINUTE);
        calendar.clear(Calendar.SECOND);
        calendar.clear(Calendar.MILLISECOND);

        calendar.set(Calendar.DATE, 10);
        Date expected = calendar.getTime();

        assertEquals(expected, dateParser.parse(day));
    }

    @Test(expected = DateParserException.class)
    public void testParseInvalidDate() {
        dateParser.parse("invaliddate");
    }
}
