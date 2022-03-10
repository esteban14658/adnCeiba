package com.ceiba.asistencia.consulta;

import com.ceiba.asistencia.modelo.dto.DtoAsistencia;
import com.ceiba.asistencia.puerto.dao.DaoAsitencia;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarAsistencias {

    private final DaoAsitencia daoAsitencia;

    public ManejadorListarAsistencias(DaoAsitencia daoAsitencia) {
        this.daoAsitencia = daoAsitencia;
    }

    public List<DtoAsistencia> ejecutar(){
        return this.daoAsitencia.listar();
    }
}
