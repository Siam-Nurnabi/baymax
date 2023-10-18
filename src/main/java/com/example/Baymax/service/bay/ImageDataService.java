package com.example.Baymax.service.bay;

import com.example.Baymax.model.bay.ImageData;
import com.example.Baymax.repository.bay.IImageDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataService {
    private final IImageDataRepository imageDataRepository;

    public ImageDataService(IImageDataRepository imageDataRepository) {
        this.imageDataRepository = imageDataRepository;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = new ImageData();
        imageData.setName(file.getOriginalFilename());
        imageData.setType(file.getContentType());
        imageData.setData(file.getBytes());
        imageDataRepository.save(imageData);
        return "Image uploaded successfully" + imageData.getName();
    }

    @Transactional
    public ImageData getImageData(String imageName) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(imageName);
        return new ImageData(dbImage.get().getId(),
                dbImage.get().getName(),
                dbImage.get().getType(),
                dbImage.get().getData());
    }

    @Transactional
    public byte[] getImage(String imageName){
        Optional<ImageData> dbImage = imageDataRepository.findByName(imageName);
        byte[] image = dbImage.get().getData();
        return image;
    }
}
