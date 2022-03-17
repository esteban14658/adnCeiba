SELECT *
from jugador
WHERE NOT EXISTS(
SELECT asistencia.id  FROM asistencia
WHERE asistencia.jugador = jugador.id and
        CAST(fecha AS date) = CAST(now() AS date)
);