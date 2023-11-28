package mx.uv;

/**
 * Hello world!
 *
 */

import static spark.Spark.*;
import com.google.gson.*;

public class App 
{   
    public static String nombre = " ";
    public static String apellido = " ";

    public static void main( String[] args )
    {
         //fuente:https://gist.github.com/saeidzebardast/e375b7d17be3e0f4dddf

options("/*",(request,response)->{

String accessControlRequestHeaders=request.headers("Access-Control-Request-Headers");

if(accessControlRequestHeaders!=null){

response.header("Access-Control-Allow-Headers",accessControlRequestHeaders);

}

String accessControlRequestMethod=request.headers("Access-Control-Request-Method");

if(accessControlRequestMethod!=null){

response.header("Access-Control-Allow-Methods",accessControlRequestMethod);

}

return "OK";

});
before((request,response)->response.header("Access-Control-Allow-Origin","*"));

        get("/insertar", 
            (request, response) -> {
                System.out.println("Nombre: " + request.queryParams("nombre"));
                nombre = request.queryParams("nombre");
                System.out.println("Apellido: " + request.queryParams("apellido"));
                apellido = request.queryParams("apellido");
                System.out.println("Insertados");
                System.out.println("Hola "+nombre+" "+apellido);
                return "Datos Insertados";
            }
        );

        get("/modificar", 
            (request, response) -> {
                System.out.println("Nombre Anterior: " + nombre);
                System.out.println("Apellido Anterior: " + apellido);
                System.out.println("Nombre Nuevo: " + request.queryParams("nombre"));
                nombre = request.queryParams("nombre");
                System.out.println("Apellido Nuevo: " + request.queryParams("apellido"));
                apellido = request.queryParams("apellido");
                System.out.println("Modificados");
                return "Datos modificados";
            }
        );

        get("/consultar", (request, response) -> {
            if (!nombre.isEmpty() && !apellido.isEmpty()) {
                System.out.println("Consulta:");
                System.out.println("Nombre: "+nombre);
                System.out.println("Apellido: "+apellido);
                return "Nombre: " + nombre + ", Apellido: " + apellido;
            } else {
                System.out.println("Consulta:");
                System.out.println("Nombre: "+nombre);
                System.out.println("Apellido: "+apellido);
                return "No hay datos almacenados";
            }
        });

        get("/eliminar", (request, response) -> {
            nombre = "";
            apellido = "";
            System.out.println("Nombre: "+nombre);
            System.out.println("Apellido: "+apellido);
            System.out.println("Eliminados");
            return "Datos eliminados correctamente.";
        });

        
    }
}
