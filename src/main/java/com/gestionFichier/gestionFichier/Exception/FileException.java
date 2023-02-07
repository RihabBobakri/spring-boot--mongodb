package com.gestionFichier.gestionFichier.Exception;

public class FileException extends Exception{

    private static final long serialVersionUID = 1L;

    public FileException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "document with "+id+" not found!";
    }

    public static String DocumentAlreadyExists() {
        return "document with given name already exists";
    }
}
