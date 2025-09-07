package com.sinaukoding.tugashari3.tugashari3.controller;

//import com.sinaukoding.tugashari2.tugashari2.entity.Student;
//import com.sinaukoding.tugashari2.tugashari2.entity.Mapel;
//import com.sinaukoding.tugashari2.tugashari2.entity.Guru;
import com.sinaukoding.tugashari3.tugashari3.entity.Kelas;
//import com.sinaukoding.tugashari2.tugashari2.repository.MapelRepository;
import com.sinaukoding.tugashari3.tugashari3.repository.KelasRepository;
//import com.sinaukoding.tugashari2.tugashari2.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/kelas")
public class KelasController {

    //private final StudentRepository studentRepository;
    private final KelasRepository kelasRepository;

    public KelasController(KelasRepository kelasRepository) {
        //this.studentRepository = studentRepository;
        this.kelasRepository = kelasRepository;
    }

    //@PostMapping("add-student")
    //public String addStudent(@RequestBody StudentRequestRecord request) {
    // var student = new Student();
    //student.setNama(request.nama());
    //student.setCreatedDate(LocalDateTime.now());
    //student.setModifiedDate(LocalDateTime.now());
    // studentRepository.save(student);

    //return "Berhasil menambahkan data";
    //}

    //@PutMapping("edit-student")
    //public String editStudent(@RequestBody StudentRequestRecord request) {
    //  var student = studentRepository.findById(request.id()).orElse(null);
    // if (student == null) {
    //   return "Data student dengan Id " + request.id() + " tidak ditemukan";
    //} else {
    //  student.setNama(request.nama());
    //student.setModifiedDate(LocalDateTime.now());
    //studentRepository.save(student);
    // return "Berhasil mengubah data";
    // }
    // }

    //@GetMapping("list-student")
    //public List<StudentDto> listStudent() {
    //  List<Student> listStudent = studentRepository.findAll();
    //return listStudent.stream().map(student -> {
    //  StudentDto studentDto = new StudentDto();
    //studentDto.setId(student.getId());
    //studentDto.setNama(student.getNama());
    //return studentDto;
    // }).toList();
    // }

    //@GetMapping("get-student")
    //public StudentDto getStudent(@RequestParam Integer id) {
    //  var student = studentRepository.findById(id).orElse(null);
    // if (student != null) {
    //    StudentDto studentDto = new StudentDto();
    //  studentDto.setId(student.getId());
    // studentDto.setNama(student.getNama());
    // return studentDto;
    //}
    //throw new RuntimeException("Data student tidak ditemukan");
    // }

    //@DeleteMapping("delete-student")
    //public String deleteStudent(@RequestParam Integer id) {
    //  var student = studentRepository.findById(id).orElse(null);
    // if (student == null) {
    //   return "Data student dengan Id " + id + " tidak ditemukan";
    // } else {
    //   studentRepository.deleteById(id);
    // return "Berhasil menghapus data";
    // }
    // }

    @PostMapping("add-kelas")
    public String addKelas(@RequestBody KelasRequestRecord request) {
        var kelas = new Kelas();
        kelas.setNama(request.nama());
        kelas.setDeskripsi(request.deskripsi());
        kelas.setKapasitas(request.kapasitas());
        kelas.setCreatedDate(LocalDateTime.now());
        kelas.setModifiedDate(LocalDateTime.now());
        kelasRepository.save(kelas);

        return "Berhasil menambahkan Kelas";
    }
    @PutMapping("edit-kelas")
    public String editKelas(@RequestBody KelasRequestRecord request) {
        var kelas = kelasRepository.findById(request.id()).orElse(null);
        if (kelas == null) {
            return "Data kelas dengan Id " + request.id() + " tidak ditemukan";
        } else {

            kelas.setNama(request.nama());
            kelas.setDeskripsi(request.deskripsi());
            kelas.setKapasitas(request.kapasitas());
            kelas.setModifiedDate(LocalDateTime.now());
            kelasRepository.save(kelas);
            return "Berhasil mengubah data";
        }
    }
    @GetMapping("list-kelas")
    public List<KelasDto> listKelas() {
        List<Kelas> listKelas = kelasRepository.findAll();
        return listKelas.stream().map(kelas -> {
            KelasDto kelasDto = new KelasDto();
            kelasDto.setId(kelas.getId());
            kelasDto.setNama(kelas.getNama());
            kelasDto.setDeskripsi(kelas.getDeskripsi());
            kelasDto.setKapasitas(kelas.getKapasitas());
            return kelasDto;
        }).toList();
    }

    @GetMapping("get-kelas")
    public KelasDto getKelas(@RequestParam Integer id) {
        var kelas = kelasRepository.findById(id).orElse(null);
        if (kelas != null) {
            KelasDto kelasDto = new KelasDto();
            kelasDto.setId(kelas.getId());
            kelasDto.setNama(kelas.getNama());
            kelasDto.setDeskripsi(kelas.getDeskripsi());
            return kelasDto;
        }
        throw new RuntimeException("Data mapel tidak ditemukan");
    }
    @DeleteMapping("delete-kelas")
    public String deleteKelas(@RequestParam Integer id) {
        var kelas = kelasRepository.findById(id).orElse(null);
        if (kelas == null) {
            return "Data mapel dengan Id " + id + " tidak ditemukan";
        } else {
            kelasRepository.deleteById(id);
            return "Berhasil menghapus data";
        }
    }
}
