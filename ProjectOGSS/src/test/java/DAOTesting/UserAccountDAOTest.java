package DAOTesting;

import static org.junit.Assert.assertEquals;

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
import com.revature.model.AccountType;
import com.revature.model.Driver;
import com.revature.model.UserAccount;
import com.revature.struct.Token;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { AppConfig.class })
public class UserAccountDAOTest {

	@Autowired
	DriverDAO driverDao;
	@Autowired
	UserAccountDAO userAccDao;

	@Test
	@Transactional
	@Rollback(true)
	public void test() {
		UserAccount acc = new UserAccount();
		acc.setUsername("UnitTestName1");
		acc.setPassword("UnitTestPass2");
		acc.setSessionToken("Atoken1");
		acc.setPhoneNumber("test");
		acc.setFirstname("OldName");
		acc.setLastname("test");
		acc.setPassword("test");
		acc.setEmail("test");
		acc.setAddress("test");
		acc.setState("test");
		acc.setCity("test");
		acc.setZip("3fe");
		AccountType atype = new AccountType(1, "customer");
		acc.setAccountType(atype);
		Driver driv = driverDao
				.getDriverShiftStatus(new Token("QGpB60qbQug5C+6c45XI9zaPaaM/vqIUUBO7M8F48C39ROtEOniTzg=="));
		UserAccount accTest = userAccDao.createUserAccount(acc);
		accTest.setFirstname("NewName");
		UserAccount updatedAcc = userAccDao.updateAccount(accTest);
		assertEquals(updatedAcc.getFirstname(), "NewName");
	}
}
