package org.youcode.cch.stage.interfaces;

import org.youcode.cch.competition.Competition;
import org.youcode.cch.shared.interfaces.GenericDaoI;
import org.youcode.cch.stage.Stage;

import java.util.List;

public interface StageDaoI extends GenericDaoI<Stage , Long> {

    List<Stage> getStagesOfCompetition (Competition competition);

    void setStageAsCompleted(Stage stage);
}
