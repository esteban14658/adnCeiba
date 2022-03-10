select count(1) from asistencia
where CAST(fecha AS date) = CAST(now() AS date)
  and jugador = :jugador;