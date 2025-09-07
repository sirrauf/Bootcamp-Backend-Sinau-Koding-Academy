package com.sinaukoding.tugashari3.tugashari3.controller;

import com.sinaukoding.tugashari3.tugashari3.entity.Student;
//import com.sinaukoding.tugashari2.tugashari2.entity.Mapel;
//import com.sinaukoding.tugashari2.tugashari2.entity.Guru;
//import com.sinaukoding.tugashari2.tugashari2.entity.Kelas;
import com.sinaukoding.tugashari3.tugashari3.repository.MapelRepository;
import com.sinaukoding.tugashari3.tugashari3.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;
    private final MapelRepository mapelRepository;

    public StudentController(StudentRepository studentRepository,MapelRepository mapelRepository) {
        this.studentRepository = studentRepository;
        this.mapelRepository = mapelRepository;
    }

    @PostMapping("add-student")
    public String addStudent(@RequestBody StudentRequestRecord request) {
        var student = new Student();
        student.setNama(request.nama());
        student.setCreatedDate(LocalDateTime.now());
        student.setModifiedDate(LocalDateTime.now());
        studentRepository.save(student);

        return "Berhasil menambahkan data";
    }

    @PutMapping("edit-student")
    public String editStudent(@RequestBody StudentRequestRecord request) {
        var student = studentRepository.findById(request.id()).orElse(null);
        if (student == null) {
            return "Data student dengan Id " + request.id() + " tidak ditemukan";
        } else {
            student.setNama(request.nama());
            student.setModifiedDate(LocalDateTime.now());
            studentRepository.save(student);
            return "Berhasil mengubah data";
        }
    }

    @GetMapping("list-student")
    public List<StudentDto> listStudent() {
        List<Student> listStudent = studentRepository.findAll();
        return listStudent.stream().map(student -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setNama(student.getNama());
            return studentDto;
        }).toList();
    }

    @GetMapping("get-student")
    public StudentDto getStudent(@RequestParam Integer id) {
        var student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(student.getId());
            studentDto.setNama(student.getNama());
            return studentDto;
        }
        throw new RuntimeException("Data student tidak ditemukan");
    }

    @DeleteMapping("delete-student")
    public String deleteStudent(@RequestParam Integer id) {
        var student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return "Data student dengan Id " + id + " tidak ditemukan";
        } else {
            studentRepository.deleteById(id);
            return "Berhasil menghapus data";
        }
    }

    //@PostMapping("add-mapel")
    //public String addMapel(@RequestBody MapelRequestRecord request) {
      //  var mapel = new Mapel();
       // mapel.setNama(request.nama());
        //mapel.setDeskripsi(request.deskripsi());
        //mapel.setCreatedDate(LocalDateTime.now());
        //mapel.setModifiedDate(LocalDateTime.now());
        //mapelRepository.save(mapel);

        //return "Berhasil menambahkan Mata Pelajaran";
   // }
    //@PutMapping("edit-mapel")
    //public String editMapel(@RequestBody MapelRequestRecord request) {
      //  var mapel = mapelRepository.findById(request.id()).orElse(null);
        //if (mapel == null) {
          //  return "Data student dengan Id " + request.id() + " tidak ditemukan";
        //} else {
          //  mapel.setNama(request.nama());
            //mapel.setModifiedDate(LocalDateTime.now());
            //mapelRepository.save(mapel);
            //return "Berhasil mengubah data";
        //}
    //}
    //@GetMapping("list-mapel")
    //public List<StudentDto> listMapel() {
      //  List<Mapel> listMapel = mapelRepository.findAll();
        //return listMapel.stream().map(mapel -> {
          //  StudentDto studentDto = new StudentDto();
            //studentDto.setId(mapel.getId());
            //studentDto.setNama(mapel.getNama());
           // return studentDto;
        //}).toList();
   // }
    //@GetMapping("get-mapel")
    //public StudentDto getMapel(@RequestParam Integer id) {
      //  var mapel = mapelRepository.findById(id).orElse(null);
        //if (mapel != null) {
          //  StudentDto studentDto = new StudentDto();
            //studentDto.setId(mapel.getId());
            //studentDto.setNama(mapel.getNama());
            //studentDto.setDeskripsi(mapel.getDeskripsi());
            //return studentDto;
       // }
        //throw new RuntimeException("Data mapel tidak ditemukan");
   // }
    //@DeleteMapping("delete-mapel")
    //public String deleteMapel(@RequestParam Integer id) {
      //  var mapel = mapelRepository.findById(id).orElse(null);
       // if (mapel == null) {
         //   return "Data mapel dengan Id " + id + " tidak ditemukan";
        //} else {
          //  mapelRepository.deleteById(id);
            //return "Berhasil menghapus data";
       // }
    }
//}
