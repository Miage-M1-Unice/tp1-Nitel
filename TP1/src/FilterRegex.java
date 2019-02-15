package fr.unice.miage.vnahim;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterRegex implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
        File ndir = new File(dir.getPath()+"/"+name);
        if (ndir.isDirectory() ||Reg(".java",name)){
            return true;
        }

        return false;
    }

    public boolean Reg (String reg, String chaine){
        Pattern pattern = Pattern.compile(".*"+reg);
        Matcher matcher = pattern.matcher(chaine);
        if (matcher.matches()){
            return true;
        }
        return false;
    }
}
