
package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    public List<Categoria> getCategorias(boolean activos);
    
    public Categoria getCategoria(Categoria categoria);
    
    public void save(Categoria categoria);//Para insertar o modificar (Si viene el idCategoria o no)
    
    public void delete(Categoria categoria);
}
