package com.example.gameindonesiastore;

import java.util.ArrayList;

public class GamesData {
    public static String[][] data = new String[][]{
            {"Motte Island", "Rp 45 999", "Gamebell Studio", "This is a 2D top-down horror game. If you enjoy adventures, top-down game with a hint of horror in it, Motte Island is for you. It has numerous features including but not limited to various puzzles and mini games contained within. It is as exciting as exploring an actual paradise island.","https://cdn.cloudflare.steamstatic.com/steam/apps/291290/header.jpg?t=1447361067"},
            {"Infectonator : Survivors", "Rp 89 999", "Toge Productions", "\"Infectonator : Survivors\" is a Randomized Permadeath Survival Simulator that combines RTS, Tower Defense, Roguelike, and Management-Simulation gameplay. The goal is to lead a group of survivors in a struggle to stay alive and find rescue in a zombie apocalyptic world.", "https://cdn.cloudflare.steamstatic.com/steam/apps/269310/header.jpg?t=1570439043"},
            {"Just Deserts", "Rp 89 999", "Vifth Floor", "Just Deserts is a sci-fi action dating sim where you play as a soldier who must protect a city from mysterious alien attack, while at the same time you will also be seeking to capture the heart of your dream girl(s)! Theme song by Vesuvia [Ecky], vocal track by iMochi", "https://cdn.cloudflare.steamstatic.com/steam/apps/488660/header.jpg?t=1620202074"},
            {"Celestian Tales: Old North", "Rp 83 999", "Ekuator Games", "Celestian Tales: Old North is a refreshing take on the classic turn-based Japanese style RPG. Scrapping away the cliché of a destined person or a boy/girl-saving-the-world, the story is tailored for a mature audience and questions the bare morals of a human being.", "https://cdn.cloudflare.steamstatic.com/steam/apps/315860/header.jpg?t=1465923387"},
            {"Nusakana", "Rp 64 999", "Studio Namaapa", "Nusakana is an open-world JRPG where you date fish girls while trying to solve the island mysteries. Play as a tourist having a full-year vacation on the island, on a mysterious invitation. Will it be a fun holiday or will it be a thrilling adventure? What about the romance? You decide!", "https://cdn.cloudflare.steamstatic.com/steam/apps/401290/header.jpg?t=1602040174"},
            {"DreadOut", "Rp 95 999", "Digital Happiness", "DreadOut is a third person supernatural horror game where you play as Linda, a high school student trapped in an old abandoned town. Equipped with her trusty smart-phone, she will battle against terrifying encounters and solve mysterious puzzles which will ultimately determine her fate.", "https://cdn.cloudflare.steamstatic.com/steam/apps/269790/header.jpg?t=1631931053"},
            };

    public static ArrayList<Games> getListData() {
        ArrayList<Games> list = new ArrayList<>();
        for(String[] aData : data) {
            Games game = new Games();
            game.setName(aData[0]);
            game.setPrice(aData[1]);
            game.setDeveloper(aData[2]);
            game.setDetail(aData[3]);
            game.setPhoto(aData[4]);
            list.add(game);
        }
        return list;
    }
}
