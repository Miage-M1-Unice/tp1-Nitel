package fr.unice.miage.vnahim.TP1;

import java.io.File;

public class DeepRepo {

    public void readDeep(File file1){
        File[] list = file1.listFiles();
        for (File f: list) {
            System.out.println(f);
            if (f.list().length!=0)
                readDeep(f);

        }
    }
}
