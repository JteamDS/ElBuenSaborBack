package com.utn.sprint3.controllers;


import com.utn.sprint3.entidades.BaseEntidad;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.Serializable;
public interface BaseController <E extends BaseEntidad, ID extends Serializable> {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getAll(Pageable pageable) throws Exception;
    public ResponseEntity<?> getOne (@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody E entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody E entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}