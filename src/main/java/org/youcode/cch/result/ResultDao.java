package org.youcode.cch.result;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.youcode.cch.cyclist.Cyclist;
import org.youcode.cch.result.embeddables.ResultKey;
import org.youcode.cch.result.interfaces.ResultDaoI;
import org.youcode.cch.shared.GenericDao;
import org.youcode.cch.stage.Stage;

import java.util.List;

public class ResultDao extends GenericDao<Result , ResultKey> implements ResultDaoI {
    public ResultDao(SessionFactory sessionFactory){
        super(Result.class , sessionFactory);
    }

    @Override
    public List<Result> findResultsByStage(Stage stage){
        try(Session session = openSession()){
            String query = "FROM Result r WHERE r.stage = :stage";

            return session.createQuery(query, Result.class)
                    .setParameter("stage", stage)
                    .getResultList();
        }
    }

}
