--My solutions to the business case

--(There is no specific correct answer, but there ARE ways to do it wrong)



create table managers (
	manager_id serial primary key,
	f_name text,
	l_name text,
	salary int
);


create table robots (
	robot_id serial primary key,
	name text,
	color text,
	manager_id_fk int references managers (manager_id) unique
);

create table employees (
	employee_id serial primary key,
	f_name text,
	l_name text,
	salary int,
	manager_id_fk int references managers(manager_id)
);

create table projects (
	project_id serial primary key,
	project_name text,
	start_date date 
);

create table project_assignments (
	project_assignment_id serial primary key,
	employee_id_fk int references employees(employee_id),
	project_id_fk int references projects(project_id)
);



insert into managers (f_name, l_name, salary) 
			values ('Bob', 'Ross', 100000),
				   ('Rob', 'Boss', 80000);


insert into robots (name, color, manager_id_fk)
			values ('coolbot', 'fuschia', 1),
				   ('funkybot', 'vermilion', 2);

insert into robots (name, color, manager_id_fk)
			values ('coolerbot', 'grey', 2); --this won't work, FK has unique constraint
											 --for the sake of 1-to-1 functionality

		
		
insert into employees (f_name, l_name, salary, manager_id_fk)
			values ('Ben', 'Petruzziello', 30000, 1),
				   ('Bon', 'Potruzziello', 40000, 1);
				  
insert into projects (project_name, start_date)	
			values ('automatic cereal bowl', '1990-05-09'),
				   ('manual cereal bowl', '1992-06-14');
				  
insert into project_assignments (employee_id_fk, project_id_fk)	
			values (1,1),
				   (2,1);
				  
				  

