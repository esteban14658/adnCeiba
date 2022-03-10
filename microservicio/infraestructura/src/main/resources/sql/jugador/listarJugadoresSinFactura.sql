SELECT j.id, j.documento, j.nombre, j.apellido, j.fecha_nacimiento,
       j.peso, j.altura, j.posicion, j.pie_habil
from factura c right join jugador j
on c.jugador = j.id
WHERE NOT CAST(fecha_caducidad AS date) >= CAST(now() AS date)
    and CAST(fecha_ingreso AS date) <= CAST(now() AS date) or
    c.jugador is null;