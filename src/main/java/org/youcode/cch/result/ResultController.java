package org.youcode.cch.result;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;

@RestController
@RequestMapping("/results")
public class ResultController {

    @PostMapping("/create")
    public ResultResponseDTO createResult(@Valid @RequestBody CreateResultDTO createResultDTO){

    }

}
