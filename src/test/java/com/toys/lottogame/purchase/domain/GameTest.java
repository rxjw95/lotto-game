package com.toys.lottogame.purchase.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {

    @Test
    public void 게임은_여섯개의_번호를_선택해야_한다() {
        Game game = new Game(List.of(1, 2, 3, 4, 5, 6));
        assertThatNoException();
    }

    @Test
    public void 여섯개의_번호를_선택하지_않았다() {
        assertThatThrownBy(() -> new Game(List.of(1, 1, 4, 5)), "picks must not be duplicated and picks size must be six.");
        assertThatIllegalArgumentException();
    }

    @Test
    public void 여섯개의_번호는_중복될_수_없다() {
        assertThatThrownBy(() -> new Game(List.of(1, 1, 4, 5, 6, 45)), "picks must not be duplicated and picks size must be six.");
        assertThatIllegalArgumentException();
    }

    @Test
    public void 각_번호는_1보다_같거나_크고_45보다_작거나_같다() {
        assertThatThrownBy(() -> new Game(List.of(-1, 46, 4, 5, 6, 2)), "pick number range must be 1 <= number <= 45");
        assertThatIllegalArgumentException();
    }

}