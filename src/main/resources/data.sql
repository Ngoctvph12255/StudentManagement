-- Thêm dữ liệu vào bảng Departments
INSERT INTO Departments (department_id, department_name) VALUES (1, 'Computer Science');
INSERT INTO Departments (department_id, department_name) VALUES (2, 'Mathematics');
INSERT INTO Departments (department_id, department_name) VALUES (3, 'Physics');
INSERT INTO Departments (department_id, department_name) VALUES (4, 'Chemistry');
INSERT INTO Departments (department_id, department_name) VALUES (5, 'Biology');

-- Thêm dữ liệu vào bảng Instructors
INSERT INTO Instructors (instructor_id, instructor_name, department_id) VALUES (1, 'Dr. John Doe', 1);
INSERT INTO Instructors (instructor_id, instructor_name, department_id) VALUES (2, 'Dr. Jane Smith', 2);
INSERT INTO Instructors (instructor_id, instructor_name, department_id) VALUES (3, 'Dr. Emily Johnson', 3);
INSERT INTO Instructors (instructor_id, instructor_name, department_id) VALUES (4, 'Dr. Michael Brown', 4);
INSERT INTO Instructors (instructor_id, instructor_name, department_id) VALUES (5, 'Dr. Sarah Davis', 5);

-- Thêm dữ liệu vào bảng Courses
INSERT INTO Courses (course_id, course_name, department_id) VALUES (1, 'Introduction to Programming', 1);
INSERT INTO Courses (course_id, course_name, department_id) VALUES (2, 'Data Structures', 1);
INSERT INTO Courses (course_id, course_name, department_id) VALUES (3, 'Calculus I', 2);
INSERT INTO Courses (course_id, course_name, department_id) VALUES (4, 'Linear Algebra', 2);
INSERT INTO Courses (course_id, course_name, department_id) VALUES (5, 'Quantum Mechanics', 3);

-- Thêm dữ liệu vào bảng Students
INSERT INTO Students (student_id, student_name, birth_date, gender, department_id) VALUES (1, 'Alice', TO_DATE('2000-01-15', 'YYYY-MM-DD'), 'F', 1);
INSERT INTO Students (student_id, student_name, birth_date, gender, department_id) VALUES (2, 'Bob', TO_DATE('1999-05-20', 'YYYY-MM-DD'), 'M', 2);
INSERT INTO Students (student_id, student_name, birth_date, gender, department_id) VALUES (3, 'Charlie', TO_DATE('2001-03-25', 'YYYY-MM-DD'), 'M', 3);
INSERT INTO Students (student_id, student_name, birth_date, gender, department_id) VALUES (4, 'Daisy', TO_DATE('2000-07-30', 'YYYY-MM-DD'), 'F', 4);
INSERT INTO Students (student_id, student_name, birth_date, gender, department_id) VALUES (5, 'Eve', TO_DATE('1998-11-10', 'YYYY-MM-DD'), 'F', 5);

-- Thêm dữ liệu vào bảng Enrollments
INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (1, 1, 1, TO_DATE('2023-01-01', 'YYYY-MM-DD'));
INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (2, 2, 3, TO_DATE('2023-01-01', 'YYYY-MM-DD'));
INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (3, 3, 5, TO_DATE('2023-01-01', 'YYYY-MM-DD'));
INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (4, 4, 4, TO_DATE('2023-01-01', 'YYYY-MM-DD'));
INSERT INTO Enrollments (enrollment_id, student_id, course_id, enrollment_date) VALUES (5, 5, 2, TO_DATE('2023-01-01', 'YYYY-MM-DD'));
