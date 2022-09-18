package ru.sergeysemenov.simple_crud_mvc_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sergeysemenov.simple_crud_mvc_app.entity.Student;
import ru.sergeysemenov.simple_crud_mvc_app.repository.StudentsRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentsRepository repository;

    public Student findById(int id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Student> findAll(){
        return repository.findAll();
    }

    public void deleteById(int id){
        repository.deleteById(id);
    }

    public void saveStudent(Student student){
        repository.save(student);
    }

}
