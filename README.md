# Roulette API 

## Descripción

Roulette API es una **API REST** que permite la nuevas creación de ruletas de apuesta, así como el registro de nuevas apuestas y el resultado de las respectivas apuestas, fue desarrollada como prueba de clean code para Masiv. 

## Pre-requisitos
+ Git
+ Docker

## Instalación & Ejecución

Para la instalación del proyecto es necesario clonar este repositorio ingresando este comando en la consola:

```
$ git clone https://github.com/D4v0r/RouletteApi-MasivTest
```

Una vez se tiene el repositorio en su máquina la aplicación se pone en marcha al ingresar el siguiente comando:

```
$ docker-compose up -d
```

## Funcionalidad

La **API** cuenta con los siguientes endpoints:

+ **POST** /api/masivRoulette 
    Permite la creacción de una nueva ruleta, devuelve su id.

+ **PATCH** /api/masivRoulette/roulette/{id}/open
    Permite abrir la ruleta con el {id} que se especifique

+ **POST** /api/masivRoulette/roulette/{id}/bet
    Permite registrar una apuesta en la ruleta con el {id} dado.
    Existen dos tipos de apuesta, uno por color (RED, BLACK) y otro por un número entre 0 y 36.
    
    1.  Ejemplo de Json para apuesta numérica:
        ```
        {
            "money":500
            "number":5
            "type": "number"
        }
        ```
        
    2.  Ejemplo de Json para apuesta por color:
        ```
        {
            "money":500
            "number":"RED"
            "type": "color"
        }
        ```
    

+ **PATCH** /api/masivRoulette/roulette/{id}/close
    Permite cerrar todas las apuestas realizadas dentro de una ruleta con el {id} indicado, una vez se cierra la ruleta se calcula el resultado de cada una de las apuestas.

+ **GET** /api/masivRoulette
    Devuelve todas las ruletas creadas.

### Ejemplo de uso

   ![](https://media.discordapp.net/attachments/748248118214262955/790698900902117396/Captura.png?width=789&height=701)

## Elaborado con 

+   Java 8
+   Spring
+   Git
+   Docker

## Autor

> Davor Javier Cortés Cardozo
>
> Estudiante de la Escuela Colombiana de Ingeniería Julio Garavito

## Licencia

Este proyecto está licenciado bajo la GNU General Public License v3.0, para más información ver la [LICENCIA](LICENSE.txt).
