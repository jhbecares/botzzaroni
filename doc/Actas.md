# Actas de sesiones

### 15 de Febrero: Elección de la idea principal del proyecto Botzzaroni

En el primer día de reunión del equipo del proyecto se decidió entre las diferentes posibilidades para el mismo, descartando las ideas de “creación de escenarios con robots colaborativos” y “robots en Minecraft”, escogiendo por tanto la realización de un chatbot.

Se hicieron dos propuestas para las cuales el chatbot aporta un valor a la solución:

* Organización de vuelos.
* Pedidos de comida.

Tras comentarlo con el profesor, se escogió la segunda propuesta, pero focalizando el tipo de establecimiento al pedido de pizzas a domicilio, debido a que la otra propuesta tenía demasiado alcance y ésto puede causar una alta complejidad en el desarrollo de un chatbot con IA (es mejor que el ámbito esté definido y no sea muy amplio para poder controlarlo).

Se llamó al proyecto Botzzaroni, y se designaron los siguientes roles:

* Jennifer Hernández Bécares: Portavoz, analista programadora 
* Beatriz Jiménez del Olmo: Documentalista, analista programadora 
* Frank Vito Julca Bedón: Programador, testing 
* Alejandro Martín Guerrero: Programador, testing 
* Alfonso Tomé Coronas: Programador, diseñador, soporte de usuario 
* Verónica del Valle Corral: Programadora, diseñadora, analista del negocio

### 22 de Febrero: Definición de escenarios

En esta sesión de prácticas en grupo, cada integrante o por parejas realizó un guión o diálogo de uso de la aplicación, pudiendo ver así los diferentes puntos de vista de cada uno sobre cómo debe ser el caso de uso de la demo final.

Se detectaron de esta manera las variables a almacenar sobre el usuario, los diferentes flujos en el diálogo así como el orden de petición de información desde el punto de vista de cada miembro del equipo, de cara a una futura implementación del proyecto. 

Queda pendiente para la próxima sesión la puesta en común de los diálogos o escenarios, una vez analizados por todos los integrantes, para extraer los elementos comunes y definir el flujo principal de la conversación.

Tras hablar con el profesor, éste determinó que la interfaz final con el usuario es a nuestra elección, existiendo posibilidades como: 

* Realizar nuestro propio webchat a mano.
* Emplear un bot de Telegram.
* Bot en canal IRC.

Finalmente, se detallaron las siguientes tareas futuras:

* Buscar información sobre chatbots: cuáles existen, probarlos, buscar algún chabot existente que también ayude a realizar pedidos de pizzas…
* Incluir casos de uso en los que se tenga en cuenta la personalización por el histórico de pedidos de un usuario ya conocido.
* Implementar (a futuro) una versión “estática” o con conversaciones por defecto de lo que podría ser la aplicación final, de manera que nos sirva para definir el diálogo o flujo de conversación.
* Investigar en los diálogos de pizzerías con pedidos a domicilio, para tomar nota de los flujos de conversación (muy estudiados) que tienen a la hora de hacer los pedidos de manera telefónica.

### 1 a 5 de Marzo: Presentación del proyecto

El miércoles 1 en el horario de clase, al final de esta, se indicó que para el lunes 6 de Marzo todos los grupos deberán hacer una breve presentación del trabajo (de unos 5 minutos aproximadamente), a cargo del *comunicador* del equipo.
En esta presentación, se deberán cumplir los siguientes apartados:

* Presentación del equipo.
* Descripción del tema del proyecto: en qué consistirá.
* Escenario de ejemplo de funcionamiento
* De manera opcional se podrán presentar los casos de uso, aunque serán detallados de manera extensa en entregas posteriores.

El trabajo se "repartió" por parejas, encargándose Frank y Alex de la redacción del diálogo, Alfonso y Vero del diseño del cómic del escenario y finalmente Jenny y Bea de la elaboración de las diapositivas de tema, motivación y equipo, así como la elección del escenario.

### 8 a 13 de Marzo: Primera entrega "Descripción del proyecto"


El miércoles 8 se indicó en clase que la primera entrega del proyecto tendría fecha límite el lunes 13. Dicha entrega consistirá en la redacción del documento "Descripción del proyecto", que debe contar con los siguientes apartados:

* Nombre de los integrantes del grupo.
* Título de la práctica.
* Breve descripción del propósito del sistema inteligente a realizar. Identificar los aspectos de "inteligencia" que se pueden considerar en el sistema propuesto.
* Identificación de actores (tipos de usuario) y funcionalidad (casos de uso). Se recomienda presentarlo como un diagrama de casos de uso UML.
* Descripción de escenarios principales de los casos de uso.
* Descripción de una historia que concatene varios escenarios (historia de lo que debería ser la demo final).

Se proporcionó además vía Campus Virtual un documento con la estructura de esta entrega.
El trabajo se repartió de la siguiente manera:

* **Jenny**: Elaboración del diagrama de casos de uso y detalle de los casos de uso Modificar pedido "Modificar pizza", "Eliminar pizza", "Eliminar bebida" y "Logout".

* **Frank**: Revisión del diagrama de casos de uso y detalla de los casos de uso "Gestionar pedido", "Aceptar pedido", "Gestionar fecha y hora", "Gestionar pago"y "Gestionar cambio".

* **Alex:** Revisión del diagrama de casos de uso y detalla de los casos de uso "Personalizar pizza", "Escoger ingredientes", "Quitar ingrediente", y "Escoger salsa".

* **Vero**: Revisión del diagrama de casos de uso y detalla de los casos de uso "Iniciar sesión", "Registrarse", "Pedir datos usuarios" y "Usuario conocido".

