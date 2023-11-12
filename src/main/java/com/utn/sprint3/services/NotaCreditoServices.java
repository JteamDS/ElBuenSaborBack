package com.utn.sprint3.services;

import com.utn.sprint3.Dto.DtoNota;
import com.utn.sprint3.entidades.NotaCredito;

public interface NotaCreditoServices extends BaseServices<NotaCredito,Long> {

    NotaCredito anularFactura(DtoNota dtoNota) throws Exception;
}
