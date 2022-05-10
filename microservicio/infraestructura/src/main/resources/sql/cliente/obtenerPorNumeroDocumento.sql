select  id, numero_documento, nombre, celular, correo, cantidad_dias
from cliente
where numero_documento = :numero_documento