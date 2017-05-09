CREATE TABLE students (
	student_id INT,
	name VARCHAR(50),
	PRIMARY KEY (student_id)
);

CREATE TABLE exams (
	exam_id INT,
	name VARCHAR(50),
	PRIMARY KEY (exam_id)
);

CREATE TABLE students_exams (
	student_id INT,
	exam_id INT,
	CONSTRAINT pk_students_exams PRIMARY KEY (student_id, exam_id),
	CONSTRAINT fk_students_exams_students FOREIGN KEY (student_id)
	REFERENCES students (student_id),
	CONSTRAINT fk_students_exams_exams FOREIGN KEY (exam_id)
	REFERENCES exams (exam_id)
);
