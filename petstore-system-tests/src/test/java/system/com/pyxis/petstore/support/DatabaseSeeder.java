package system.com.pyxis.petstore.support;

import com.pyxis.petstore.domain.Item;
import com.pyxis.petstore.domain.hibernate.Transactor;
import com.pyxis.petstore.domain.hibernate.UnitOfWork;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DatabaseSeeder {
    private final SessionFactory sessionFactory;

    public DatabaseSeeder(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void seed(final Item item) throws Exception {
        final Session session = sessionFactory.openSession();
        new Transactor(session).perform(new UnitOfWork() {
            public void work() throws Exception {
                session.saveOrUpdate(item);
            }
        });
        session.close();
    }
}
