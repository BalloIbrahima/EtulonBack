package com.odc.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.odc.backend.Models.ERole;
import com.odc.backend.Models.Role;
import com.odc.backend.Models.User;
import com.odc.backend.Repository.RoleRepository;
import com.odc.backend.Service.UserService;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(BackendApplication.class, args);

		RoleRepository roleRepos = ctx.getBean(RoleRepository.class);

		UserService userService = ctx.getBean(UserService.class);

		PasswordEncoder encoder=ctx.getBean(PasswordEncoder.class);

		///creation des roles
		if(roleRepos.findByName(ERole.ROLE_CITOYEN)==null){
			// TODO: handle exception
			Role userRole = new Role();
			// userRole.setId(1L);
			userRole.setName(ERole.ROLE_CITOYEN);
			roleRepos.save(userRole);
		};

		if(roleRepos.findByName(ERole.ROLE_ADMIN)==null){
			// TODO: handle exception
			Role userRole = new Role();
			// userRole.setId(1L);
			userRole.setName(ERole.ROLE_ADMIN);
			roleRepos.save(userRole);
		};

		if(roleRepos.findByName(ERole.ROLE_SUPERADMIN)==null){
			// TODO: handle exception
			Role userRole = new Role();
			// userRole.setId(1L);
			userRole.setName(ERole.ROLE_SUPERADMIN);
			roleRepos.save(userRole);
		};
		

		//creation du super Admin
		try {
			userService.getByUsername("Ballo");
		} catch (Exception e) {
			// TODO: handle exception
			User admin=new User();

			admin.setNom("Ballo");
			admin.setPrenom("Ibrahima");
			admin.setUsername("Ballo");
			admin.setPassword(encoder.encode("bababallo") );
			admin.setPoint(0l);
			admin.setNiveau(0l);

			admin.getRoles().add(roleRepos.findByName(ERole.ROLE_SUPERADMIN));
		
			userService.saveUser(admin);
		}
	}

}
