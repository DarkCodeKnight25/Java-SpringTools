const fs = require('fs');
const path = require('path');
const readline = require('readline');

// Interfaz para leer la entrada del usuario
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Función para preguntar el nombre de la carpeta principal
function preguntarNombreCarpetaPrincipal() {
  return new Promise((resolve) => {
    rl.question('Nombre del Backed: ', (respuesta) => {
      resolve(respuesta.trim());
    });
  });
}

// Función para crear archivos y carpetas dentro de la carpeta principal
async function crearEstructura(nombreCarpetaPrincipal) {
  const rutaCarpetaPrincipal = `./${nombreCarpetaPrincipal}`;

  // Crear la carpeta principal
  if (!fs.existsSync(rutaCarpetaPrincipal)) {
    fs.mkdirSync(rutaCarpetaPrincipal);
    console.log(`Carpeta principal "${nombreCarpetaPrincipal}" creada.`);
  } else {
    console.log(`La carpeta principal "${nombreCarpetaPrincipal}" ya existe.`);
  }

  // Carpeta "src"
  const rutaSrc = path.join(rutaCarpetaPrincipal, 'src');
  fs.mkdirSync(rutaSrc);
  console.log(`Carpeta "src" creada.`);

  // Carpetas y archivos dentro de "src"
  const estructura = {
    controller: ['usuario.controller.js'],
    database: ['conexion.js', 'db.js', 'dbKill.js'],
    model: ['usuarioModel.js'],
    routers: ['usuario.routers.js'],
  };

  Object.entries(estructura).forEach(([carpeta, archivos]) => {
    const rutaCarpeta = path.join(rutaSrc, carpeta);
    fs.mkdirSync(rutaCarpeta);
    console.log(`Carpeta "${carpeta}" creada.`);

    archivos.forEach((archivo) => {
      const rutaArchivo = path.join(rutaCarpeta, archivo);
      fs.writeFileSync(rutaArchivo, '');
      console.log(`Archivo "${archivo}" creado.`);
    });
  });
}

// Función para crear archivos fuera de la carpeta principal
function crearArchivosFueraCarpetaPrincipal(nombreCarpetaPrincipal) {
  // Archivos fuera de la carpeta principal
  const archivosFueraCarpetaPrincipal = [
    'app.js',
    'config.js',
    'index.js',
    '.babelrc',
    '.env',
    'iniciar.bat'    
  ];

  archivosFueraCarpetaPrincipal.forEach((archivo) => {
    const rutaArchivo = `./${nombreCarpetaPrincipal}/${archivo}`;
    fs.writeFileSync(rutaArchivo, '');
    console.log(`Archivo "${archivo}" creado fuera de la carpeta principal.`);
  });
}

// Función principal para iniciar el proceso
async function iniciar() {
  const nombreCarpetaPrincipal = await preguntarNombreCarpetaPrincipal();
  await crearEstructura(nombreCarpetaPrincipal);
  crearArchivosFueraCarpetaPrincipal(nombreCarpetaPrincipal);
  rl.close();
}

// Llamada a la función principal
iniciar();
