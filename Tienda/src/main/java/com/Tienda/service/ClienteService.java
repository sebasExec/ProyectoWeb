
package com.Tienda.service;

import com.Tienda.domain.Cliente;
import java.util.List;

public interface ClienteService {
    public List<Cliente> getClientes();
    
    public Cliente getCliente(Cliente cliente);
    
    public void save(Cliente cliente);//Para insertar o modificar (Si viene el idCliente o no)
    
    public void delete(Cliente cliente);
    
    public List<Cliente> findByApellidos(String apellidos);
    public List<Cliente> getClienteNombre(String nombre);

    
    
}
