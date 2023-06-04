package com.utils;

import java.io.*;

import com.player.PlayerConfig;

public class FileSystem {
    private static final String SAVE_FILE_PATH = "player_data";

    public static void savePlayerConfig(PlayerConfig playerConfig) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(SAVE_FILE_PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(playerConfig);
            System.out.println("Player data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving player data: " + e.getMessage());
        }
    }

    public static PlayerConfig loadPlayerConfig() {
    	PlayerConfig playerConfig = null;
        try (FileInputStream fileInputStream = new FileInputStream(SAVE_FILE_PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            playerConfig = (PlayerConfig) objectInputStream.readObject();
            System.out.println("Player data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while loading player data: " + e.getMessage());
        }
        return playerConfig;
    }
}