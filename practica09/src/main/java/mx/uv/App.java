package mx.uv;

/**
 * Hello world!
 *
 */

import static spark.Spark.*;
import com.google.gson.*;

public class App 
{
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


        get("/", 
            (request, response) ->"<h1>Hola Mundo!</h1>"
            );

        post("/", (request,response) -> "soy el post");

        get("/ruta1", 
            (request, response) -> {
                String parametro = request.queryParams("apellido");
                System.out.println(parametro);
                System.out.println("Esto es el ruta1" + request.contentType());
                return "<h1>Adios Mundo"+ parametro + "!</h1>";
            }
        );

        post ("/ruta1", 
            (request, response) -> {
                String parametro = request.queryParams("apellido");
                System.out.println(parametro);
                System.out.println("Esto es el request" + request.contentType());
                return "<h1>Adios "+ parametro + "!</h1>";
            }
        );

        get("/ruta2", 
            (request, response) -> {
                String parametro = request.queryParams("nombre");
                System.out.println("Tipo de contenido"+request.contentType());
                
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("msj", "hola");
                respuesta.addProperty("apellido", parametro);
                response.type("application/json");

                return respuesta;
            }
        );

        post("/ruta2", 
            (request, response) -> {
                //String parametro = request.queryParams("nombre");
                String parametro = request.body();
                System.out.println("Tipo de contenido"+request.contentType());
                System.out.println("EL body tiene"+parametro);
                
                //este objeto sirve para acceder a los elementos de la peticion en json
                JsonParser parser = new JsonParser();
                JsonElement arbol = parser.parse(parametro);
                
                //este objeto sirve para cpnstruir la respuesta en json
                JsonObject respuesta = new JsonObject();
                respuesta.addProperty("msj", "hola");
                respuesta.addProperty("apellido", arbol.getAsJsonObject().get("nombre").getAsString());
                response.type("application/json");

                return respuesta;
            }
        );

        get("/ruta3", 
             (request, response) -> {
                System.out.println("Esto es el request" + request.contentType());
                response.type("application/json");
                return "{\"Alumno\":\"John\",\"Matricula\":\"20001\",\"Carrera\"':\"TC\"}";
            }
        );
    }
}
