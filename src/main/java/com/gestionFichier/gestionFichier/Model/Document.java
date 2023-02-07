package com.gestionFichier.gestionFichier.Model;

import jakarta.annotation.Generated;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;


@Data
@Getter
@Setter

//@Table(name="Document")
@org.springframework.data.mongodb.core.mapping.Document(collation = "document")
@AllArgsConstructor
@NoArgsConstructor
public class Document {


        @Id
      /*@GeneratedValue(generator = "uuid2")
        @GenericGenerator(name  ="uuid2",strategy ="uuid2")
        @Column(name = "id" )*/
        private String id;

        @NonNull
        private  String titre;
        private  String tags;
        private Date date ;


       // @Lob

      //  private byte[] data;

        public void setTags(String motCle) {
                this.tags=motCle;
        }
}


