package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import org.primefaces.model.ResponsiveOption;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;

    private List<ResponsiveOption> responsiveOptions;

    List<GalleryImage> images = new ArrayList<>();


    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        GalleryImage img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 1");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 2");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 3");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 4");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 5");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 6");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 7");
        images.add(img);
        img = new GalleryImage(UUID.randomUUID(), "resources/images/small.jpg", "resources/images/big.jpg", "image 8");
        images.add(img);

        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 6));
        responsiveOptions.add(new ResponsiveOption("960px", 4));
        responsiveOptions.add(new ResponsiveOption("768px", 3));
        responsiveOptions.add(new ResponsiveOption("560px", 2));
        responsiveOptions.add(new ResponsiveOption("400px", 1));

    }

    public void deleteGalleryImageById(){
        String paramId = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("imageId");
        UUID id = UUID.fromString(paramId);
        GalleryImage gi = images.stream().filter(g -> g.getId().equals(id)).findFirst().orElse(null);
        if(gi == null){
            return;
        }

        deleteGalleryImage(gi);
    }

    public void deleteGalleryImage(GalleryImage gi){
        images.remove(gi);
    }

}
