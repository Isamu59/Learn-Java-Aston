package ru.aston.hometask.patterns.builder;

//Builder героя с характеристиками

public class Hero {
    private final String name;
    private final String race;
    private final String heroClass;
    private final int strength;
    private final int agility;
    private final int intelligence;
    private final int vitality;

    private Hero(Builder builder) {
        this.name = builder.name;
        this.race = builder.race;
        this.heroClass = builder.heroClass;
        this.strength = builder.strength;
        this.agility = builder.agility;
        this.intelligence = builder.intelligence;
        this.vitality = builder.vitality;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    @Override
    public String toString() {
        return "Hero{name='" + name + "', race='" + race + "', class='" + heroClass
                + "', str=" + strength + ", agi=" + agility + ", int=" + intelligence + ", vit=" + vitality + "}";
    }


    public static class Builder {
        private String name;
        private String race;
        private String heroClass;
        private int strength;
        private int agility;
        private int intelligence;
        private int vitality;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRace(String race) {
            this.race = race;
            return this;
        }

        public Builder setHeroClass(String heroClass) {
            this.heroClass = heroClass;
            return this;
        }

        public Builder setStrength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder setAgility(int agility) {
            this.agility = agility;
            return this;
        }

        public Builder setIntelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Builder setVitality(int vitality) {
            this.vitality = vitality;
            return this;
        }

        public Hero build() {
            if (name == null || name.isEmpty()) {
                throw new IllegalStateException("Имя героя обязательно");
            }
            if (heroClass == null || heroClass.isEmpty()) {
                throw new IllegalStateException("Класс героя обязателен");
            }
            return new Hero(this);
        }
    }
}