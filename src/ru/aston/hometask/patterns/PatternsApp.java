package ru.aston.hometask.patterns;

import ru.aston.hometask.patterns.strategy.AttackStrategy;
import ru.aston.hometask.patterns.strategy.Fighter;
import ru.aston.hometask.patterns.strategy.MagicAttackStrategy;
import ru.aston.hometask.patterns.strategy.MeleeAttackStrategy;
import ru.aston.hometask.patterns.strategy.RangedAttackStrategy;
import ru.aston.hometask.patterns.chain.Damage;
import ru.aston.hometask.patterns.chain.DamageHandler;
import ru.aston.hometask.patterns.chain.DamageType;
import ru.aston.hometask.patterns.chain.FireDamageHandler;
import ru.aston.hometask.patterns.chain.PhysicalDamageHandler;
import ru.aston.hometask.patterns.chain.PoisonDamageHandler;
import ru.aston.hometask.patterns.builder.Hero;
import ru.aston.hometask.patterns.proxy.ClanVault;
import ru.aston.hometask.patterns.proxy.ClanVaultProxy;
import ru.aston.hometask.patterns.decorator.FireEnchantment;
import ru.aston.hometask.patterns.decorator.IronSword;
import ru.aston.hometask.patterns.decorator.PoisonEnchantment;
import ru.aston.hometask.patterns.decorator.Weapon;
import ru.aston.hometask.patterns.adapter.MagicSystemAdapter;
import ru.aston.hometask.patterns.adapter.OldMagicSystem;


public class PatternsApp {
    public static void main(String[] args) {
        System.out.println("--- ДЕМОНСТРАЦИЯ ПАТТЕРНОВ ПРОЕКТИРОВАНИЯ ---\n");

        // 1. СТРАТЕГИЯ
        demonstrateStrategy();

        // 2. ЦЕПОЧКА ОБЯЗАННОСТЕЙ
        demonstrateChainOfResponsibility();

        // 3. БИЛДЕР
        demonstrateBuilder();

        // 4. ПРОКСИ
        demonstrateProxy();

        // 5. ДЕКОРАТОР
        demonstrateDecorator();

        // 6. АДАПТЕР
        demonstrateAdapter();
    }

    private static void demonstrateStrategy() {
        System.out.println("1. СТРАТЕГИЯ");
        System.out.println("Боец меняет стиль атаки (ближний, дальний, магия) во время боя.\n");

        Fighter fighter = new Fighter("Артас");

        AttackStrategy melee = new MeleeAttackStrategy();
        AttackStrategy ranged = new RangedAttackStrategy();
        AttackStrategy magic = new MagicAttackStrategy();

        fighter.setAttackStrategy(melee);
        fighter.attack("Гоблин");

        fighter.setAttackStrategy(ranged);
        fighter.attack("Орк");

        fighter.setAttackStrategy(magic);
        fighter.attack("Дракон");

        System.out.println();
    }

    private static void demonstrateChainOfResponsibility() {
        System.out.println("2. ЦЕПОЧКА ОБЯЗАННОСТЕЙ");
        System.out.println("Урон проходит через цепочку сопротивлений (физическое -> огонь -> яд).\n");

        DamageHandler physicalHandler = new PhysicalDamageHandler();
        DamageHandler fireHandler = new FireDamageHandler();
        DamageHandler poisonHandler = new PoisonDamageHandler();

        physicalHandler.setNext(fireHandler).setNext(poisonHandler);

        System.out.println("--- Физический урон 100 ---");
        physicalHandler.handle(new Damage(DamageType.PHYSICAL, 100));

        System.out.println("\n--- Огненный урон 80 ---");
        physicalHandler.handle(new Damage(DamageType.FIRE, 80));

        System.out.println("\n--- Урон от яда 60 ---");
        physicalHandler.handle(new Damage(DamageType.POISON, 60));

        System.out.println("\n--- Неизвестный урон 50 (проходит полностью) ---");
        physicalHandler.handle(new Damage(DamageType.LIGHT, 50));

        System.out.println();
    }

    private static void demonstrateBuilder() {
        System.out.println("3. БИЛДЕР");
        System.out.println("Пошаговое создание героя с расами, классами и характеристиками.\n");

        Hero hero1 = new Hero.Builder()
                .setName("Торин")
                .setRace("Дворф")
                .setHeroClass("Воин")
                .setStrength(18)
                .setAgility(12)
                .setIntelligence(8)
                .setVitality(16)
                .build();

        Hero hero2 = new Hero.Builder()
                .setName("Элара")
                .setRace("Эльф")
                .setHeroClass("Маг")
                .setStrength(8)
                .setAgility(14)
                .setIntelligence(18)
                .setVitality(10)
                .build();

        System.out.println("Создан герой 1: " + hero1);
        System.out.println("Создан герой 2: " + hero2);

        // Демонстрация проверки обязательных полей
        System.out.println("\n--- Попытка создать героя без имени (ошибка) ---");
        try {
            new Hero.Builder()
                    .setHeroClass("Разбойник")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println();
    }

    private static void demonstrateProxy() {
        System.out.println("4. ПРОКСИ");
        System.out.println("Прокси сокровищницы проверяет права клана, лениво создаёт хранилище, логирует действия.\n");

        ClanVault vault = new ClanVaultProxy("Торин", "Элара", "Артас");

        System.out.println("--- Член клана Торин кладёт меч ---");
        vault.deposit("Торин", "Железный меч");

        System.out.println("\n--- Член клана Элара просматривает сокровищницу ---");
        vault.listContents("Элара");

        System.out.println("\n--- Член клана Артас забирает меч ---");
        vault.withdraw("Артас", "Железный меч");

        System.out.println("\n--- Враг Гоблин пытается залезть в сокровищницу ---");
        try {
            vault.deposit("Гоблин", "Мусор");
        } catch (SecurityException e) {
            System.out.println("Доступ запрещён: " + e.getMessage());
        }

        System.out.println();
    }

    private static void demonstrateDecorator() {
        System.out.println("5. ДЕКОРАТОР");
        System.out.println("Базовый меч зачаровывается огнём и ядом, урон и описание накапливаются.\n");

        Weapon sword = new IronSword();
        System.out.println("Базовое оружие: " + sword.getDescription() + ", урон: " + sword.getDamage());

        Weapon fireSword = new FireEnchantment(sword);
        System.out.println("После огненного зачарования: " + fireSword.getDescription() + ", урон: " + fireSword.getDamage());

        Weapon poisonFireSword = new PoisonEnchantment(fireSword);
        System.out.println("После ядовитого покрытия: " + poisonFireSword.getDescription() + ", урон: " + poisonFireSword.getDamage());

        System.out.println();
    }

    private static void demonstrateAdapter() {
        System.out.println("6. АДАПТЕР");
        System.out.println("Старая магическая система (OldMagicSystem) адаптируется под AttackStrategy.\n");

        OldMagicSystem oldSystem = new OldMagicSystem();
        AttackStrategy adaptedMagic = new MagicSystemAdapter(oldSystem, "Огненный шар", 20);

        System.out.println("Стратегия: " + adaptedMagic.getName());
        adaptedMagic.attack("Демон");

        // Можно использовать адаптер там, где ожидается AttackStrategy
        Fighter mage = new Fighter("Гендальф");
        mage.setAttackStrategy(adaptedMagic);
        mage.attack("Балрог");

        System.out.println();
    }
}