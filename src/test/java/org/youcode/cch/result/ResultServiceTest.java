package org.youcode.cch.result;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.youcode.cch.result.mappers.CreateResultDTOToResultEntityMapper;
import org.youcode.cch.result.mappers.ResultEntityToResultResponseDTOMapper;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ResultServiceTest {
    @Mock
    private ResultDao resultDao;
    @Mock
    private CreateResultDTOToResultEntityMapper createResultDTOToResultEntityMapper;
    @Mock
    private ResultEntityToResultResponseDTOMapper resultEntityToResultResponseDTOMapper;
    @InjectMocks
    private ResultService resultService;


    @Test
    public void testGetAllResults(){
        List<Result> results = List.of(new Result() , new Result() , new Result());

    }

}
