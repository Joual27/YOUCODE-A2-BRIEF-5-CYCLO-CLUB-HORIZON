package org.youcode.cch.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.cyclist.CyclistDao;
import org.youcode.cch.cyclist.DTOs.EmbeddedCyclistDTO;
import org.youcode.cch.result.DTOs.CreateResultDTO;
import org.youcode.cch.result.DTOs.ResultResponseDTO;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.mappers.CreateResultDTOToResultEntityMapper;
import org.youcode.cch.result.mappers.ResultEntityToResultResponseDTOMapper;
import org.youcode.cch.stage.DTOs.EmbeddedStageDTO;
import org.youcode.cch.stage.Stage;
import org.youcode.cch.stage.StageDao;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResultServiceTest {
    @Mock
    private ResultDao resultDao;
    @Mock
    private CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper;
    @Mock
    private ResultEntityToResultResponseDTOMapper resultEntityToResultResponseDTOMapper;
    @Mock
    private StageDao stageDao;
    @Mock
    private CyclistDao cyclistDao;
    @InjectMocks
    private ResultService resultService;
    private final EmbeddedStageDTO embeddedStageDTO = new EmbeddedStageDTO(15, "test" , "test" , "test");
    private final EmbeddedCyclistDTO embeddedCyclistDTO = new EmbeddedCyclistDTO("test", "test" , "test");

    @Test
    public void testGetAllResults(){
        List<Result> results = List.of(new Result() , new Result() , new Result());
        when(resultDao.findAll()).thenReturn(results);
        ResultResponseDTO resultResponseDTO = new ResultResponseDTO(new ResultKey(15L , 15L ), Duration.ofMinutes(15), 15 , embeddedStageDTO , embeddedCyclistDTO);
        when(resultEntityToResultResponseDTOMapper.entityToDto(any(Result.class))).thenReturn(resultResponseDTO);
        List<ResultResponseDTO> res = resultService.getAllStageResults();
        assertEquals(3 , res.size());
        verify(resultDao , times(1)).findAll();
    }

    @Test
    public void testResultCreation() {
        Long stageId = 100L;
        Long cyclistId = 200L;

        Stage s = new Stage();
        s.setId(stageId);

        Cyclist c = new Cyclist();
        c.setId(cyclistId);

        when(stageDao.findById(stageId)).thenReturn(Optional.of(s));
        when(cyclistDao.findById(cyclistId)).thenReturn(Optional.of(c));

        CreateResultDTO createResultDTO = new CreateResultDTO();

        Result resToCreate = new Result();
        when(createResultDTOToResultEntityMapper.toEntity(createResultDTO)).thenReturn(resToCreate);

        resToCreate.setRank(1);

        Result createdResult = new Result();
        when(resultDao.save(resToCreate)).thenReturn(createdResult);

        ResultResponseDTO resultResponseDTO = new ResultResponseDTO(new ResultKey(15L, 15L), Duration.ofMinutes(15), 15, embeddedStageDTO, embeddedCyclistDTO);

        when(resultEntityToResultResponseDTOMapper.entityToDto(createdResult)).thenReturn(resultResponseDTO);

        ResultResponseDTO res = resultService.save(createResultDTO);

        assertNotNull(res);
        verify(stageDao, times(1)).findById(stageId);
        verify(cyclistDao, times(1)).findById(cyclistId);
        verify(createResultDTOToResultEntityMapper, times(1)).toEntity(createResultDTO);
        verify(resultDao, times(1)).save(resToCreate);
    }


}
