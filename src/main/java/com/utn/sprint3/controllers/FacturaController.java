package com.utn.sprint3.controllers;

import com.utn.sprint3.Dto.DtoFactura;
import com.utn.sprint3.entidades.Domicilio;
import com.utn.sprint3.entidades.Factura;
import com.utn.sprint3.services.DomicilioServicesImpl;
import com.utn.sprint3.services.FacturaServicesImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path ="api/v1/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServicesImpl>{


}
