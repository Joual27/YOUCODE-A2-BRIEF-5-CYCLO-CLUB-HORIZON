package org.youcode.cch.result.interfaces;

import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.result.Result;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.shared.interfaces.GenericDaoI;
import org.youcode.cch.stage.Stage;

import java.util.List;

public interface ResultDaoI extends GenericDaoI<Result , ResultKey> {
    List<Result> findResultsByStage(Stage stage);
//    Result getResultByStageAndCyclist(Stage stage , Cyclist cyclist);
}
