package org.youcode.cch.generalResult.interfaces;

import org.youcode.cch.competition.Competition;
import org.youcode.cch.generalResult.GeneralResult;
import org.youcode.cch.generalResult.embeddables.GeneralResultKey;
import org.youcode.cch.shared.interfaces.GenericDaoI;

import java.util.List;

public interface GeneralResultDaoI extends GenericDaoI<GeneralResult , GeneralResultKey> {

    List<GeneralResult> getGeneralResultsOfCompetition(Competition c);
}
