/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Maryr
 */
public class Seguridad {

    private static final String ALGORITMO = "AES";
    private static final String CLAVE_SECRETA = "FallingAwayFromU"; 

    /**
     * Encripta un texto utilizando AES.
     * @param telefono el telefono que se quiere encriptar
     * @return el telefono en su forma encriptada
     */
    public static String encriptar(String telefono) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] bytesEncriptados = cipher.doFinal(telefono.getBytes());
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    /**
     * Desencripta un texto utilizando AES.
     * @param telefonoEncriptado el telefono que se quiere desencriptar
     * @return el telefono en su forma original
     */
    public static String desencriptar(String telefonoEncriptado) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
        Cipher cipher = Cipher.getInstance(ALGORITMO);
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] bytesDesencriptados = cipher.doFinal(Base64.getDecoder().decode(telefonoEncriptado));
        return new String(bytesDesencriptados);
    }
}
