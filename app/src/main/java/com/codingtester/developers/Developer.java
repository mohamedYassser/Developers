package com.codingtester.developers;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.text.DecimalFormat;

@Entity(tableName = "dev_table")
public class Developer {

    private String name;
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double salary;
    private String title;
    private int vacation;
    private int absence;

    private double bonus;

    private int midIns;

    private int socialIns;

    public Developer(String name, double salary, String title, int vacation, int absence, double bonus, int midIns, int socialIns) {
        this.name = name;
        this.salary = salary;
        this.title = title;
        this.vacation = vacation;
        this.absence = absence;
        this.bonus = bonus;
        this.midIns = midIns;
        this.socialIns = socialIns;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public int getMidIns() {
        return midIns;
    }

    public void setMidIns(int midIns) {
        this.midIns = midIns;
    }

    public int getSocialIns() {
        return socialIns;
    }

    public void setSocialIns(int socialIns) {
        this.socialIns = socialIns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVacation() {
        return vacation;
    }

    public void setVacation(int vacation) {
        this.vacation = vacation;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }

    // 2000.123273623682736
    // 2000.12

    public double calcSalary() {
        return Double.parseDouble(new DecimalFormat("0.00")
                .format(salary - (absence * (salary / 30))));
    }

    public void printData() {
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
        System.out.println("some logic");
    }

}
