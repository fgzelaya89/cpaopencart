# Automatización de Pruebas con Java, Selenium WebDriver y Cucumber

Este proyecto de automatización de pruebas utiliza las siguientes tecnologías:

- **Lenguaje de Programación**: Java
- **Herramienta de Automatización**: Selenium WebDriver (versión 4.10.0)
- **Framework de Pruebas BDD**: Cucumber (versión 4.2.6)
- **Navegador de Pruebas**: Google Chrome

## Descripción del Proyecto

Este proyecto tiene como objetivo automatizar pruebas en la página web de OpenCart, específicamente en la URL [https://opencart.abstracta.us/](https://opencart.abstracta.us/). Utilizamos Java como lenguaje de programación, Selenium WebDriver (versión 4.10.0) como herramienta de automatización y Cucumber como framework de pruebas BDD para crear escenarios de prueba legibles y mantenibles.

## Versión de la Automatización

La versión actual de la automatización es la 1.0. Esta versión representa el estado actual del proyecto y se utilizará para realizar pruebas en la página web de OpenCart.

## Feature
- **AltaUsuario**: verificar y validar que la pagina "Register" este dando de alta a los usuarios nuevo.

## Configuración del Proyecto

Para ejecutar las pruebas de este proyecto en tu entorno local, sigue estos pasos:

1. Clona el repositorio desde [URL del Repositorio]([URL_DEL_REPOSITORIO](https://github.com/fgzelaya89/cpaopencart.git)).

2. Asegúrate de tener instalado Java en tu máquina.

3. Configura el navegador Chrome como tu navegador de pruebas. Puedes hacerlo instalando el controlador (driver) de Chrome y ajustando la configuración en los archivos de configuración del proyecto.

4. Ejecuta las pruebas utilizando Cucumber y el runner correspondiente.

```bash
mvn test
