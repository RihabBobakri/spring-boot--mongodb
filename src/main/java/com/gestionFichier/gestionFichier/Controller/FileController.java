package com.gestionFichier.gestionFichier.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.gestionFichier.gestionFichier.Model.Document;
import com.gestionFichier.gestionFichier.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RestController
public class FileController {


    @Autowired
    private FileService fileService;

    @GetMapping("/home")
    public String home() {
        return "welcome !!!!";
    }


    @PostMapping("/File")
    public ResponseEntity<?> createTodo(@RequestBody Document doc) {
            fileService.createDocument(doc);
            return new ResponseEntity<Document>(doc, HttpStatus.OK);
    }

    @GetMapping("/docs")
    public ResponseEntity<?> getAllFiles()  {
        List<Document> docs = fileService.getAllDocument();
        return new ResponseEntity<>(docs, docs.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping("/Single/{id}")
    public ResponseEntity<?> getSingleTodo(@PathVariable("id") String id) {

        return new ResponseEntity<>(fileService.getSingleDocument(id), HttpStatus.OK);

    }
    @DeleteMapping("/file/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {

            fileService.delete(id);
            return new ResponseEntity<>("Successfully deleted todo with id "+id, HttpStatus.OK);

    }

    @PutMapping("/doc/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id, @RequestBody Document document) {
            fileService.updateDocument(id,document);
            return new ResponseEntity<>("Updated movie with id "+id+"", HttpStatus.OK);

    }


}












































































































    /*
      @GetMapping("/doc")
      public List<Document> getFile(){
          List<Document> docs=fileService.getFiles();
          return docs;
      }
    @GetMapping("/file")
    public ResponseEntity<JsonNode> getFile() throws IOException {
        JsonNode file = fileService.getFile("path/to/file.json");
        return ResponseEntity.ok().body(file);

        //  @PostMapping("/file")
        @PostMapping("/save")
        public ResponseEntity<Void> saveFile (@RequestBody JsonNode jsonNode) throws IOException {
            fileService.saveFile("path/to/file.json", jsonNode);
            return ResponseEntity.ok().build(jsonNode);
        }
        /*@PostMapping("/File")
        public String uploadFile (@RequestParam("file") MultipartFile[] files) throws IOException {
            for (MultipartFile file: files) {
                fileService.saveFile();
            }
            return  "redirect:/";
        }*/

       /* @PostMapping("/Files")
        public String uploadFiles (@RequestParam("files") MultipartFile[] files) throws IOException {
            for (MultipartFile file: files) {
              fileService.saveFiles(files);

            }
            return  "redirect files:/";
        }*/

      /*  @GetMapping("/get/{fileId}")
        public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileId){
            Document doc = fileService.getFile(fileId).get();
            return ResponseEntity.ok()
                    //  .contentType(MediaType.parseMediaType(doc.getDocType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getTitre()+"\"")
                    .body(new ByteArrayResource(doc.getData()));
        }*/



     /*   @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteProduct(@PathVariable String id) throws Exception{
            fileService.deleteFile(id);

            return new ResponseEntity<String>("Product with id "+id+"  has been deleted", HttpStatus.OK);
        }*/

