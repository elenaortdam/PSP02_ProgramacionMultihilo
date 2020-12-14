## Adivinar el número

Se trata de simular el juego para adivinar un número. Se crearán varios hilos, los hilos son los jugadores que 
tienen que adivinar el número. Habrá un árbitro que generará el número a adivinar, comprobará la jugada 
del jugador y averiguará a qué jugador le toca jugar. El 
número tiene que estar comprendido entre 1 y 10, usa la siguiente fórmula para generar el número:
 ```
 1 + (int) (10 * Math.random()); 
```

Se definen 3 clases: 
-  **Arbitro:** Contiene el número a adivinar, el turno y muestra el resultado. Se definen los siguientes 
atributos: el número total de jugadores, el turno, el número a adivinar y si el juego acabó o no. En 
el constructor se recibe el número de jugadores que participan y se inicializan el número a 
adivinar y el turno. Tiene varios métodos: uno que devuelve el turno, otro que indica si el juego 
se acabó o no y el tercer método que comprueba la jugada del jugador y averigua a quien le toca a 
continuación, este método recibirá el identificador de jugador y el número que ha jugado; deberá 
definirse como synchronized, así cuando un jugador está haciendo la jugada, ningún otro podrá 
interferir. En este método se indicará cual es el siguiente turno y si el juego ha finalizado porque 
algún jugador ha acertado el número. 
- **Jugador:** Extiende Thread. Su constructor recibe un identificador de jugador y el árbitro, todos 
los hilos comparten el árbitro. El jugador dentro del método run() comprobará si es su turno, en 
ese caso generará un número aleatorio entre 1 y 10 y creará la jugada usando el método 
correspondiente del árbitro. Este proceso se repetirá hasta que el juego se acabe. 
- **Main:** Esta clase inicializa el árbitro indicándole el número de jugadores, este se introducirá por 
teclado; y lanza los hilos de los jugadores, asignando un identificador a cada hilo y enviándoles el 
objeto árbitro que tienen que compartir. 

### Funcionamiento

El juego empieza con el Jugador 1, hace la jugada, se comprueba su jugada y a continuación le toca al 
jugador 2, hace la jugada, se comprueba, a continuación al jugador 3, … y así sucesivamente hasta que les 
toque a todos los jugadores. Si en algún momento el jugador acierta el número entonces el juego finaliza. 

*Ejemplo de salida al ejecutar el programa, únicamente se introduce el número de jugadores, el resto se genera automáticamente:*
 
 ```
Número de jugadores: 5 (SE INTRODUCE POR TECLADO)
NUMERO A ADIVINAR: 2 (SE GENERA AUTOMÁTICAMENTE)
EMPIEZA EL JUGADOR: 1 
Jugador1 dice: 8 (TAMBIÉN SE GENERA AUTOMÁTICAMENTE)
 Le toca a Jug2 
Jugador2 dice: 1 
 Le toca a Jug3 
Jugador3 dice: 3 
 Le toca a Jug4 
Jugador4 dice: 8 
 Le toca a Jug5 
Jugador5 dice: 4 
 Le toca a Jug1 
Jugador1 dice: 2 
¡Jugador 1 gana, adivinó el número! 
 ¡SE ACABÓ EL JUEGO! 
```
**OTRO EJEMPLO, PARA 3 JUGADORES:**
```
Número de jugadores: 3 
NUMERO A ADIVINAR: 10 
EMPIEZA EL JUGADOR: 1 
Jugador1 dice: 7 
 Le toca a Jug2 
4 
Jugador2 dice: 10 
¡Jugador 2 gana, adivinó el número! 
 ¡SE ACABÓ EL JUEGO!
```