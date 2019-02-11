package fr.unice.miage.vnahim;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}
