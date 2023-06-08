package com.set.model.spec.dto;

import java.io.Serializable;

public class SpecDTO implements Serializable {

    private int charNo;
    private String userId;
    private int specSk1;
    private int specSk2;
    private int specSk3;
    private String specWeapon;
    private String specArtifactFlower;
    private String specArtifactPlume;
    private String specArtifactSands;
    private String specArtifactGoblet;
    private String specArtifactCirclet;
    private int specHp;
    private int specDef;
    private int specAfk;
    private int specEm;
    private double specEr;
    private double specCr;
    private double specCdmg;
    private String specEtc;
    private String specEtc2;

    public SpecDTO() {
    }

    public SpecDTO(int charNo, String userId, int specSk1, int specSk2, int specSk3, String specWeapon, String specArtifactFlower, String specArtifactPlume, String specArtifactSands, String specArtifactGoblet, String specArtifactCirclet, int specHp, int specDef, int specAfk, int specEm, double specEr, double specCr, double specCdmg, String specEtc, String specEtc2) {
        this.charNo = charNo;
        this.userId = userId;
        this.specSk1 = specSk1;
        this.specSk2 = specSk2;
        this.specSk3 = specSk3;
        this.specWeapon = specWeapon;
        this.specArtifactFlower = specArtifactFlower;
        this.specArtifactPlume = specArtifactPlume;
        this.specArtifactSands = specArtifactSands;
        this.specArtifactGoblet = specArtifactGoblet;
        this.specArtifactCirclet = specArtifactCirclet;
        this.specHp = specHp;
        this.specDef = specDef;
        this.specAfk = specAfk;
        this.specEm = specEm;
        this.specEr = specEr;
        this.specCr = specCr;
        this.specCdmg = specCdmg;
        this.specEtc = specEtc;
        this.specEtc2 = specEtc2;
    }

    public int getCharNo() {
        return charNo;
    }

    public void setCharNo(int charNo) {
        this.charNo = charNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSpecSk1() {
        return specSk1;
    }

    public void setSpecSk1(int specSk1) {
        this.specSk1 = specSk1;
    }

    public int getSpecSk2() {
        return specSk2;
    }

    public void setSpecSk2(int specSk2) {
        this.specSk2 = specSk2;
    }

    public int getSpecSk3() {
        return specSk3;
    }

    public void setSpecSk3(int specSk3) {
        this.specSk3 = specSk3;
    }

    public String getSpecWeapon() {
        return specWeapon;
    }

    public void setSpecWeapon(String specWeapon) {
        this.specWeapon = specWeapon;
    }

    public String getSpecArtifactFlower() {
        return specArtifactFlower;
    }

    public void setSpecArtifactFlower(String specArtifactFlower) {
        this.specArtifactFlower = specArtifactFlower;
    }

    public String getSpecArtifactPlume() {
        return specArtifactPlume;
    }

    public void setSpecArtifactPlume(String specArtifactPlume) {
        this.specArtifactPlume = specArtifactPlume;
    }

    public String getSpecArtifactSands() {
        return specArtifactSands;
    }

    public void setSpecArtifactSands(String specArtifactSands) {
        this.specArtifactSands = specArtifactSands;
    }

    public String getSpecArtifactGoblet() {
        return specArtifactGoblet;
    }

    public void setSpecArtifactGoblet(String specArtifactGoblet) {
        this.specArtifactGoblet = specArtifactGoblet;
    }

    public String getSpecArtifactCirclet() {
        return specArtifactCirclet;
    }

    public void setSpecArtifactCirclet(String specArtifactCirclet) {
        this.specArtifactCirclet = specArtifactCirclet;
    }

    public int getSpecHp() {
        return specHp;
    }

    public void setSpecHp(int specHp) {
        this.specHp = specHp;
    }

    public int getSpecDef() {
        return specDef;
    }

    public void setSpecDef(int specDef) {
        this.specDef = specDef;
    }

    public int getSpecAfk() {
        return specAfk;
    }

    public void setSpecAfk(int specAfk) {
        this.specAfk = specAfk;
    }

    public int getSpecEm() {
        return specEm;
    }

    public void setSpecEm(int specEm) {
        this.specEm = specEm;
    }

    public double getSpecEr() {
        return specEr;
    }

    public void setSpecEr(double specEr) {
        this.specEr = specEr;
    }

    public double getSpecCr() {
        return specCr;
    }

    public void setSpecCr(double specCr) {
        this.specCr = specCr;
    }

    public double getSpecCdmg() {
        return specCdmg;
    }

    public void setSpecCdmg(double specCdmg) {
        this.specCdmg = specCdmg;
    }

    public String getSpecEtc() {
        return specEtc;
    }

    public void setSpecEtc(String specEtc) {
        this.specEtc = specEtc;
    }

    public String getSpecEtc2() {
        return specEtc2;
    }

    public void setSpecEtc2(String specEtc2) {
        this.specEtc2 = specEtc2;
    }

    @Override
    public String toString() {
        return "SpecDTO{" +
                "charNo=" + charNo +
                ", userId='" + userId + '\'' +
                ", specSk1=" + specSk1 +
                ", specSk2=" + specSk2 +
                ", specSk3=" + specSk3 +
                ", specWeapon='" + specWeapon + '\'' +
                ", specArtifactFlower='" + specArtifactFlower + '\'' +
                ", specArtifactPlume='" + specArtifactPlume + '\'' +
                ", specArtifactSands='" + specArtifactSands + '\'' +
                ", specArtifactGoblet='" + specArtifactGoblet + '\'' +
                ", specArtifactCirclet='" + specArtifactCirclet + '\'' +
                ", specHp=" + specHp +
                ", specDef=" + specDef +
                ", specAfk=" + specAfk +
                ", specEm=" + specEm +
                ", specEr=" + specEr +
                ", specCr=" + specCr +
                ", specCdmg=" + specCdmg +
                ", specEtc='" + specEtc + '\'' +
                ", specEtc2='" + specEtc2 + '\'' +
                '}';
    }
}
