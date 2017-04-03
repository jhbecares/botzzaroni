*** PIZZAS ***
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


*** PEDIDO ***

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

Sacar precio del pedido
SELECT sum(pizza.precio) precioTotal FROM pedido, tienePizza, pizza WHERE pedido.id = 'ID_PEDIDO' and tienePizza.idPedido = pedido.id and tienePizza.idPizza = pizza.id







