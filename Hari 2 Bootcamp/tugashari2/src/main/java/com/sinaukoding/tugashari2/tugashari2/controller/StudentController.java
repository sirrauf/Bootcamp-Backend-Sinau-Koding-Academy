package com.sinaukoding.tugashari2.tugashari2.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    @GetMapping("/list-student")
    public List<Student> listStudent() {
        return students;
    }

    @GetMapping("/get-student")
    public Map<String, Object> getStudent(@RequestParam Integer id) {
        Map<String, Object> response = new HashMap<>();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                response.put("status", "success");
                response.put("data", s);
                return response;
            }
        }
        response.put("status", "error");
        response.put("message", "Student tidak ditemukan");
        return response;
    }

    @PostMapping("/add-student")
    public Map<String, Object> addStudent(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();

        if (student.getId() == null || student.getNama() == null ||
                student.getNama().trim().isEmpty()) {
            response.put("status", "error");
            response.put("message", "ID dan Nama tidak boleh kosong");
            return response;
        }

        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                response.put("status", "error");
                response.put("message", "ID sudah ada");
                return response;
            }
        }

        students.add(student);
        response.put("status", "success");
        response.put("message", "Student berhasil ditambahkan");
        response.put("data", student);
        return response;
    }

    @PutMapping("/edit-student")
    public Map<String, Object> editStudent(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();

        if (student.getId() == null || student.getNama() == null ||
                student.getNama().trim().isEmpty()) {
            response.put("status", "error");
            response.put("message", "ID dan Nama tidak boleh kosong");
            return response;
        }

        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                s.setNama(student.getNama());
                response.put("status", "success");
                response.put("message", "Student berhasil diupdate");
                response.put("data", s);
                return response;
            }
        }

        response.put("status", "error");
        response.put("message", "Student tidak ditemukan");
        return response;
    }

    @DeleteMapping("/delete-student")
    public Map<String, Object> deleteStudent(@RequestParam Integer id) {
        Map<String, Object> response = new HashMap<>();
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getId().equals(id)) {
                iterator.remove();
                response.put("status", "success");
                response.put("message", "Student berhasil dihapus");
                return response;
            }
        }

        response.put("status", "error");
        response.put("message", "Student tidak ditemukan");
        return response;
    }
}

class Student {
    private Integer id;
    private String nama;

    public Student() {
    }

    public Student(Integer id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
