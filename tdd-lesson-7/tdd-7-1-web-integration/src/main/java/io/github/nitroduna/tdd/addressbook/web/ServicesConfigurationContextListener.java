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

package io.github.nitroduna.tdd.addressbook.web;

import io.github.nitroduna.tdd.addressbook.support.MemAddressBook;
import io.github.nitroduna.tdd.addressbook.support.UUIDIdGenerator;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Lamentablemente en los objetos del contenedor no podemos usar
 * Direct Injection para configurar las depencias de los controladores
 * ya que al ser servlets las instanciará el contenedor.
 *
 * Se pierde el control de la instanciación de los controladores, por tanto
 * tienen que buscar sus dependencias. No se puede configurar desde el cliente.
 *
 * Se pierde parte de IoC, pero se usa un sistema para que los controladores
 * sigan siendo independientes de la implementación.
 *
 * Los controladores no sabrán ni que existe MemAddressBook, solo conocen
 * la interfaz del serivio GlobalAddressBook.
 *
 * La configuración e instanciación de dependencias se realiza en
 * un listener del contexto.
 *
 * FUTURA REFACTORIZACION:
 *    Implementar una arquitectura MVC de Controlador Frontal de forma
 *    que los controladores no tengan que ser servlets.
 *
 * @author Pedro Ballesteros (nitroduna@gmail.com)
 */
public class ServicesConfigurationContextListener implements ServletContextListener {

    // El inicio de la aplicación crea todos los servicios en forma de
    // singletons (no confundir con patron singleton), para que los controladores
    // puedan buscarlos por nombre.
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // Se utilizará la implementación en memoria del GlobalAddressBook
        // que a su vez usa la implementación UUID del generador de ids.
        MemAddressBook addressBook = new MemAddressBook();   
        addressBook.setIdGenerator(new UUIDIdGenerator());
        // Esto es una configuración por código. Se podría idear un sistema
        // que permitira la configuración fuera del código.

        // Se registran los servicios en el servletContext para que los
        // controladores puedan buscar una implementación de AddressBook
        // sin tener que depender de una implementación específica.
        sce.getServletContext().setAttribute("globalAddressBook", addressBook);

        // PREGUNTA:
        //   ¿Los tests debería verificar que el GlobalAddressBook es en realidad
        //    una instancia de MemAddressBook?

        //   Si verifica estamos realizando un test de caja blanca y atando
        //   el funcionamiento del tests a un detalle de configuración y despliegue.

        //   En este caso la configuración se hace por código en el listener,
        //   pero se podría intentar extraer. Actualmente sería un test
        //   de caja blanca, que tampoco es muy problematico usando TDD ya que
        //   si se cambia la implementación se cambia el test y ya está.

        //   Como en este caso la configuración se hace por código (en el
        //   listener), se podrían estar enmascarando errores al haber
        //   implementado un test de caja negra.

        // EJEMPLO:
           // sce.getServletContext().setAttribute("globalAddressBook", new MemAddressBook());

        //   No obstante son errores que se localizarán facilmente en un
        //   test de integración o de sistema.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {        
    }
}
