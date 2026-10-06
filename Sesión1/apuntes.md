# Estructura de datos
## ¿Cómo entiende la computadora el mundo real?
Una computadora solo administra ceros y unos 0 y 1. Para que un programa 
resuelva problemas reales (como registrar una cédula, cobrar una multa o guardar un 
nombre), necesitamos **darle significado y reglas a esos bits en memoria**.

Clasificamos esos tipos de datos según **al dominio que pertenecen** (Qué abarcan). Un dominio 
define dos cosas:

1. El conjunto de valores válidos (Qué se puede guardar).
2. Las operaciones asociadas (Qué tenemos permitido hacer con esos valores).

Los dominios se clasifican en:

- **Dominio Numérico**: Agrupa datos como edad, año de nacimiento número de multas.
Nos permiten hacer operaciones aritméticas.

- **Dominio Texto**: Agrupa datos como nombre, dirección o cédula. No se operan 
matemáticamente, sino mediante operaciones de cadena (concatenar, buscar subcadenas).

### Tipos de datos primitivos
El Dominio define la regla teórica, y el Tipo Primitivo de Java es la casilla de memoria fija
diseñada para cumplir esa regla. Es decir, que para ver la idea del Dominio de un dato en la
práctica, Java dispone de los tipos de datos primitivos. 

Un Tipo de Dato Primitivo es simplemente un tipo de realización física del Dominio (Lo que se
procesa en un Hardware). Son los tipos de datos más básicos e indivisibles que el lenguaje de
programación ofrece de forma nativa. Representan un único valor directo en memoria.

![datosPrimitivos](./imgs/datosPrimitivos.png)

Con esto, se puede ver que el dominio de los `Strings` sería de dominio texto, el de los `int` 
sería dominio numérico y así sucesivamente.

En el mundo Real, la información no suele venir aislada en variables simples. Un estudiante 
no es solo un int edad (Suelto, sin una clase); es un conjunto de nombre, cédula, materias y
promedios. Intentar manejar eso con puras variables primitivas sueltas vuelve el código 
inmanejable.

### Tipos de datos compuestos
Surgen para agrupar varios tipos de datos simples bajo una misma estructura y así representar
entidades complejas del mundo real.

- Variables que almacenan más de un valor.
- Variables que representen información de la vida real.
- Estarán formados a partir de tipos de datos simples.

En Java, tenemos:

![datosCompuestos](./imgs/datosCompuestos.png)

Note que **la clase representa un tipo de datos compuesto** ya que una simple class Estudiante
podría conformarse de un String nombre, int edad, boolean estaEstudiando, entre otras. Por lo
que se evidencia un conjunto de datos primitivo.

## La necesidad de manejar la complejidad: La Abstracción
Al agrupar datos en estructuras compuestas más grandes, surge un nuevo problema: si para 
usar una estructura tuvieras que conocer y modificar manualmente cada detalle interno de 
cómo está guardada en memoria, el software se volvería frágil e inmanejable.

Por ejemplo: Supón que el objeto `Estudiante` tiene 20 datos internos (promedio, materias
aprobadas, multas de biblioteca, año de ingreso, etc.). Si **NO usaras abstracción**, cada vez
que quisieras matricular al estudiante tendrías que modificar manualmente sus 20 variables en
memoria una por una. Si te equivocas en un dato, todo el programa falla (software frágil e
inmanejable).

Para resolver esto, la ciencia de la computación aplica el principio de **Abstracción**.

> **Abstracción:** Es una visión simplificada de la realidad en la que solo consideramos 
los aspectos esenciales, haciendo énfasis en el **¿QUÉ HACE?** más que en el **¿CÓMO LO HACE?**.

En programación, la abstracción ocurre en dos niveles:

1. **Abstracción de Control:** Es la utilización de procedimientos o funciones sin preocuparse
de cómo están implementados internamente. Solo nos interesa qué hace la función, ocultando
detalles como variables temporales o secuencias de instrucciones. Por ejemplo, al calcular
el promedio de un conjunto de datos, sólo te interesa pasar los datos, no el procedimiento
matemático detrás de ello.

2. **Abstracción de Datos:** Permite definir nuevos tipos de datos enfocándonos en las  
operaciones que podemos realizar con ellos, sin importar cómo se almacenan en memoria. De
este concepto nace el **TDA**.

### Tipos de datos abstractos (TDAs)
Un **TDA** es un modelo matemático de una estructura de datos que representa entidades del
mundo real o conceptos abstractos, especificando el **QUÉ** y omitiendo el **CÓMO**.

Un TDA bien diseñado se compone de dos partes fundamentales:

- **Comportamiento u Operaciones (Público):** Define lo que el TDA puede hacer. Es lo único
que el programador usuario puede ver y utilizar. 
  * *Ejemplo:* Un carro es útil porque se puede manejar; `manejar()` es una operación del TDA
    Carro.

