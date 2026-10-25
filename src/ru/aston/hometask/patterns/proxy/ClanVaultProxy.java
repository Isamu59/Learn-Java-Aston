package ru.aston.hometask.patterns.proxy;

import java.util.Arrays;
import java.util.List;

//Прокси клановой сокровищницы

public class ClanVaultProxy implements ClanVault {
    private final List<String> allowedPlayers;
    private RealClanVault realVault;

    public ClanVaultProxy(String... allowedPlayers) {
        this.allowedPlayers = Arrays.asList(allowedPlayers);
    }

    private void checkAccess(String playerName) {
        if (!allowedPlayers.contains(playerName)) {
            throw new SecurityException("Игрок " + playerName + " не имеет доступа к сокровищнице!");
        }
    }

    private RealClanVault getRealVault() {
        if (realVault == null) {
            System.out.println("[Proxy] Ленивая инициализация RealClanVault...");
            realVault = new RealClanVault();
        }
        return realVault;
    }

    @Override
    public void deposit(String playerName, String item) {
        System.out.println("[Proxy] Лог: " + playerName + " пытается положить " + item);
        checkAccess(playerName);
        getRealVault().deposit(playerName, item);
    }

    @Override
    public void withdraw(String playerName, String item) {
        System.out.println("[Proxy] Лог: " + playerName + " пытается взять " + item);
        checkAccess(playerName);
        getRealVault().withdraw(playerName, item);
    }

    @Override
    public void listContents(String playerName) {
        System.out.println("[Proxy] Лог: " + playerName + " просматривает сокровищницу");
        checkAccess(playerName);
        getRealVault().listContents(playerName);
    }
}