package com.set.view.spec;

import com.set.model.character.dto.CharacterDTO;

import java.util.List;

public class SpecPrint {

    public void printErrorMessage(String msg) {
        switch (msg){
            case "input":
                System.out.println("input 실 "); break;
        }
    }

    public void printCharacterList(List<CharacterDTO> list) {
    }

    public void printSuccessMessage(String msg) {
        switch (msg){
            case "input":
                System.out.println("input 성공"); break;
        }
    }
}
