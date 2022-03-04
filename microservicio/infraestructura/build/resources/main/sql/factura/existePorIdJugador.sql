select count(1) from factura
WHERE CAST(fecha_caducidad AS date) >= CAST(now() AS date)
and CAST(fecha_ingreso AS date) <= CAST(now() AS date) and
jugador = :jugador