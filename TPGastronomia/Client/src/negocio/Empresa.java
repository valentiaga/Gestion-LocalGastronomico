package negocio;

import exceptions.ContrasenaIncorrecta_Exception;
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
    
    public void modificaOperario (Operario operario, String NyA, String userName, String password, boolean activo) throws UserNameRepetido_Exception {}
    
}
