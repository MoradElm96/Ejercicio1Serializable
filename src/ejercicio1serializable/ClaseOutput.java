/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Morad
 */
public class ClaseOutput extends ObjectOutputStream{
    
    ClaseOutput(FileOutputStream f) throws IOException{
        super(f);
    }
    @Override
    protected void writeStreamHeader(){}
}

