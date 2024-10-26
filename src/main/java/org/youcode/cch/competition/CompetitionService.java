package org.youcode.cch.competition;

import org.youcode.cch.competition.DTOs.CompetitionResponseDTO;
import org.youcode.cch.competition.DTOs.CreateAndUpdateCompetitionDTO;
import org.youcode.cch.competition.interfaces.CompetitionDaoI;
import org.youcode.cch.competition.interfaces.CompetitionServiceI;
import org.youcode.cch.competition.mappers.CompetitionEntityToCompetitionResponseDTOMapper;
import org.youcode.cch.competition.mappers.CreateAndUpdateCompetitionDTOToCompetitionEntityMapper;
import org.youcode.cch.exceptions.EntityNotFoundException;
import org.youcode.cch.stage.interfaces.StageDaoI;

import java.util.List;
import java.util.Optional;

public class CompetitionService implements CompetitionServiceI {
    private final CompetitionDaoI competitionDao;
    private final StageDaoI stageDao;
    private final CreateAndUpdateCompetitionDTOToCompetitionEntityMapper createAndUpdateCompetitionDTOToCompetitionEntityMapper;
    private final CompetitionEntityToCompetitionResponseDTOMapper competitionEntityToCompetitionResponseDTOMapper;

    public CompetitionService(CompetitionDaoI competitionDao , StageDaoI stageDao , CreateAndUpdateCompetitionDTOToCompetitionEntityMapper createAndUpdateCompetitionDTOToCompetitionEntityMapper , CompetitionEntityToCompetitionResponseDTOMapper competitionEntityToCompetitionResponseDTOMapper){
        this.competitionDao = competitionDao;
        this.stageDao = stageDao;
        this.createAndUpdateCompetitionDTOToCompetitionEntityMapper = createAndUpdateCompetitionDTOToCompetitionEntityMapper;
        this.competitionEntityToCompetitionResponseDTOMapper = competitionEntityToCompetitionResponseDTOMapper;
    }

    @Override
    public List<CompetitionResponseDTO> getAllCompetitions(){
        List<Competition> competitions = competitionDao.findAll();
        return competitions.stream()
                .map(competitionEntityToCompetitionResponseDTOMapper::entityToDto)
                .toList();
    }

    public Competition getCompetitionEntityById(Long id){
        Optional<Competition> competition = competitionDao.findById(id);
        if (competition.isEmpty()){
            throw new EntityNotFoundException("No competition found with the given ID !");
        }
        return competition.get();
    }
    @Override
    public CompetitionResponseDTO save(CreateAndUpdateCompetitionDTO c){
        Competition competitionToCreate = createAndUpdateCompetitionDTOToCompetitionEntityMapper.toEntity(c);
        Competition createdCompetition = competitionDao.save(competitionToCreate);
        createdCompetition.setStages(stageDao.getStagesOfCompetition(createdCompetition));
        return competitionEntityToCompetitionResponseDTOMapper.entityToDto(createdCompetition);
    }

    @Override
    public CompetitionResponseDTO update(CreateAndUpdateCompetitionDTO c , Long id){
        if(competitionDao.findById(id).isEmpty()){
            throw new EntityNotFoundException("No Competition Found With Given Id !");
        }
        else {
            Competition competitionToUpdate = createAndUpdateCompetitionDTOToCompetitionEntityMapper.toEntity(c);
            competitionDao.update(competitionToUpdate);
            competitionToUpdate.setId(id);
            competitionToUpdate.setStages(stageDao.getStagesOfCompetition(competitionToUpdate));
            return competitionEntityToCompetitionResponseDTOMapper.entityToDto(competitionToUpdate);
        }
    }

    @Override
    public CompetitionResponseDTO getById(Long id){
        Competition c = competitionDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No competition found with given ID !"));
        return competitionEntityToCompetitionResponseDTOMapper.entityToDto(c);
    }

    @Override
    public CompetitionResponseDTO deleteById(Long id){
        Competition c = competitionDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Competition found with given ID !"));
        competitionDao.deleteById(id);
        return competitionEntityToCompetitionResponseDTOMapper.entityToDto(c);
    }
}
