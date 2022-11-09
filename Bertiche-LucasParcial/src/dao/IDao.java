package dao;

import java.util.List;

public interface IDao<T> {

    T guardar(T t);

    void eliminar(Integer id);

    void actualizar(T t);

    T buscar(Integer id);

    List<T> buscarTodos();

}
