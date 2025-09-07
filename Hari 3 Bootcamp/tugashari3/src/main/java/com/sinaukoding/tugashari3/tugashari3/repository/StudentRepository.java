package com.sinaukoding.tugashari3.tugashari3.repository;

import com.sinaukoding.tugashari3.tugashari3.entity.Student;
//import com.sinaukoding.tugashari2.tugashari2.entity.Mapel;
//import com.sinaukoding.tugashari2.tugashari2.entity.Guru;
//import com.sinaukoding.tugashari2.tugashari2.entity.Kelas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
