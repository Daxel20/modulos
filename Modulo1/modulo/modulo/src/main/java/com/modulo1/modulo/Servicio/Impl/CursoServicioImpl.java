package com.modulo1.modulo.Servicio.Impl; 
 
import java.util.List; 
 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
 
import com.modulo1.modulo.Modelo.Curso; 
import com.modulo1.modulo.Repositorio.ICursoRepositorio; 
import com.modulo1.modulo.Servicio.ICursoServicio; 
 
@Service 
public class CursoServicioImpl implements ICursoServicio { 
     
    @Autowired 
    private ICursoRepositorio repositorio; 
 
    @Override 
    public List<Curso> listarCursos() { 
        return repositorio.findAll(); 
    } 
 
    @Override 
    public void guardarCurso(Curso curso) { 
        repositorio.save(curso); 
    } 
 
    @Override 
    public void eliminarCurso(Long id) { 
        repositorio.deleteById(id); 
    } 
 
    @Override 
    public Curso obtenerCursoPorId(Long id) { 
        return repositorio.findById(id).orElse(null); 
    } 
}