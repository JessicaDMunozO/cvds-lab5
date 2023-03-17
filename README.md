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

![proyecto_maven](https://user-images.githubusercontent.com/123814482/226031455-3a68816e-b0e2-4a01-9610-7d8aecc99aa4.jpg)

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
14. Se realiza la misma implementación anterior para el método *doPost*
```
    ...
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
```

15. Se crea el archivo *index.html* en el directorio *src/main/webapp/* y se crea un formulario para ingresar el número y que sea validado, se usa un botón.

```
    <!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
		<h1>
			Hello World!
		</h1>
        <script>
			function validateNumber() {
				let x = document.forms["form"]["id"].value;
				if (isNaN(x)){
					alert("It must be an integer");
					return true;
				}
			}
		</script>
		<form name="form" action="otherServlet" onsubmit="return validateNumber()" method="POST">
			<label for="id">id:</label><br>
			<input type="text" id="id" name="id"><br>
			<input type="submit" value="Submit">
		</form>
    </body>
</html>
```

16. Se recompila y se ejecuta. En el browser se escribe *localhost:8080*
    
![POST](https://user-images.githubusercontent.com/123814482/226058825-7c52afeb-6fec-4890-9176-45debb00486a.jpg)
    
Se observa lo siguiente al dar en el botón. 
    
![resultado](https://user-images.githubusercontent.com/123814482/226058956-5e657afa-a758-4ede-aca9-e83d5a29ef3e.jpg)
    
17. Ahora se cambia el método a *GET* en el archivo *index.html* se recompila y se ejecuta.
    
![GET](https://user-images.githubusercontent.com/123814482/226059256-3a86149f-1801-4761-b295-bf9e62fab2d5.jpg)

Se observa lo siguiente al dar en el botón.
    
![resultado2](https://user-images.githubusercontent.com/123814482/226059311-e3405600-ff7a-4e30-a6c0-45ae29d81759.jpg)

Lo que cambia entre un método y otro es que cuando trae el mensaje del id indicado, la URL con *POST* es *localhost:8080/otherServlet* mientras que con *GET* le agrega el parámetro del id *localhost:8080/otherServlet?id=14*
  
18. En la clase Service.java se observa el método *getTodo* que permite traer todos los elementos del *Todo* asociados a un id, el método *todoToHTMLRow* permite mostrar los elementos del *Todo* en fila y el método *todosToHTMLTable* construye una tabla con los atributos del *Todo*.

## PARTE IV. FRAMEWORKS WEB MVC - JAVA SERVER FACES / PRIMEFACES    
1. Se agregan las dependencias de *javax.javaee-api, com.sun.faces.jsf-api, com.sun.faces.jsf-impl, javax.servlet.jstl, Primefaces* en el archivo *pom.xml*
2. En el archivo *web.xml* se agregó la siguiente configuración:

```
<servlet>
	<servlet-name>Faces Servlet</servlet-name>
	<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
	<load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
	<servlet-name>Faces Servlet</servlet-name>
	<url-pattern>/faces/*</url-pattern>
</servlet-mapping>
<welcome-file-list>
	<welcome-file>faces/index.jsp</welcome-file>
</welcome-file-list>
```

3. En la etiqueta <servlet> se añade la información básica del mismo, como su nombre, la clase, que en este caso es de Java Faces y tenemos el indicador de cargar
el servlet o no al momento de despliegue. Esta es obligatoria.
Con la etiqueta de <servlet-mapping> fuera de relacionarse al nombre del servlet, se le asigna el patrón de URL que se utilizará para acceder a los recursos que
se creen para nuestro servlet. Actuando como parte de la ruta, dando un directorio raíz para acceder a los servicios ofrecidos.
Por último, la etiqueta <welcome-file-list> nos permite especificar el archivo que queremos que se abra al momento de conectarse al servlet. En nuestro caso, al
momento de acceder con http://localhost:8080/ sin especificar una ruta nos mostrará el archivo index.jsp en el directorio faces. Esta es opcional, pues podemos
especificar esta página de inicio, sino se asigna tomará el primer archivo que encuentre dentro del directorio dado en <servlet-mapping>

4. Ahora se crea la clase *bean* con la lógica del juego. 

```
package edu.eci.cvds.bean;

//import javax.annotation.ManagedBean;
//import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean")

@SessionScoped

public class bean {
    private int numeroAdivinar = (int) (Math.random() * (10 + 1));
    private int intentos = 0;
    private int premioAcumulado = 100000;
    private String estado = "Jugando";
    private int penalizacionFalla = 10000;

    public bean() {
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(int premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPenalizacionFalla() {
        return penalizacionFalla;
    }

    public void setPenalizacionFalla(int penalizacionFalla) {
        this.penalizacionFalla = penalizacionFalla;
    }

    public void guess(int numero) {
        intentos += 1;
        if (numero == numeroAdivinar) {
            setEstado("Ganó");
            System.out.println(getEstado() + " $" + getPremioAcumulado());
        } else {
            if (premioAcumulado > penalizacionFalla) {
                premioAcumulado -= penalizacionFalla;
            } else {
                setEstado("Perdió");
                System.out.println(getEstado() + " $0");
            }
        }
    }

    public void restart() {
        setNumeroAdivinar((int) (Math.random() * (10 + 1)));
        setPremioAcumulado(100000);
        setEstado("Jugando");
        setIntentos(0);
    }

}
```

5. Se crea un archivo *guess.xhtml* y se agrega un formulario que permita tener el número que se vaya a adivinar (oculto), reciba el número del usuario, los intentos realizados, el estado del juego y el premio usando los elementos de la clase *bean*. Además se agregan botones para enviar el número y para reiniciar el juego.

```
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"    
	xmlns:h="http://java.sun.com/jsf/html"    
	xmlns:f="http://java.sun.com/jsf/core"    
	xmlns:p="http://primefaces.org/ui">

	<h:head>
	</h:head>
	<body>
	<h:body>
		<h1>Adivina el número!</h1>
		<h:form id="guess_form">
			<h:panelGrid>
				<h:outputLabel value="Adivinar: #{bean.getNumeroAdivinar()}" style="display: none;"/>
				<h:inputText id="numero" binding="#{input}"/>
				<h:outputLabel value="Intentos: #{bean.getIntentos()}"/>
				<h:outputLabel value="Estado: #{bean.getEstado()}"/>
				<h:outputLabel value="Premio Acumualdo: #{bean.getPremioAcumulado()}"/>
				
				<h:commandButton update="guess_form" actionListener="#{bean.guess(input.value)}" value="Enviar número"/>
				<h:commandButton update="guess_form" actionListener="#{bean.restart()}" value="Reiniciar juego"/>
			</h:panelGrid>
		</h:form>
	</h:body>
	</body>
</html>
```

6. Nuevamente se compila y se ejecuta con la URL *http://localhost:8080/faces/guess.xhtml*

![juego](https://user-images.githubusercontent.com/123814482/226062321-86b92787-9242-4693-b1a8-761ae05e74cc.jpg)

7. Pruebas
Primera jugada

![primera_jugada](https://user-images.githubusercontent.com/123814482/226062530-79ee4a98-c2ac-4191-8b27-05f4c2b83140.jpg)

Cuando gana

![gano](https://user-images.githubusercontent.com/123814482/226062612-037cc8a5-5f3b-493f-92a5-7e6e278cc8fe.jpg)

Luego de usar el botón de reiniciar

![reiniciar](https://user-images.githubusercontent.com/123814482/226062674-ed8beb57-4a29-4fcb-8f70-06df9d694d44.jpg)

- 5 intentos en el navegador

![5intentos](https://user-images.githubusercontent.com/123814482/226063029-22b720f9-0b76-4a6c-b6d4-dfb264eddd1b.jpg)

1 intento en modo incógnito

![incognito](https://user-images.githubusercontent.com/123814482/226063064-e819e57d-42c5-4738-990f-3f3743f86c99.jpg)

Se puede observar que en el modo incógnito retoma los valores que se obtuvieron en una pestaña del navegador normal. Sin embargo si se cambia la anotación *@ApplicationScoped* por *@SessionScoped* al realizar la misma prueba anterior se puede ver que los toma como dos ingresos diferentes idenpendiente de que sean sobre la misma aplicación.

- En el navegador 

![navegador](https://user-images.githubusercontent.com/123814482/226063384-946d57c8-1b42-403a-bd84-281734f6a778.jpg)

En incógnito

![incógnito2](https://user-images.githubusercontent.com/123814482/226063452-16d50d61-2d94-4b2f-90e3-e2588f85032d.jpg)

En el browser por medio de la tecla `F12` se busca el elemento oculto en la sección de estilos y se observa cómo cambia la página pues ahora muestra el número a adivinar.

![oculto](https://user-images.githubusercontent.com/123814482/226063831-eead38c4-c889-4723-b638-3cc1d302be76.jpg)

Se pueden cambiar los colores, conocer valores de las variables y ver la distribución de la página, entre otros.

8. Por último se realiza una lista con los intentos fallidos del usuario y se limpia cada vez que se haga un reinicio.

```
package edu.eci.cvds.bean;

import java.util.ArrayList;

//import javax.annotation.ManagedBean;
//import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bean")

@SessionScoped

public class bean {
    private int numeroAdivinar = (int) (Math.random() * (10 + 1));
    private int intentos = 0;
    private int premioAcumulado = 100000;
    private String estado = "Jugando";
    private int penalizacionFalla = 10000;
    private ArrayList<Integer> listaIntentos = new ArrayList<>();

    public bean() {
    }

    public int getNumeroAdivinar() {
        return numeroAdivinar;
    }

    public void setNumeroAdivinar(int numeroAdivinar) {
        this.numeroAdivinar = numeroAdivinar;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getPremioAcumulado() {
        return premioAcumulado;
    }

    public void setPremioAcumulado(int premioAcumulado) {
        this.premioAcumulado = premioAcumulado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPenalizacionFalla() {
        return penalizacionFalla;
    }

    public void setPenalizacionFalla(int penalizacionFalla) {
        this.penalizacionFalla = penalizacionFalla;
    }

    public ArrayList<Integer> getListaIntentos() {
        return listaIntentos;
    }

    public void setListaIntentos(ArrayList<Integer> listaIntentos) {
        this.listaIntentos = listaIntentos;
    }

    public void guess(int numero) {
        listaIntentos.add(numero);
        intentos += 1;
        if (numero == numeroAdivinar) {
            setEstado("Ganó");
            System.out.println(getEstado() + " $" + getPremioAcumulado());
        } else {
            if (premioAcumulado > penalizacionFalla) {
                premioAcumulado -= penalizacionFalla;
            } else {
                setEstado("Perdió");
                System.out.println(getEstado() + " $0");
            }
        }
    }

    public void restart() {
        setNumeroAdivinar((int) (Math.random() * (10 + 1)));
        setPremioAcumulado(100000);
        setEstado("Jugando");
        setIntentos(0);
        listaIntentos.clear();
    }

}
```

Además se agrega al archivo *.xhtml* en forma de tabla.

```
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"    
	xmlns:h="http://java.sun.com/jsf/html"    
	xmlns:f="http://java.sun.com/jsf/core"    
	xmlns:p="http://primefaces.org/ui">

	<h:head>
	</h:head>
	<body>
	<h:body>
		<h1>Adivina el número!</h1>
		<h:form id="guess_form">
			<h:panelGrid>
				<h:outputLabel value="Adivinar: #{bean.getNumeroAdivinar()}" style="display: none;"/>
				<h:inputText id="numero" binding="#{input}"/>
				<h:outputLabel value="Intentos: #{bean.getIntentos()}"/>
				
				<h:dataTable value="#{bean.getListaIntentos()}" var ="intentos">
					<h:column>
						<f:facet name="header"> Intentos Realizados </f:facet>
						#{intentos}
					</h:column>
				</h:dataTable>
					
				<h:outputLabel value="Estado: #{bean.getEstado()}"/>
				<h:outputLabel value="Premio Acumualdo: #{bean.getPremioAcumulado()}"/>
				
				<h:commandButton update="guess_form" actionListener="#{bean.guess(input.value)}" value="Enviar número"/>
				<h:commandButton update="guess_form" actionListener="#{bean.restart()}" value="Reiniciar juego"/>
			</h:panelGrid>
		</h:form>
	</h:body>
	</body>
</html>
```

Ahora la página se ve del siguiente modo después de realizar algunos intentos:

![con_lista](https://user-images.githubusercontent.com/123814482/226064860-33bc3096-7ed3-4079-99f0-b46e48c9acb2.jpg)

## BIBLIOGRAFÍA
MVNRepository. (9 de abril del 2019). *JavaEE Web API » 8.0.1*. Recuperado de: <https://mvnrepository.com/artifact/javax/javaee-web-api/8.0.1>

MVNRepository. (6 de enero del 2023). *Gson » 2.10.1*. Recuperado de: <https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10.1>

MVNRepository. (9 de abril del 2019). *JavaEE Web API » 8.0.1*. Recuperado de: <https://mvnrepository.com/artifact/javax/javaee-api/8.0.1>

MVNRepository. (31 de julio del 2019). *Oracle's Implementation of The JSF 2.2 Specification API. » 2.2.20*. Recuperado de: <https://mvnrepository.com/artifact/com.sun.faces/jsf-api/2.2.20>

MVNRepository. (31 de julio del 2019). *Oracle's Implementation of The JSF 2.2 Specification. » 2.2.20*. Recuperado de: <https://mvnrepository.com/artifact/com.sun.faces/jsf-impl/2.2.20>

MVNRepository. (23 de junio del 2011). *JSTL » 1.2*. Recuperado de: <https://mvnrepository.com/artifact/javax.servlet/jstl/1.2>

MVNRepository. (5 de octubre del 2023). *PrimeFaces » 12.0.0*. Recuperado de: <https://mvnrepository.com/artifact/org.primefaces/primefaces/12.0.0>

Oracle. (2013). *The Java EE 6 Tutorial*. Recuperado de: <https://docs.oracle.com/javaee/6/tutorial/doc/bnafu.html>

W3Schools. (s.f.). *HTTP Request Methods*. Recuperado de: <https://www.w3schools.com/tags/ref_httpmethods.asp>

R, Fielding. M, Nottingham. J, Reschke. (Junio del 2022). *RFC 9110 HTTP Semantics*. Recuperado de: <https://www.rfc-editor.org/rfc/rfc9110#section-15>

Wikipedia. (s.f.). *List of HTTP status codes*. Recuperado de: <https://en.wikipedia.org/wiki/List_of_HTTP_status_codes>

Oracle. (10 de febrero del 2011). *Interface HttpServletResponse*. Recuperado de: <https://docs.oracle.com/javaee/6/api/javax/servlet/http/HttpServletResponse.html>

Oracle. (2020). *Class FileNotFoundException*. Recuperado de: <https://docs.oracle.com/javase/7/docs/api/java/io/FileNotFoundException.html>

W3Schools. (s.f.). *HTML JavaScript*. Recuperado de: <https://www.w3schools.com/html/html_scripts.asp>

W3Schools. (s.f.). *JavaScript Forms*. Recuperado de: <https://www.w3schools.com/js/js_validation.asp>

Çivici, Ç. (s.f.). *PRIMEFACES USER GUIDE 5.2*. Recuperado de: https://www.primefaces.org/docs/guide/primefaces_user_guide_5_2.pdf>

Curl. (s.f.). *curl.1 the man page*. Recuperado de: <https://curl.se/docs/manpage.html>

Curl. (s.f.). *curl tutorial*. Recuperado de: <https://curl.se/docs/manual.html>

IETF. (Junio de 1999). *5.1.1 Method*. Recuperado de: <https://www.rfc-editor.org/rfc/rfc2616#page-36>

Javatpoint. (s.f.). *Curl Command in Linux with Examples*. Recuperado de: <https://www.javatpoint.com/linux-curl-command>

Silva, C. (8 de marzo del 2023). *HTTP Status Codes: A Complete List + Explanations*. Recuperado de: <https://www.semrush.com/blog/http-status-codes/?kw=&cmp=LM_SRCH_DSA_Blog_EN&label=dsa_pagefeed&Network=g&Device=c&utm_content=622526966305&kwid=dsa-1754723155433&cmpid=18364824154&agpid=146618527572&BU=Core&extid=60109657981&adpos=&gclid=Cj0KCQjwn9CgBhDjARIsAD15h0DtXgpuHKdcp1r4cbwm1p2ZfuUVKsq9g63ux94ZBl7oJu0K5HG0k4EaArNaEALw_wcB>

mdn web docs. (2023). *Métodos de petición HTTP*. Recuperado de: <https://developer.mozilla.org/es/docs/Web/HTTP/Methods>

W3Schools. (s.f.). *HTML Tutorial*. Recuperado de: <https://www.w3schools.com/html/>

Javatpoint. (s.f.). *How to Generate Random Number in Java*. Recuperado de: <https://www.javatpoint.com/how-to-generate-random-number-in-java>

Viñé, E. (30 de junio del 2010). *Introducción a Primefaces*. Recuperado de: <https://www.adictosaltrabajo.com/2010/06/30/introduccion-primefaces/>

Google Cloud. (11 de marzo del 2023). *Configurar el descriptor de implementación de web.xml*. Recuperado de: <https://cloud.google.com/appengine/docs/flexible/java/configuring-the-web-xml-deployment-descriptor?hl=es-419>

Javatpoint. (s.f.). *load on startup in web.xml*. Recuperado de: <https://www.javatpoint.com/load-on-startup>

Javatpoint. (s.f.). *welcome-file-list in web.xml*. Recuperado de: <https://www.javatpoint.com/welcome-file-list>
