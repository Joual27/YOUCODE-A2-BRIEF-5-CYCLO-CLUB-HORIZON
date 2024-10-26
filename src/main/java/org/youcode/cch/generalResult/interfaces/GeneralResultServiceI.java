package org.youcode.cch.generalResult.interfaces;

import org.youcode.cch.generalResult.DTOs.CreateGeneralResultDTO;
import org.youcode.cch.generalResult.DTOs.GeneralResultResponseDTO;

public interface GeneralResultServiceI {
    GeneralResultResponseDTO save(CreateGeneralResultDTO generalResultDTO);
}
