-- Creamos algunas consultas

-- 1 mostrar todos los Organizadores

SELECT * FROM organizadores;


-- 2 coger eventos y usuario de inscripciones

SELECT u.Nombre AS Usuario, e.Nombre AS Evento
FROM inscripciones i
JOIN usuarios u ON i.ID_Usuario = u.ID_Usuario
JOIN eventos e ON i.ID_Evento = e.ID_Evento
ORDER BY u.Nombre;


