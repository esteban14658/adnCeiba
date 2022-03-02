SELECT count(1) FROM factura b
inner join jugador a on b.jugador = a.id
WHERE CAST(fecha_caducidad AS date) >= CAST(now() AS date)
and CAST(fecha_ingreso AS date) <= CAST(now() AS date) and
a.documento = :documento;