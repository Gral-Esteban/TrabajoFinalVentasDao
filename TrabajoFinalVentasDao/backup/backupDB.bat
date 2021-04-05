@echo off 
SET PG_BIN="C:\Program Files\PostgreSQL\12\bin\pg_dump.exe"
SET PG_HOST=localhost
SET PG_PORT=5432
SET PG_DATABASE=VentasDAO
SET PG_USER=postgres
SET PGPASSWORD=5984
SET PG_PATH=C:\Users\Esteban DAlbano\Documents\NetBeansProjects\VentasDAOs\TrabajoFinalVentasDao\backup
SET PG_FECHA=%date:~11,4%%date:~8,2%%date:~5,2%
SET PG_FILENAME="%PG_PATH%\%PG_DATABASE%_%PG_FECHA%.sql"
%PG_BIN% -U %PG_USER% -v -F c %PG_DATABASE% > %PG_FILENAME%