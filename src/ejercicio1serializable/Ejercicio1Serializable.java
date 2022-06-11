/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1serializable;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Morad
 */
public class Ejercicio1Serializable {

    public static void main(String[] args) {

        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        File f = new File("paises.obj");

        do {
            System.out.println("---------------Menu----------------");
            System.out.println("1) Crear el fichero serializable paises.obj\n"
                    + "2) Añadir países al fichero, cuyos valores se pedirán por teclado.\n"
                    + "3) Listar toda la información contenida en el fichero.\n"
                    + "4) Consultar un registro por el nombre del país, que se pedirá por teclado.\n"
                    + "5)Actualizar la información del fichero pudiendo modificar la información de cualquiera\n"
                    + "de los atributos excepto el Id que no se podrá modificar. \n"
                    + "6)Pulsa 6 si quieres salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:

                    crearFichero(f);

                    break;

                case 2:

                    anadirPais(f, sc);

                    break;

                case 3:

                    mostrarDatosFichero(f);

                    break;
                case 4:

                    consultarPais(sc, f);

                    break;
                case 5:

                    actualizarIdioma(sc, f);

                    break;
                /*  default:
                    System.out.println("Seleciona opcion correcta");*/
            }

        } while (opcion != 6);

    }

    public static void actualizarIdioma(Scanner sc, File f) {
        try {
            //actualizar

            File f1 = new File("auxiliar.obj");
            Pais pais;
            boolean existe = false;
            String nombre, idioma;

            System.out.println("Introduce pais a actualizar");
            nombre = sc.next();

            System.out.println("Intruduce nuevo idioma");
            idioma = sc.next();

            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            FileOutputStream fos = new FileOutputStream(f1);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            try {
                while (true) {
                    pais = (Pais) ois.readObject();
                    if (pais.getNombre().equals(nombre)) {
                        pais.setIdioma(idioma);

                    }
                    oos.writeObject(pais);
                }

            } catch (EOFException ef) {
                System.out.println("Fin del fichero");

            }

            ois.close();
            fis.close();
            oos.close();
            fos.close();

            f.delete();
            f1.renameTo(f);

        } catch (FileNotFoundException | ClassNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public static void consultarPais(Scanner sc, File f) {
        //consultar
        Pais pais = null;
        boolean existe = false;
        String nombre;
        System.out.println("introduce nombre pais a buscar");
        nombre = sc.next();
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {

                while (true) {
                    pais = (Pais) ois.readObject();
                    if (pais.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.println(pais.toString());
                        existe = true;
                    } else {
                        existe = false;
                        System.out.println("No existe ese pais");
                    }

                }

            } catch (EOFException ef) {
                System.out.println("Fin del fichero");
            }

            ois.close();
            fis.close();

        } catch (FileNotFoundException | ClassNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public static void mostrarDatosFichero(File f) {
        try {
            //mostramos el fichero
            Pais p;
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //para leer siempre eofe exception

            try {

                while (true) {
                    p = (Pais) ois.readObject();
                    System.out.println(p.toString());
                }

            } catch (EOFException ef) {
                System.out.println("Fin del fichero");
            }

        } catch (FileNotFoundException | ClassNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public static void anadirPais(File f, Scanner sc) {
        int id;
        String nombre,
                capital,
                idioma;
        Pais pais;
        try {
            /* if (!f.exists()) {
                crearFichero(f);*/

            FileOutputStream fos = new FileOutputStream(f, true);
            ClaseOutput oos = new ClaseOutput(fos);//para la cabecera

            System.out.println("Introduce id");
            id = sc.nextInt();

            System.out.println("Introduce nombre pais");
            nombre = sc.next();
            System.out.println("Introduce capital");
            capital = sc.next();
            System.out.println("Introduce idioma");
            idioma = sc.next();

            pais = new Pais(id, nombre, capital, idioma);

            //ahora escribimos en el fichero
            oos.writeObject(pais);
            oos.close();
            fos.close();

            /* } else {
                System.out.println("El fichero ya existe");
            }*/
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

    public static void crearFichero(File f) {
        try {

            if (f.exists()) {
                System.out.println("El fichero ya existe");
            } else {
                FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.close();
                fos.close();
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }
    }

}
