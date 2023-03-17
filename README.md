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





