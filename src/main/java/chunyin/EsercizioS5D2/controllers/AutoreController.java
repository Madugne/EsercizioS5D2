package chunyin.EsercizioS5D2.controllers;

import chunyin.EsercizioS5D2.entities.Autore;
import chunyin.EsercizioS5D2.services.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autori")
public class AutoreController {
    @Autowired
    private AutoreService autoreService;

    @PostMapping
    private Autore saveAutore(@RequestBody Autore body){
        return this.autoreService.saveAutore(body);
    }
    @GetMapping
    private List<Autore> getAllAutori() {return this.autoreService.getUsersList();}

    @GetMapping("/{autoreId}")
    private Autore findAutoreById(@PathVariable int autoreId) {
        return this.autoreService.findById(autoreId);
    }

    @PutMapping("/{autoreId}")
    private Autore findUserByIdAndUpdate(@PathVariable int autoreId, @RequestBody Autore body){
        return this.autoreService.findByIdAndUpdate(autoreId, body);
    }

    @DeleteMapping("/{userId}")
    private void findUserByIdAndDelete(@PathVariable int userId){
        this.autoreService.findByIdAndDelete(userId);
    }
}
