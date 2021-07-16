package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

public class RouletteGamePlayer implements PlayerInterface {
RouletteGame game;
    CasinoAccount casinoAccount;
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    @Override
    public void play() { game.run();

    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {this.casinoAccount=casinoAccount;

    }
}
