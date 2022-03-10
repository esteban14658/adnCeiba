SELECT j.id, j.documento, j.nombre, j.apellido, j.fecha_nacimiento,
       j.peso, j.altura, j.posicion, j.pie_habil
from asistencia a right join jugador j
                             on a.jugador = j.id
WHERE NOT CAST(fecha AS date) = CAST(now() AS date) or
    a.jugador is null;