package test.integration.com.pyxis.petstore.persistence.support;

import com.pyxis.petstore.domain.ItemRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PetStoreContext {

    private static final ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext(new String[] {
                "test-dataSource.xml",
                "persistenceContext.xml" 
        });
    }

    public static SessionFactory sessionFactory() {
        return applicationContext.getBean(SessionFactory.class);
    }

    public static ItemRepository itemRepository() {
        return applicationContext.getBean(ItemRepository.class);
    }
}