## ¿Cómo consigo el proyecto?
Descargar el proyecto por primera vez: 

    git clone https://github.com/masterucm1617/botzzaroni
    
Se creará una carpeta llamada botzzaroni con los contenidos del repositorio. 

> Nota: si usas windows, recomiendo instalar github desktop (https://desktop.github.com), ya que instala una consola (git shell) que funciona como la de linux. 

## ¿Cómo actualizo el proyecto si sólo hay una rama?

    git pull 
    
## ¿Cómo actualizo el proyecto si hay más de una rama?

    git pull origin nombre-de-la-rama
    
## Proceso para subir cambios a git

* git status
* git add
* git commit
* git push

### git status
Te mostrará en verde los archivos que has añadido para el próximo commit, y en rojo los que no has añadido. En rojo saldrán dos tipos de archivos distintos, aquellos "sin seguimiento", que son aquellos archivos o ficheros que nunca han estado subidos al repositorio y los que sí están ya en el repo, que salen marcados como "modificados". 

### git add

    git add .
    
"Prepara" todos los ficheros que se han modificado. Se pueden (y recomiendo) añadir los archivos individualmente. Por ejemplo, si he creado un fichero llamado prueba.txt y una carpeta llamada carpeta-prueba, haré lo siguiente:

    git add prueba.txt

    git add carpeta-prueba/*
    
El segundo comando añadirá todos los contenidos de la carpeta prueba al commit. 

### git commit
"Consolida" los cambios sobre los ficheros que se han añadido. Es necesario escribir un mensaje de commit con los cambios que se han realizado. Ejemplo:

    git commit -m "Este es mi primer commit"
    
> Nota: git commit es una forma de "guardar" los cambios en tu ordenador. Hacer git commit no implica subirlo al repositorio, por lo que no hay que olvidar hacer git push después de hacer git commit :)

### git push
Una vez que estamos contentos con el trabajo que hemos hecho, podemos subir todos los commits anteriores al repositorio. Para ello, en caso de que queramos hacer push a la rama máster, el comando será el siguiente:

    git push origin master
    


