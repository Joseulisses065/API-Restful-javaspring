package com.aula.worshopmongo.resources;

import com.aula.worshopmongo.domain.User;
import com.aula.worshopmongo.dto.UserDTO;
import com.aula.worshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> dtoList = list.stream().map(x->new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<UserDTO> findById(@PathVariable String id){
        User user = service.findById(id);
        UserDTO dto = new UserDTO(user);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDto){
        User user = service.fromDto(userDto);
        user = service.insert(user);
        //this code will get the uri of inserted object
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return  ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
        User user = service.fromDto(objDto);
        user.setId(id);
        user = service.update(user);
        return  ResponseEntity.noContent().build();
    }
}
