package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.models.User;
import com.revature.daos.UserDAOInterface;
import org.mockito.Spy;

//@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@Mock //mock instance
	private UserDAOInterface mockedDao;

	@Spy //real instance that we can track, aka "spy" on with certain methods like verify()
	private UserService testInstance  = new UserService(mockedDao);

	private User u = new User(1, "kewlUsername", "password");
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		testInstance = new UserService(mockedDao);

		//due to these two lines of code, the user returned will always be User u, declared above
		when(mockedDao.findByUsername("kewlUsername")).thenReturn(u);
		when(mockedDao.findById(1)).thenReturn(u);
	}
	
	@Test
	public void testLoginByNameSuccess() {
		assertTrue(testInstance.loginWithName("kewlUsername", "password").equals(u));

		//make sure that the findByUsername method of the UserDAO ran once (test fails if not)
		verify(mockedDao, times(1)).findByUsername("kewlUsername");
	}
	
	@Test
	public void testLoginByNameFail() {
		assertNull(testInstance.loginWithName("coolUsername", "password"));
	}
	
	@Test
	public void testLoginByIdSuccess() {
		assertTrue(testInstance.loginWithId(1, "password").equals(u));

		//make sure that the findById method of the UserDAO ran once (test fails if not)
		verify(mockedDao, times(1)).findById(1);
	}
	
	@Test
	public void testLoginByIdFail() {
		assertNull(testInstance.loginWithId(1, "sassword"));
	}
	
}