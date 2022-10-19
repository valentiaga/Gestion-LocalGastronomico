package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.UserNameIncorrecto_Exception;
import excepciones.UserNameRepetido_Exception;
import modelo.Estado;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.Sueldo;

/**
 * Clase Singleton que representa a la empresa gastronomica.
 */
public class Sistema {
    
    private HashMap<String,Mozo> mozos; 
    private HashMap<Integer,Producto> productos;
    private HashMap<String,Operario> operarios;
    private ArrayList<Mesa> mesas; 
    private static Sistema instance = null;
    private Sueldo sueldo;
    
    public Sistema getInstance(){
        if(instance == null)
            instance = new Sistema();
        return instance;
    }

/**
     * Metodo que configura los datos basicos de funcionamiento de local. <br>
     * @param nombre 
     * @param mozos
     * @param productos
     * @param operarios
     * @param mesas
     * @param map
     */
    public void configuraLocal(String nombre, ArrayList<Mozo> mozos, ArrayList<Producto> productos, ArrayList<Operario> operarios,
                   ArrayList<Mesa> mesas,Map<String, String> map,Sueldo sueldo) {
        this.nombre = nombre;
        this.mozos = mozos;
        this.productos = productos;
        this.operarios = operarios;
        this.mesas = mesas;
        this.map = map;
        this.sueldo = sueldo;
    }
    
    
    /**
     * Metodo que registra un nuevo operario en el sistema. <br>
     * Post: Agrega un nuevo operario al HashMap 
     * @param NyA atributo correspondiente al nombre y apellido del operario que desea registrarse. <br>
     * @param userName atributo correspondiente al nombre de usuario que usara el operario para el login. <br>
     * @param password atributo que representa la contrasena y que corresponde al userName. <br>
     * @throws UserNameRepetido_Exception si el nombre de usuario ingresado esta asociado a otra cuenta.
     */
    public void registro(String NyA,String userName,String password) throws UserNameRepetido_Exception{}
    
    /**
     *  metodo para logear un operario. <br>
     *  Pre: El operario debe estar activo <br>
     *  Pre: El campo password debe contener entre 6 y 12 caracteres. Con al menos un digito y una mayuscula <br>
     *  Post: El operario queda logeado. <br>
     * @param userName utilizado para logear al usuario. <br>
     * @param password  correspondiente al userName. <br>
     * @return Retorna un objeto de la clase Operario. <br>
     * @throws UserNameIncorrecto_Exception
     * @throws ContrasenaIncorrecta_Exception
     */
    
    public Operario login(String userName,String password)throws UserNameIncorrecto_Exception,ContrasenaIncorrecta_Exception {return null;}
    
 
    public void modificaOperarioNyA (String userName, String NyA){}
    
    public void modificaOperarioUsername (String userName, String newUserName) throws UserNameRepetido_Exception {}
    
    public void modificaOperarioPassword (String userName, String password){}
    
    public void modificaOperarioEstado (String userName, boolean activo){}
    


    public void eliminaOperario (String userName)throws NoExisteOperario_Exception{}
    

    public void agregaMozo(String NyA, GregorianCalendar fecha, int cantHijos, Estado estado){}


    public void modificaMozoNyA(String NyA, String newNyA){}


    public void modificaMozoCantHijos(String NyA, int cantHijos){}
    

    public void modificaMozoEstado(String NyA, Estado estado){}
    
    public void eliminaMozo(String NyA) throws NoExisteMozo_Exception {}
    
    
}
