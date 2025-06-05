-- Desactivamos autocommit y comenzamos una transacción
SET AUTOCOMMIT=0;
START TRANSACTION;

use portal;


-- creamos los usuarios 
CREATE OR REPLACE USER 'miguelangel'@'localhost' IDENTIFIED BY 'miguelangel1234';
CREATE OR REPLACE USER 'enriquemoyano'@'localhost' IDENTIFIED BY 'enrique1234';
CREATE OR REPLACE USER 'frangamero'@'localhost' IDENTIFIED BY 'gamero1234';
CREATE OR REPLACE USER 'pacoacosta'@'localhost' IDENTIFIED BY 'pacoacosta1234';
CREATE OR REPLACE USER 'esturmio'@'localhost' IDENTIFIED BY 'esturmio1234';



-- damos permisos a los organizadores
GRANT ALL PRIVILEGES ON portal.* TO 'miguelangel'@'localhost';
GRANT ALL PRIVILEGES ON portal.* TO 'enriquemoyano'@'localhost';

-- damos SOLO los permisos de insert en la tabla eventos, pues deben de poder añadir sus eventos
GRANT INSERT ON portal.eventos TO 'frangamero'@'localhost';
GRANT INSERT ON portal.eventos TO 'pacoacosta'@'localhost';
GRANT INSERT ON portal.eventos TO 'esturmio'@'localhost';

COMMIT WORK;
