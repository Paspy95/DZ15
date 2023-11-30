package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void ifPlayer2Win() {
        Player vadim = new Player(5, "Вадим", 300);
        Player anton = new Player(2, "Антон", 350);
        Game game = new Game();
        game.register(vadim);
        game.register(anton);

        int expected = 2;
        int actual = game.round("Вадим", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifPlayer1Win() {
        Player ruslan = new Player(1, "Руслан", 400);
        Player anton = new Player(2, "Антон", 350);
        Game game = new Game();
        game.register(ruslan);
        game.register(anton);

        int expected = 1;
        int actual = game.round("Руслан", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifDraw() {
        Player oleg = new Player(6, "Олег", 300);
        Player anton = new Player(2, "Антон", 300);
        Game game = new Game();
        game.register(oleg);
        game.register(anton);

        int expected = 0;
        int actual = game.round("Олег", "Антон");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifPlayer1NotReg() {
        Player oleg = new Player(6, "Олег", 300);
        Player anton = new Player(2, "Антон", 300);
        Game game = new Game();
        game.register(oleg);
        game.register(anton);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Влад", "Антон");
        });
    }

    @Test
    public void ifPlayer2NotReg() {
        Player oleg = new Player(6, "Олег", 300);
        Player anton = new Player(2, "Антон", 300);
        Game game = new Game();
        game.register(oleg);
        game.register(anton);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Олег", "Влад");
        });
    }


}