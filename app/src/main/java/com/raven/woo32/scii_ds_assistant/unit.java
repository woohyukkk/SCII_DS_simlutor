package com.raven.woo32.scii_ds_assistant;

/**
 * Created by woo32 on 8/12/2017.
 */

public class unit {
    private int order_number;
    private String race;
    private String name;
    private int cost;
    private int HP;
    private int shield;
    private int armor;
    private String armor_type;
    private double movement;
    private int dmg_g;
    private int range_g;
    private int dmg_a;
    private int range_a;
    private String bonus_type;



    private int Bdmg_g;
    private int Bdmg_a;
    private double atkSp_g;
    private double atkSp_a;

    public unit(String race,int cost,int hp,int shield,int armor,String type,double move,int dmg_g,int dmg_a,int range_g,int range_a,String Btype,int Bdmg_g,int Bdmg_a,double atkSp_g,double atkSp_a,int order){
        this.race=race;
        this.cost=cost;
        this.HP=hp;
        this.shield=shield;
        this.armor=armor;
        this.armor_type=type;
        this.movement=move;
        this.dmg_g=dmg_g;
        this.dmg_a=dmg_a;
        this.range_g=range_g;
        this.range_a=range_a;
        this.bonus_type=Btype;
        this.Bdmg_g=Bdmg_g;
        this.Bdmg_a=Bdmg_a;
        this.atkSp_g=atkSp_g;
        this.atkSp_a=atkSp_a;
        this.order_number=order;

    }
    public int getOrder_number() {
        return order_number;
    }

    public String getRace() {
        return race;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getHP() {
        return HP;
    }

    public int getShield() {
        return shield;
    }

    public int getArmor() {
        return armor;
    }

    public String getArmor_type() {
        return armor_type;
    }

    public double getMovement() {
        return movement;
    }

    public int getDmg_g() {
        return dmg_g;
    }

    public int getRange_g() {
        return range_g;
    }

    public int getDmg_a() {
        return dmg_a;
    }

    public int getRange_a() {
        return range_a;
    }

    public String getBonus_type() {
        return bonus_type;
    }

    public int getBdmg_g() {
        return Bdmg_g;
    }

    public int getBdmg_a() {
        return Bdmg_a;
    }

    public double getAtkSp_g() {
        return atkSp_g;
    }

    public double getAtkSp_a() {
        return atkSp_a;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setArmor_type(String armor_type) {
        this.armor_type = armor_type;
    }

    public void setMovement(double movement) {
        this.movement = movement;
    }

    public void setDmg_g(int dmg_g) {
        this.dmg_g = dmg_g;
    }

    public void setRange_g(int range_g) {
        this.range_g = range_g;
    }

    public void setDmg_a(int dmg_a) {
        this.dmg_a = dmg_a;
    }

    public void setRange_a(int range_a) {
        this.range_a = range_a;
    }

    public void setBonus_type(String bonus_type) {
        this.bonus_type = bonus_type;
    }

    public void setBdmg_g(int bdmg_g) {
        Bdmg_g = bdmg_g;
    }

    public void setBdmg_a(int bdmg_a) {
        Bdmg_a = bdmg_a;
    }

    public void setAtkSp_g(double atkSp_g) {
        this.atkSp_g = atkSp_g;
    }

    public void setAtkSp_a(double atkSp_a) {
        this.atkSp_a = atkSp_a;
    }

    @Override
    public String toString() {
        return "unit{" +
                "order_number='" + order_number + '\'' +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", HP=" + HP +
                ", shield=" + shield +
                ", armor=" + armor +
                ", armor_type='" + armor_type + '\'' +
                ", movement=" + movement +
                ", dmg_g=" + dmg_g +
                ", range_g=" + range_g +
                ", dmg_a=" + dmg_a +
                ", range_a=" + range_a +
                ", bonus_type='" + bonus_type + '\'' +
                ", Bdmg_g=" + Bdmg_g +
                ", Bdmg_a=" + Bdmg_a +
                ", atkSp_g=" + atkSp_g +
                ", atkSp_a=" + atkSp_a +
                '}';
    }
}