* **Alfonso**: Revisión del diagrama de casos de uso y detalla de los casos de uso "Generar Pedido",  "Pedir pizza", "Seleccionar pizza de la carta" y "Preguntar alergias".

* **Bea:** Elaboración del diagrama de casos de uso, la descripción del propósito y de la inteligencia y detalle de los casos de uso "Guardar pizza", "Repetir pizza", "Escoger masa", "Escoger tamaño" y "Pedir bebida".

Los escenarios principales de los casos de uso y la historia para la demo final fueron añadidos de documentación generada anteriormente, en concreto para la "Presentación del proyecto" del día 6 de Marzo. El documento final se revisó **exhaustivamente** por todos los integrantes del grupo el domingo 12.


### 22 de Marzo: Diseño del sistema

El día 22 de Marzo en horario de clase se comenzó a trabajar en el diseño del sistema, con una entrega prevista para después de Semana Santa. 
Esta entrega constará de una demo "cableada" del sistema, de manera que para llevarla a acabo es necesario:

* Definir el flujo conversacional completo del chatbot, identificando sus mensajes, redirecciones, orden...
* Diseñar la arquitectura de agentes que se llevará a cabo, permitiendo identificar para cada uno sus objetivos inicialmente para después obtener las tareas necesarias para llevarlos a cabo. El proceso más sencillo para hacer esto es listar inicialmente objetivos y tareas para después repartir entre los agentes de la aplicación.
* Identificar los recursos necesarios, así como las interfaces que permitirán a los agentes de la aplicación utilizarlos para llevar a cabo sus tareas.

El trabajo se ha repartido inicialmente de la siguiente forma:

* Frank y Alex: Encargados del manejo de GATE, con la integración con el sistema y procesamiento del lenguaje para la primera versión.

* Vero y Alfonso: Diseño e implementación de la interfaz, mediante el framework Spring, que permite una integración rápida de Java con tecnologías web.

* Jenny y Bea: Investigación de la creación y control de agentes en la herramienta ÍCARO, así como integración de los distintos recursos a utilizar.


### 27 de Marzo: Diseño del sistema (II)

El día 27 de Marzo se ha recibido feedback sobre la primera entrega realizada en la asignatura. Se han recibido las siguientes recomendaciones:

¿Cómo demostramos que nuestro sistema es inteligente?

- Preguntar menos en una segunda interacción con el mismo usuario (aprender información sobre el usuario).
- Quedarse con información sobre usuarios para hacer recomendaciones posteriormente. 
- Demostrar que el sistema es capaz de razonar. 
- Capacidad del sistema para demostrar lo que hace (explicar sus funciones). 
- En los diálogos, demostrar que el sistema razona (que los diálogos implican que el sistema puede hacer cosas).

Se ha hablado también de la necesidad de que exista un rol de integración, para asegurar que para el día de la demo va a haber algo funcional. 

Se recomienda:

* Hacer varias iteraciones con pocas cosas en cada una (para ir avanzando poco a poco) con metodología ágil, en parejas de 2 que luego se van intercambiando para finalmente entender el código completo. 
* Replanificaciones: Revisar cosas poco a poco, añadir cosas nuevas en función de lo que vamos aprendiendo
*  Añadir lista de riesgos -> tecnologías desconocidas, problemas organizativos de los equipos

Como recomendación para nuestro proyecto:
- Añadir como recurso o como agente algo que pueda generar múltiples input/output

Finalmente el grupo ha estado terminando de diseñar el sistema que se va a utilizar el día de la demo, especificando qué agentes se van a utilizar y cuáles aun no se van a implementar. 

Para el próximo día, hemos quedado en enterarnos de cómo funciona el proyecto que nuestros compañeros del año pasado habían desarrollado (SONIA [https://github.com/SONIAGroup]). 

Finalmente, se decidió entre todos los integrantes implementar lo siguiente para la demo cableada:

* Usuario que inicia sesión o se registra en la aplicación.
* Pedido de una pizza de la carta.
* Aceptar/Cancelar el pedido, tras mostrar un resumen del mismo.
* Seleccionar entre pago en efectivo o con tarjeta.

### 5 de Abril: Desarrollo primera versión del sistema

El último día antes de las vacaciones de Semana Santa se hizo un reparto de tareas, en el cual se asignaron los agentes presentes en la aplicación a los miembros del equipo en pares, de manera que cada pareja era responsable de la implementación de un agente o agentes.

Se acordó que el día 17 de Abril, a la vuelta de Semana Santa, debería estar implementado el comportamiento de los agentes asignados, de manera que se dispusiese de tiempo para unificar antes de la entrega prevista para el día 27 de Abril.

Los agentes se repartieron de la siguiente manera:

* Contexto e Identificador: Jenny y Bea.
* Pizzero: Frank y Alex.
* Bebida y Pago: Vero y Alfonso.

### 21 de Abril: Reparto de tareas previo a la demo y a la segunda entrega

El día 21 de Abril por la mañana se procedió a realizar el reparto de tareas para la redacción de la memoria pertinente en esta segunda entrega, pospuesta hasta después del puente de Mayo por estar demasiado próxima la demo del lunes 24 y la entrega, de manera que fuera posible realizar los cambios pertinentes.

En concreto, se repartieron las tareas de la siguiente manera:
* Unificación de los agentes: Jenny y Bea.
* Comentarios sobre la primera entrega: Jenny y Bea.
* Diseño de la arquitectura: Vero, Alfonso, Frank y Alex.
* Modelo de dominio: Vero, Alfonso, Frank y Alex.
* Descripción de los agentes: Cada pareja responsable de la descripción de los agentes que ha implementado.
* Instalación y ejecución, limitaciones del prototipo y plan de desarrollo: Jenny y Bea.

