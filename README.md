# LABORATORIO 5 - MVC PRIMEFACES INTRODUCTION
# INTEGRANTES
- Jessica Muñoz
- Ricardo Pulido
# RESPUESTAS
## PARTE I. JUGANDO A SER UN CLIENTE HTTP.
1. Se abre la terminal de Linux.
2. Se hace una conexión síncrona a través de Telnet al servidor *www.escuelaing.edu.co* en el puerto *80* con el comando `telnet www.escuelaing.edu.co 80`
3. Ahora se realiza un petición *GET* sobre el servidor para solicitar el recurso *sssss/abc.html* usando la versión 1.0 de HTTP. 
Con el comando `GET /sssss/abc.html HTTP/1.0` se observa lo siguiente:

![get_escuela](https://user-images.githubusercontent.com/123814482/225965842-41a41532-8c13-4791-84fc-e97dcbc81bfa.jpg)

El código de error que se muestra es un 400 *Bad Request*, que corresponde a un mensaje del servicio HTTP de error provocado por el cliente.
Los otros códigos de error que existen son los siguientes:

![codigos_error](https://user-images.githubusercontent.com/123814482/225967062-a4f06a59-ee24-41a6-9941-fa7707101aac.jpg)

4. Ahora se realizará una nueva conexión a través de Telnet con el servidor *www.httpbin.org* en el puerto *80* con el comando `telnet www.httpbin.org 80`.
La petición que se realiza es sobre el recurso */html* con la versión 1.1 de HTTP.
Con el comando `GET /html HTTP/1.1` se observa lo siguiente:

![get_bin](https://user-images.githubusercontent.com/123814482/225967885-d324529e-3148-4d72-9a16-84effe5ff7ad.jpg)

Sin embargo, como nuevamente sale un error de usuario se decidió probar con la versión 1.0 para poder realizar los ejercicios siguientes con los elementos del GET.

![get_bin_10](https://user-images.githubusercontent.com/123814482/225968196-00d7057b-ee12-41bd-ad14-0848d89213a2.jpg)

5. Se ejecuta el comando `wc -c` para contar el número de caracteres obtenidos del HTML.

![contar_caracteres](https://user-images.githubusercontent.com/123814482/225969230-9b2d1a20-1e91-42e7-afd7-95b082566817.jpg)

Los métodos de peticiones HTTP son:

**GET** solicita el recurso especificado.

**HEAD** solicita sólo el encabezado del recurso especificado.

**POST** envía datos a un recurso específico.

**PUT** reemplaza las representaciones de un recurso.

**DELETE** borra un recurso especificado.

**CONNECT** establece una conexión hacia el servidor del recurso especificado.

**OPTIONS** enuncia las opciones de comunicación para el recurso.

**TRACE** hace pruebas de retorno de mensaje de la ruta del recurso.

**PATCH** para hacer modificaciones parciales sobre un recurso.

6. Ahora se realiza la petición mediante el comando `curl` al servidor *www.httpbin.org*

![curl](https://user-images.githubusercontent.com/123814482/225972065-271d5d5f-c5dc-48b1-a16d-798414920355.jpg)

Con el parámetro -v se observa lo siguiente:

![curl_v](https://user-images.githubusercontent.com/123814482/225972225-59aa7973-2075-4eb8-83f8-cec7e8d754b9.jpg)

Con el parámetro -i se observa:

![curl_i](https://user-images.githubusercontent.com/123814482/225972352-2669cc7d-9f4b-4e03-82d3-316259df21b4.jpg)

El parámetro -i permite incluir los encabezados junto al cuerpo en la respuesta del recurso solicitado,
mientras que el parámetro -v muestra toda la información detallada.

## PARTE II. HACIENDO UNA APLICACIÓN WEB DINÁMICA A BAJO NIVEL.
1. Se crea un proyecto maven nuevo con el arqueotipo web, con el comando `mvn arcgetype:generate -Dfilter=maven-archetype-webapp`. A continuación se pueden
ver los valores con los que se creó y la validación de que fue construido satisfactoriamente.

!proyecto_maven](https://user-images.githubusercontent.com/123814482/226031455-3a68816e-b0e2-4a01-9610-7d8aecc99aa4.jpg)

Luego se crea la clase *SampleServlet* con el código dado. Esta clase es la que ayuda a responder las solicitudes HTTP de las URL que atiende `/helloServlet`. 
En este caso genera una respuesta de saludo y puede incluir el nombre indicado como parámetro dentro de la URL.

2. Dentro del pom.xml se modifica la propiedad *packaging* con el valor de *war*, se agrega la dependencia *javax* y se agrega la sección build.

3. El puerto TCP/IP para el que se configuró el servidor de tomcat es el 8080.

4. Ahora se compila y ejecuta la aplicación en el servidor de tomcat. Para este se ejecuta el comando `mvn package`

![package](https://user-images.githubusercontent.com/123814482/226037323-227608b9-a2b4-4548-acf5-cbf9521b5a79.jpg)

Luego se ejecuta el comando `mvn tomcat7:run`

![tomcat](https://user-images.githubusercontent.com/123814482/226037601-de35c0f7-7bf8-48e8-adb3-c45e2446a061.jpg)

5. Desde el navegador se escribe la siguiente URL *localhost/8080/helloServlet* que permite enviar las peticiones al *SampleServlet*.

![sample_servlet](https://user-images.githubusercontent.com/123814482/226038512-72ede153-9c6d-4f9e-9762-87067a5609f2.jpg)

6. Nuevamente se coloca la misma URL pero agregando un parámetro *GET*, en este caso se usa el parámetro *name*. 
Para esto se escribe `localhost:8080/helloServlet?name=%20Jessica`.

![sample_jessica](https://user-images.githubusercontent.com/123814482/226043836-b1f183a3-f2cf-4cf9-a3a5-6d59c67ac292.jpg)

7. Se agrega la dependencia del artefacto *gson*.

8. Ahora, en el navegador se revisa la dirección *https://jsonplaceholder.typicode.com/todos/1* y se reemplaza el último elemento del path por varios números.

![prueba200](https://user-images.githubusercontent.com/123814482/226045728-bb5db014-2460-413d-b824-0cb7fa67aecd.jpg)

Lo que pudimos observar es que el userId va variando según el id que se haya colocado en la URL, al igual que va cambiando el título y el booleano

9. Teniendo en cuenta los parámetros vistos de userId, Id, título y completado se realiza la clase *Todo* en el paquete *model* con los métodos *getter* y *setter*
para cada atributo.

```
package edu.eci.cvds.servlet.model;

public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int new_user_id) {
        this.userId = new_user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int new_id) {
        this.id = new_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String new_title) {
        this.title = new_title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean new_completed) {
        this.completed = new_completed;
    }
}
```

10. Además se crea la clase *Service* con el código dado para poder consumir el servicio de la url *https://jsonplaceholder.typicode.com/todos/<Id>*

11. Se crea una clase similar a *SampleServlet* llamada *OtherServlet* y se sobreescribe el método *doGet* en donde se genera el *Todo* para cada *Id* ingresado en forma de tabla. Además se indica la URL de la cuál se tomarán las peticiones `/otherServlet` y se hace el tratamiento de errores si no se encuentra un item dado,
o si el parámetro falta o está mal, entre otros.

```
package edu.eci.cvds.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(urlPatterns = "/otherServlet")

public class OtherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String print_response = "";
        Writer responseWriter = resp.getWriter();

        try {
            Optional<String> optNumber = Optional.ofNullable(req.getParameter("id"));
            Todo todo = Service.getTodo(Integer.valueOf(optNumber.get()));
            resp.setStatus(HttpServletResponse.SC_OK);

            ArrayList<Todo> todosList = new ArrayList<>();
            todosList.add(todo);
            print_response = Service.todosToHTMLTable(todosList);

        } catch (FileNotFoundException notFound) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            print_response = "No existe un item con el identificador dado";

        } catch (NumberFormatException format) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            print_response = "Requerimiento inválido";

        } catch (MalformedInputException malformed) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            print_response = "Error interno en el servidor";

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            print_response = "Requerimiento inválido";
        }

        responseWriter.write(print_response);
    }
}
```

12. Nuevamente se hace `mvn packge` y `mvn tomcat7:run`

![compilar](https://user-images.githubusercontent.com/123814482/226056798-6a90e6a1-4166-4fcb-b571-d075404ec410.jpg)

![ejecutar](https://user-images.githubusercontent.com/123814482/226056819-be39a611-7a52-4164-95f9-e67ef4f007ac.jpg)

13. La primera prueba que se hará es ingresando un *id* válido.

![id_valido](https://user-images.githubusercontent.com/123814482/226057156-1f4ff4bc-1ea2-400b-8c6c-c0150fb80128.jpg)

Si se ingresa un *id* inválido se observa lo siguiente:

![id_invalido](https://user-images.githubusercontent.com/123814482/226057238-94bff645-b552-44f6-9062-546c4219b7cd.jpg)

Si no se coloca el *id*

![sin_id](https://user-images.githubusercontent.com/123814482/226057302-fa1b328f-21aa-41c9-a2ae-0e6ba72854c5.jpg)

Con un valor incorrecto en el *id*

![incorrecto](https://user-images.githubusercontent.com/123814482/226057366-ef76e47c-f1aa-4f74-b2fa-ad0079b83e15.jpg)

Con un parámetro que no está definido

![no_definido](https://user-images.githubusercontent.com/123814482/226057447-1beab9e6-d700-4afe-b382-7e94fbfe6661.jpg)

## PARTE III.



