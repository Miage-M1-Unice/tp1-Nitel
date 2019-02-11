package fr.unice.miage.vnahim;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class ReadRepo {
    public File file;

    public ReadRepo(String dir) {
        this.file = new File(dir);
    }

    public void readSimple(){
        String[] list = this.file.list();
        for (int i =0; i<list.length; i++){
            System.out.println(list[i]);
        }
    }

    public void readDeep(File file1){
        File[] list = file1.listFiles();
        for (File f: list) {
            System.out.println(f);
            if (f.isDirectory()){
                readDeep(f);
                System.out.println();
            }
        }
    }

    public void readDeepFiltered(File file1, FilenameFilter filter){
        File[] list = file1.listFiles(filter);
        for (File f: list) {
            System.out.println(f);
            if (f.isDirectory()){
                readDeep(f);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        ReadRepo readRepo = new ReadRepo(".");
        readRepo.readSimple(); //1
       // readRepo.readDeep(readRepo.file); //2
        readRepo.readDeepFiltered(readRepo.file, new Filter1()); //3
    }


    public static class Filter1 implements FilenameFilter{

        @Override
        public boolean accept(File dir, String name) { //TODO
            File ndir = new File(dir.getPath()+"/");
            if (ndir.isDirectory() || ndir.getPath().endsWith(".java")){
                return true;
            }

            return false;
        }
    }
}

