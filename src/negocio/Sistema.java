/*
 * Los estados de mozo y operario los maneja cada uno al final del dia o el sistema / admin??
 * Si esta en el contrato lo consideramos como una precondicion? Por lo tanto no lanzamos excepcion (producto)
 * 
 */

package negocio;

import java.util.GregorianCalendar;
import java.util.HashMap;

import excepciones.ContrasenaIncorrecta_Exception;
import excepciones.NoExisteID_Exception;
import excepciones.NoExisteMesa_Exception;
import excepciones.NoExisteMozo_Exception;
import excepciones.NoExisteOperario_Exception;
import excepciones.NyAExistente_Exception;
import excepciones.PromoIdRepetido_Exception;
import excepciones.UserNameIncorrecto_Exception;
import excepciones.UserNameRepetido_Exception;
import modelo.Enumerados;
import modelo.Mesa;
import modelo.Mozo;
import modelo.Operario;
import modelo.Producto;
import modelo.PromocionProd;
import modelo.Sueldo;

/**
 * Clase Singleton que representa a la empresa gastronomica.
 */
public class Sistema {
    
    private HashMap<String,Mozo> mozos = new HashMap<>(); 
    private HashMap<Integer,Producto> productos = new HashMap<Integer,Producto>();
    private HashMap<String,Operario> operarios = new HashMap<String, Operario>();
    private HashMap<Integer,Mesa> mesas = new HashMap<Integer,Mesa>(); 
    private HashMap<Integer, PromocionProd> promocionProds = new HashMap<Integer, PromocionProd>();
    private Operario operarioActual;
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
    /*
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
    */
    
    
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
     * metodo utilizado para modificar el o los campos de Operario que se deseen.
     * @param NyA nombre y apellido nuevo.
     * @param userName nuevo nombre de usuario.
     * @param password nueva contrasenia.
     * @param activo nuevo estado del Operario.
     * @throws UserNameRepetido_Exception Se lanza si el nuevo nombre de usuario ya existe en el sistema.
     */
    public void modificaOperario (String NyA, String userName, String password, boolean activo) throws UserNameRepetido_Exception 
    {
        //llamamos al operario actual y modificamos a ese
        //El estado se modifica?
    }
    
    
    public void eliminaOperario (){ //consideramos que el operario puede eliminarse por sí mismo al igual que puede eliminarlo el admin.
        //se llama al actual y se lo elimina
    }
    
    /**
     * metodo para modificar el/los atributos del mozo que se desee/n.
     * @param NyA nombre y apellido nuevo.
     * @param cantHijos nueva cantidad de hijos.
     * @param mozo que se desea modificar.
     */
    public void modificaMozo (Mozo mozo, String NyA, int cantHijos){ //el estado lo modifica el o el sistema??
        //el estado se modifica?
    }

    /**
     * metodo para modificar el/los atributos que se deseen del producto.
     * @param id correspondiente al producto. <br>
     * @param nombre nuevo nombre del producto. <br>
     * @param precioCosto nuevo precio de costo. <br>
     * @param precioVenta nuevo precio de venta. <br>
     * @param stockInicial nuevo stock inicial. <br>
     * @throws NoExisteID_Exception Se lanza si el ID ingresado no esta relacionado a ningun producto del sistema.
     */
    public void modificaProducto (int id, String nombre, double precioCosto, double precioVenta, int stockInicial) throws NoExisteID_Exception{}
 
 
 /**
     * metodo para modificar el/los atributos que se deseen de la mesa.
     * @param nroMesa ID de mesa. <br>
     * @param cantSillas cantidad de personas que ocuparan la mesa. <br>
     * @param libre estado de la mesa. <br>
     * @throws NoExisteMesa_Exception Se lanza si el ID no corresponde con ninguna mesa cargada en el sistema. 
     */
    public void modificaMesa (int nroMesa, int cantSillas, boolean libre)throws NoExisteMesa_Exception{} //tira excepcion de no existe mesa? O vamos a tener un mapa de mesas 
    
    
    /**
     * metodo para agregar un nuevo producto en promo al menu. <br>
     * Pre: El producto debe ser distinto de null. <br>
     * Pre: La promo aplica2x1 y 
     * @param idProd ID del producto al que se le aplica la promo. <br>
     * @param dia de la semana en el que estara disponible la promo. <br>
     * @param aplica2x1 tipo de descuento. <br>
     * @param aplicaDtoPorCantidad tipo de descuento. <br>
     * @param dtoPorCantidad_CantMinima tipo de descuento. <br>
     * @param dtoPorCantidad_PrecioUnitario tipo de descuento. <br>
     * @param activa determina si esta activa o no en el momento actual. <br>
     * @throws PromoIdRepetido_Exception Se lanza si se intenta asignar un identificador de promo existente. <br>
     */
    public void agregaProductoPromo(int idProd, Enumerados.diasDePromo dia, boolean aplica2x1, boolean aplicaDtoPorCantidad, int dtoPorCantidad_CantMinima, double dtoPorCantidad_PrecioUnitario, boolean activa) throws PromoIdRepetido_Exception {}
    
    
    /**
        * metodo para modificar el estado de una promo.<br>
         * @param idProm identificador de la promo. <br>
         * @param activa estado de la promo. <br>
         */

        public void modificaProductoPromo(int idProm, boolean activa) { /* solo activa o desactiva la promo */}

        /**
         * metodo que elimina la promo. <br>
         * @param idProm identificador de la promo. <br>
         */
        public void eliminaProductoPromo(int idProm) {}
 
    
}
