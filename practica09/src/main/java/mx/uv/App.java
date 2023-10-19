package mx.uv;

/**
 * Hello world!
 *
 */

import static spark.Spark.*;

public class App 
{
    public static void main( String[] args )
    {
        get("/", 
            (request, response) ->"<h1>Hola Mundo!</h1>"
            );
        get("/ruta1", 
            (request, response) ->"<h1>Adios Mundo!</h1>"
            );
        get("/ruta2", 
            (request, response) ->"<h1>Que tal Mundo!</h1>"
            );
        get("/ruta3", 
            (request, response) ->"{'alumno':'john','matricula':'s12334','carrera':'tc'}"
            );
    }
}
