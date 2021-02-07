package br.com.zup.orange.talents1.template.ecommerce.ecommerce.produto;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public interface Uploader {

	Set<String> envia(List<MultipartFile> images);

}
