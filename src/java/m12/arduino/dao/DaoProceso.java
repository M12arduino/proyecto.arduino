/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m12.arduino.dao;

import java.util.List;
import java.util.Map;
import m12.arduino.domain.Proceso;

/**
 *
 * @author Jordi
 */
public interface DaoProceso {

    public Proceso buscarProceso(String codigo);
    
    public Proceso buscarProceso(Map<String, Object> whereMap);

    public List<Proceso> obtenerListaProcesos(Map<String, Object> whereMap);

    public List<Proceso> obtenerListaProcesos();

    public Proceso guardarProceso(Proceso pro);

    public Proceso actualizarProceso(Proceso pro);
    
    public void eliminarProceso(Proceso pro);
}
