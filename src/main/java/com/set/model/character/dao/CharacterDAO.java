package com.set.model.character.dao;

import com.set.model.character.dto.CharacterDTO;

import java.util.List;

public interface CharacterDAO {
    List<CharacterDTO> selectCharacterList();
}
