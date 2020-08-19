import java.util.Random;

public class Game {
    private static Integer MIN_CHARACTERS = 2;
    private static Integer MAX_CHARACTERS = 10;

    private static Integer MAX_MAGICIAN_HEALTH = 50;
    private static Integer MAX_MONSTERS_HEALTH = 70;

    private static Integer MIN_SPELLS_BOOK = 1;
    private static Integer MAX_SPELLS_BOOK = 3;

    private static Integer MAX_GAME_STEPS = 100;

    public static void main(String[] args) {
        Scene game = new Scene(new Random().nextInt(
                Game.MAX_CHARACTERS - Game.MIN_CHARACTERS) + Game.MIN_CHARACTERS);

        System.out.println("Loading scene");
        creationScene(game);

        System.out.println("Start game");
        Integer stepCounter = 0;
        while (++stepCounter <= Game.MAX_GAME_STEPS) {
            System.out.println("Step: " + stepCounter);
            game.gameStep();
            if(game.getEndGame()) {
                break;
            }
        }
    }

    private static void creationScene(Scene scene) {
        if (scene == null) {
            return;
        }

        for (Integer i = 0; i < scene.getMaxPositions(); i++) {
            if (new Random().nextBoolean()) {
                Monster monster = new Monster("monster" + i, Game.MAX_MONSTERS_HEALTH);
                if (scene.addCharacter(monster) == null){
                    System.out.println("No place for \"" + monster.getName() + "\"");
                    break;
                }
            }
            else {
                Integer numSpells = new Random().nextInt(Game.MAX_SPELLS_BOOK - Game.MIN_SPELLS_BOOK) + Game.MIN_SPELLS_BOOK;
                Spell[] spells = new Spell[numSpells];

                for (Integer j = 0; j < spells.length; j++)
                {
                    Spell[] spellList = Spell.values();
                    spells[j] = spellList[new Random().nextInt(Spell.values().length)];
                }

                Magician magician = new Magician("mag" + i, Game.MAX_MAGICIAN_HEALTH, spells);
                if (scene.addCharacter(magician) == null){
                    System.out.println("No place for \"" + magician.getName() + "\"");
                    break;
                }
            }
        }
    }
}