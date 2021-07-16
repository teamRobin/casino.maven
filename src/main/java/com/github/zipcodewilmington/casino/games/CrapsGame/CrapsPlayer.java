package com.github.zipcodewilmington.casino.games.CrapsGame;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class CrapsPlayer implements PlayerInterface {
CasinoAccount casinoAccount;



    CrapsGame craps;
    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }

    @Override
    public void play() {craps.run();}

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {this.casinoAccount=casinoAccount;

    }
}
