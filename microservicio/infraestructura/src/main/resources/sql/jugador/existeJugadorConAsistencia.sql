SELECT CASE WHEN
count(1) > 0
THEN 'true'
ELSE 'false'
END AS bool
from jugador j inner join asistencia a
on j.id = a.jugador
where j.id = :id;