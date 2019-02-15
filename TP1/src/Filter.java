package fr.unice.miage.vnahim;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        File ndir = new File(dir.getPath()+"/"+name);
        if (ndir.isDirectory() || ndir.getPath().endsWith(".java")){
            return true;
        }

        return false;
    }
}
