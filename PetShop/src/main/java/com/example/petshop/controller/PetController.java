package com.example.petshop.controller;

import com.example.petshop.entity.Pet;
import com.example.petshop.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
=======
import java.util.Optional;
import java.util.UUID;
>>>>>>> AnhNgo

@Controller
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/pet/detail/{id}")
    public String getPetDetail(@PathVariable("id") String id, Model model) {
        // Lấy tất cả thú cưng
        List<Pet> allPets = petService.getAll();

        // Giới hạn danh sách chỉ lấy 6 thú cưng
        List<Pet> limitPets = allPets.stream()
                .limit(6)
                .collect(Collectors.toList());

        // Lấy chi tiết thú cưng theo ID, nếu không có thì ném ngoại lệ
        Pet petDetail = petService.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pet not found"));

        // Đưa dữ liệu vào model
        model.addAttribute("pets", limitPets);
        model.addAttribute("petDetail", petDetail);

        // Trả về view hiển thị chi tiết thú cưng
        return "/layout/_petDetail";
    }

<<<<<<< HEAD
=======
    @GetMapping("/{id}")
    public Optional<Pet> getPetId(@PathVariable("id") String id) {
        return petService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody Pet pet) {
        pet.setPetID(UUID.randomUUID().toString());
        petService.save(pet);
    }

    @PutMapping("/{id}")
    public void updatePet(@PathVariable("id") String id, @RequestBody Pet pet) {
        pet.setPetID(id);
        petService.save(pet);
    }

    @DeleteMapping("/{id}")
    public void deletePet(@PathVariable("id") String id) {
        petService.deleteById(id);
    }
>>>>>>> AnhNgo
}
