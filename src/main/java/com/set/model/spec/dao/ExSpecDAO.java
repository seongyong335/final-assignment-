package com.set.model.spec.dao;

import com.set.model.spec.dto.ExSpecDTO;
import com.set.model.spec.dto.SpecDTO;

import java.util.List;

public interface ExSpecDAO {

    List<ExSpecDTO> selectExSpec(SpecDTO specDTO);
}
