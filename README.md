Ejercicio

Realizar un CRUD sobre el objeto Persona. Para ello se creará una lista de Personas y se crearan 4 clases de controladores, una para cada una de las opciones: - Añadir Persona. Petición POST. Body: { “name”:”Jesús” …. } http://URL/persona - Modificar por id. Petición PUT. http://URL/persona/{id} - Body se manda los datos.

Tener en cuenta que si no se manda un campo este está a nulo y NO queremos modificar a NULO los campos. - Borrar (por id). Petición DELETE. http://URL/persona/{id} - Consultar por id y por nombre. Petición GET http://URL/persona/{id} y http://URL/persona/nombre/{nombre}

El objeto Persona tendrá los campos: ‘nombre’, ‘edad’ y ‘población’.

Se deberá una clase de servicio que será la que inyectaremos en los controladores. Esa clase tendrá la lógica para el mantenimiento de los datos. Usar @RequestMapping(“persona”) para que todas las llamadas sean tipo http://URL/persona/...
