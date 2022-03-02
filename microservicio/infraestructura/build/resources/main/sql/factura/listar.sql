SELECT * from factura c inner join jugador j
on c.jugador = j.id
WHERE CAST(fecha_caducidad AS date) >= CAST(now() AS date)
  and CAST(fecha_ingreso AS date) <= CAST(now() AS date);