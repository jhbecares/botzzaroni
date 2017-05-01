#### Instalación y ejecución del prototipo

1. Descargar el prototipo con git clone
https://github.com/masterucm1617/botzzaroni

2. Abrir eclipse (desarrollado en Neon 1 y Neon 2 con la versión 1.8
de java).

3. Importar el proyecto.

4. Configurar la ejecución con:

   - Run configurations.

   - Project BotzzaroniDev

   - Main:
     icaro.infraestructura.clasesGeneradorasOrganizacion.ArranqueSistemaConCrtlGestorO

   - Argumentos: chatters/descripcionAplicacionBotzzaroni

5. Modificar el archivo
config/icaro/aplicaciones/descripcionOrganizaciones/chatters/descripcionAplicacionBotzzaroni.xml
modificando la contraseña de root de MySQL si se tiene.

6. Lanzar MySQL o arrancar Apache y MySQL desde XAMPP. Para su
instalación, se puede acceder a
https://dev.mysql.com/downloads/installer/ y
https://www.apachefriends.org/es/index.html

7. Ejecutar el proyecto. Se mostrará una ventana en la que se podrá
iniciar sesión en caso de ser usuario conocido o se podrá registrar un
nuevo usuario indicando usuario y contraseña.

8. Tras hacer una de estas dos cosas, se abrirá la ventana de chat
donde podremos conversar con el sistema para realizar nuestros pedidos
a Botzzaroni.
