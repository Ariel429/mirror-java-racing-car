package racingGame;

import racingGame.controller.RacingController;

public class RacingGameApplication {

    public static void main(String[] args) {

        RacingController controller = new RacingController();
        controller.play();
    }
}
