package com.company;

import Monster.*;
import weapon.Weapon_Knife;
import weapon.Weapon_M16;

public class Story {

    Game game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    SuperMonster monster;
    int credits;

    public Story(Game g, UI userInterface, VisibilityManager vManager) {

        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup() {

        player.hp = 100;
        ui.hpNumberLabel.setText("" + player.hp);

        player.currentWeapon = new Weapon_Knife();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        credits = 0;
    }

    public void selectPosition(String nextPositon) {
        switch (nextPositon) {
            case "showId":
                showId();
                break;
            case "attackGuards":
                attackGuards();
                break;
            case "leaveGuards":
                leaveGuards();
                break;
            case "tryToLeave":
                leaveGuards();
                break;
            case "sneakIn":
                sneakIn();
                break;
            case "bribeGuards":
                bribeGuards();
                break;
            case "tryToSneak":
                tryToSneak();
                break;
            case "findHelp":
                findHelp();
                break;
            case "bridge":
                bridge();
                break;
            case "return":
                townCustom();
                break;
            case "forest":
                forest();
                break;
            case "mountains":
                mountains();
                break;
            case "cave":
                cave();
                break;
            case "toTitle":
                toTitle();
                break;
            case "south":
                south();
                break;
            case "west":
                west();
                break;
            case "fight":
                figth();
                break;
            case "attack":
                attack();
                break;
            case "monsterAttack":
                monsterAttack();
                break;
            case "win":
                win();
                break;
            case "lose":
                lose();
                break;
            case "townCustom":
                townCustom();
                break;
            case "leave":
                leave();
                break;
            case "help":
                help();
                break;
            case "north":
                north();
                break;
            case "ending":
                ending();
                break;


        }
    }

    public void townCustom() {
        ui.mainTextArea.setText("Planet Zarros.\nThis is your first time wisiting after the Great War.\nYou are currently at the gate of the town. \nA group of guards are asking you for your id.\nYou look suspicious to them. \n\n What do you do?");
        ui.choice1.setText("Show the guards your id");
        ui.choice2.setText("Attack the guards");
        ui.choice3.setText("Leave");
        ui.choice4.setText("Bribe the guards");

        game.nextPosition1 = "showId";
        game.nextPosition2 = "attackGuards";
        game.nextPosition3 = "leaveGuards";
        game.nextPosition4 = "bribeGuards";

    }

    public void showId() {
        ui.mainTextArea.setText("One of the guards:Your id checks out.\n\nAs soon as you start to leave.\n Guard:Hey wait a minute I know you!\n Your race isn't allowed at this town.");
        ui.choice1.setText("Try to leave");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "tryToLeave";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void attackGuards() {
        ui.mainTextArea.setText("Guard:Don't be a fool\nYou are outnumbered.\n\nThe guards attacked you and you gave up because you can't win this fight. \n(You recieved 15 damage)");
        player.hp = player.hp - 15;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Try to sneak in");
        ui.choice2.setText("Try to bribe the guards");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "sneakIn";
        game.nextPosition2 = "bribeGuards";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void leaveGuards() {
        ui.mainTextArea.setText("If you leave the town everything the order stand for will be for nothing.\nEveryone depends on you.");
        ui.choice1.setText("Try to sneak in");
        ui.choice2.setText("Try to bribe the guards");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "sneakIn";
        game.nextPosition2 = "bribeGuards";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    public void sneakIn() {
        ui.mainTextArea.setText("It won't be easy to sneak in.\nThe town gate is to tall.\nYou may need some help.");
        ui.choice1.setText("Find help");
        ui.choice2.setText("Try anyway");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "findHelp";
        game.nextPosition2 = "tryToSneak";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    public void bribeGuards() {
        if (credits < 100) {
            ui.mainTextArea.setText("You don't have enough credits to bribe the guards!!!");
            ui.choice1.setText("Go back");
            ui.choice2.setText("");
            ui.choice3.setText("");
            ui.choice4.setText("");

            game.nextPosition1 = "townCustom";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (credits >= 100) {
            ending();
        }
    }

    public void tryToSneak() {
        ui.mainTextArea.setText("While you were climbing the gate you fell down and died.\n<GAME OVER>");
        ui.choice1.setText("Go to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void findHelp() {
        ui.mainTextArea.setText("You remember your old friend Garrus.He was your second in command during the Great War.He lives in the small village near the town,but you can't remember the way to the village.There are four paths to the village.First path is across the bridge.Second is through the forest.Third is across the mountains.Fourth path is through the dark cave.\n Choose carefully ");
        ui.choice1.setText("Bridge");
        ui.choice2.setText("Forest");
        ui.choice3.setText("Mountains");
        ui.choice4.setText("Cave");

        game.nextPosition1 = "bridge";
        game.nextPosition2 = "forest";
        game.nextPosition3 = "mountains";
        game.nextPosition4 = "cave";
    }

    public void bridge() {
        ui.mainTextArea.setText("You fall through the bridge and drowned\n\n<GAME OVER>");
        ui.choice1.setText("Go to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void forest() {
        ui.mainTextArea.setText("While you were going to the forest you found crate that contained M16\n\n(You obtained rifle M16)");
        player.currentWeapon = new Weapon_M16();
        ui.weaponNameLabel.setText(player.currentWeapon.name);
        ui.choice1.setText("Go south");
        ui.choice2.setText("Go west");
        ui.choice3.setText("Go east");
        ui.choice4.setText("Go north");

        game.nextPosition1 = "south";
        game.nextPosition2 = "west";
        game.nextPosition3 = "east";
        game.nextPosition4 = "north";
    }

    public void mountains() {
        ui.mainTextArea.setText("The avalanche killed you\n\n<GAME OVER>");
        ui.choice1.setText("Go to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void cave() {
        ui.mainTextArea.setText("The earthquake started while you were in the cave\n You got killed by the falling stone\n\n<GAME OVER>");
        ui.choice1.setText("Go to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void south() {
        ui.mainTextArea.setText("You found health pack\n\n(Your health is recovered by 30)");
        player.hp = player.hp + 30;
        ui.hpNumberLabel.setText("" + player.hp);
        ui.choice1.setText("Go west");
        ui.choice2.setText("Go east");
        ui.choice3.setText("Go north");
        ui.choice4.setText("");

        game.nextPosition1 = "west";
        game.nextPosition2 = "east";
        game.nextPosition3 = "north";
        game.nextPosition4 = "";
    }

    public void west() {
        monster = new Monster_Reaper();
        ui.mainTextArea.setText("You encounter a " + monster.name + "!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "forest";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void figth() {
        ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\n  What do you do?");
        ui.choice1.setText("Attack");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "attack";
        game.nextPosition2 = "forest";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void attack() {

        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);

        ui.mainTextArea.setText("You attacked the " + monster.name + " and gave " + playerDamage + " damage.");

        monster.hp = monster.hp - playerDamage;

        if (monster.hp > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (monster.hp <= 0) {
            game.nextPosition1 = "win";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";

        }

    }

    public void monsterAttack() {
        int monsterDamage = new java.util.Random().nextInt(monster.attack);

        player.hp = player.hp - monsterDamage;
        ui.hpNumberLabel.setText("" + player.hp);

        game.nextPosition1 = "win";
        game.nextPosition2 = "run";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        if (player.hp > 0) {
            game.nextPosition1 = "fight";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else if (player.hp <= 0) {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void win() {
        ui.mainTextArea.setText("You've defeated the " + monster.name + "!\n The monster dropped credits.\n\n(You obtained 100 credits)!");
        credits = 100;

        ui.choice1.setText("Go back to town gate");
        ui.choice2.setText("Go north");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "townCustom";
        game.nextPosition2 = "north";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void lose() {
        ui.mainTextArea.setText("You are dead!\n\n<GAME OVER>");
        ui.choice1.setText("Go to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    public void north() {
        ui.mainTextArea.setText("You found your friends village and Garrus.\n Garrus accepts to help you but he needs your help to defeat the monster that is attacking his village\n\nWhat do you do?");
        ui.choice1.setText("Leave him");
        ui.choice2.setText("Help him");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "leave";
        game.nextPosition2 = "help";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    public void leave() {
        ui.mainTextArea.setText("You have failed your friend and broke your orders code\n\n<GAME OVER>");
        ui.choice1.setText("Go to title screen");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");
        game.nextPosition1 = "toTitle";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }


    public void help() {


        int i = new java.util.Random().nextInt(100) + 1;
        if (i > 70) {
            monster = new Monster_Harbinger();
        } else if (i < 40) {
            monster = new Monster_Leviathan();
        } else {
            monster = new Monster_Husk();
        }

        ui.mainTextArea.setText("You encounter a " + monster.name + "!");
        ui.choice1.setText("Fight");
        ui.choice2.setText("Run");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "fight";
        game.nextPosition2 = "forest";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    public void ending() {
        ui.mainTextArea.setText("The guards accepted your credits\n\nGuard:Move along!!!\n\nYou have successfully entered the town!!!");
        ui.choice1.setVisible(false);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);

    }

    public void toTitle() {
        defaultSetup();
        vm.showTitleScreen();
    }
}

