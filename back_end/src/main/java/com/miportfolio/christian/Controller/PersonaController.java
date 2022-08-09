package com.miportfolio.christian.Controller;

import com.miportfolio.christian.Entity.Persona;
import com.miportfolio.christian.InterFace.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
        @GetMapping("personas/traer")
        public List<Persona> getPersona(){
            return ipersonaService.getPersona();
        }
        
        @PostMapping("/personas/crear")
        public String createPersona(@RequestBody Persona persona){
            ipersonaService.savePersona(persona);
            return "El usuario fue creado correctamente";
        }
        
        @DeleteMapping("/personas/borrar (id)")
        public String deletePersona(@PathVariable long id){
            ipersonaService.deletePersona(id);
            return "La usuario fue eliminada correctamente";
        }
        
        @PutMapping("/personas/editar/(id)")
        public Persona editPersona(@PathVariable Long id,
                                   @RequestParam("nombre")String nuevoNombre,
                                   @RequestParam("apellido")String nuevoApellido,
                                   @RequestParam("img")String nuevoImg){
            Persona persona = ipersonaService.findPersona(id);
            persona.setNombre(nuevoNombre);
            persona.setApellido(nuevoApellido);
            persona.setImg(nuevoImg);                   
            
            ipersonaService.savePersona(persona);
            return persona;
}
                                       
}