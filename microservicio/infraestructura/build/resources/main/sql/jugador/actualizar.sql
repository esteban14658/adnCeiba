update jugador
set nombre = :nombre,
	apellido = :apellido,
	fecha_nacimiento = :fechaNacimiento,
    peso = :peso,
    altura = :altura,
    posicion = :posicion,
    pie_habil = :pieHabil
where id = :id