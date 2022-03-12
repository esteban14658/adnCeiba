SELECT *
FROM jugador
WHERE YEAR(fecha_nacimiento) = :fecha;