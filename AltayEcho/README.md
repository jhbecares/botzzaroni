# S.O.N.I.A. - Sistema Organizador de eNcuentros basado en Inteligencia Artificial

Proyecto de la asignatura de DASI del Máster de Ingeniería Informática de la Universidad Complutense de Madrid

### Integrantes del proyecto

* Jorge Casas Hernán
* Mariano Hernández García
* Daw Issa Daw Hniesh
* Alberto Lorente Sánchez 

### Pasos a seguir para la puesta en marcha

La aplicación está preparada para ejecutarse en un chat IRC de Internet (irc.freenode.net). Ver **Nota** si no se dispone de acceso a un servidor IRC en Internet.  

Lo primero es **descargar el repositorio** de GitHub en la carpeta *C:/hlocal/workspace* (importante guardarlo en esta carpeta para que no sea necesario modificar archivos de rutas).

``` bash
$ git clone https://github.com/SONIAGroup/S.O.N.I.A..git
```
Una vez descargado es necesario **renombrar** la carpeta “S.O.N.I.A.” a “SONIA”.

A continuación **abrir Eclipse**. El proyecto ha sido desarrollado y testeado con Eclipse Mars 2 y las versiones 1.7 y 1.8 de java 4, otras versiones de Eclipse y Java deberían funcionar aunque no han sido probadas.


1. Ir a **Run configurations**
2. Project: SONIA
3. Main: icaro.infraestructura.clasesGeneradorasOrganizacion.ArranqueSistemaCon CrtlGestorO
4. Arguments: descripcionAplicacionChatters

**Ejecutar** el proyecto.

Lanzar un **cliente IRC** (por ejemplo <http://kiwiirc.com/client/> es un cliente web válido).

Escribir un nombre de usuario e **iniciar sesión en el canal #kiwiirc-sonia**. Sonia enviará automáticamente un mensaje privado saludándonos.

Haciendo click sobre el chat con Sonia podremos empezar a comunicarnos con ella.  

> **Nota:** Para ejecutar la aplicación en un servidor IRC local basta con instalarlo en una máquina propia (nosotros lo hicimos en una Raspberry Pi 2) y configurarlo en el sistema en el siguiente fichero: *src/icaro/aplicaciones/recursos/comunicacionChat/ConfigIngoComunicacionChat.java*, especificando en la variable *urlFeeNode* la dirección IP del servidor local donde está ejecutándose el demonio IRC (lo más común es que sea 192.168.1.X).


### Documentación asociada al proyecto

En el siguiente link se puede acceder a toda la documentación del proyecto, incluyendo los **diagramas de diseño**, cada una de las **actas de reunión** y la **memoria final**.

<https://drive.google.com/a/ucm.es/folderview?id=0B25URHn5C174NkM1MWtxeWFBTzQ&usp=sharing>

