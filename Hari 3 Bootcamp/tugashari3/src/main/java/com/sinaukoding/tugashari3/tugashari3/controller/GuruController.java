package com.sinaukoding.tugashari3.tugashari3.controller;

//import com.sinaukoding.tugashari2.tugashari2.entity.Student;
//import com.sinaukoding.tugashari2.tugashari2.entity.Mapel;
import com.sinaukoding.tugashari3.tugashari3.entity.Guru;
//import com.sinaukoding.tugashari2.tugashari2.repository.MapelRepository;
import com.sinaukoding.tugashari3.tugashari3.repository.GuruRepository;
//import com.sinaukoding.tugashari2.tugashari2.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/guru")
public class GuruController {

    private final GuruRepository guruRepository;

    public GuruController(GuruRepository guruRepository) {
        this.guruRepository = guruRepository;
    }

    // CREATE
    @PostMapping("add-guru")
    public String addGuru(@RequestBody GuruRequestRecord request) {
        var guru = new Guru();
        guru.setNama(request.nama());
        guru.setNip(request.nip());
        guru.setNomorHp(request.nomorHp());
        guru.setAlamat(request.alamat());
        guru.setCreatedDate(LocalDateTime.now());
        guru.setModifiedDate(LocalDateTime.now());
        guruRepository.save(guru);

        return "Berhasil menambahkan Guru";
    }

    // UPDATE
    @PutMapping("edit-guru")
    public String editGuru(@RequestBody GuruRequestRecord request) {
        var guru = guruRepository.findById(request.id()).orElse(null);
        if (guru == null) {
            return "Data guru dengan Id " + request.id() + " tidak ditemukan";
        } else {
            guru.setNama(request.nama());
            guru.setNip(request.nip());
            guru.setNomorHp(request.nomorHp());
            guru.setAlamat(request.alamat());
            guru.setModifiedDate(LocalDateTime.now());
            guruRepository.save(guru);
            return "Berhasil mengubah data Guru";
        }
    }

    // READ (List)
    @GetMapping("list-guru")
    public List<GuruDto> listGuru() {
        List<Guru> listGuru = guruRepository.findAll();
        return listGuru.stream().map(guru -> {
            GuruDto dto = new GuruDto();
            dto.setId(guru.getId());
            dto.setNama(guru.getNama());
            dto.setNip(guru.getNip());
            dto.setNomorHp(guru.getNomorHp());
            dto.setAlamat(guru.getAlamat());
            return dto;
        }).toList();
    }

    // READ (By Id)
    @GetMapping("get-guru")
    public GuruDto getGuru(@RequestParam Integer id) {
        var guru = guruRepository.findById(id).orElse(null);
        if (guru != null) {
            GuruDto dto = new GuruDto();
            dto.setId(guru.getId());
            dto.setNama(guru.getNama());
            dto.setNip(guru.getNip());
            dto.setNomorHp(guru.getNomorHp());
            dto.setAlamat(guru.getAlamat());
            return dto;
        }
        throw new RuntimeException("Data guru tidak ditemukan");
    }

    // DELETE
    @DeleteMapping("delete-guru")
    public String deleteGuru(@RequestParam Integer id) {
        var guru = guruRepository.findById(id).orElse(null);
        if (guru == null) {
            return "Data guru dengan Id " + id + " tidak ditemukan";
        } else {
            guruRepository.deleteById(id);
            return "Berhasil menghapus data Guru";
        }
    }
}