- **Propiedades o Atributos (Oculto / Encapsulado):** Es la representación interna del estado
y los datos. Un TDA correctamente creado **mantiene sus propiedades ocultas**.
  * *Ejemplo:* Al conductor no le interesa cómo el motor inyecta gasolina o cómo giran los
    pistones; solo le interesa que el carro avance al acelerar.

## Implementación de un TDA en Java
Para llevar un TDA del papel (modelo matemático) a un lenguaje orientado a objetos como Java,
el lenguaje nos ofrece tres herramientas principales:

1. **Interfaces (`interface`):** Representan el TDA en su estado más puro. Solo definen el
    **QUÉ** (la firma de los métodos/operaciones) sin incluir detalles de implementación ni
    variables de estado.

2. **Clases Abstractas (`abstract class`):** Un punto medio. Permiten definir el contrato 
    pero también compartir código o atributos comunes entre diferentes implementaciones.

3. **Clases Concretas (`class`):** Representan la **Estructura de Datos real**. Implementan la
    interfaz y definen el **CÓMO** (cómo se organizan físicamente los datos en la memoria RAM 
    y cómo ejecutan los algoritmos).

---

### Caso de Estudio: El TDA `List` en Java
El TDA **`List`** representa una colección ordenada de elementos de cualquier tipo.


                     ┌──────────────────┐
                     │  List<E>         │  <-- TDA / Interfaz
                     │  <interface>     │      (Especifica el QUÉ)
                     └────────┬─────────┘
                              │
               ┌──────────────┴──────────────┐
               │                             │
    ┌──────────┴──────────┐       ┌──────────┴──────────┐
    │  ArrayList<E>       │       │  LinkedList<E>      │  <-- Estructuras de Datos
    │  (Basado en Arrays) │       │  (Basado en Nodos)  │      (Implementan el CÓMO)
    └─────────────────────┘       └─────────────────────┘


#### 1. El Contrato (La Interfaz `List<E>`)
Define las reglas que toda lista debe cumplir en Java:
- Permite añadir, eliminar y recuperar elementos.
- Permite elementos duplicados.
- Las operaciones como `add()` o `remove()` informan el éxito o fracaso de la operación.
- *Operaciones clave:* `add(E e)`, `add(int index, E element)`, `clear()`, `contains(Object o)`.

#### 2. Usuario vs. Implementador
Existe una separación radical de roles al trabajar con TDAs:

- **Para el Programador Cliente (Usuario del TDA):**
  - Tanto `ArrayList` como `LinkedList` se comportan exactamente igual a través de la interfaz
    `List`.

  - No necesita saber si los datos están contiguos en memoria o enlazados por referencias.

  - *Ejemplo:* `List<String> nombres = new ArrayList<>();`

- **Para el Desarrollador de la Estructura (Implementador):**
  - Debe tomar decisiones de ingeniería sobre la representación concreta en memoria.

  - **`ArrayList`:** Almacena los elementos en un arreglo interno redimensionable. Acceso por 
  índice ultra rápido, pero inserciones en el medio costosas.

  - **`LinkedList`:** Almacena los elementos en nodos dispersos en memoria unidos por punteros/
  referencias. Inserciones rápidas, pero acceso por índice lento.

---

## ¿Cómo podemos construir nuestras propias estructuras?

Para poder programar nuestras propias versiones de `ArrayList`, `LinkedList`, `Pilas` y `Colas` 
desde cero en este curso, necesitamos dominar 3 herramientas fundamentales de Java y Algoritmos:

1. **Java Generics (`<T>` / `<E>`):** Para que nuestros TDAs puedan almacenar cualquier tipo de 
objeto sin perder la seguridad de tipos.

2. **Notación Asintótica (Big-O):** Para medir matemáticamente si es mejor usar `ArrayList` o 
`LinkedList` según el problema.

3. **Recursividad:** La técnica base para recorrer estructuras no lineales complejas como Árboles 
y Grafos.

Todo esto se verá con detalle a continuación.

## De los TDAs a Java Generics
### 1. ""El Axioma del Contenedor (El Lema Inspirador)""

> **"La estructura y los algoritmos que gestionan los datos son totalmente independientes de la naturaleza de los datos gestionados."**

O dicho de otra forma:
> **"Una caja es una caja sin importar si guarda oro, joyas o discos duros[cite: 50, 55]. La lógica para abrirla, cerrarla o almacenar un elemento en ella es exactamente la misma."**

---

### 2. El Dilema del Creador de TDAs
Para entender mejor la idea anterior, observa que:

Cuando diseñas un **Tipo de Dato Abstracto (TDA)** como el TDA `List`:
* Defines las operaciones esenciales: `add()`, `remove()`, `get()`, `contains()`.
* El comportamiento matemático y la estructura lógica de una lista no cambian si guardas números
enteros (`1, 2, 3`), texto (`"A", "B"`) o entidades del mundo real (`Estudiante`, `Laptop`,
`Joya`).

Al traducir este modelo teórico a código Java, surgen dos problemas de diseño:

#### Opción A: Crear un TDA específico para cada tipo de dato
Escribir clases independientes como `IntArrayList`, `StringArrayList` o `StudentArrayList`.

