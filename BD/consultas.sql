***PIZZAS***

Devuelve las pizzas de la carta
SELECT nombre FROM pizza WHERE aliasUsuario='botzzaroni'

Devuelve las pizzas de un usuario
SELECT * FROM pizza WHERE aliasUsuario='ALIAS_USER'

Obtener precio de una pizza por nombre
SELECT precio FROM pizza WHERE nombre='NOMBRE_PIZZA'

Obtener precio de una pizza por id
SELECT precio FROM pizza WHERE id=ID_DESEADO

Obtener los tipos de masa 
SHOW COLUMNS FROM tienePizza where Field='masa'

Obtener los diferentes tamaños de pizza
SHOW COLUMNS FROM tienePizza where Field='tamanio'

Obtener los ingredientes de una pizza a partir del id
SELECT nombre FROM tieneIngrediente, ingrediente where tieneIngrediente.idPizza=ID_DESEADO and tieneIngrediente.idIngrediente = ingrediente.id

Obtener el numero de ingredientes de una pizza 
SELECT count(nombre) FROM tieneIngrediente, ingrediente where tieneIngrediente.idPizza=ID_DESEADO and tieneIngrediente.idIngrediente = ingrediente.id

Insertar una pizza 
INSERT INTO pizza('id', 'aliasUsuario', 'nombre', 'precio') VALUES ('ID','ALIAS_USER','NOMBRE_PIZZA','PRECIO_DESEADO')

Actualizar nombre de una pizza
UPDATE 'pizza' SET nombre='NUEVONOMBRE' WHERE id=ID_DESEADO


***PEDIDOS***

Mostrar las pizzas del pedido
SELECT pizza.nombre FROM pedido, tienePizza, pizza WHERE pedido.id = 'ID_PEDIDO' and tienePizza.idPedido = pedido.id and tienePizza.idPizza = pizza.id

Cancelar el pedido
DELETE FROM pedido WHERE pedido.id = 'ID_PEDIDO'

Actualizar metodo del metodo del pago
UPDATE pedido SET metodoPago='METODO_PAGO' WHERE id='ID_PEDIDO'

Actualizar cambio
UPDATE pedido SET cambio='CAMBIO' WHERE id='ID_PEDIDO'

Actualizar fecha
UPDATE pedido SET fecha='DATETIME' WHERE id='ID_PEDIDO'

Insertar pedido
INSERT INTO pedido('id', 'aliasUsuario', 'metodoPago', 'cambio', 'fecha') VALUES ('ID','ALIAS_USER','METODO_PAGO','CAMBIO','FECHA')

Obtener masa de una pizza del pedido 
SELECT masa FROM 'tienePizza' WHERE idPedido=ID_PEDIDO and idPizza=ID_PIZZA

Obtener tamaño de una pizza del pedido
SELECT tamanio FROM 'tienePizza' WHERE idPedido=ID_PEDIDO and idPizza=ID_PIZZA

Actualizar tamaño de una pizza del pedido
UPDATE 'tienePizza' SET 'tamanio'='TAMANIO_DESEADO' WHERE idPedido=ID_PEDIDO and idPizza=ID_PIZZA

Actualizar masa de una pizza del pedido
UPDATE 'tienePizza' SET 'masa'='MASA_DESEADA' WHERE idPedido=ID_PEDIDO and idPizza=ID_PIZZA

Obtener nombre de un ingrediente
SELECT id FROM 'ingrediente' WHERE nombre='NOMBRE_INGREDIENTE'

Insertar ingredientes en una pizza
INSERT INTO 'tieneIngrediente'('idPizza', 'idIngrediente') VALUES (ID_PIZZA,ID_INGREDIENTE)

Borrar el ingrediente de una pizza del usuario
DELETE FROM 'tieneIngrediente' WHERE idPizza=ID_PIZZA and idIngrediente=ID_INGREDIENTE

Obtener nombres de la salsas disponibles
SELECT nombre FROM salsa

Obtener los ingredientes disponibles
SELECT nombre from ingrediente


*** BEBIDAS ***

Obtener precio y nombre de las bebidas disponibles
SELECT nombre,precio from bebida

Obtener precio de una bebida en concreto por nombre
SELECT precio from bebida where nombre = 'NOMBRE_BEBIDA'

Obtener precio de una bebida en concreto por id
SELECT precio from bebida where id = 'ID_BEBIDA'

Insertar una bebida en un pedido en concreto con un tamanio determinado
INSERT INTO tieneBebida('idPedido', 'idBebida', 'tamanio') VALUES ('ID_PEDIDO','ID_BEBIDA','TAMANIO')

Actualizar el tamaño de bebida
UPDATE tieneBebida SET tamanio='TAMANIO_BEBIDA' WHERE idPedido='ID_PEDIDO' and idBebida='ID_BEBIDA'

Recuperar el tamaño de la bebida
SELECT 'idPedido', 'idBebida', 'tamanio' FROM tieneBebida WHERE idPedido='ID_PEDIDO' and idBebida='ID_BEBIDA'


*** PAGO ***

Obtener método de PAGO de un pedido
SELECT metodoPago FROM pedido WHERE id = 'ID_PEDIDO'

Obtener cambio
SELECT cambio FROM pedido WHERE id = 'ID_PEDIDO'


*** CALENDARIO ***

SELECT fecha FROM pedido WHERE id = 'ID_PEDIDO'


*** AMIGO/CAJERO ***

Obtener el numero de pizzas de un pedido en concreto
SELECT COUNT(*) FROM pedido, tienePizza WHERE pedido.id = 'ID_PEDIDO' and pedido.id = tienePizza.idPedido

Obtener las ingredientes asociados a la alergia de un pedido
SELECT ingrediente.nombre FROM ingrediente, pedido, tieneAlergia WHERE pedido.id = 'ID_PEDIDO' and pedido.id = tieneAlergia.idPedido and tieneAlergia.idIngrediente = ingrediente.id


Sacar precio del pedido
SELECT sum(pizza.precio) precioTotal FROM pedido, tienePizza, pizza WHERE pedido.id = 'ID_PEDIDO' and tienePizza.idPedido = pedido.id and tienePizza.idPizza = pizza.id

***USUARIO***

Devuelve la información del usuario indicando el alias
SELECT * FROM usuario where alias='ALIAS_USER'

Introducir un nuevo usuario
INSERT INTO usuario('alias', 'password', 'nombre', 'calle', 'numero', 'piso', 'puerta', 'codPostal', 'movil') VALUES ('ALIAS_USER','PASSWORD','USUARIO','CALLE','NUMERO','PISO','PUERTA','COD_POSTAL','MOVIL')

