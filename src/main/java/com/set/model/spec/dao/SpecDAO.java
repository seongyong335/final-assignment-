package com.set.model.spec.dao;

import com.set.model.character.dto.CharacterDTO;
import com.set.model.spec.dto.SpecDTO;

import java.util.List;

public interface SpecDAO {

    int inputSpec(SpecDTO inputInfo);

    List<CharacterDTO> selectUserCharacterList(String userId);

    List<SpecDTO> selectSpec(SpecDTO specDTO);

    List<CharacterDTO> selectUserCharacter(SpecDTO specDTO);

    int updateSpec(SpecDTO specDTO);
}
