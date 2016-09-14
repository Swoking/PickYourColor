package fr.scopegames.DYC.Game;

public enum GameState {
    LOBBY(true),
    PREGAME(false),
    GAME(false),
    FINISH(false);
    
    private static GameState current;
    private boolean canJoin;

    private GameState(String b, int n2, boolean bl) {
        this.canJoin = b;
    }

    public boolean canJoin() {
        return this.canJoin;
    }

    public static void setState(GameState state) {
        current = state;
    }

    public static boolean isState(GameState state) {
        if (current == state) {
            return true;
        }
        return false;
    }

    public static GameState getState() {
        return current;
    }
}