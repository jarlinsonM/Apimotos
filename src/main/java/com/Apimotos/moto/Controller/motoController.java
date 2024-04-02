package com.Apimotos.moto.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Apimotos.moto.model.Moto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/motos")

public class motoController {
    private List<Moto>motos;

    public motoController(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Moto[] motosArray = objectMapper.readValue(new ClassPathResource("motos.json")
            .getFile(),Moto[].class);
            motos = new ArrayList<>(Arrays.asList(motosArray));
        } catch (IOException e) {
            e.printStackTrace();
            motos = new ArrayList<>();
        }
    }
    
    @GetMapping
    public List<Moto> getAllMotos(){
        return motos;
    }
    
    @GetMapping("/{codigo}")
    public Moto getMotoBycodigo(@PathVariable Long codigo){
        return motos.stream().filter(motos -> motos.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
    
    @PostMapping
    public Moto createMoto(@RequestBody Moto moto){
        motos.add(moto);
        return moto;
    }
    
    @PutMapping("/{codigo}")
    public Moto updateMoto(@PathVariable Long codigo, @RequestBody Moto updateMoto){
        Moto moto = getMotoBycodigo(codigo);
        if(moto != null){
            moto.setPlaca(updateMoto.getPlaca());
            moto.setMarca(updateMoto.getMarca());
            moto.setNombre(updateMoto.getNombre());
            return moto;
        }
        return null;
    }

    @DeleteMapping("/{codigo}")
    public void Eliminarmoto(@PathVariable Long codigo){
        motos.removeIf(motos -> motos.getCodigo().equals(codigo));

    }

}
