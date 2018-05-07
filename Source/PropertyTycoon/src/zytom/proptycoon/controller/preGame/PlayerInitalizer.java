package zytom.proptycoon.controller.preGame;

import zytom.proptycoon.model.Player;

import java.util.ArrayList;

public class PlayerInitalizer {

    private final ArrayList<Player> players;
    private final ArrayList<Player.TokenType> tokens;


    public PlayerInitalizer(){
        players = new ArrayList<>();
        tokens = new ArrayList<>();
        tokens.add(Player.TokenType.BOOT);
        tokens.add(Player.TokenType.CAT);
        tokens.add(Player.TokenType.GOBLET);
        tokens.add(Player.TokenType.HATSTAND);
        tokens.add(Player.TokenType.SMARTPHONE);
        tokens.add(Player.TokenType.SPOON);
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }

    public void createPlayer(String name, Player.TokenType tokenType) throws ToManyPlayersException, TokenNotFoundException {
        if(players.size() < 6 ) {
            if(tokens.contains(tokenType)) {
                Player player = new Player(name, tokenType);
                this.players.add(player);
                tokens.remove(tokenType);
            }else{
                throw new TokenNotFoundException();
            }
        }else{
            throw new ToManyPlayersException();
        }
    }

    public static class ToManyPlayersException extends Exception {
        public ToManyPlayersException(){
            super (
                    "To Many Players!"
            );
        }
        /**
         * Gets the message
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }

    public static class TokenNotFoundException extends Exception {
        public TokenNotFoundException(){
            super (
                    "Token Taken!"
            );
        }
        /**
         * Gets the message
         * @return The exception message.
         */
        @Override
        public String getMessage()
        {
            return super.getMessage();
        }
    }
}

