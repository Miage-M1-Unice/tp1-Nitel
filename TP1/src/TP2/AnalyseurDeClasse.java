package fr.unice.miage.vnahim.TP2;
/**
 * @version 1.00 23 Mars 2001
 * @author Michel Buffa
 * Inspiré par la classe Reflectiontest.java de
 * Cay S. Horstmann & Gary Cornell, publiée dans le livre Core Java, Sun Press
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class AnalyseurDeClasse {

    public static void analyseClasse(String nomClasse) throws ClassNotFoundException {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = getClasse(nomClasse);// CODE A ECRIRE !

        afficheEnTeteClasse(cl);

        System.out.println();
        afficheAttributs(cl);

        System.out.println();
        afficheConstructeurs(cl);

        System.out.println();
        afficheMethodes(cl);

        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }


    /**
     * Retourne la classe dont le nom est passé en paramètre
     */
    public static Class getClasse(String nomClasse) throws ClassNotFoundException {
        return Class.forName(nomClasse);
    }

    /**
     * Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {"
     */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        System.out.print(Modifier.toString(cl.getModifiers()) + " " + cl.getName());

        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = cl.getSuperclass(); // CODE A ECRIRE

        // On ecrit le "extends " que si la superclasse est non nulle et
        // différente de Object
        // CODE A ECRIRE

        if (!supercl.equals(null)) {
            System.out.print(" extends ");
        }

        // Affichage des interfaces que la classe implemente
        System.out.print(cl.getInterfaces().getClass().getName());

        // Enfin, l'accolade ouvrante !
        System.out.print(" {\n");
    }

    public static void afficheAttributs(Class cl) {
        for (Field f : cl.getDeclaredFields()) {
            System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().toString() + " " + f.getName() + ";");
        }

    }

    public static void afficheConstructeurs(Class cl) {
        // CODE A ECRIRE
        for (Constructor c : cl.getConstructors()
        ) {
            System.out.println(c + ";");
        }

    }


    public static void afficheMethodes(Class cl) {
        for (Method m : cl.getDeclaredMethods()) {
            System.out.print(Modifier.toString(m.getModifiers()) + " " + m.getName() + "(");
            for (int i = 0; i < m.getGenericParameterTypes().length; i++) {
                if (i == m.getGenericParameterTypes().length - 1)
                    System.out.print(m.getGenericParameterTypes()[i]);
                else
                    System.out.print(m.getGenericParameterTypes()[i] + ",");
            }
            System.out.println(")");
        }

    }


    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void main(String[] args) {
        boolean ok = false;

        while (!ok) {
            //try {
            // System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
            // String nomClasse = litChaineAuClavier();

            //analyseClasse(nomClasse);
            try {
                analyseClasse("java.awt.Point");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            ok = true;
      /*} catch(ClassNotFoundException e) {
        System.out.println("Classe non trouvée.");
      }catch(IOException e) {
        System.out.println("Erreur d'E/S!");
      }*/
        }
    }
}
