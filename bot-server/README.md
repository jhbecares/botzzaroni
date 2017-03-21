Esta carpeta contiene el servidor del proyecto Botzzaroni.

:)


Botzzaroni está preparado para correr con Eclipse. Se puede importar directamente el proyecto como un proyecto de Maven en Eclipse. 


Prerrequisitos:

- Maven

- Servidor Apache (probado con Apache 8.5)

- MySQL (probado con MySQL 5.7 en Ubuntu 16.04, que se ha instalado siguiendo las instrucciones de [digitalocean](https://www.digitalocean.com/community/tutorials/how-to-install-mysql-on-ubuntu-16-04)).


Cómo ejecutar el proyecto:

- 1. Clonar el proyecto

```
git clone https://github.com/masterucm1617/botzzaroni.git
```

- 2. Una vez instalado MySQL, lanzar el script de creación de la base de datos. Suponiendo que el usuario elegido es "root", se haría como sigue:

```
cd ${path}/botzzaroni/bot-server/src/main/resources
mysql -u root -p < db.sql
```

- 3. Importar el proyecto en Eclipse, seleccionando la opción de importar como proyecto maven. 

- 4. Asegurarse de que en ${path}/botzzaroni/bot-server/src/main/resources/application.properties el usuario y la contraseña de jdbc se corresponden con los que habéis usado para crear la base de datos MySQL previamente. Cambiarlo en application.properties si no fuera así. 

- 5. Pinchar con el botón derecho en el nombre del proyecto, y seleccionar run as -> run on server. Habrá que seleccionar un servidor de la lista o configurar uno de cero si aun no existieran servidores configurados en Eclipse. 


