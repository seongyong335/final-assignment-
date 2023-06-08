package com.set.model.character.dto;

import java.io.Serializable;

public class CharacterDTO implements Serializable {

    private int charNo;
    private String charName;
    private String charElement;
    private int charStar;

    public CharacterDTO() {
    }

    public CharacterDTO(int charNo, String charName, String charElement, int charStar) {
        this.charNo = charNo;
        this.charName = charName;
        this.charElement = charElement;
        this.charStar = charStar;
    }

    public int getCharNo() {
        return charNo;
    }

    public void setCharNo(int charNo) {
        this.charNo = charNo;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharElement() {
        return charElement;
    }

    public void setCharElement(String charElement) {
        this.charElement = charElement;
    }

    public int getCharStar() {
        return charStar;
    }

    public void setCharStar(int charStar) {
        this.charStar = charStar;
    }

    @Override
    public String toString() {
        return "CharacterDTO{" +
                "charNo=" + charNo +
                ", charName='" + charName + '\'' +
                ", charElement='" + charElement + '\'' +
                ", charStar=" + charStar +
                '}';
    }
}
