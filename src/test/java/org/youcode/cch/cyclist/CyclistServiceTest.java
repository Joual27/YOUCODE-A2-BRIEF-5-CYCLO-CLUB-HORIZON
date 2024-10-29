package org.youcode.cch.cyclist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.youcode.cch.cyclist.DTOs.CreateAndUpdateCyclistDTO;
import org.youcode.cch.cyclist.DTOs.CyclistResponseDTO;
import org.youcode.cch.cyclist.interfaces.CyclistDaoI;
import org.youcode.cch.cyclist.mappers.CreateCyclistDTOToCyclistEntityMapper;
import org.youcode.cch.cyclist.mappers.CyclistEntityToCyclistResponseDTOMapper;
import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.team.DTOs.EmbeddedTeamDTO;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


public class CyclistServiceTest {
    @Mock
    private CyclistDaoI cyclistDao;
    @Mock
    private CyclistEntityToCyclistResponseDTOMapper cyclistEntityToCyclistResponseDTOMapper;
    @Mock
    private CreateCyclistDTOToCyclistEntityMapper createCyclistDTOToCyclistEntityMapper;

    @InjectMocks
    private CyclistService cyclistService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testGetAllCyclists(){
        List<Cyclist> cyclists = List.of(new Cyclist() , new Cyclist());
        when(cyclistDao.findAll()).thenReturn(cyclists);

        EmbeddedTeamDTO embeddedTeamDTO = new EmbeddedTeamDTO("test");
        CyclistResponseDTO cyclistResponseDTO = new CyclistResponseDTO( 1L , "test" , "test" , "test" , 15 , embeddedTeamDTO);
        when(cyclistEntityToCyclistResponseDTOMapper.entityToDto(any(Cyclist.class))).thenReturn(cyclistResponseDTO);

        List<CyclistResponseDTO> res = cyclistService.getAllCyclists();
        assertEquals(2 , cyclists.size());
        verify(cyclistDao , times(1)).findAll();
    }

    @Test
    public void testGetCyclistById_cyclistExists(){
        Long id = 1L;
        Cyclist c = new Cyclist();
        when(cyclistDao.findById(id)).thenReturn(Optional.of(c));
        EmbeddedTeamDTO embeddedTeamDTO = new EmbeddedTeamDTO("test");
        CyclistResponseDTO cyclistResponseDTO = new CyclistResponseDTO( 1L , "test" , "test" , "test" , 15 , embeddedTeamDTO);

        when(cyclistEntityToCyclistResponseDTOMapper.entityToDto(c)).thenReturn(cyclistResponseDTO);

        CyclistResponseDTO res = cyclistService.getCyclistById(id);
        assertNotNull(res);
    }

    @Test
    public void testGetCyclistById_cyclistDoesNotExist(){
        Long id = 10000000L;
        when(cyclistDao.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> cyclistService.getCyclistById(id));
    }

    @Test
    public void testCyclistCreation(){
        CreateAndUpdateCyclistDTO cyclistToCreate = new CreateAndUpdateCyclistDTO();
        Cyclist c = new Cyclist();
        when(createCyclistDTOToCyclistEntityMapper.toEntity(cyclistToCreate)).thenReturn(c);

        Cyclist createdCyclist = new Cyclist();
        createdCyclist.setId(100L);

        EmbeddedTeamDTO embeddedTeamDTO = new EmbeddedTeamDTO("test");
        CyclistResponseDTO cyclistResponseDTO = new CyclistResponseDTO( 1L , "test" , "test" , "test" , 15 , embeddedTeamDTO);

        when(cyclistDao.save(c)).thenReturn(createdCyclist);
        when(cyclistEntityToCyclistResponseDTOMapper.entityToDto(createdCyclist)).thenReturn(cyclistResponseDTO);

        CyclistResponseDTO res = cyclistService.save(cyclistToCreate);
        assertNotNull(res);
    }


    @Test
    public void testCyclistUpdate(){
        Long id = 100L;
        Cyclist c = new Cyclist();
        when(cyclistDao.findById(id)).thenReturn(Optional.of(c));
        CreateAndUpdateCyclistDTO cyclistToUpdate = new CreateAndUpdateCyclistDTO();
        when(createCyclistDTOToCyclistEntityMapper.toEntity(cyclistToUpdate)).thenReturn(c);
        c.setId(id);
        EmbeddedTeamDTO embeddedTeamDTO = new EmbeddedTeamDTO("test");
        CyclistResponseDTO cyclistResponseDTO = new CyclistResponseDTO( id , "test" , "test" , "test" , 15 , embeddedTeamDTO);
        when(cyclistEntityToCyclistResponseDTOMapper.entityToDto(c)).thenReturn(cyclistResponseDTO);

        CyclistResponseDTO res = cyclistService.update(100L , cyclistToUpdate);

        assertNotNull(cyclistResponseDTO);
        assertEquals(c.getId() , res.getId());
    }

    @Test
    public void testCyclistUpdate_cyclistDoesntExist(){
        Long id = 100L;
        CreateAndUpdateCyclistDTO cyclist = new CreateAndUpdateCyclistDTO();
        when(cyclistDao.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> cyclistService.update(id,cyclist));
    }

    @Test
    public void testCyclistDeletion(){
        Long id = 100L;
        Cyclist c = new Cyclist();
        when(cyclistDao.findById(id)).thenReturn(Optional.of(c));
        EmbeddedTeamDTO embeddedTeamDTO = new EmbeddedTeamDTO("test");
        CyclistResponseDTO cyclistResponseDTO = new CyclistResponseDTO( id , "test" , "test" , "test" , 15 , embeddedTeamDTO);
        when(cyclistEntityToCyclistResponseDTOMapper.entityToDto(c)).thenReturn(cyclistResponseDTO);
        CyclistResponseDTO res = cyclistService.deleteById(id);
        assertNotNull(res);
    }

    @Test
    public void testCyclistDeletion_cyclistDoesntExist(){
        Long id = 100L;
        when(cyclistDao.findById(id)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class , () -> cyclistService.deleteById(id));

    }

}
