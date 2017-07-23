package com.learners;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.learners.models.Role;
import com.learners.repository.RoleRepository;
import com.learners.repository.UserRepository;
import com.learners.security.AuthoritiesConstants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnersManagementSystemApplicationTests {

	@Autowired
	private RoleRepository roleRepo;
	private UserRepository userRepo;

	@Test
	public void contextLoads() {

		Field[] f = AuthoritiesConstants.class.getDeclaredFields();
		for (Field field : f) {
			field.setAccessible(true);
			try {
				Object value = field.get(new AuthoritiesConstants());
				String role = value.toString();
				if (roleRepo.findOneByName(role) == null) {
					Role r = new Role();
					r.setName(role);
					roleRepo.save(r);
				}

			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

//		User u = new User();
//		u.setUserName("000000000v");
//
//		u.setPassword("admin");
//		Set<Role> s = new HashSet<>();
//		s.add(roleRepo.findOneByName(AuthoritiesConstants.ADMIN));
//		u.setRoles(s);
//		u.setEmail("thamira1005@gmail.com");
//
//		userRepo.save(u);

	}

}
