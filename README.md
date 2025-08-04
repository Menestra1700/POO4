Cambios realizados 
El proyecto se desarrolló y mejoró en varias fases, integrando nuevas 
funcionalidades visto en clases. Se implementó el manejo de archivos CSV para almacenar
y recuperar información de todas las clases: Películas, Series de TV, Documentales, 
Actores, Temporadas e Investigadores. Se mejoró tambien el manejo de excepciones para
que el sistema pueda continuar funcionando con normalidad incluso ante errores de lectura
o escritura de archivos. Se refactorizó el código para hacerlo más modular y fácil de
mantener, eliminando duplicaciones y asegurando que cada clase tenga una única 
responsabilidad. Se aplicaron principios SOLID, lo que permitió mejorar la flexibilidad 
del sistema y facilitar futuras ampliaciones. Se reorganizó la estructura del proyecto 
siguiendo el patrón MVC, separando claramente la lógica de negocio (Modelos), la interfaz 
de usuario por consola (Vista) y la gestión del flujo de datos (Controladores). Además, se
implementaron pruebas unitarias con JUnit para algunas las clases principales,cubriendo 
casos normales, casos límite y tratar de corregir los mayores errores posibles, 
logrando una cobertura del 68.2%.

Estructura del código 
El código está organizado en paquetes dentro de la carpeta src/uni1a. Modelos (Model):
Clases que representan las entidades principales (Pelicula, SerieDeTV, Documental, Actor,
Temporada, Investigador), todas heredan o implementan comportamientos acordes a su naturaleza
. Vista (View): ConsolaView es la interfaz de usuario por consola, con menús específicos
para cada tipo de entidad y métodos para solicitar datos. Controladores (Controller): 
Controladores específicos para cada entidad (PeliculasController, SeriesController, 
DocumentalesController, ActoresController, TemporadasController, InvestigadoresController)
y un MainController que centraliza el flujo del sistema. Manejo de Archivos: Clases 
encargadas de leer y escribir archivos CSV para cada entidad (PeliculasFile, SeriesFile,
DocumentalesFile, ActoresFile, TemporadasFile, InvestigadoresFile). En la carpeta test/ 
se ubican las clases de pruebas unitarias organizadas para cubrir todos los métodos 
relevantes del proyecto.

Cómo clonar y ejecutar el proyecto Abrir una terminal y clonar el repositorio con el comando:
git clone https://github.com/Menestra1700/Proyectopoo1/tree/main Abrir el proyecto en un IDE
como Eclipse. Verificar que el proyecto esté configurado con el JDK adecuado. Configurar las
rutas de los archivos CSV en la clase MainController, asegurándose de que apunten a ubicaciones
válidas en el equipo, por ejemplo: peliculasController a new PeliculasController
(view, "C:/Users/Usuario/Desktop/peliculas.csv"); Ejecutar la clase Main.java para iniciar 
el sistema. Navegar por los menús para listar, agregar o modificar información.

Cómo ejecutar las pruebas
Abrir la carpeta test/ en el IDE. Seleccionar el paquete o la 
clase de pruebas a ejecutar. En Eclipse, hacer clic derecho y elegir Run As, JUnit Test.
