package ru.sergeysemenov.simple_crud_mvc_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sergeysemenov.simple_crud_mvc_app.entity.Student;

@Repository
public interface StudentsRepository extends JpaRepository<Student,Integer> {
}
