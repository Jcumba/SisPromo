package servicio;

import dao.UbigeImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "autocompletar")
@SessionScoped
public class Autocompletar implements Serializable {

    public List<String> completeUbigeo(String query) throws Exception {
        UbigeImpl ubigeo = new UbigeImpl();
        return ubigeo.autocompleteUbigeo(query);
    }
}
