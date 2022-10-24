/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SistemasU
 */
public class api_empleados {
    public String get(){
        String salida="";
        
        try{
            URL url = new URL("https://localhost:5001/api/empleados");
            HttpURLConnection c_api = (HttpURLConnection) url.openConnection();
            c_api.setRequestMethod("GET");
            c_api.setRequestProperty("Accept", "application/json");
            if(c_api.getResponseCode()==200){
                InputStreamReader entrada = new InputStreamReader(c_api.getInputStream());
                BufferedReader lectura = new BufferedReader(entrada);
                salida = lectura.readLine();
            
            }else{
                
                System.out.println("No de puede conectar a la api" + c_api.getResponseCode());
                salida="";
            }
            c_api.disconnect();
            
        }catch(IOException ex){
            System.out.println("Error api:" + ex.getMessage());
        }
        return salida;
    }
    public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try{
            String encabezado[] = {"Nombres","Apellidos","Direccion","Direccion","Telefono","Puesto","DPI","Fecha Nacimiento","Fecha Registro"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[7];
            JSONArray arreglo = new JSONArray(get());
            
            for(int indice = 0;indice < arreglo.length();indice++){
                JSONObject atributo = arreglo.getJSONObject(indice);
                datos[0]=String.valueOf(atributo.getInt("idEmpleado"));
                datos[1]=atributo.getString("Nombre"); 
                datos[2]=atributo.getString("Apellido");
                datos[3]=atributo.getString("Direccion");
                datos[4]=atributo.getString("Telefono");
                datos[5]=atributo.getString("idPuesto");
                datos[6]=atributo.getString("fechaNacimiento");
                datos[7]=atributo.getString("fechaIngresoRegistro");
                tabla.addRow(datos);
            }
        }catch(JSONException ex){
            System.out.println("Error tabla:" + ex.getMessage());
        }
    return tabla;
    }
    
}