* **Falla:** Causa **duplicación masiva de código**. No es una solución escalable ni fácil de
    mantener. Si se detecta un error en la lógica interna del método `add()`, habría 
    que corregirlo en cada clase por separado.

#### Opción B: Crear un TDA utilizando la clase ancestro `Object`
Escribir una sola estructura basada en `Object`. Dado que toda clase hereda de `Object` en Java, la estructura puede almacenar cualquier tipo de elemento.
* **Falla:** Elimina la **seguridad de tipos (*Type Safety*)**. Obliga a realizar casting explícito al extraer los datos y genera riesgo de errores graves en tiempo de ejecución (*Runtime*) como un `ClassCastException` si se inserta un tipo de dato no esperado.

Más adelante seguiremos hablando de la opción B con más detalle.

---

### 3. El Corolario: Por qué nacen los Generics en Java

> **Corolario de Parametrización:**  
> *"Para que un TDA sea verdaderamente abstracto y reutilizable, debe ser capaz de recibir el TIPO de dato como un parámetro de configuración en el momento de ser instanciado."*

**Java Generics (`<T>`)** resuelve esta necesidad al nivel del lenguaje:

1. **Abstracción Pura:** Permite escribir el algoritmo de la estructura de datos **una sola vez**.

2. **Seguridad en Tiempo de Compilación:** Evita el uso de castings manuales y permite que el compilador verifique que solo se almacenen los tipos permitidos, detectando incompatibilidades antes de ejecutar el programa.

---
## Java Generics (Parametrización de Tipos)
### 1. La Evolución: De Parametrizar Datos a Parametrizar Tipos
Para entender por qué existen los Genéricos, debemos ver cómo evoluciona la reutilización de
código en programación:

#### A. El Problema de la Duplicación Lógica
Imagina que necesitas métodos para dividir números entre valores fijos: `divideByTwo(n)`,
`divideByThree(n)`, `divideByFour(n)`, ...

- **Falla:** Esta estrategia es **difícil de mantener**, **no es escalable** y es **demasiado 
específica**.

#### B. Primera Solución: Parametrización de Datos (Variables)
Pasamos el divisor como un argumento: `divideBy(int n, int divisor)`. Es lo que comúnmente
llamamos **Parametrización de Datos**.

- **Ganancia:** Permite modificar el comportamiento del método enviando diferentes *valores* de
datos sin reescribir la rutina. Así, hemos creado una solución **más genérica**.

#### C. El Nuevo Límite: ¿Y si queremos variar el TIPO de dato?
Si ahora queremos que un método o una clase funcione no solo con `int`, sino también con `String`,
`Estudiante` o `Joya`, la parametrización de datos ya no alcanza. Por lo que hace falta
generalizar.

- **La Solución (Parametrización de Tipos):** En lugar de pasar un *valor* como parámetro,
pasamos un **TIPO DE DATO** como parámetro usando la sintaxis `<T>`.

La `Parametrización de Tipos` es la característica del lenguaje que permite crear clases,
interfaces y métodos especificando los tipos de datos sobre los que operan mediante
parámetros, en lugar de fijar un tipo de dato rígido desde el inicio.

Por otro lado el `Parámetro de tipo` es el identificador o símbolo placeholder (escrito
formalmente entre llaves angulares `<>`) que representa un tipo de dato abstracto hasta que
la clase o método es instanciado con un tipo real.

De esta forma, podemos crear clases, interfaces y métodos en los que los tipos de datos sobre
los que opera se especifican como parámetros. Pudiendo observar las siguientes ventajas:

* El código genérico trabaja automáticamente con el tipo de datos pasados a su
parámetro de tipo.

    * Ejemplo: La búsqueda binaria es la misma ya sea que se esté buscando
      números, o cadenas de caracteres, o estudiantes, o materias, etc

* Con genéricos, se puede definir el algoritmo una vez y aplicarlo a varios tipos de
datos sin mayor esfuerzo adicional.


---

## 2. La Solución Antigua vs. La Solución Moderna

                    ¿Cómo almacenar cualquier tipo de dato?
                                      │
            ┌─────────────────────────┴─────────────────────────┐
            ▼                                                   ▼
      Usando Object (Antiguo)                      Usando Generics <T> (Moderno)
    - Object es superclase de todos.             - Define un parámetro de tipo <T>.
    - Acepta cualquier objeto.                   - Mantiene el tipo específico en uso.
    - Requiere Casts manuales.                   - No requiere Casts.
    - Inseguro: Errores en Runtime.              - Seguro: Errores en Compilación.


### ¿Qué es un Genérico en Java?
Es el mecanismo general (introducido en Java 5) que permite definir estructuras y algoritmos
tipo "plantilla" que funcionan automáticamente sobre cualquier tipo de dato asignado a su
parámetro de tipo, garantizando seguridad en tiempo de compilación. Hay 2 formas de usar tipos
de datos genéricos en Java:

- Usando la clase Object.

- Usando parámetros de tipo.

