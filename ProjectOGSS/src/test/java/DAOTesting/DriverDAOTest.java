package DAOTesting;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.revature.config.AppConfig;
import com.revature.dao.DriverDAO;
import com.revature.dao.UserAccountDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class })
public class DriverDAOTest {

	@Autowired
	DriverDAO driverDao;
	UserAccountDAO userAccDao;

	@Test
	@Transactional
	@Rollback(true)
	public void test() {

	}
}
