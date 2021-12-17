package pl.edu.zse.gry.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.zse.gry.dao.IGameDAO;
import pl.edu.zse.gry.model.Game;

import java.util.List;

@Repository
public class GameDAO implements IGameDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Game> getAllConsoles() {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM pl.edu.zse.gry.model.Game GROUP BY console";
        List<Game> list = session.createQuery(hql).getResultList();
        /*for(int i=0; i<list.size(); i++) {
            Object[] row = (Object[]) list.get(i);
            System.out.println(row[0]+", "+ row[1]);
        }*/
        session.close();
        return list;
    }

    @Override
    public List<Game> getGamesByConsole(Game.Console console) {
        Session session = this.sessionFactory.openSession();
        Query<Game> query = session
                .createQuery("FROM pl.edu.zse.gry.model.Game WHERE console = :console");
        query.setParameter("console", console);
        List<Game> games = query.getResultList();
        session.close();
        return games;
    }

    @Override
    public void persistGame(Game game) {
        Transaction tx = null;
        try {
            Session session = this.sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(game);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        }
    }
}
