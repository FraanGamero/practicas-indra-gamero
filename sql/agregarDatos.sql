    -- Desactivamos autocommit y comenzamos una transacción
    SET AUTOCOMMIT=0;
    START TRANSACTION;
    USE portal;

    -- Insertamos usuarios con los nuevos nombres y correos
    INSERT INTO usuarios (Nombre, Correo, Contrasena) VALUES
    ('Fran Gamero', 'frangamero@gmail.com', 'password123'),
    ('Paco Acosta', 'pacoacosta@gmail.com', 'segura456'),
    ('Esturmio Solis', 'esturmiosolis@gmail.com', 'clave789');

    -- Insertamos organizadores
    INSERT INTO organizadores (Nombre, TLF, Correo) VALUES
    ('Enrique Moyano', '912345678', 'enriquemoyano@gmail.com'),
    ('Miguel Angel', '931234567', 'miguelangel@gmail.com');

    -- Insertamos categorías
    INSERT INTO categorias (Nombre) VALUES
    ('Conferencia'),
    ('Feria'),
    ('Taller');

    -- Insertamos ubicaciones
    INSERT INTO ubicaciones (tipo, direccion) VALUES
    ('Presencial', 'Calle Mayor 10, Madrid'),
    ('Online', NULL),
    ('Semipresencial', 'Av. Libertad 55, Barcelona');

    -- Insertamos eventos
    INSERT INTO eventos (Nombre, Fecha, Lugar, Duracion, ID_Organizador, ID_Ubicacion, ID_Categoria) VALUES
    ('Conferencia sobre Energías Renovables', '2025-09-15', 'Sala A', 3, 1, 1, 1),
    ('Feria Ecofriendly de Productos Sostenibles', '2025-07-20', 'Estadio Central', 2, 2, 1, 2),
    ('Taller de Compostaje Doméstico', '2025-08-05', 'Online', 4, 1, 2, 3);

    -- Insertamos inscripciones
    INSERT INTO inscripciones (ID_Usuario, ID_Evento) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (1, 3);

    COMMIT WORK;