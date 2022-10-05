package negocio;

import exceptions.ContrasenaIncorrecta_Exception;
import exceptions.NoExisteOperario_Exception;
import exceptions.UserNameIncorrecto_Exception;

import exceptions.UserNameRepetido_Exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
/**
 * Clase Singleton que representa a la empresa gastronomica.
 */
public class Empresa {
    
    private String nombre;
    private ArrayList<Mozo> mozos; 
    private ArrayList<Producto> productos;
    private ArrayList<Operario> operarios;
    private ArrayList<Mesa> mesas; 
    private static Empresa instance = null;
    private Map <String, String> map = new HashMap<String, String>();
    
    public Empresa getInstance(){
        if(instance == null)
            instance = new Empresa();
        return instance;
    }
    /**
     * Metodo que registra un nuevo operario en el sistema. <br>
     * Post: Agrega un nuevo operario al HashMap
     * @param NyA
     * @param userName
     * @param password
     * @throws UserNameRepetido_Exception si el nombre de usuario ingresado esta asociado a otra cuenta.
     */
    public void registro(String NyA,String userName,String password) throws UserNameRepetido_Exception{}
    
    /**
     *  metodo para logear un operario. <br>
     *  Pre: El operario debe estar activo <br>
     *  Pre: El campo password debe contener entre 6 y 12 caracteres. Con al menos un digito y una mayuscula <br>
     *  Post: El operario queda logeado. <br>
     * @param userName
     * @param password
     * @return
     * @throws UserNameIncorrecto_Exception
     * @throws ContrasenaIncorrecta_Exception
     */
    
    public Operario login(String userName,String password)throws UserNameIncorrecto_Exception,ContrasenaIncorrecta_Exception {return null;}
    
    /**
     * Metodo para modificar algun atributo del operario en cuestion.
     * Pre: El campo NyA debe ser distinto de null y distinto de vacio.
     * Pre: El campo userName debe ser distinto de null y distinto de vacio.
     * Pre: El campo password debe ser distinto de null y distinto de vacio.
     * Pre: El campo activo debe ser distinto de null y distinto de vacio.
     * @param operario
     * @param NyA
     * @param userName
     * @param password
     * @param activo
     * @throws UserNameRepetido_Exception si el nombre de usuario ingresado esta asociado a otra cuenta.
     */
    public void modificaOperario (Operario operario, String NyA, String userName, String password, boolean activo) throws UserNameRepetido_Exception {}
    
    /**
     * Metodo para eliminar un operario del sistema. <br>
     * Pre: El operario debe ser dsitinto de null o vacio. <br>
     * Post: Se elimina el operario del sistema.
     * @param operario
     * @throws NoExisteOperario_Exception si no esta registrado el operario en el sistema.
     */
    public void eliminaOperario (Operario operario)throws NoExisteOperario_Exception{}
    
}
