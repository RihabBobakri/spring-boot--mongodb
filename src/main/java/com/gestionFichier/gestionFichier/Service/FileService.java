package com.gestionFichier.gestionFichier.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionFichier.gestionFichier.Model.Document;
import com.gestionFichier.gestionFichier.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository repository;


    public List<Document> getAllDocument()  {

        List<Document> todos =repository.findAll();
        if (todos.size() > 0) {
            return todos;
        }else {
            return new ArrayList<Document>();
        }
      /*  List<Document> documentList = repository.findAll();
            return new ArrayList<Document>();*/

    }


    public Document getSingleDocument(String id){
        Optional<Document> document = repository.findById(id);
            return document.get();
    }
    public void createDocument(Document document) {
        Optional<Document> doc= repository.findById(document.getId());
            repository.save(document);


    }


    public void updateDocument(String id, Document document ) {
        Optional<Document> docWithId = repository.findById(id);
        Optional<Document> DocWithSameName = repository.findById(document.getId());

        Document DocumentUpdate=docWithId.get();

        DocumentUpdate.setTitre(document.getTitre());
        DocumentUpdate.setTags(document.getTags());
        DocumentUpdate.setDate(document.getDate());

        repository.save(DocumentUpdate);

    }


    public void delete(String id) {
        Optional<Document> doc = repository.findById(id);

            repository.deleteById(id);
        }

    }




























































































































  /*  public void saveFile(String filePath, JsonNode jsonNode) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), jsonNode);
    }
  /*  public Document saveFile(MultipartFile file) throws IOException {

        String titre = file.getOriginalFilename();
        try {
            Document document=new Document();
            document.setDate(new Date());
            document.setTags(document.getTags());
            document.setTitre(titre);
            // document.setType(file.getContentType());
            document.setData(file.getBytes());
            return  repository.save(document);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;

    }*/
   /* public Document saveFiles(MultipartFile[] files) {
        for (MultipartFile file : files) {

            Document document=new Document();

            document.setTitre(document.getTitre());
            try {
                document.setData(file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return  repository.save(document);

        }
        return null ;
    }*/


   /* public Optional<Document> getFile(String fileId ){
        return repository.findById(fileId) ;  }*/


   /* public List<Document> getFiles(){
        return  repository.findAll();
    }*/

   /* public JsonNode getFile() throws IOException {
        Document document = new Document();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readTree(document.getData());
    }
    public void deleteFile(String id) throws Exception {
        repository.deleteById(id);


    }*/


