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

import modelo.Mozo.estado;

import modelo.Operario;
import modelo.Producto;
import modelo.Sueldo;

/**
 * Clase Singleton que representa a la empresa gastronomica.
 */
public class Sistema {
    
//    enum Estado{activo,
//                deFranco,
//                ausente}
    
    private String nombre;
    private ArrayList<Mozo> mozos; 
    private ArrayList<Producto> productos;
    private ArrayList<Operario> operarios;
    private ArrayList<Mesa> mesas; 
    private static Sistema instance = null;
    private Map <String, String> map = new HashMap<String, String>();
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
    
    /**
     * Metodo para modificar algun atributo del operario en cuestion. <br>
     * Pre: El campo NyA debe ser distinto de null y distinto de vacio. <br>
     * Pre: El campo userName debe ser distinto de null y distinto de vacio. <br>
     * Pre: El campo password debe ser distinto de null y distinto de vacio. <br>
     * Pre: El campo activo debe ser distinto de null y distinto de vacio. <br>
     * @param operario Representa al operario a modificar. <br>
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
     * Post: Se elimina el operario del sistema. <br>
     * @param operario Representa a un operario a eliminar. <br>
     * @throws NoExisteOperario_Exception si no esta registrado el operario en el sistema.
     */
    public void eliminaOperario (Operario operario)throws NoExisteOperario_Exception{}
    
    public void agregaMozo(Mozo mozo){}
    
    public void modificaMozo(Mozo mozo){}
    
    public void modificaMozo(String NyA){}
    
    public void modificaMozo(int cantHijos){}
    
   // public void modificaMozo(Estado estado){}
    
    public void eliminaMozo(Mozo mozo){}
    
}
