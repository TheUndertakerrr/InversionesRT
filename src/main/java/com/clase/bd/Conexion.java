/**
 * Conexion.java
 * Esta clase establece una conexión a una base de datos MySQL local utilizando JDBC.
 * Proporciona un método estático "conectar" que devuelve un objeto Connection para interactuar
 * con la base de datos.
 * Se utiliza para realizar operaciones de acceso y manipulación de datos en la base de datos de
 * InversionesRT.
 *
 * Este archivo es parte de InversionesRT.
 *
 * InversionesRT es software libre: puedes redistribuirlo y/o modificarlo
 * bajo los términos de la Licencia Pública General GNU publicada por
 * la Free Software Foundation, ya sea la versión 3 de la Licencia, o
 * (a su elección) cualquier versión posterior.
 *
 * InversionesRT se distribuye con la esperanza de que sea útil,
 * pero SIN NINGUNA GARANTÍA; incluso sin la garantía implícita de
 * COMERCIABILIDAD o APTITUD PARA UN PROPÓSITO PARTICULAR. Consulta la
 * Licencia Pública General GNU para más detalles.
 *
 * Deberías haber recibido una copia de la Licencia Pública General GNU
 * junto con [nombre del proyecto]. En caso contrario, consulta
 * <https://www.gnu.org/licenses/gpl-3.0.html>.
 */
package com.clase.bd;

import java.sql.*;

public class Conexion {

    // Conexión Local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3308/inversionesrt",
                    "root", "");
            return cn;

        } catch (SQLException e) {
            System.out.println("Error en la conexión local" + e);
        }
        return (null);
    }
}
