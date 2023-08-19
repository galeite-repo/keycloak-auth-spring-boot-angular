package com.tutorial.keycloakbackend.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.keycloakbackend.dto.ResponseMessage;
import com.tutorial.keycloakbackend.model.Foo;

@RestController
@RequestMapping("/foo")
@CrossOrigin
public class FooController {
    List<Foo> foos = Stream.of(new Foo(1, "foo 1"), new Foo(2, "foo 2"), new Foo(3, "foo 3"))
            .collect(Collectors.toList());

    @RolesAllowed("backend-user")
    @GetMapping("/list")
    public ResponseEntity<List<Foo>> list() {
        return new ResponseEntity<List<Foo>>(foos, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    @RolesAllowed("backend-user")
    public ResponseEntity<Foo> detail(@PathVariable("id") Integer id) {
        Foo foo = foos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        return new ResponseEntity<Foo>(foo, HttpStatus.OK);
    }

    @PostMapping("/create")
    @RolesAllowed("backend-admin")
    public ResponseEntity<?> create(@RequestBody Foo foo) {
        int maxIndex = foos.stream().max(Comparator.comparing(m -> m.getId())).get().getId();
        foo.setId(maxIndex + 1);
        foos.add(foo);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("criado"), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @RolesAllowed("backend-admin")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Foo foo) {
        Foo fooUpdate = foos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        fooUpdate.setName(foo.getName());
        foos.add(fooUpdate);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("atualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @RolesAllowed("backend-admin")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Foo foo = foos.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        foos.remove(foo);
        return new ResponseEntity<ResponseMessage>(new ResponseMessage("Deletado"), HttpStatus.OK);
    }

}
