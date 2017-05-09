CREATE TABLE teachers(
	teacher_id INT PRIMARY KEY,
	name VARCHAR(50),
	manager_id INT,
	CONSTRAINT fk_teachers_teachers FOREIGN KEY(manager_id)
	REFERENCES teachers(teacher_id)
);
